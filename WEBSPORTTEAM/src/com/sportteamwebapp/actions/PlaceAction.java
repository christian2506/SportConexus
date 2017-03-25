package com.sportteamwebapp.actions;

import  com.sportteamwebapp.models.Place;
import com.sportteamwebapp.models.Sport;
import com.sportteamwebapp.services.HrService;

import java.util.List;

/**
 * Created by yeyo on 25/03/2017.
 */
public class PlaceAction {


    private String placesCount;
    private List<Place> places;
    private HrService service;

    public PlaceAction() {
        service = new HrService();
    }


    public String getPlacesCount() {
        placesCount = String.valueOf(service.getAllCount());
        return placesCount;
    }

    public void setPlacesCount(String placesCount) {
        this.placesCount = placesCount;
    }

    public String execute() {
        if(Integer.parseInt(getPlacesCount()) > 10) {
            return "success";
        } else {
            return "error";
        }

    }

    public List<Place> getPlaces() { return places;}

    public String list() {
        places = service.findAllPlaces();
        return "success";
    }







}
