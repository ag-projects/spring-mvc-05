package com.agharibi.recipeapp.controllers;

import com.agharibi.recipeapp.domain.Category;
import com.agharibi.recipeapp.domain.UnitOfMeasure;
import com.agharibi.recipeapp.repositories.CategoryRepository;
import com.agharibi.recipeapp.repositories.UnitOfMeasureRepository;
import com.agharibi.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Retrieving index page");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
