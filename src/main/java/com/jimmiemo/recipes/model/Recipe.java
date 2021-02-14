package com.jimmiemo.recipes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String source;
	private Integer timesCooked;
	private Integer jimRanking;
	private Integer tracyRanking;
	private String page;
	private String notes;
	@OneToMany
	@JoinTable(name="recipe_ingredients",
			joinColumns=@JoinColumn(name="recipe_id"),
			inverseJoinColumns=@JoinColumn(name="ingredient_id")
	)
	private Set<Ingredient> ingredients;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="type",
			referencedColumnName = "id")
	private RecipeType recipeType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ethnicity",
			referencedColumnName = "id")
	private Ethnicity ethnicity;

	public boolean containsAll(List<Integer> ingredientIds) {
		for (Integer ingredientId : ingredientIds) {
			if (ingredients.stream().map(Ingredient::getId).noneMatch(id -> id.equals(ingredientId))) {
				return false;
			}
		}
		return true;
	}
}
