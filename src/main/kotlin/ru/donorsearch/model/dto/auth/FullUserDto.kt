package ru.donorsearch.model.dto.auth

import com.fasterxml.jackson.annotation.JsonProperty
import ru.donorsearch.model.dto.region.CityDto

data class FullUserDto(
    val id: Int?,
    @JsonProperty("date_joined")
    val dateJoined: String?,
    val username: String?,
    @JsonProperty("first_name")
    val firstName: String?,
    @JsonProperty("last_name")
    val lastName: String?,
    @JsonProperty("middle_name")
    val middleName: String?,
    @JsonProperty("maiden_name")
    val maidenName: String?,
    @JsonProperty("birth_date")
    val birthDate: String?,
    val gender: String?,
    val email: String?,
    val phone: String?,
    @JsonProperty("login_via_phone")
    val loginViaPhone: Boolean?,
    val about: String?,
    @JsonProperty("city_id")
    val cityId: Int?,
    val city: CityDto?,
    @JsonProperty("is_pin_20")
    val isPin20: Boolean?,
    @JsonProperty("is_pin_100")
    val isPin100: Boolean?,
//    @JsonProperty("donation_agg")
//    val donationAgg: DonationAgg?,
    val socials: List<String>?,
    val photo: String?,
    @JsonProperty("photo_id")
    val photoId: String?,
//    @JsonProperty("next_donation_date")
//    val nextDonationDate: LocalDateTime?,
//    @JsonProperty("next_donation")
//    val nextDonation: NextDonation?,
    @JsonProperty("blood_group")
    val bloodGroup: String?,
    @JsonProperty("has_password")
    val hasPassword: Boolean?,
    @JsonProperty("is_email_verified")
    val isEmailVerified: Boolean?,
    @JsonProperty("is_phone_verified")
    val isPhoneVerified: Boolean?,
    @JsonProperty("email_reconfirmed_at")
    val emailReconfirmedAt: String?,
    @JsonProperty("phone_reconfirmed_at")
    val phoneReconfirmedAt: String?,
    @JsonProperty("legacy_avatar")
    val legacyAvatar: String?,
    @JsonProperty("start_donor_year")
    val startDonorYear: String?,
    @JsonProperty("referal_code")
    val referralCode: String?,
    @JsonProperty("parent_user")
    val parentUser: String?,
    @JsonProperty("invited_users")
    val invitedUsers: List<String>?,
//    @JsonProperty("donor_status")
//    val donorStatus: DonorStatus?,
    @JsonProperty("managed_organizations")
    val managedOrganizations: List<String>?,
    @JsonProperty("joined_events")
    val joinedEvents: List<String>?,
    @JsonProperty("joined_organizations")
    val joinedOrganizations: List<String>?,
    @JsonProperty("donor_certificate")
    val donorCertificate: Boolean?
)