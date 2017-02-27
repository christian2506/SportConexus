package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;


public class User{

    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;

    public User(int user_id, String email, String password, String first_name, String last_name) {
        this.setUser_id(user_id);
        this.setEmail(email);
        this.setPassword(password);
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public static User buildFromResultSet(ResultSet resultSet) {
        User user = null;
        try {
            user = new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
