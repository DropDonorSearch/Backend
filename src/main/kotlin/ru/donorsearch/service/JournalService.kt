package ru.donorsearch.service

import ru.donorsearch.model.dto.journal.JournalDto

interface JournalService {
    fun getJournals(): List<JournalDto>
    fun findJournalsByKeyWords(keywords: List<String>): List<JournalDto>
}