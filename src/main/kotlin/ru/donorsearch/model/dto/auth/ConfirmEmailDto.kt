package ru.donorsearch.model.dto.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class ConfirmEmailDto(
    val email: String?,
    @JsonProperty("user_id")
    val userId: Int?,
    val code: Int?
)