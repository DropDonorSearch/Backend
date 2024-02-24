package ru.donorsearch.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.donorsearch.model.entity.Journal
import java.util.*

interface JournalRepository : JpaRepository<Journal, Long> {
    @Query(nativeQuery = true,
        value = """
            select * from donor_search.journal as journal
            where journal.description ilike any(select concat('%', keyword, '%') from :keywords as keyword)
        """
    )
    fun findByDescriptionContainsKeywords(@Param("keywords") keywords: List<String>): Optional<List<Journal>>
}