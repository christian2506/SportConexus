package com.sportteamwebapp.models;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class BusinessPartner {
    private int businesspartnerId;
    private String namepartner;
    private int placeId;

    public BusinessPartner(int businesspartnerId, String namepartner, int placeId) {
        this.setBusinesspartnerId(businesspartnerId);
        this.setNamepartner(namepartner);
        this.setPlaceId(placeId);
    }

    public int getBusinesspartnerId() {
        return businesspartnerId;
    }

    public void setBusinesspartnerId(int businesspartnerId) {
        this.businesspartnerId = businesspartnerId;
    }

    public String getNamepartner() {
        return namepartner;
    }

    public void setNamepartner(String namepartner) {
        this.namepartner = namepartner;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
