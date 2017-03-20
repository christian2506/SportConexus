package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yeyo on 10/03/2017.
 */
public class SportSpace {
    private int sportSpaceId;
    private String sportSpaceName;
    private int maximumCapacity;
    private String status;
    private Place placeId;
    private Sport sportId;

    public SportSpace(int sportSpaceId, String sportSpaceName, int maximumCapacity, String status, Place placeId, Sport sportId) {
        this.sportSpaceId = sportSpaceId;
        this.sportSpaceName = sportSpaceName;
        this.maximumCapacity = maximumCapacity;
        this.status = status;
        this.placeId = placeId;
        this.sportId = sportId;
    }





    public int getSportSpaceId() {
        return sportSpaceId;
    }

    public void setSportSpaceId(int sportSpaceId) {
        this.sportSpaceId = sportSpaceId;
    }

    public String getSportSpaceName() {
        return sportSpaceName;
    }

    public void setSportSpaceName(String sportSpaceName) {
        this.sportSpaceName = sportSpaceName;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Place getPlaceId() {
        return placeId;
    }

    public SportSpace setPlaceId(Place placeId) {
        this.placeId = placeId;
        return this ;
    }

    public Sport getSportId() {
        return sportId;
    }

    public SportSpace setSportId(Sport sportId) {
        this.sportId = sportId;
        return this;
    }

    public static SportSpace build(ResultSet resultSet, PlacesEntity placesEntity, SportsEntity sportsEntity) {
        try {
            return new SportSpace(resultSet.getInt("sport_space_id"),
                    resultSet.getString("sport_space_name"),
                    resultSet.getInt("maximun_capacity"),
                    resultSet.getString("status"),
                    placesEntity.findById(resultSet.getInt("place_id")),
                    sportsEntity.findById(resultSet.getInt("sport_id"))

            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
