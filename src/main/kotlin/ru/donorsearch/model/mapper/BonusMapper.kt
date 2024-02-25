package ru.donorsearch.model.mapper

import org.mapstruct.Mapper
import ru.donorsearch.model.dto.bonus.BonusDto
import ru.donorsearch.model.entity.Bonus

@Mapper(componentModel = "spring")
interface BonusMapper {

    fun getBonusDto(bonus: Bonus): BonusDto
    fun getBonusDtos(bonuses: MutableList<Bonus>?): List<BonusDto>
}