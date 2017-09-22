package com.agharibi.recipeapp.repositories;

import com.agharibi.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
