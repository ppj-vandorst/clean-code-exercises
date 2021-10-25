package com.novi.easyboat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Skipper {

    @Id
    @GeneratedValue
    Long id;

    String firstname;

    String lastname;

    String phoneNumber;

    @Lob
    byte[] license;

    @OneToOne
    @JsonBackReference("skipperBoat")
    Boat boat;

    public Long getId() {
        return id;
    }

    // Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public byte[] getLicense() {
        return license;
    }

    public Boat getBoat() {
        return boat;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLicense(byte[] license) {
        this.license = license;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
