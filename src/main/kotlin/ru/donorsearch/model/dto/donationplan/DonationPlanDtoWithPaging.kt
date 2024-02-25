package ru.donorsearch.model.dto.donationplan

data class DonationPlanDtoWithPaging (
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<DonationPlanDto>
)