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
            return bonusMapper.getBonusDtos(userOpt.get().bonuses)
        }

        return emptyList()
    }

    override fun takeBonusForUser(userId: Long, bonusId: Long): BonusDto? {
//        val bonusOpt = userTakenBonusRepository
//            .deleteByUserIdAndBonusId(userId, bonusId)
//
//        if (bonusOpt.isPresent) {
//            val bonus = bonusOpt.get().bonus ?: return null
//            userTakenBonusRepository.deleteByUserIdAndBonusId(userId, bonusId)
//            return bonusMapper.getBonusDto(bonus)
//        }
//
        val userOpt = userRepository.findByExternalId(userId)

        if (userOpt.isPresent) {
            val bonuses = userOpt.get().bonuses ?: return null
            val bonusOpt = bonuses.stream().filter { it.bonusId == bonusId }?.findFirst()

            if (bonusOpt == null || bonusOpt.isEmpty) {
                return null
            }

            bonuses.removeIf { it.bonusId == bonusId }
            val result = bonusMapper.getBonusDto(bonusOpt.get())

            userOpt.get().bonuses?.removeIf { it.bonusId == bonusId }
            bonusOpt.get().users?.removeIf { it.externalId == userId }
            userRepository.save(userOpt.get())
            bonusRepository.save(bonusOpt.get())

            return result
        }

        return null
    }
}