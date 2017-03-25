package com.sportteamwebapp.actions;

import com.sportteamwebapp.models.SportSpace;
import com.sportteamwebapp.models.Sport;
import com.sportteamwebapp.services.HrService;

import java.util.List;

/**
 * Created by yeyo on 25/03/2017.
 */
public class SportSpaceAction {

    private String sportSpacesCount;
    private List<SportSpace> sportSpaces;
    private HrService service;

    public SportSpaceAction() {
        service = new HrService();
    }


    public String getSportSpacesCount() {
        sportSpacesCount = String.valueOf(service.getAllCount());
        return sportSpacesCount;
    }

    public void setSportSpacesCount(String sportSpacesCount) {
        this.sportSpacesCount = sportSpacesCount;
    }

    public String execute() {
        if(Integer.parseInt(getSportSpacesCount()) > 10) {
            return "success";
        } else {
            return "error";
        }

    }

    public List<SportSpace> getSportSpaces() { return sportSpaces;}

    public String list() {
        sportSpaces = service.findAllSportSpaces();
        return "success";
    }




}
