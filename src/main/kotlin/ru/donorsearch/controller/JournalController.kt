package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.donorsearch.model.dto.journal.JournalDto
import ru.donorsearch.service.JournalService


@RestController
@RequestMapping("/api/journals")
@RequiredArgsConstructor
class JournalController (
    private val journalService: JournalService
) {

    @GetMapping
    fun getAll(): List<JournalDto> {
        return journalService.getJournals();
    }

    @GetMapping("/keywords")
    fun getJournalsByKeywords(@RequestParam("keywords") keywords: List<String>): List<JournalDto> {
        return journalService.findJournalsByKeyWords(keywords);
    }
}