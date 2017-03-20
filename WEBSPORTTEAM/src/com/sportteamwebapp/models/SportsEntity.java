package com.sportteamwebapp.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 18/03/2017.
 */
public class SportsEntity extends  BaseEntity{

    private static String DEFAULT_SQL = "SELECT * FROM db_sport.regions";

    public List<Sport> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Sport findById(int id) {
        List<Sport> sports = findByCriteria(DEFAULT_SQL + " WHERE sport_id = " + String.valueOf(id));
        return (sports != null) ? sports.get(0) : null;
    }


    public Sport findByName(String name) {
        List<Sport> sports = findByCriteria(DEFAULT_SQL + " WHERE sport_name = '" + name + "'");
        return (sports.isEmpty()) ? null : sports.get(0);
    }

    private List<Sport> findByCriteria(String sql) {
        List<Sport> sports;
        if(getConnection() != null) {
            sports = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Sport sport = Sport.build(resultSet);
                    sports.add(sport);
                }
                return sports;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(sport_id) as max_id FROM sports";
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
    public Sport create(String name) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO sports(sport_id, sport_name) VALUES(" +
                        Integer.toString(getMaxId()+1) + ", '" +
                        name + "')";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Sport sport = new Sport(getMaxId(), name);
                        return sport;
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
        return updateByCriteria("DELETE FROM sports WHERE sport_id = "+
                Integer.toString(id)) > 0;
    }

    public boolean delete(String name) {
        return updateByCriteria("DELETE FROM sports WHERE sport_name = '"+
                name + "'") > 0;
    }

    public boolean update(Sport sport) {
        return updateByCriteria("UPDATE sports SET sport_name = '" +
                sport.getSportName() + "' WHERE sport_id = " + Integer.toString(sport.getSportId())) > 0;
    }
}

