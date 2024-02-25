package ru.donorsearch.service

import ru.donorsearch.model.dto.user.InternalUserDto

interface UserService {
    fun getUser(externalId: Long): InternalUserDto?
    fun getUserByEmail(email: String?): InternalUserDto?
    fun createUser(internalUserDto: InternalUserDto): InternalUserDto?
    fun updateUser(externalId: Long, internalUserDto: InternalUserDto): InternalUserDto?
}