package com.sportteamwebapp.actions;

import com.sportteamwebapp.models.BusinessPartner;

import com.sportteamwebapp.services.HrService;

import java.util.List;

/**
 * Created by yeyo on 25/03/2017.
 */
public class BusinessPartnerAction {

    private String businessPartnersCount;
    private List<BusinessPartner> businessPartners;
    private HrService service;

    public BusinessPartnerAction() {service = new HrService();}


    public String getBusinessPartnersCount() {
        businessPartnersCount = String.valueOf(service.getAllCount());
        return businessPartnersCount;
    }

    public void setBusinessPartnersCount(String businessPartnersCount) {
        this.businessPartners = businessPartners;
    }

    public String execute() {
        if(Integer.parseInt(getBusinessPartnersCount()) > 10) {
            return "success";
        } else {
            return "error";
        }

    }

    public List<BusinessPartner> getBusinessPartners() { return businessPartners;}

    public String list() {
        businessPartners = service.findAllBusinessPartners();
        return "success";
    }





}
