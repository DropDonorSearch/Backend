package ru.donorsearch.model.dto.event

import com.fasterxml.jackson.annotation.JsonProperty

class EventsDto(
    val count: Int?,
    @JsonProperty("num_pages")
    val numPages: Int?,
    var next: String?,
    var previous: String?,
    val results: List<EventDto?>
)