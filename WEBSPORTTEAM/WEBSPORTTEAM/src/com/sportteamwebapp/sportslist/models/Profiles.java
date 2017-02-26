package com.sportteamwebapp.sportslist.models;

/**
 * Created by yeyo on 25/02/2017.
 */
public class Profiles {
    private int profile_id;
    private int user_id ;
    private String birthdate;
    private String Center ;
    private String phone ;
    private String description;
    private int price;

    public Profiles(int profile_id, int user_id, String birthdate, String center, String phone, String description, int price) {
        this.profile_id = profile_id;
        this.user_id = user_id;
        this.birthdate = birthdate;
        Center = center;
        this.phone = phone;
        this.description = description;
        this.price = price;
    }


    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCenter() {
        return Center;
    }

    public void setCenter(String center) {
        Center = center;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
