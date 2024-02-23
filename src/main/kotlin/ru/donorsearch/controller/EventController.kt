package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.event.EventDto

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
class EventController(
    private val hackatonFeignClient: HackatonFeignClient
) {

    @GetMapping
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
    ): List<EventDto?> {
        return hackatonFeignClient.getEvents(
            bloodStation,
            byBloodStation,
            byDate,
            id,
            ordering,
            organizationId,
            page,
            pageSize,
            search
        )
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable("id") id: Int?): EventDto? {
        return hackatonFeignClient.getEvent(id)
    }
}