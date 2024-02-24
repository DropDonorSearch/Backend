package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.donorsearch.model.dto.specialproject.SpecialProjectDto
import ru.donorsearch.service.SpecialProjectService

@RestController
@RequestMapping("/api/special-projects")
@RequiredArgsConstructor
class SpecialProjectController(
    private val specialProjectService: SpecialProjectService
) {

    @GetMapping
    fun getAllSpecialProjects(): List<SpecialProjectDto> {
        return specialProjectService.getSpecialProjects()
    }
}
