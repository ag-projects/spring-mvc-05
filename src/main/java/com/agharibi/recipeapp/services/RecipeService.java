package com.agharibi.recipeapp.services;

import com.agharibi.recipeapp.commands.RecipeCommand;
import com.agharibi.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long aLong);

    void deleteById(Long id);
}
