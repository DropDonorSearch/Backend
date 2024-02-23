package ru.donorsearch.model.dto.bloodstation

import com.fasterxml.jackson.annotation.JsonProperty

data class BloodStationUserDto(
    val id: Int?,
    @JsonProperty(value = "first_name")
    val firstName: String?,
    @JsonProperty(value = "last_name")
    val lastName: String?,
    @JsonProperty(value = "middle_name")
    val middleName: String?,
    val photo: PhotoDto?,
    @JsonProperty(value = "legacy_avatar")
    val legacyAvatar: String?
)