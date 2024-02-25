package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.donation.DonationDto
import ru.donorsearch.model.dto.donation.DonationDtoWithPaging
import ru.donorsearch.model.dto.donationplan.DonationPlanDto

@RestController
@RequestMapping("/api/donations")
@RequiredArgsConstructor
class DonationController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping
    fun getDonations(
        @CookieValue("token") basicToken: String,
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): DonationDtoWithPaging {
        return hackatonFeignClient.getDonations("Basic $basicToken", donateAtGte, ordering, page, pageSize, search, status)
    }

    @PostMapping
    fun createDonation(
        @CookieValue("token") basicToken: String,
        @RequestBody donation: DonationDto?
    ): DonationDto? {
        return hackatonFeignClient.createDonation("Basic $basicToken", donation)
    }

    @GetMapping("/{id}")
    fun getDonation(
        @CookieValue("token") basicToken: String,
        @PathVariable("id") id: Int
    ): DonationDto? {
        return hackatonFeignClient.getDonation("Basic $basicToken", id)
    }

    @PatchMapping("/{id}")
    fun patchDonation(
        @CookieValue("token") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donation: DonationDto
    ): DonationDto? {
        return hackatonFeignClient.patchDonation("Basic $basicToken", id, donation)
    }

    @PutMapping("/{id}")
    fun putDonation(
        @CookieValue("token") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donation: DonationDto
    ): DonationDto? {
        return hackatonFeignClient.putDonation("Basic $basicToken", id, donation)
    }

    @DeleteMapping("/{id}")
    fun deleteDonation(@PathVariable("id") id: Int?) {
        return
    }

    @GetMapping("/is-exists")
    fun checkDonationExistsOnDate(@RequestParam("date") date: String?): Boolean? {
        return true
    }
}