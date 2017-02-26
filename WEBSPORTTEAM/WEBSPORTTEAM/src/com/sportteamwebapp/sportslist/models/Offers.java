package com.sportteamwebapp.sportslist.models;

/**
 * Created by yeyo on 25/02/2017.
 */
public class Offers {
    private int offer_id;
    private int user_id;
    private String service;
    private String level;
    private String star_date;
    private String end_date;
    private String days;
    private int hours;
    private String descripcion;
    private int vacant;
    private String status;

    public Offers(int offer_id, int user_id, String service, String level, String star_date, String end_date, String days, int hours, String descripcion, int vacant, String status) {
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.service = service;
        this.level = level;
        this.star_date = star_date;
        this.end_date = end_date;
        this.days = days;
        this.hours = hours;
        this.descripcion = descripcion;
        this.vacant = vacant;
        this.status = status;
    }


    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStar_date() {
        return star_date;
    }

    public void setStar_date(String star_date) {
        this.star_date = star_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVacant() {
        return vacant;
    }

    public void setVacant(int vacant) {
        this.vacant = vacant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
