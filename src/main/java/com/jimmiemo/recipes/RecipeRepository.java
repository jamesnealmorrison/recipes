package com.jimmiemo.recipes;

import com.jimmiemo.recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
