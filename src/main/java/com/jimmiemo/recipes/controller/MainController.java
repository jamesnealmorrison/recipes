package com.jimmiemo.recipes.controller;

import com.jimmiemo.recipes.repository.RecipeRepository;
import com.jimmiemo.recipes.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
	private RecipeRepository recipeRepository;

	@PostMapping(path="/addRecipe")
	public @ResponseBody String addRecipe(@RequestParam String name,
										   @RequestParam String source) {
		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setSource(source);
		recipeRepository.save(recipe);
		return "Saved";
	}

	@GetMapping(path="/allRecipes")
	public @ResponseBody Iterable<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@GetMapping(path="/recipe")
	public @ResponseBody Recipe getOne(@RequestParam int id) {
		return recipeRepository.findById(id).orElse(null);
	}
}
