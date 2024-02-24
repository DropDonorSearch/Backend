package ru.donorsearch.model.dto.specialproject

import ru.donorsearch.model.entity.enums.SpecialProjectStatusEnum
import java.time.LocalDate
import java.time.LocalDateTime

data class SpecialProjectDto (
    var specialProjectId: Long?,
    var imageUrl: String,
    var status: SpecialProjectStatusEnum = SpecialProjectStatusEnum.ONLINE,
    var date: LocalDate,
    var title: String,
    var description: String,
    var created: LocalDateTime?,
    var updated: LocalDateTime?
)