package ru.donorsearch.model.dto.user

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import java.time.LocalDateTime
import jakarta.persistence.*

data class InternalUserDto(
    @JsonProperty(value = "external_id")
    val externalId: Long?,

    @JsonProperty(value = "first_name")
    var firstName: String? = null,

    @JsonProperty(value = "last_name")
    var lastName: String? = null,

    @JsonProperty(value = "middle_name")
    var middleName: String? = null,

    @JsonProperty(value = "username")
    val username: String? = null,

    @JsonProperty(value = "email")
    val email: String? = null,

    @JsonProperty(value = "password")
    val password: String? = null,

    @JsonProperty(value = "gender")
    var gender: String? = null,

    @JsonProperty(value = "about")
    var about: String? = null,

    @JsonProperty(value = "created")
    val created: LocalDateTime? = null,

    @JsonProperty(value = "updated")
    val updated: LocalDateTime? = null
) {

}