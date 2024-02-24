package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.user.InternalUserDto
import ru.donorsearch.service.UserService

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
class UserController(
    private val userService: UserService,
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Long): InternalUserDto? {
        return userService.getUser(id)
    }

    @PatchMapping("/{id}")
    fun updateUser(@PathVariable("id") id: Long, @RequestBody internalUserDto: InternalUserDto): InternalUserDto? {
        return userService.updateUser(id, internalUserDto)
    }
}