package com.novi.easyboat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Recipe recipe;

}
