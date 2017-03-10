package com.sportteamwebapp.models;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class Sport {
    private int sportId;
    private String nameSport;

    public Sport(int sportId, String nameSport) {
        this.setSportId(sportId);
        this.setNameSport(nameSport);
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getNameSport() {
        return nameSport;
    }

    public void setNameSport(String nameSport) {
        this.nameSport = nameSport;
    }
}
