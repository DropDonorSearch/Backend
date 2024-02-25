package ru.donorsearch.config

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


@Component
@Slf4j
@RequiredArgsConstructor
class AuthFilter : OncePerRequestFilter() {

    @OptIn(ExperimentalEncodingApi::class)
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val requestWrapper = RequestWrapper(request)

        if (requestWrapper.method.equals("POST")) {
            val bodyString = requestWrapper.reader.lines().reduce("", String::plus)
            if (requestWrapper.requestURI.contains("register")) {
                val objectMapper = ObjectMapper()
                val json = objectMapper.readValue(bodyString, JsonNode::class.java)
                var username = json.get("email").toString()
                username = username.substring(1, username.length - 1)
                var pass = json.get("password").toString()
                pass = pass.substring(1, pass.length - 1)
                val token: String = Base64.encode("$username:$pass".toByteArray())

                logger.debug(token)
                response.addCookie(Cookie("token", token))
            }

            if (requestWrapper.requestURI.contains("login")) {
                val objectMapper = ObjectMapper()
                val json = objectMapper.readValue(bodyString, JsonNode::class.java)
                var username = json.get("username").toString()
                username = username.substring(1, username.length - 1)
                var pass = json.get("password").toString()
                pass = pass.substring(1, pass.length - 1)
                val token: String = Base64.encode("$username:$pass".toByteArray())

                logger.debug(token)
                response.addCookie(Cookie("token", token))
            }
        }

        filterChain.doFilter(requestWrapper, response)
    }
}