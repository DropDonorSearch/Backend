package ru.donorsearch.model.dto.bonus

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class BonusDto (
    @JsonProperty("bonus_id")
    var bonusId: Long,

    var promo: String,

    @JsonProperty("image_url")
    var imageUrl: String,

    @JsonProperty("title")
    var title: String,

    @JsonProperty("description")
    var description: String,

    @JsonProperty
    var created: LocalDateTime,
    var updated: LocalDateTime? = null
)