package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.donation.DonationPlanDto

@RestController
@RequestMapping("/api/donations")
@RequiredArgsConstructor
class DonationController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping
    fun getDonations(
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): List<DonationPlanDto?> {
//        return hackatonFeignClient.getDonationPlans(donateAtGte, ordering, page, pageSize, search, status)
        return emptyList()
    }

    @PostMapping
    fun createDonation(@RequestBody donation: DonationPlanDto?): DonationPlanDto? {
        return null
    }

    @GetMapping("/{id}")
    fun getDonation(@PathVariable("id") id: Int?): DonationPlanDto? {
        return hackatonFeignClient.getDonationPlan(id)
    }

    @DeleteMapping("/{id}")
    fun deleteDonation(@PathVariable("id") id: Int?) {

    }

    @GetMapping("/is-exists")
    fun checkDonationExistsOnDate(@RequestParam("date") date: String?): Boolean? {
        return true
    }
}