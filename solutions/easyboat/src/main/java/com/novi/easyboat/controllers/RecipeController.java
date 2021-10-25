package com.novi.easyboat.controllers;

import com.novi.easyboat.model.Recipe;
import com.novi.easyboat.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeRepository repository;

    @Autowired
    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return this.repository.save(recipe);
    }
}
