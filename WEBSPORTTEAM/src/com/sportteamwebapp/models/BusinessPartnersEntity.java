package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 20/03/2017.
 */
public class BusinessPartnersEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM db_sport.business_partners";
    private PlacesEntity placesEntity;

    public List<BusinessPartner> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public BusinessPartner findById(String id) {
        List<BusinessPartner> businessPartners = findByCriteria(DEFAULT_SQL +
                " WHERE business_partner_id = '" + id + "'");
        return (businessPartners != null) ? businessPartners.get(0) : null;
    }

    public BusinessPartner findByName(String name) {
        List<BusinessPartner> businessPartners = findByCriteria(DEFAULT_SQL +
                " WHERE name_partner = '" + name + "'");
        return (businessPartners.isEmpty()) ? null : businessPartners.get(0);
    }

    private List<BusinessPartner> findByCriteria(String sql) {
        List<BusinessPartner> businessPartners;
        if(getConnection() != null) {
            businessPartners = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    BusinessPartner businessPartner = BusinessPartner.build(resultSet, getPlacesEntity());
                    businessPartners.add(businessPartner);
                }
                return businessPartners;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public PlacesEntity getPlacesEntity() {return placesEntity;
    }

    public void setPlacesEntity(PlacesEntity placesEntity) {
        this.placesEntity = placesEntity;
    }


    private int getMaxId() {
        String sql = "SELECT MAX(business_partner_id) as max_id FROM business_partners";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt(1) : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public BusinessPartner create( String name,  int phone, int placeId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO business_partners(business_partner_id, name_partner, phone, place_id) VALUES(" +
                        Integer.toString(getMaxId()+1) + ", '" +
                        name + "', " + Integer.toString(phone) +  ", " + Integer.toString(placeId) + ")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        BusinessPartner businessPartner = new BusinessPartner(getMaxId(), name,phone, getPlacesEntity().findById(placeId));
                        return businessPartner;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection().createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM business_partners WHERE business_partner_id = "+
                Integer.toString(id) ) > 0;
    }


    public boolean update(BusinessPartner businessPartner) {
        return updateByCriteria("UPDATE business_partners SET name_partner = '" +
                businessPartner.getNamePartner() + "' ,phone = " +Integer.toString(businessPartner.getPhone()) +
                " WHERE business_partner_id = " + Integer.toString(businessPartner.getBusinessPartnerId())) > 0;
    }



}
