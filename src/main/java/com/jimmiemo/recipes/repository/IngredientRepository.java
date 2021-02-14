package com.jimmiemo.recipes.repository;

import com.jimmiemo.recipes.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

}
