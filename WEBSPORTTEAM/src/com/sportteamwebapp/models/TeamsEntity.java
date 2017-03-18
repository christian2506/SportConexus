package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 18/03/2017.
 */
public class TeamsEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM db_sport.teams";
    private SportsEntity sportsEntity;

    public List<Team> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Team findById(String id) {
        List<Team> teams = findByCriteria(DEFAULT_SQL +
                " WHERE team_id = '" + id + "'");
        return (teams != null) ? teams.get(0) : null;
    }

    public Team findByName(String name) {
        List<Team> teams = findByCriteria(DEFAULT_SQL +
                " WHERE team_name = '" + name + "'");
        return (teams.isEmpty()) ? null : teams.get(0);
    }

    private List<Team> findByCriteria(String sql) {
        List<Team> teams;
        if(getConnection() != null) {
            teams = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Team team = Team.build(resultSet, getSportsEntity());
                    teams.add(team);
                }
                return teams;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public SportsEntity getRegionsEntity() {
        return sportsEntity;
    }

    public void setSportsEntity(SportEntity sportsEntity) {
        this.sportsEntity = sportsEntity;
    }

    public Team create(int id, String name,  int regionId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO countries(country_id, country_name, region_id) VALUES('" +
                        id + "', '" +
                        name + "', " + String.valueOf(regionId) + ")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Country country = new Country(id, name, getRegionsEntity().findById(regionId));
                        return country;
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
        return updateByCriteria("DELETE FROM countries WHERE country_id = '"+
                id + "'") > 0;
    }


    public boolean update(Country country) {
        return updateByCriteria("UPDATE countries SET country_name = '" +
                country.getName() + "' WHERE country_id = '" + country.getId() + "'") > 0;
    }


}


