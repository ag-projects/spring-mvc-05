package com.agharibi.recipeapp.services;

import com.agharibi.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
