package com.sportteamwebapp.models;


import java.sql.ResultSet;
import java.sql.SQLException;

public class User{
    private int userId;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private int phone;
    private String email;
    private String gender;
    private int dni;


    public User(int userId, String password, String firstName, String lastName, int age, int phone, String email, String gender, int dni) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.dni = dni;

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public static User build(ResultSet resultSet) {
        try {
            return new User(resultSet.getInt("user_id"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    resultSet.getInt("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("gender"),
                    resultSet.getInt("dni"));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}

