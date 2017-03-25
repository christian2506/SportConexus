package com.sportteamwebapp.actions;
import com.sportteamwebapp.models.Team;
import com.sportteamwebapp.models.Sport;
import com.sportteamwebapp.services.HrService;

import java.util.List;

/**
 * Created by yeyo on 25/03/2017.
 */
public class TeamAction {

    private String teamsCount;
    private List<Team> teams;
    private HrService service;

    public TeamAction() {
        service = new HrService();
    }


    public String getTeamsCount() {
        teamsCount = String.valueOf(service.getAllCount());
        return teamsCount;
    }

    public void setTeamsCount(String teamsCount) {
        this.teamsCount = teamsCount;
    }

    public String execute() {
        if(Integer.parseInt(getTeamsCount()) > 10) {
            return "success";
        } else {
            return "error";
        }

    }

    public List<Team> getTeams() { return teams;}

    public String list() {
        teams = service.findAllTeams();
        return "success";
    }




}
