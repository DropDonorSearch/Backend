package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.donationplan.DonationPlanDto
import ru.donorsearch.model.dto.donationplan.DonationPlanDtoWithPaging

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
    ): DonationPlanDtoWithPaging? {
        return hackatonFeignClient.getDonationPlans("Basic $basicToken", donateAtGte, ordering, page, pageSize, search, status)
    }

    @PostMapping
    fun createDonationPlan(
        @CookieValue("token") basicToken: String,
        @RequestBody donation: DonationPlanDto?
    ): DonationPlanDto? {
        return hackatonFeignClient.createDonationPlan("Basic $basicToken", donation)
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
        return hackatonFeignClient.patchDonationPlan("Basic $basicToken", id, donationPlan)
    }

    @PutMapping("/{id}")
    fun putDonationPlan(
        @CookieValue("token") basicToken: String,
        @PathVariable("id") id: Int,
        @RequestBody donationPlan: DonationPlanDto
    ): DonationPlanDto? {
        return hackatonFeignClient.putDonationPlan("Basic $basicToken", id, donationPlan)
    }
}