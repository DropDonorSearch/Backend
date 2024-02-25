package ru.donorsearch.service

import ru.donorsearch.model.dto.bonus.BonusDto

interface BonusService {
    fun getBonusesForUser(userId: Long): List<BonusDto>

    fun takeBonusForUser(userId: Long, bonusId: Long)
}