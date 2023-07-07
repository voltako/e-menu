package edu.diplom.diplom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name, Ingredients;

    private Double cost;

    public Long getId() {
        return id;
    }

    public Dish() {
    }

    public Dish(String name, String ingredients, Double cost) {
        Name = name;
        Ingredients = ingredients;
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
