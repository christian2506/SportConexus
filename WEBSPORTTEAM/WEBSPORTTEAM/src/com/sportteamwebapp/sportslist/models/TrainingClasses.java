package com.sportteamwebapp.sportslist.models;

/**
 * Created by yeyo on 25/02/2017.
 */
public class TrainingClasses {
    int offer_id;
    int user_id;
    int team_score;
    int match_score;

    public TrainingClasses(int offer_id, int user_id, int team_score, int match_score) {
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.team_score = team_score;
        this.match_score = match_score;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTeam_score() {
        return team_score;
    }

    public void setTeam_score(int team_score) {
        this.team_score = team_score;
    }

    public int getMatch_score() {
        return match_score;
    }

    public void setMatch_score(int match_score) {
        this.match_score = match_score;
    }
}
