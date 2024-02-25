package ru.donorsearch.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.donorsearch.model.entity.User
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    fun findByExternalId(externalId: Long): Optional<User>
    fun findByEmail(email: String?): Optional<User>
}