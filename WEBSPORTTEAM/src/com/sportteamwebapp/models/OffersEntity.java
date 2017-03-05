package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHRISTIAN on 05/03/2017.
 */
public class OffersEntity extends BaseEntity {
    private static String DEFAULT_QUERY =
            "SELECT * FROM offers";

    private List<Offer> findAllByCriteria(String criteria) {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(DEFAULT_QUERY +
                    " " + criteria);
            if(resultSet != null) {
                List<Offer> offers = new ArrayList<>();
                while(resultSet.next()) {
                    Offer offer = Offer.buildFromResultSet(resultSet);
                    offers.add(offer);
                }
                return offers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Offer> findAll()  {
        return findAllByCriteria("");
    }

    private Offer findBy(String condition) {
        String query = DEFAULT_QUERY + " "+ condition;
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(query);
            if(resultSet == null) return null;
            if(resultSet.next()) {
                Offer offer = Offer.buildFromResultSet(resultSet);
                return offer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Offer findById(int id_o) {
        return findBy(" WHERE offer_id = " +
                Integer.toString(id_o));
    }

    public Offer findByInstrument(String instrument) {
        return findBy("WHERE service = '" +
                instrument + "'");
    }

    public List<Offer> findByTeacher(String id) {
        return findAllByCriteria("WHERE user_id = '" +
                id + "'");
    }

    public Offer findWithVacant(int vacant) {
        return findBy(" WHERE vacant = " +
                Integer.toString(vacant));
    }

    public boolean add(int id_o, User user, String instrument, String level, String start_date, String end_date, String days,
                       String hour, String description, int vacant, String status) {
        return(executeUpdate(
                "INSERT INTO offers(offer_id, user_id, instrument, level, start_date, end_date, days, hour, description, vacant, state) VALUES(" +
                        Integer.toString(id_o) + Integer.toString(user.getUser_id())
                        + ", '" + instrument  + "', '" + level
                        + "', '" + start_date  + "', '" + end_date
                        + "', '" + days  + "', '" + hour
                        + "', '" + description  + "', " + Integer.toString(vacant)
                        +  ", '" + status +"')") > 0);
    }

    public boolean delete(int id_p) {
        return(executeUpdate(
                "DELETE FROM offers WHERE offer_id = " +
                        Integer.toString(id_p)) > 0);
    }

    public boolean update(int id_o, User user, String service, String level, String start_date, String end_date, String days,
                          String hour, String description, int vacant, String status) {
        return(executeUpdate(
                "UPDATE offers SET user_id = "  + Integer.toString(user.getUser_id())
                        + ", service = '" + service
                        + "', level = '" + level
                        + "', start_date = '" + start_date
                        + "', end_date = '" + end_date
                        + ", days = '" + days
                        + "', hour = '" + hour
                        + "', description = '" + description
                        + "', vacant ='" + Integer.toString(vacant)
                        + ", status = '" + status
                        + "' WHERE offer_id = " + Integer.toString(id_o)) > 0);
    }
}

