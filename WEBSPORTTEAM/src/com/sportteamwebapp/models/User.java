package com.sportteamwebapp.models;


public class User{

    private int userId;
    private String password;
    private String firstName;
    private String lastName;
    private int phone;
    private String email;
    private String gender;
    private int dni;
    private double paymenttype;
    private int teamid;

    public User(int userId, String password, String firstName, String lastName, int phone, String email, String gender, int dni, double paymenttype, int teamid) {
        this.setUserId(userId);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setEmail(email);
        this.setGender(gender);
        this.setDni(dni);
        this.setPaymenttype(paymenttype);
        this.setTeamid(teamid);
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

    public double getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(double paymenttype) {
        this.paymenttype = paymenttype;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

}
