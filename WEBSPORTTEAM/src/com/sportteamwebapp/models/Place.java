package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class Place {
    private int placeId;
    private String location;

    public Place(int placeId, String location) {
        this.placeId = placeId;
        this.location = location;
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

    public static Place build(ResultSet resultSet) {
        try {
            return new Place(resultSet.getInt("place_id"),
                    resultSet.getString("location")


            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



}
