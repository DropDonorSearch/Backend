package ru.donorsearch.model.dto.user

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class InternalUserDto (
    @JsonProperty(value = "external_id")
    val externalId: Long?,

    @JsonProperty(value = "firstname")
    val firstname: String? = null,

    @JsonProperty(value = "lastname")
    val lastname: String? = null,

    @JsonProperty(value = "username")
    val username: String? = null,

    @JsonProperty(value = "email")
    val email: String,

    @JsonProperty(value = "password")
    val password: String? = null,

    @JsonProperty(value = "created")
    val created: LocalDateTime? = null,

    @JsonProperty(value = "updated")
    val updated: LocalDateTime? = null
) {

}