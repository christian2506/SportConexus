package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class BusinessPartner {
    private int businessPartnerId;
    private String namePartner;
    private int phone;
    private Place placeId;


    public BusinessPartner(int businessPartnerId, String namePartner, int phone, Place placeId) {
        this.businessPartnerId = businessPartnerId;
        this.namePartner = namePartner;
        this.phone = phone;
        this.placeId = placeId;
    }


    public int getBusinessPartnerId() {
        return businessPartnerId;
    }

    public void setBusinessPartnerId(int businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public String getNamePartner() {
        return namePartner;
    }

    public BusinessPartner setNamePartner(String namePartner) {
        this.namePartner = namePartner;
        return this ;
    }

    public int getPhone() {
        return phone;
    }

    public BusinessPartner setPhone(int phone) {
        this.phone = phone;
        return this ;
    }

    public Place getPlaceId() {
        return placeId;
    }

    public BusinessPartner setPlaceId(Place placeId) {
        this.placeId = placeId;
        return this;
    }


    public static BusinessPartner build(ResultSet resultSet, PlacesEntity placesEntity) {
        try {
            return new BusinessPartner(resultSet.getInt("bussines_partner_id"),
                    resultSet.getString("name_partner"),
                    resultSet.getInt("phone"),
                    placesEntity.findById(resultSet.getInt("place_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
