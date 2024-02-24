package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import ru.donorsearch.feign.HackatonFeignClient
import ru.donorsearch.model.dto.event.EventDto
import ru.donorsearch.model.dto.event.EventsDto
import java.net.URI

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
    ): EventsDto? {

        val eventsDto: EventsDto? = hackatonFeignClient.getEvents(
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

        if (eventsDto?.next != null) {
            val uri = URI(eventsDto.next!!)
            // Удаление сегмента `/api` из пути
            eventsDto.next = uri.path.replace("/api", "")
        }

        if (eventsDto?.previous != null) {
            val index = eventsDto.previous!!.indexOf("/api")
            eventsDto.previous = eventsDto.previous!!.substring(index + 4, eventsDto.next!!.lastIndex - 1)
        }

        return eventsDto
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable("id") id: Int?): EventDto? {
        return hackatonFeignClient.getEvent(id)
    }
}