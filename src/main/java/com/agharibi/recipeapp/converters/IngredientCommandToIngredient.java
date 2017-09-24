package com.agharibi.recipeapp.converters;

import com.agharibi.recipeapp.commands.IngredientCommand;
import com.agharibi.recipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomc;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomc) {
        this.uomc = uomc;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomc.convert(source.getUnitOfMeasure()));

        return ingredient;
    }
}
