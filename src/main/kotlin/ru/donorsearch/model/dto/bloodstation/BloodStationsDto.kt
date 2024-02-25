package ru.donorsearch.model.dto.bloodstation

import com.fasterxml.jackson.annotation.JsonProperty

data class BloodStationsDto(
    val count: Int?,
    @JsonProperty("num_pages")
    val numPages: Int?,
    var next: String?,
    var previous: String?,
    val results: List<BloodStationDto?>
)