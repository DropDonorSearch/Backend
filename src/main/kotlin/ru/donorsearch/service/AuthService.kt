package ru.donorsearch.service

interface AuthService {
    fun login(username: String): String
//    fun register(userDto: UserDto, username: String, password: String): GetUserDto
}