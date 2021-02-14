package com.jimmiemo.recipes.controller;

import com.jimmiemo.recipes.model.Ingredient;
import com.jimmiemo.recipes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping(path="/addIngredient")
    public @ResponseBody String addIngredient(@RequestParam String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredientRepository.save(ingredient);
        return "Saved";
    }

    @GetMapping(path="/allIngredients")
    public @ResponseBody Iterable<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping(path="/ingredient")
    public @ResponseBody Ingredient getOne(@RequestParam int id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
