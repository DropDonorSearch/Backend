package ru.donorsearch.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.donorsearch.model.entity.SpecialProject


interface SpecialProjectRepository : JpaRepository<SpecialProject, Long> {
}