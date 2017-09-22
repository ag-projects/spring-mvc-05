package com.agharibi.recipeapp.repositories;

import com.agharibi.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
