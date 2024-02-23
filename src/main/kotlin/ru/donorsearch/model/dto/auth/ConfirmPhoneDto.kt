package ru.donorsearch.model.dto.auth

data class ConfirmPhoneDto(
    val phone: String?,
    val code: Int?
)