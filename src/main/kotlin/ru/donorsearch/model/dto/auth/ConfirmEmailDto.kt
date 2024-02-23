package ru.donorsearch.model.dto.auth

data class ConfirmEmailDto(
    val email: String?,
    val code: Int?
)