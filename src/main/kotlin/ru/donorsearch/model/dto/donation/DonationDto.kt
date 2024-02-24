package ru.donorsearch.model.dto.donation

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.ImageDto
import ru.donorsearch.model.dto.region.CityDto

data class DonationDto(
    val id: Int?,
    @JsonProperty("blood_station_id")
    val bloodStationId: Int?,
    @JsonProperty("blood_station")
    val bloodStation: String?,
    val image: ImageDto?,
    @JsonProperty("image_id")
    val imageId: Int?,
    @JsonProperty("city_id")
    val cityId: Int?,
    val city: CityDto?,
    @JsonProperty("legacy_image")
    val legacyImage: String?,
    @JsonProperty("has_reply")
    val hasReply: Boolean?,
    @JsonProperty("reply_viewed")
    val replyViewed: Boolean?,
    @JsonProperty("allowed_modify")
    val allowedModify: Boolean?,
    @JsonProperty("created_at")
    val createdAt: String?,
    @JsonProperty("updated_at")
    val updatedAt: String?,
    val status: String?,
    @JsonProperty("reject_reason")
    val rejectReason: String?,
    @JsonProperty("donate_at")
    val donateAt: String?,
    @JsonProperty("blood_class")
    val bloodClass: String?,
    @JsonProperty("payment_type")
    val paymentType: String?,
    @JsonProperty("is_out")
    val isOut: Boolean?,
    val volume: Int?,
    @JsonProperty("payment_cost")
    val paymentCost: Int?,
    @JsonProperty("on_moderation_date")
    val onModerationDate: String?,
    @JsonProperty("with_image")
    val withImage: Boolean?,
    @JsonProperty("created_using_ocr")
    val createdUsingOcr: Boolean?,
    val user: Int?
)