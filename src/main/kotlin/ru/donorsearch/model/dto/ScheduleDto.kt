package ru.donorsearch.model.dto

data class ScheduleDto(
    val id: Int?,
    val dow: String?,
    val start: String?,
    val end: String?
)