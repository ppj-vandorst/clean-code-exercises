package com.novi.easyboat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Boat {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String type;

    @OneToOne(mappedBy = "boat")
    @JsonBackReference("skipperBoat")
    Skipper skipper;

    @OneToMany(mappedBy = "boat")
    List<Booking> bookings;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Skipper getSkipper() {
        return skipper;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSkipper(Skipper skipper) {
        this.skipper = skipper;
    }
}
