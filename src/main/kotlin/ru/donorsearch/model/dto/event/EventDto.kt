package ru.donorsearch.model.dto.event

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.bloodstation.BloodStationDto
import ru.donorsearch.model.dto.region.CityDto

data class EventDto(
    val id: Int?,
    val city: CityDto?,
    @JsonProperty("city_id")
    val cityId: Int?,
    val author: AuthorDto?,
    val type: String?,
    @JsonProperty("available_slots")
    val availableSlots: Int?,
    @JsonProperty("start_date")
    val startDate: String?,
    @JsonProperty("end_date")
    val endDate: String?,
    @JsonProperty("object_id")
    val objectId: Int?,
    val name: String?,
    val description: String?,
    val address: String?,
    val phone: String?,
    @JsonProperty("joined_count")
    val joinedCount: Int?,
    @JsonProperty("content_type")
    val contentType: Int?
)