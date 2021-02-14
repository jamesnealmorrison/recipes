package com.jimmiemo.recipes.controller;

import com.jimmiemo.recipes.model.RecipeType;
import com.jimmiemo.recipes.repository.RecipeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypeController {
    @Autowired
    private RecipeTypeRepository recipeTypeRepository;

    @PostMapping(path="/addRecipeType")
    public @ResponseBody String addRecipeType(@RequestParam String type) {
        RecipeType recipeType = new RecipeType();
        recipeType.setType(type);
        recipeTypeRepository.save(recipeType);
        return "Saved";
    }

    @GetMapping(path="/allRecipeTypes")
    public @ResponseBody Iterable<RecipeType> getAllRecipeTypes() {
        return recipeTypeRepository.findAll();
    }

    @GetMapping(path="/recipeType")
    public @ResponseBody RecipeType getOne(@RequestParam int id) {
        return recipeTypeRepository.findById(id).orElse(null);
    }
}
