package ru.donorsearch.model.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.Mappings
import ru.donorsearch.model.dto.user.InternalUserDto
import ru.donorsearch.model.entity.User

@Mapper(componentModel = "spring")
interface UserMapper {

    fun createUserDto(user: User): InternalUserDto?

    fun createUser(internalUserDto: InternalUserDto?): User

    @Mappings(value = [
        Mapping(target = "externalId", ignore = true)
    ])
    fun updateUserDto(@MappingTarget user: User, source: InternalUserDto?)
}