package ru.donorsearch.service.impl

import org.springframework.stereotype.Service
import ru.donorsearch.model.dto.bonus.BonusDto
import ru.donorsearch.model.mapper.BonusMapper
import ru.donorsearch.repository.BonusRepository
import ru.donorsearch.repository.UserRepository
import ru.donorsearch.service.BonusService

@Service
class BonusServiceImpl(
    private val bonusRepository: BonusRepository,
    private val userRepository: UserRepository,
    private val bonusMapper: BonusMapper
) : BonusService {

    override fun getBonusesForUser(userId: Long): List<BonusDto> {

        val userOpt = userRepository.findByExternalId(userId)

        if (userOpt.isPresent) {
            val test = bonusRepository.findAll()
            userOpt.get().bonuses?.let { test.removeAll(it) }
            return bonusMapper.getBonusDtos(test)
        }

        return emptyList()
    }

    override fun takeBonusForUser(userId: Long, bonusId: Long) {
        val userOpt = userRepository.findByExternalId(userId)

        if (userOpt.isPresent) {

            val bonusOpt = bonusRepository.findById(bonusId)

            if (bonusOpt.isEmpty) {
                return
            }

            val bonus = bonusOpt.get()

            val user = userOpt.get()
            val bonuses = user.bonuses ?: ArrayList()

            if (bonuses.isNotEmpty()) {
                bonuses.add(bonus)
            } else {
                user.bonuses = mutableListOf(bonus)
            }

            userRepository.save(user)
            bonusRepository.save(bonus)
        }
    }
}