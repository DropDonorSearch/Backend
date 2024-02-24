package ru.donorsearch.service.impl

import org.springframework.stereotype.Service
import ru.donorsearch.model.dto.specialproject.SpecialProjectDto
import ru.donorsearch.model.mapper.SpecialProjectMapper
import ru.donorsearch.repository.SpecialProjectRepository
import ru.donorsearch.service.SpecialProjectService

@Service
class SpecialProjectServiceImpl(
    private val specialProjectRepository: SpecialProjectRepository,
    private val specialProjectMapper: SpecialProjectMapper
) : SpecialProjectService {
    override fun getSpecialProjects(): List<SpecialProjectDto> {
        return specialProjectMapper.createSpecialProjectDtos(
            specialProjectRepository.findAll())
    }
}