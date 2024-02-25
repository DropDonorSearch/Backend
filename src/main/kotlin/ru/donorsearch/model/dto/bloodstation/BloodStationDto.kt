package ru.donorsearch.model.dto.bloodstation

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.PhoneNumberDto
import ru.donorsearch.model.dto.ScheduleDto
import ru.donorsearch.model.dto.region.CityDto

data class BloodStationDto(
    val id: Int?,
    @JsonProperty("city_id")
    val cityId: Int?,
    val city: CityDto?,
    val lat: String?,
    val lng: String?,
    val schedule: List<ScheduleDto?>?,
    @JsonProperty("phone_numbers")
    val phoneNumbers: List<PhoneNumberDto>?,
    @JsonProperty("blood_group")
    val bloodGroup: List<String?>?,
    val title: String?,
    @JsonProperty("parser_url")
    val parserUrl: String?,
    @JsonProperty("is_get_from_parser")
    val isGetFromParser: Boolean?,
    @JsonProperty("o_plus")
    val oPlus: String?,
    @JsonProperty("o_minus")
    val oMinus: String?,
    @JsonProperty("a_plus")
    val aPlus: String?,
    @JsonProperty("a_minus")
    val aMinus: String?,
    @JsonProperty("b_plus")
    val bPlus: String?,
    @JsonProperty("b_minus")
    val bMinus: String?,
    @JsonProperty("ab_plus")
    val abPlus: String?,
    @JsonProperty("ab_minus")
    val abMinus: String?,
    val blood: String?,
    val plasma: String?,
    val platelets: String?,
    val erythrocytes: String?,
    val leukocytes: String?,
    val address: String?,
    val site: String?,
    val phones: String?,
    val email: String?,
    val worktime: String?,
    @JsonProperty("without_registration")
    val withoutRegistration: Boolean?,
    @JsonProperty("with_typing")
    val withTyping: Boolean?,
    @JsonProperty("for_moscow")
    val forMoscow: Boolean?,
    val closed: Boolean?,
    val priority: Int?
)