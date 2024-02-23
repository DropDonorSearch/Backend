package ru.donorsearch.model.dto.bloodstation

import com.fasterxml.jackson.annotation.JsonProperty

data class BloodStationUsersDto(
    val count: Int?,
    @JsonProperty("num_pages")
    val numPages: Int?,
    val next: String?,
    val previous: String?,
    val results: List<BloodStationUserDto?>
)