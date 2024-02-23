package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.auth.RegisterDto
import ru.donorsearch.model.dto.auth.UserDto

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
class AuthController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @PostMapping("/register")
    fun register(
        @RequestBody registerDto: RegisterDto
    ): ResponseEntity<UserDto> {
        val user: UserDto = hackatonFeignClient.register(registerDto)
        return ResponseEntity.ok().body(user)
    }
}