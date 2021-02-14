package com.jimmiemo.recipes.model;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name="domain_type")
@Data
public class RecipeType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String type;
}
