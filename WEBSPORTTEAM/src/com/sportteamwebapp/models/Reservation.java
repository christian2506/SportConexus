package com.sportteamwebapp.models;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class Reservation {
    private int reservationId;
    private int sportSpaceId;
    private int userId;
    private double price;

    public Reservation(int reservationId, int sportSpaceId, int userId, double price) {
        this.setReservationId(reservationId);
        this.setSportSpaceId(sportSpaceId);
        this.setUserId(userId);
        this.setPrice(price);
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getSportSpaceId() {
        return sportSpaceId;
    }

    public void setSportSpaceId(int sportSpaceId) {
        this.sportSpaceId = sportSpaceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}