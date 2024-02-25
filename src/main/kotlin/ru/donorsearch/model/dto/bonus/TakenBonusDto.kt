package ru.donorsearch.model.dto.bonus

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class TakenBonusDto (
    var id: Long,
    @JsonProperty("user_id")
    var userId: Long,
    @JsonProperty("bonus_id")
    var bonusId: Long,
    var promo: String,
    @JsonProperty("image_url")
    var imageUrl: String,
    var created: LocalDateTime,
    var updated: LocalDateTime? = null
)