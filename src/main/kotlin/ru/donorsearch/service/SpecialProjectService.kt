package ru.donorsearch.service

import ru.donorsearch.model.dto.specialproject.SpecialProjectDto

interface SpecialProjectService {
    fun getSpecialProjects(): List<SpecialProjectDto>;
}