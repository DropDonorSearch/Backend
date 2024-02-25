package ru.donorsearch.model.dto.donationplan

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.bloodstation.BloodStationDto
import ru.donorsearch.model.dto.region.CityDto

data class DonationPlanDto(
    val id: Int?,
    val event: String?,
    @JsonProperty("blood_station_id")
    val bloodStationId: Int?,
    @JsonProperty("blood_station")
    val bloodStation: BloodStationDto?,
    @JsonProperty("city_id")
    val cityId: Int?,
    val city: CityDto?,
    @JsonProperty("created_at")
    val createdAt: String?,
    @JsonProperty("updated_at")
    val updatedAt: String?,
    @JsonProperty("object_id")
    val objectId: Int?,
    @JsonProperty("blood_class")
    val bloodClass: String?,
    @JsonProperty("plan_date")
    val planDate: String?,
    @JsonProperty("payment_type")
    val paymentType: String?,
    val status: String?,
    @JsonProperty("is_out")
    val isOut: Boolean?,
    val user: Int?,
    @JsonProperty("content_type")
    val contentType: Int?,
    val donation: Int?
)