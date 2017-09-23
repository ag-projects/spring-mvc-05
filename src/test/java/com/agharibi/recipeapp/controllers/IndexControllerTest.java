package com.agharibi.recipeapp.controllers;

import com.agharibi.recipeapp.domain.Recipe;
import com.agharibi.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    private IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() throws Exception {

        Set<Recipe> recipes = new HashSet<>();

        Recipe kebabRecipe = new Recipe();
        kebabRecipe.setId(123L);
        recipes.add(kebabRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setId(452L);
        recipes.add(tacosRecipe);

        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> recipeArguemnt = ArgumentCaptor.forClass(Set.class);
        String viewIndexValue = indexController.getIndexPage(model);

        assertEquals("index", viewIndexValue);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), recipeArguemnt.capture());
        Set<Recipe> arguemntValue = recipeArguemnt.getValue();
        assertEquals(2, arguemntValue.size());
    }



}