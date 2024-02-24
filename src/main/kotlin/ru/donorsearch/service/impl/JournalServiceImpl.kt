package ru.donorsearch.service.impl

import org.springframework.stereotype.Service
import ru.donorsearch.model.dto.journal.JournalDto
import ru.donorsearch.model.mapper.JournalMapper
import ru.donorsearch.repository.JournalRepository
import ru.donorsearch.service.JournalService

@Service
class JournalServiceImpl(
    private val journalRepository: JournalRepository,
    private val journalMapper: JournalMapper,
) : JournalService {
    override fun getJournals(): List<JournalDto> {
        return journalMapper.createJournalDtoList(
            journalRepository.findAll()
        )
    }

    override fun findJournalsByKeyWords(keywords: List<String>): List<JournalDto> {
        return journalMapper.createJournalDtoList(
            journalRepository.findAll()
                .stream()
                .filter { j -> keywords.stream().anyMatch { k -> j.description.contains(k, true) } }
                .toList()
        )
    }
}