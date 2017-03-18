package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class Sport {
    private int sportId;
    private String sportName;

    public Sport(int sportId, String sportName) {
        this.sportId = sportId;
        this.sportName = sportName;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public static Sport build(ResultSet resultSet) {
        try {
            return new Sport(resultSet.getInt("sport_id"),
                    resultSet.getString("sport_name")


            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}