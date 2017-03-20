package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yeyo on 10/03/2017.
 */
public class Team {
    private int teamId;
    private String name ;
    private int rank ;
    private int numberOfVictory;
    private Sport sportId;

    public Team(int teamId, String name, int rank, int numberOfVictory, Sport sportId) {
        this.teamId = teamId;
        this.name = name;
        this.rank = rank;
        this.numberOfVictory = numberOfVictory;
        this.sportId = sportId;
    }

    public int getTeamId() {
        return teamId;
    }

    public Team setTeamId(int teamId) {
        this.teamId = teamId;
        return this;

    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;

    }

    public int getRank() {
        return rank;
    }

    public Team setRank(int rank) {
        this.rank = rank;
        return this;

    }

    public int getNumberOfVictory() {
        return numberOfVictory;
    }

    public Team setNumberOfVictory(int numberOfVictory) {
        this.numberOfVictory = numberOfVictory;
        return this;

    }

    public Sport getSportId() {
        return sportId;
    }

    public Team setSportId(Sport sportId) {
        this.sportId = sportId;
        return this;
    }
    public static Team build(ResultSet resultSet, SportsEntity sportsEntity) {
        try {
            return new Team(resultSet.getInt("team_id"),
                    resultSet.getString("team_name"),
                    resultSet.getInt("team_name"),
                    resultSet.getInt("team_name"),
                    sportsEntity.findById(resultSet.getInt("sport_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



}
