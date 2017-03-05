package com.sportteamwebapp.models;

import com.sportteamwebapp.STService;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {

    private int profile_id;
    private User user;
    private String birthdate;
    private String phone;
    private String description;
    private double price;

    public Profile(int profile_id, User user, String birthdate, String phone, String description, double price) {
        this.setProfile_id(profile_id);
        this.setUser(user);
        this.setBirthdate(birthdate);
        this.setPhone(phone);
        this.setDescription(description);
        this.setPrice(price);
    }


    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Profile buildFromResultSet(ResultSet resultSet) {
        Profile profile = null;
        STService service = new STService();
        try {
            profile = new Profile(
                    resultSet.getInt("profile_id"),
                    service.getUser(resultSet.getInt("profile_id")),
                    resultSet.getString("birthdate"),
                    resultSet.getString("phone"),
                    resultSet.getString("description"),
                    resultSet.getInt("price")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }

    public static Profile buildFromResultSet(ResultSet resultSet, STService service) {
        Profile profile = null;
        try {
            profile = new Profile(
                    resultSet.getInt("profile_id"),
                    service.getUser(resultSet.getInt("user_id")),
                    resultSet.getString("birthdate"),
                    resultSet.getString("phone"),
                    resultSet.getString("description"),
                    resultSet.getInt("price")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }


}
