package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 19/03/2017.
 */
public class BusinessPartnersEntity extends  BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM db_sport.business_partners";
    private SportsEntity sportsEntity;

    public List<BusinessPartner> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public BusinessPartner findById(int id) {
        List<BusinessPartner> businessPartners = findByCriteria(DEFAULT_SQL +
                " WHERE business_partner_id = '" +String.valueOf(id) + "'");
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
                    BusinessPartner businessPartner = BusinessPartner.build(resultSet , getPlacesEntity());
                    businessPartners.add(businessPartner);
                }
                return businessPartners;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public PlacesEntity getPlacesEntity() {return placesEntity;}


    public void setPlacesEntity(PlacesEntity placesEntity) {
        this.placesEntity = placesEntity;
    }

    public BusinessPartner create(int id, String name,  int phone, int placeId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO teams(team_id, team_name, team_rank , number_victory , sport_id) VALUES('" +
                        String.valueOf(id) + "', '" +
                        name + "', " +  String.valueOf(rank) + "', '"+ String.valueOf(victory) + "', '" + String.valueOf(sportId) + ")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Team team = new Team(id, name,rank,victory , getPlacesEntity().findById(sportId));
                        return team;
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

    public boolean delete(String id) {
        return updateByCriteria("DELETE FROM teams WHERE team_id = '"+
                id + "'") > 0;
    }


    public boolean update(Team team) {
        return updateByCriteria("UPDATE team SET team_name = '" +
                team.getName() + "' WHERE team_id = '" + team.getTeamId() + "'") > 0;
    }


}
