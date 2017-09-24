package com.agharibi.recipeapp.converters;

import com.agharibi.recipeapp.commands.IngredientCommand;
import com.agharibi.recipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomc;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomc) {
        this.uomc = uomc;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {

        if(source == null) {
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasure(uomc.convert(source.getUom()));

        return ingredientCommand;
    }
}
