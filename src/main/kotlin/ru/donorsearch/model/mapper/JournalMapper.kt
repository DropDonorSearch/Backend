package ru.donorsearch.model.mapper

import org.mapstruct.Mapper
import ru.donorsearch.model.dto.journal.JournalDto
import ru.donorsearch.model.entity.Journal

@Mapper(componentModel = "spring")
interface JournalMapper {
    fun createJournalDto(journal: Journal): JournalDto
    fun createJournalDtoList(journals: List<Journal>): List<JournalDto>
}