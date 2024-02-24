package ru.donorsearch.feign

import feign.FeignException
import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.web.bind.annotation.*
import ru.donorsearch.model.dto.auth.*
import ru.donorsearch.model.dto.event.EventDto
import ru.donorsearch.model.dto.bloodstation.BloodStationDto
import ru.donorsearch.model.dto.bloodstation.BloodStationUsersDto
import ru.donorsearch.model.dto.bloodstation.BloodStationsDto
import ru.donorsearch.model.dto.donation.DonationDto
import ru.donorsearch.model.dto.donation.DonationDtoWithPaging
import ru.donorsearch.model.dto.donationplan.DonationPlanDto
import ru.donorsearch.model.dto.event.EventsDto
import ru.donorsearch.model.dto.region.CitiesDto

@Retryable(
    exclude = [FeignException.InternalServerError::class, FeignException.BadRequest::class,
//        FeignException.Unauthorized::class
    ],
    maxAttemptsExpression = "3",
    backoff = Backoff(delayExpression = "3000")
)
@FeignClient(name = "hackaton", url = "\${client.hackathon}")
interface HackatonFeignClient {

    @PostMapping("/auth/registration/")
    fun register(@RequestBody(required = true) registerDto: RegisterDto): UserDto?

    @GetMapping("/blood_stations/{id}/")
    fun getBloodStation(@PathVariable("id") id: Int): BloodStationDto?

    @GetMapping("/blood_stations/", consumes = ["application/json"])
    fun getBloodStations(
        @RequestParam("blood_group") bloodGroup: String?,
        @RequestParam("city_id") cityId: Int?,
        @RequestParam("city_slug") citySlug: String?,
        @RequestParam("closed") closed: Boolean?,
        @RequestParam("for_moscow") forMoscow: Boolean?,
        @RequestParam("open_on_saturday") openOnSaturday: Boolean?,
        @RequestParam("open_on_sunday") openOnSunday: Boolean?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("q") search: String?,
        @RequestParam("with_typing") withTyping: Boolean?,
        @RequestParam("without_registration") withoutRegistration: Boolean?,
        @RequestParam("status") status: String?
    ): BloodStationsDto?

    @GetMapping("/blood_stations/{id}/planned/")
    fun getUsersWithPlannedDonations(@PathVariable id: Int?): BloodStationUsersDto?

    @GetMapping("/donation_plan/{id}/")
    fun getDonationPlan(@PathVariable("id") id: Int?): DonationPlanDto?

    @GetMapping("/donation_plan/")
    fun getDonationPlans(
        @RequestHeader("Authorization") basicToken: String,
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): List<DonationPlanDto?>

    @PostMapping("/donation_plan/")
    fun createDonationPlan(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody donation: DonationPlanDto?
    ): DonationPlanDto

    @PatchMapping("/donation_plan/{id}/")
    fun patchDonationPlan(
        @RequestHeader("Authorization") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donation: DonationPlanDto?
    ): DonationPlanDto?

    @PutMapping("/donation_plan/{id}/")
    fun putDonationPlan(
        @RequestHeader("Authorization") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donation: DonationPlanDto?
    ): DonationPlanDto?

    @GetMapping("/events/")
    fun getEvents(
        @RequestParam("blood_station") bloodStation: Int?,
        @RequestParam("by_blood_station") byBloodStation: String?,
        @RequestParam("by_date") byDate: String?,
        @RequestParam("id") id: Int?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("organization_id") organizationId: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?
    ): EventsDto?

    @GetMapping("/{id}/")
    fun getEvent(@PathVariable("id") id: Int?): EventDto?

    @PostMapping("/auth/change_email/")
    fun changeEmail(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody emailDto: EmailDto?
    ): StatusDto?

    @PostMapping("/change_password/")
    fun changePassword(@RequestBody passwordDto: PasswordDto?): FullUserDto?

    @PostMapping("/auth/change_phone/")
    fun changePhone(@RequestBody phoneDto: PhoneDto?): StatusDto?

    @PostMapping("/auth/confirm_email_reg/")
    fun confirmEmailReg(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody emailDto: ConfirmEmailDto?
    ): StatusDto?

    @PostMapping("/auth/confirm_phone/")
    fun confirmPhone(@RequestBody phoneDto: PhoneDto?): StatusDto?

    @PostMapping("/auth/login/")
    fun login(@RequestBody loginDto: LoginDto?): FullUserDto?

    @GetMapping("/auth/me/")
    fun getCurrentUser(@RequestHeader("Authorization") basicToken: String): FullUserDto?

    @PatchMapping("/me/")
    fun updateCurrentUser(@RequestBody userDto: FullUserDto?): FullUserDto?

    @GetMapping("/cities/")
    fun getCities(
        @RequestParam("all_bs") allBloodStations: Boolean?,
        @RequestParam("country") country: Int?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("region") region: Int?,
        @RequestParam("s") search: String?,
        @RequestParam("with_bs") withBloodStations: Boolean?
    ): CitiesDto?

    @GetMapping("/donations/")
    fun getDonations(
        @RequestHeader("Authorization") basicToken: String,
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): DonationDtoWithPaging

    @PostMapping("/donations/")
    fun createDonation(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody donation: DonationDto?
    ): DonationDto

    @GetMapping("/donations/{id}/")
    fun getDonation(
        @RequestHeader("Authorization") basicToken: String,
        @PathVariable("id") id: Int
    ): DonationDto?

    @PatchMapping("/donations/{id}/")
    fun patchDonation(
        @RequestHeader("Authorization") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donation: DonationDto?
    ): DonationDto?

    @PutMapping("/donations/{id}/")
    fun putDonation(
        @RequestHeader("Authorization") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donation: DonationDto?
    ): DonationDto?
}