package ru.donorsearch.model.dto.donation

data class DonationDtoWithPaging (
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<DonationDto>
)