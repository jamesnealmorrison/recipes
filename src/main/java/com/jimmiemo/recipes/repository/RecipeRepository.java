package com.jimmiemo.recipes.repository;

import com.jimmiemo.recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
