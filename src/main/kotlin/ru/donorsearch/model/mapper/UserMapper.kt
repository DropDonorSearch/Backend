package ru.donorsearch.model.mapper

import org.mapstruct.*
import ru.donorsearch.model.dto.user.InternalUserDto
import ru.donorsearch.model.entity.User
import java.beans.BeanProperty

@Mapper(componentModel = "spring")
interface UserMapper {

    fun createUserDto(user: User): InternalUserDto?

    fun createUser(internalUserDto: InternalUserDto?): User

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings(value = [
        Mapping(target = "externalId", ignore = true)
    ])
    fun updateUserDto(@MappingTarget user: User, source: InternalUserDto?): User
}