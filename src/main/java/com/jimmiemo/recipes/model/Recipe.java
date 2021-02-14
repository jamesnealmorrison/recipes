package com.jimmiemo.recipes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
