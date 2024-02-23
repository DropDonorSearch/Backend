package ru.donorsearch.model.dto.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterDto(
    val email: String,
    val password: String,
    @JsonProperty(value = "first_name")
    val firstName: String,
    val tag: String
)