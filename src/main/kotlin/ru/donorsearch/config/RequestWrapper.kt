package ru.donorsearch.config

import jakarta.servlet.ReadListener
import jakarta.servlet.ServletInputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader

class RequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private val body: String

    init {
        val stringBuilder = StringBuilder()
        request.inputStream.use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { bufferedReader ->
                val charBuffer = CharArray(128)
                var bytesRead: Int
                while (bufferedReader.read(charBuffer).also { bytesRead = it } > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead)
                }
            }
        }
        body = stringBuilder.toString()
    }

    @Throws(IOException::class)
    override fun getInputStream(): ServletInputStream {
        val byteArrayInputStream = ByteArrayInputStream(body.toByteArray())
        return object : ServletInputStream() {
            @Throws(IOException::class)
            override fun read(): Int {
                return byteArrayInputStream.read()
            }

            override fun isFinished(): Boolean {
                return byteArrayInputStream.available() == 0
            }

            override fun isReady(): Boolean {
                return true
            }

            override fun setReadListener(readListener: ReadListener?) {
                throw RuntimeException("Not implemented")
            }
        }
    }

    @Throws(IOException::class)
    override fun getReader(): BufferedReader {
        return BufferedReader(InputStreamReader(this.inputStream))
    }

    fun getBody(): String {
        return body
    }
}