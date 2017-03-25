package com.sportteamwebapp.actions;

import com.sportteamwebapp.models.Sport;
import com.sportteamwebapp.services.HrService;

import java.util.List;

/**
 * Created by yeyo on 20/03/2017.
 */
public class SportAction {

    private String sportsCount;
    private List<Sport> sports;
    private HrService service;

    public SportAction() {
        service = new HrService();
    }


    public String getSportsCount() {
        sportsCount = String.valueOf(service.getAllCount());
        return sportsCount;
    }

    public void setSportsCount(String sportsCount) {
        this.sportsCount = sportsCount;
    }

    public String execute() {
        if(Integer.parseInt(getSportsCount()) > 10) {
            return "success";
        } else {
            return "error";
        }

    }

    public List<Sport> getSports() { return sports;}

    public String list() {
        sports = service.findAllSports();
        return "success";
    }






}
