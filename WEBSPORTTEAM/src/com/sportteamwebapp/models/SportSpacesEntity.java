package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 20/03/2017.
 */
public class SportSpacesEntity extends  BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM db_sport.sport_space";
    private PlacesEntity placesEntity;
    private SportsEntity sportsEntity;

    public List<SportSpace> findAll() {

        String sql = "SELECT * FROM db_sport.sport_space";
        List<SportSpace> sportSpaces = new ArrayList<>();
        try {
            ResultSet resultSet  = getConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                sportSpaces.add(new SportSpace(resultSet.getInt("sport_space_id"),
                        resultSet.getString("sport_space_name"),
                        resultSet.getInt("maximum_capacity"),
                        resultSet.getString("status"),
                        placesEntity.findById(resultSet.getInt("place_id")),
                        sportsEntity.findById(resultSet.getInt("sport_id"))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sportSpaces;
    }

    public SportSpace findById(String id) {
        List<SportSpace> sportSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE sport_space_id = '" + id + "'");
        return (sportSpaces != null) ? sportSpaces.get(0) : null;
    }

    public SportSpace findByName(String name) {
        List<SportSpace> sportSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE  sport_space_name= '" + name + "'");
        return (sportSpaces.isEmpty()) ? null : sportSpaces.get(0);
    }

    private List<SportSpace> findByCriteria(String sql) {
        List<SportSpace> sportSpaces;
        if(getConnection() != null) {
            sportSpaces = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    SportSpace sportSpace = SportSpace.build(resultSet, getPlacesEntity(),getSportsEntity());
                    sportSpaces.add(sportSpace);
                }
                return sportSpaces;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public SportsEntity getSportsEntity() {return sportsEntity;
    }

    public void setSportsEntity(SportsEntity sportsEntity) {
        this.sportsEntity = sportsEntity;
    }


    public PlacesEntity getPlacesEntity() {return placesEntity;
    }

    public void setPlacesEntity(PlacesEntity placesEntity) {
        this.placesEntity = placesEntity;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(sport_space_id) as max_id FROM sport_space";
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

    public SportSpace create( String name,  int maximum,String status ,int placeId,int sportId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO sport_space(sport_space_id, sport_space_name, maximum_capacity,status ,place_id,sport_id) VALUES(" +
                        Integer.toString(getMaxId()+1) + ", '" +
                        name + "', " +  Integer.toString(maximum) +  ", '" +status +"'," + Integer.toString(placeId)+"," +Integer.toString(sportId) +")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        SportSpace sportSpace = new SportSpace
                                (getMaxId(), name,maximum,status, getPlacesEntity().findById(placeId),getSportsEntity().findById(sportId));
                        return sportSpace;
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
        return updateByCriteria("DELETE FROM sport_space WHERE sport_space_id = "+
                Integer.toString(id) ) > 0;
    }


    public boolean update(SportSpace sportSpace) {
        return updateByCriteria("UPDATE sport_space SET sport_space_name = " +
               sportSpace.getSportSpaceName() + " , maximum_capacity = " + Integer.toString(sportSpace.getMaximumCapacity())
                +",status = '"+ sportSpace.getStatus() +
                "' WHERE sport_space_id = " +Integer.toString(sportSpace.getSportSpaceId())) > 0;
    }




}
