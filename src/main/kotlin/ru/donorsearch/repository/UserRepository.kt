package ru.donorsearch.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.donorsearch.model.entity.User

interface UserRepository : JpaRepository<User, Long> {
    fun findByExternalId(externalId: Long): User
}