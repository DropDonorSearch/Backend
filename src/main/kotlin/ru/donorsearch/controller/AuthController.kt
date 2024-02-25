package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.auth.*
import ru.donorsearch.model.dto.user.InternalUserDto
import ru.donorsearch.service.UserService
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

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
        val internalUserDto =
            InternalUserDto(
                userDto?.userId,
                registerDto.firstName,
                null,
                null,
                null,
                registerDto.email,
                registerDto.password
            )
        userService.createUser(internalUserDto)

        return userDto
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto?): FullUserDto? {
        return hackatonFeignClient.login(loginDto)
    }

    @PostMapping("/change-email")
    fun changeEmail(
        @CookieValue("token") basicToken: String,
        @RequestBody emailDto: EmailDto?
    ): StatusDto? {
        return hackatonFeignClient.changeEmail("Basic $basicToken", emailDto)
    }

    @PostMapping("/change-password")
    fun changePassword(@RequestBody passwordDto: PasswordDto?): FullUserDto? {
        return hackatonFeignClient.changePassword(passwordDto)
    }

    @PostMapping("/change-phone")
    fun changePhone(@RequestBody phoneDto: PhoneDto?): StatusDto? {
        return hackatonFeignClient.changePhone(phoneDto)
    }

    @PostMapping("/confirm-email-reg")
    fun confirmEmailReg(
        @CookieValue("token") basicToken: String,
        @RequestBody emailDto: ConfirmEmailDto?
    ): StatusDto? {
        return hackatonFeignClient.confirmEmailReg(basicToken, emailDto)
    }

    @PostMapping("/confirm-phone")
    fun confirmPhone(@RequestBody phoneDto: PhoneDto?): StatusDto? {
        return hackatonFeignClient.confirmPhone(phoneDto)
    }

    @OptIn(ExperimentalEncodingApi::class)
    @GetMapping("/me")
    fun getCurrentUser(@CookieValue("token") basicToken: String): FullUserDto? {
        val decodeString = String(Base64.decode(basicToken))
        val splitEd = decodeString.split(":")

        val user = userService.getUserByEmail(splitEd[0])
        val userDto = hackatonFeignClient.getCurrentUser("Basic $basicToken")

        userDto?.gender = user?.gender
        userDto?.firstName = user?.firstName
        userDto?.lastName = user?.lastName
        userDto?.middleName = user?.middleName
        userDto?.about = user?.about

        return userDto
    }

    @PatchMapping("/me")
    fun updateCurrentUser(
        @RequestBody userDto: FullUserDto?
    ): FullUserDto? {
        return hackatonFeignClient.updateCurrentUser(userDto)
    }
}