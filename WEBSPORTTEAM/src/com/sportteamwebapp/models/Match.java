package com.sportteamwebapp.models;

/**
 * Created by Accent AR on 10/03/2017.
 */
public class Match {
    private int matchId;
    private String description;
    private String score;
    private int teamid;

    public Match(int matchId, String description, String score, int teamid) {
        this.setMatchId(matchId);
        this.setDescription(description);
        this.setScore(score);
        this.setTeamid(teamid);
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }
}
