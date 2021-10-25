package com.novi.easyboat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Boat boat;

    @ManyToOne
    Customer customer;

    LocalDateTime plannedStartTime;

    LocalDateTime plannedEndTime;

    LocalDateTime actualStartTime;

    LocalDateTime actualEndTime;

    Double charge;

    BookingStatus status;

    String discountCode;

    // Getters
    public Long getId() {
        return id;
    }

    public Boat getBoat() {
        return boat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public LocalDateTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public LocalDateTime getActualStartTime() {
        return actualStartTime;
    }

    public LocalDateTime getActualEndTime() {
        return actualEndTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Double getCharge() {
        return charge;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPlannedStartTime(LocalDateTime plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public void setPlannedEndTime(LocalDateTime plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public void setActualStartTime(LocalDateTime actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public void setActualEndTime(LocalDateTime actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
