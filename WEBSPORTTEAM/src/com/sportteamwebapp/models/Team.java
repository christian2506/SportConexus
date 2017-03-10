package com.sportteamwebapp.models;

/**
 * Created by yeyo on 10/03/2017.
 */
public class Team {
    private int teamId;
    private String name ;
    private int rank ;
    private int numberOfVictory;
    private int sportId;

    public Team(int teamId, String name, int rank, int numberOfVictory, int sportId) {
        this.teamId = teamId;
        this.name = name;
        this.rank = rank;
        this.numberOfVictory = numberOfVictory;
        this.sportId = sportId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getNumberOfVictory() {
        return numberOfVictory;
    }

    public void setNumberOfVictory(int numberOfVictory) {
        this.numberOfVictory = numberOfVictory;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }
}
