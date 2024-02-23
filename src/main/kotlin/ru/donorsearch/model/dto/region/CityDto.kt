package ru.donorsearch.model.dto.region

import com.fasterxml.jackson.annotation.JsonProperty

data class CityDto(
    val id: Int?,
    val title: String?,
    val slug: String?,
    @JsonProperty("region_id")
    val regionId: Int?,
    val region: RegionDto?,
    val country: CountryDto?,
    val priority: Int?,
    val lat: String?,
    val lng: String?
)