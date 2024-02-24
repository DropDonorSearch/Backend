package ru.donorsearch.model.dto.journal

import java.time.LocalDateTime

data class JournalDto(
    var journalId: Long,
    var author: String,
    var title: String,
    var description: String,
    var created: LocalDateTime?,
    var updated: LocalDateTime?
)