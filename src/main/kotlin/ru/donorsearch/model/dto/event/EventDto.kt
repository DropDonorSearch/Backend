package ru.donorsearch.model.dto.event

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.bloodstation.BloodStationDto
import ru.donorsearch.model.dto.region.CityDto

data class EventDto(
    val id: Int?,
    val city: CityDto?,
    @JsonProperty("city_id")
    val cityId: Int?,
//    val timeSlots: List<TimeSlotDto>?,
    val joinedUsers: String?,
//    val reports: List<ReportDto>?,
    val author: String?,
//    val category: CategoryDto?,
    val userStatus: String?,
    val type: String?,
//    val individualPartners: List<IndividualPartnerDto>?,
//    val unityPartners: List<UnityPartnerDto>?,
//    val donorsRequirements: List<DonorsRequirementDto>?,
    val bloodStation: BloodStationDto?,
    val availableSlots: String?,
//    val socialNetworks: List<SocialNetworkDto>?,
    val createdAt: String?,
    val updatedAt: String?,
    val objectId: Int?,
    val name: String?,
    val description: String?,
    val startDate: String?,
    val endDate: String?,
    val address: String?,
    val email: String?,
    val website: String?,
    val phone: String?,
    val joinedCount: Int?,
    val isPrivate: Boolean?,
    val contentType: Int?
)