package com.agharibi.recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    private Category category;

    @Before
    public void setup() {

        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long id = 1234L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }

}