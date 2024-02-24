package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.donationplan.DonationPlanDto

@RestController
@RequestMapping("/api/donation-plan")
@RequiredArgsConstructor
class DonationPlanController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping
    fun getDonationPlans(
        @CookieValue("token") basicToken: String,
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): List<DonationPlanDto?> {
        return hackatonFeignClient.getDonationPlans(basicToken, donateAtGte, ordering, page, pageSize, search, status)
    }

    @PostMapping
    fun createDonationPlan(
        @CookieValue("token") basicToken: String,
        @RequestBody donation: DonationPlanDto?
    ): DonationPlanDto? {
        return hackatonFeignClient.createDonationPlan(basicToken, donation)
    }

    @GetMapping("/{id}")
    fun getDonationPlan(@PathVariable("id") id: Int?): DonationPlanDto? {
        return hackatonFeignClient.getDonationPlan(id)
    }

    @PatchMapping("/{id}")
    fun patchDonationPlan(
        @CookieValue("token") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donationPlan: DonationPlanDto
    ): DonationPlanDto? {
        return hackatonFeignClient.patchDonationPlan(basicToken, id, donationPlan)
    }

    @PutMapping("/{id}")
    fun putDonationPlan(
        @CookieValue("token") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donationPlan: DonationPlanDto
    ): DonationPlanDto? {
        return hackatonFeignClient.putDonationPlan(basicToken, id, donationPlan)
    }
}