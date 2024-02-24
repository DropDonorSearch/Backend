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
        @RequestHeader("Authorization") basicToken: String,
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): DonationDtoWithPaging {
        return hackatonFeignClient.getDonations(basicToken, donateAtGte, ordering, page, pageSize, search, status)
    }

    @PostMapping
    fun createDonation(
        @RequestHeader("Authorization") basicToken: String,
        @RequestBody donation: DonationDto?
    ): DonationDto? {
        return hackatonFeignClient.createDonation(basicToken, donation)
    }

    @GetMapping("/{id}")
    fun getDonation(
        @RequestHeader("Authorization") basicToken: String,
        @PathVariable("id") id: Int
    ): DonationDto? {
        return hackatonFeignClient.getDonation(basicToken, id)
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