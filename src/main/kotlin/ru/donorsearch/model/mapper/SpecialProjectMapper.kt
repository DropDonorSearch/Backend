package ru.donorsearch.model.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.Mappings
import ru.donorsearch.model.dto.specialproject.SpecialProjectDto
import ru.donorsearch.model.entity.SpecialProject

@Mapper(componentModel = "spring")
interface SpecialProjectMapper {

    fun createSpecialProjectDto(specialProject: SpecialProject?): SpecialProjectDto
    fun createSpecialProjectDtos(specialProjects: List<SpecialProject>): List<SpecialProjectDto>

    fun createSpecialProject(specialProjectDto: SpecialProjectDto): SpecialProject

    @Mappings(value = [
        Mapping(target = "specialProjectId", ignore = true)
    ])
    fun updateSpecialProject(@MappingTarget specialProject: SpecialProject, specialProjectDto: SpecialProjectDto): SpecialProject
}