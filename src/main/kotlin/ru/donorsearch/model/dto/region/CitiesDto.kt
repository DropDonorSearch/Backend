package ru.donorsearch.model.dto.region

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.event.EventDto

class CitiesDto(
    val count: Int?,
    @JsonProperty("num_pages")
    val numPages: Int?,
    val next: String?,
    val previous: String?,
    val results: List<CityDto?>
)