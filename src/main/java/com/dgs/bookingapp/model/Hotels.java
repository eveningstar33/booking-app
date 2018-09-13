package com.dgs.bookingapp.model;

// This is the model

import javax.persistence.*;

@Entity
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String hotelName;

    private double pricePerNight;

    private int nbOfNights;

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public double getTotalPrice() {
        return pricePerNight * nbOfNights;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setNbOfNights(int nbOfNights) {
        this.nbOfNights = nbOfNights;
    }
}
