package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.region.CitiesDto
import ru.donorsearch.model.dto.region.CityDto
import ru.donorsearch.model.dto.region.CountryDto
import ru.donorsearch.model.dto.region.RegionDto

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class RegionsController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping("/cities")
    fun getCities(
        @RequestParam("all_bs") allBloodStations: Boolean?,
        @RequestParam("country") country: Int?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("region") region: Int?,
        @RequestParam("s") search: String?,
        @RequestParam("with_bs") withBloodStations: Boolean?
    ): CitiesDto? {
        return hackatonFeignClient.getCities(
            allBloodStations,
            country,
            ordering,
            page,
            pageSize,
            region,
            search,
            withBloodStations
        )
    }

    @GetMapping("/countries")
    fun getCountries(
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): List<CountryDto?> {
        return emptyList()
    }

    @GetMapping("/regions")
    fun getRegions(
        @RequestParam("donate_at__gte") donateAtGte: String?,
        @RequestParam("ordering") ordering: String?,
        @RequestParam("page") page: Int?,
        @RequestParam("page_size") pageSize: Int?,
        @RequestParam("search") search: String?,
        @RequestParam("status") status: String?
    ): List<RegionDto?> {
        return emptyList()
    }
}