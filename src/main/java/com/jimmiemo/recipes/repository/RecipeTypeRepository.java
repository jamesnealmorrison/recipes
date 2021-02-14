package com.jimmiemo.recipes.repository;

import com.jimmiemo.recipes.model.RecipeType;
import org.springframework.data.repository.CrudRepository;

public interface RecipeTypeRepository extends CrudRepository<RecipeType, Integer> {
}
