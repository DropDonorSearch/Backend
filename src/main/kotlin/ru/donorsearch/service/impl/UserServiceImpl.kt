package ru.donorsearch.service.impl

import org.springframework.stereotype.Service
import ru.donorsearch.model.dto.user.InternalUserDto
import ru.donorsearch.model.mapper.UserMapper
import ru.donorsearch.repository.UserRepository
import ru.donorsearch.service.UserService

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserService {

    override fun getUser(externalId: Long): InternalUserDto? {
        return userMapper.createUserDto(
            userRepository.findById(externalId)
                .orElse(null))
    }

    override fun createUser(internalUserDto: InternalUserDto): InternalUserDto? {
        val user = userMapper.createUser(internalUserDto)
        userRepository.save(user)

        return userMapper.createUserDto(user)
    }

    override fun updateUser(externalId: Long, internalUserDto: InternalUserDto): InternalUserDto? {
        val existingUser = userRepository.findByExternalId(externalId)

        userMapper.updateUserDto(existingUser, internalUserDto)
        return userMapper.createUserDto(existingUser)
    }
}