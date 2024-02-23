package ru.donorsearch.model.dto.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDto(
    @JsonProperty(value = "user_id")
    val userId: Long,
)