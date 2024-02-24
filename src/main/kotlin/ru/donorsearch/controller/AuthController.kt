package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.auth.*
import ru.donorsearch.model.dto.user.InternalUserDto
import ru.donorsearch.service.UserService

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
class AuthController(
    private val hackatonFeignClient: HackatonFeignClient,
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(@RequestBody registerDto: RegisterDto): UserDto? {
        val userDto = hackatonFeignClient.register(registerDto)
        val internalUserDto = InternalUserDto(userDto?.userId, registerDto.firstName, null, null, registerDto.email, registerDto.password)
        userService.createUser(internalUserDto)

        return userDto
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto?): FullUserDto? {
        return hackatonFeignClient.login(loginDto)
    }

    @PostMapping("/change-email")
    fun changeEmail(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody emailDto: EmailDto?
    ): StatusDto? {
        return hackatonFeignClient.changeEmail(basicToken, emailDto)
    }

    @PostMapping("/change-password")
    fun changePassword(@RequestBody passwordDto: PasswordDto?): FullUserDto? {
        return hackatonFeignClient.changePassword(passwordDto)
    }

    @PostMapping("/change-phone")
    fun changePhone(@RequestBody phoneDto: PhoneDto?): StatusDto? {
        return hackatonFeignClient.changePhone(phoneDto)
    }

    @PostMapping("/confirm-email")
    fun confirmEmail(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody emailDto: ConfirmEmailDto?
    ): StatusDto? {
        return hackatonFeignClient.confirmEmail(basicToken, emailDto)
    }

    @PostMapping("/confirm-phone")
    fun confirmPhone(@RequestBody phoneDto: PhoneDto?): StatusDto? {
        return hackatonFeignClient.confirmPhone(phoneDto)
    }

    @GetMapping("/me")
    fun getCurrentUser(@RequestHeader("Authorization") basicToken: String): FullUserDto? {
        return hackatonFeignClient.getCurrentUser(basicToken)
    }

    @PatchMapping("/me")
    fun updateCurrentUser(
        @RequestBody userDto: FullUserDto?
    ): FullUserDto? {
        return hackatonFeignClient.updateCurrentUser(userDto)
    }
}