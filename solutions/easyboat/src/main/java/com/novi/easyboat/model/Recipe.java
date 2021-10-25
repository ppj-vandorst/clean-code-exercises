package com.novi.easyboat.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    List<Ingredient> ingredients;
}

