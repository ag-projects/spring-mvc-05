package com.agharibi.recipeapp.services;

import com.agharibi.recipeapp.converters.RecipeCommandToRecipe;
import com.agharibi.recipeapp.converters.RecipeToRecipeCommand;
import com.agharibi.recipeapp.domain.Recipe;
import com.agharibi.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        // Creates a mock recipe repository
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {

        Recipe recipe = new Recipe();
        recipe.setId(12L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe returnedRecipe = recipeService.findById(12L);

        assertNotNull("Null recipe returned", returnedRecipe);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipesTest() throws Exception {
        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        Set<Recipe> recipeSet = recipeService.getRecipes();
        assertEquals(recipeSet.size(), 1);
        
        verify(recipeRepository, times(1)).findAll();
    }

}