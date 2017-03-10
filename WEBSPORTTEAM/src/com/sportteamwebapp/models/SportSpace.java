package com.sportteamwebapp.models;

/**
 * Created by yeyo on 10/03/2017.
 */
public class SportSpace {
    private int sportSpaceId;
    private int maximumCapacity;
    private int placeId;
    private int sportId;
    private String status;

    public SportSpace(int sportSpaceId, int maximumCapacity, int placeId, int sportId, String status) {
        this.sportSpaceId = sportSpaceId;
        this.maximumCapacity = maximumCapacity;
        this.placeId = placeId;
        this.sportId = sportId;
        this.status = status;
    }


    public int getSportSpaceId() {
        return sportSpaceId;
    }

    public void setSportSpaceId(int sportSpaceId) {
        this.sportSpaceId = sportSpaceId;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
