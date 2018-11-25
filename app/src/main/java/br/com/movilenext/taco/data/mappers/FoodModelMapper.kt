package br.com.movilenext.taco.data.mappers

import br.com.movilenext.taco.core.extension.getSafe
import br.com.movilenext.taco.data.ws.food.Food
import br.com.movilenext.taco.presentation.features.food.list.AttributeModel
import br.com.movilenext.taco.presentation.features.food.list.FoodAttributesModel
import br.com.movilenext.taco.presentation.features.food.list.FoodModel
import javax.inject.Inject

class FoodModelMapper @Inject constructor() : Mapper<FoodModel, Food> {
    override fun transform(from: FoodModel): Food {
        TODO("not implemented")
    }

    override fun toFrom(to: Food): FoodModel {
        return FoodModel(
                name = to.name,
                baseInfo = "${to.baseQtd} ${to.baseUnit}",
                vitaminC = to.vitaminC?.let { "${it.qty} ${it.unit}" } ?: "",
                categoryId = to.categoryId,
                attributes = FoodAttributesModel(
                        carbohydrate = AttributeModel(
                                to.attributes.carbohydrate?.qty.getSafe(),
                                to.attributes.carbohydrate?.unit.getSafe()
                        ),
                        sodium = AttributeModel(
                                to.attributes.sodium?.qty.getSafe(),
                                to.attributes.sodium?.unit.getSafe()
                        ),
                        energy = AttributeModel(
                                to.attributes.energy?.kcal.toString().getSafe(),
                                to.attributes.energy?.kj.toString().getSafe()
                        ),
                        cholesterol = AttributeModel(
                                to.attributes.cholesterol?.qty.getSafe(),
                                to.attributes.cholesterol?.unit.getSafe()
                        ),
                        iron = AttributeModel(
                                to.attributes.iron?.qty.getSafe(),
                                to.attributes.iron?.unit.getSafe()
                        )
                )
        )
    }

}