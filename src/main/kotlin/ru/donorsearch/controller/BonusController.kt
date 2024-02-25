package ru.donorsearch.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.donorsearch.model.dto.bonus.BonusDto
import ru.donorsearch.service.BonusService

@RestController
@RequestMapping("/api/bonuses")
@RequiredArgsConstructor
class BonusController(
    private val bonusService: BonusService
) {

    @GetMapping
    fun getBonuses(@RequestParam("userId") userId: Long): List<BonusDto?> {
        return bonusService.getBonusesForUser(userId)
    }

    @DeleteMapping
    fun takeBonus(
        @RequestParam("userId") userId: Long,
        @RequestParam("bonusId") bonusId: Long
    ) {
        bonusService.takeBonusForUser(userId, bonusId)
    }
}