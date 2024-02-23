package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.bloodstation.BloodStationDto
import ru.donorsearch.model.dto.bloodstation.BloodStationUsersDto
import ru.donorsearch.model.dto.bloodstation.BloodStationsDto

@RestController
@RequestMapping("/api/blood-stations")
@RequiredArgsConstructor
class BloodStationController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping("/{id}")
    fun getBloodStation(@PathVariable("id") id: Int): BloodStationDto? {
        return hackatonFeignClient.getBloodStation(id)
    }

    @GetMapping
    fun getBloodStations(
        @RequestParam("blood_group", required = false) bloodGroup: String?,
        @RequestParam("city_id", required = false) cityId: Int?,
        @RequestParam("city_slug", required = false) citySlug: String?,
        @RequestParam("closed", required = false) closed: Boolean?,
        @RequestParam("for_moscow", required = false) forMoscow: Boolean?,
        @RequestParam("open_on_saturday", required = false) openOnSaturday: Boolean?,
        @RequestParam("open_on_sunday", required = false) openOnSunday: Boolean?,
        @RequestParam("ordering", required = false) ordering: String?,
        @RequestParam("page", required = false) page: Int?,
        @RequestParam("page_size", required = false) pageSize: Int?,
        @RequestParam("q", required = false) search: String?,
        @RequestParam("with_typing", required = false) withTyping: Boolean?,
        @RequestParam("without_registration", required = false) withoutRegistration: Boolean?,
        @RequestParam("status", required = false) status: String?
    ): BloodStationsDto? {
        val stations: BloodStationsDto? =
            hackatonFeignClient.getBloodStations(
                bloodGroup, cityId, citySlug, closed, forMoscow, openOnSaturday,
                openOnSunday, ordering, page, pageSize, search, withTyping, withoutRegistration, status
            )

        return stations
    }

    @GetMapping("/{id}/planned")
    fun getUsersWithPlannedDonations(@PathVariable("id") id: Int): BloodStationUsersDto? {
        return hackatonFeignClient.getUsersWithPlannedDonations(id)
    }
}