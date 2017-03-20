package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 20/03/2017.
 */
public class PlacesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM db_sport.places";

    public List<Place> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Place findById(int id) {
        List<Place> places = findByCriteria(DEFAULT_SQL + " WHERE place_id = " + String.valueOf(id));
        return (places != null) ? places.get(0) : null;
    }


    public Place findByName(String name) {
        List<Place> places = findByCriteria(DEFAULT_SQL + " WHERE location = '" + name + "'");
        return (places.isEmpty()) ? null : places.get(0);
    }

    private List<Place> findByCriteria(String sql) {
        List<Place> places;
        if(getConnection() != null) {
            places = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Place place = Place.build(resultSet);
                    places.add(place);
                }
                return places;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(place_id) as max_id FROM places";
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
    public Place create(String name) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO places(place_id, location) VALUES(" +
                        String.valueOf(getMaxId()+1) + ", '" +
                        name + "')";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Place place = new Place(getMaxId(), name);
                        return place;
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
        return updateByCriteria("DELETE FROM places WHERE place_id = "+
                String.valueOf(id)) > 0;
    }

    public boolean delete(String name) {
        return updateByCriteria("DELETE FROM places WHERE location = '"+
                name + "'") > 0;
    }

    public boolean update(Place place) {
        return updateByCriteria("UPDATE places SET location = '" +
                place.getLocation() + "' WHERE place_id = " + String.valueOf(place.getPlaceId())) > 0;
    }
}
