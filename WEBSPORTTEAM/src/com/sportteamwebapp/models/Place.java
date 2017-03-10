package com.sportteamwebapp.models;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class Place {
    private int placeId;
    private String location;

    public Place(int placeId, String location) {
        this.setPlaceId(placeId);
        this.setLocation(location);
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
