package com.agharibi.recipeapp.controllers;

import com.agharibi.recipeapp.domain.Category;
import com.agharibi.recipeapp.domain.UnitOfMeasure;
import com.agharibi.recipeapp.repositories.CategoryRepository;
import com.agharibi.recipeapp.repositories.UnitOfMeasureRepository;
import com.agharibi.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {


    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
