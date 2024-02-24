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

@Retryable(
    exclude = [FeignException.InternalServerError::class, FeignException.BadRequest::class
    ],
    maxAttemptsExpression = "\${external-service.retry.attempts}",
    backoff = Backoff(delayExpression = "\${external-service.retry.delay}")
)
@FeignClient(name = "hackaton", url = "\${client.hackathon}")
@Headers("Authorization: Basic {requester}")
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
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): List<DonationPlanDto>

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

    @PostMapping("auth/change_email/")
    fun changeEmail(@RequestBody emailDto: EmailDto?): StatusDto?

    @PostMapping("/change_password/")
    fun changePassword(@RequestBody passwordDto: PasswordDto?): FullUserDto?

    @PostMapping("/change_phone/")
    fun changePhone(@RequestBody phoneDto: PhoneDto?): StatusDto?

    @PostMapping("/confirm_email/")
    fun confirmEmail(@RequestBody emailDto: ConfirmEmailDto?): StatusDto?

    @PostMapping("/confirm_phone/")
    fun confirmPhone(@RequestBody phoneDto: PhoneDto?): StatusDto?

    @PostMapping("/login/")
    fun login(@RequestBody loginDto: LoginDto?): FullUserDto?

    @GetMapping("/me/")
    fun getCurrentUser(): FullUserDto?

    @PatchMapping("/me/")
    fun updateCurrentUser(@RequestBody userDto: FullUserDto?): FullUserDto?

    @GetMapping("/donations/")
    fun getDonations(
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): DonationDtoWithPaging

    @PostMapping("/donations/")
    fun createDonation(
        @RequestBody donation: DonationDto?
    ) : DonationDto

//    TODO: modify donation dto for this call
    @GetMapping("/donations/{id}")
    fun getDonation(@PathVariable("id") id: Int): DonationDto?
}