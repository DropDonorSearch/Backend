package ru.donorsearch.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.donorsearch.model.entity.Bonus

interface BonusRepository : JpaRepository<Bonus, Long> {

}