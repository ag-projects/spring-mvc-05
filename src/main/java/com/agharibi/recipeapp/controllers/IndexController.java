package com.agharibi.recipeapp.controllers;

import com.agharibi.recipeapp.domain.Category;
import com.agharibi.recipeapp.domain.UnitOfMeasure;
import com.agharibi.recipeapp.repositories.CategoryRepository;
import com.agharibi.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage() {

        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.err.println("Cat id is: " + category.get().getId());
        System.err.println("Unit of measure id is: " + unitOfMeasure.get().getId());

        System.err.println("re-run of spring dev tool");
        return "index";
    }
}
