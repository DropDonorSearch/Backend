package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.auth.*

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
class AuthController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @PostMapping("/register")
    fun register(@RequestBody registerDto: RegisterDto): UserDto? {
        return hackatonFeignClient.register(registerDto)
    }

    @PostMapping("/change-email")
    fun changeEmail(@RequestBody emailDto: EmailDto?): StatusDto? {
        return hackatonFeignClient.changeEmail(emailDto)
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
    fun confirmEmail(@RequestBody emailDto: ConfirmEmailDto?): StatusDto? {
        return hackatonFeignClient.confirmEmail(emailDto)
    }

    @PostMapping("/confirm-phone")
    fun confirmPhone(@RequestBody phoneDto: PhoneDto?): StatusDto? {
        return hackatonFeignClient.confirmPhone(phoneDto)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto?): FullUserDto? {
        return hackatonFeignClient.login(loginDto)
    }

    @GetMapping("/me")
    fun getCurrentUser(): FullUserDto? {
        return hackatonFeignClient.getCurrentUser()
    }

    @PatchMapping("/me")
    fun updateCurrentUser(
        @RequestBody userDto: FullUserDto?
    ): FullUserDto? {
        return hackatonFeignClient.updateCurrentUser(userDto)
    }
}