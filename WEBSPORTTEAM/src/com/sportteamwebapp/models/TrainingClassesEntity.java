package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHRISTIAN on 05/03/2017.
 */

    public class TrainingClassesEntity extends BaseEntity{
        private static String DEFAULT_QUERY =
                "SELECT * FROM trainingclasses";

        private List<TrainingClass> findAllByCriteria(String criteria) {
            try {
                Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(DEFAULT_QUERY +
                        " " + criteria);
                if(resultSet != null) {
                    List<TrainingClass> trainingclasses = new ArrayList<>();
                    while(resultSet.next()) {
                        TrainingClass trainingclass = TrainingClass.buildFromResultSet(resultSet);
                        trainingclasses.add(trainingclass);
                    }
                    return trainingclasses;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public List<TrainingClass> findAll()  {
            return findAllByCriteria("");
        }

        private TrainingClass findBy(String condition) {
            String query = DEFAULT_QUERY + " "+ condition;
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(query);
                if(resultSet == null) return null;
                if(resultSet.next()) {
                    TrainingClass trainingclass = TrainingClass.buildFromResultSet(resultSet);
                    return trainingclass;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public TrainingClass findUserbyOffer(int id_o, int id) {
            return findBy(" WHERE offer_id = " +
                    Integer.toString(id_o)+ "user_id = " +Integer.toString(id));
        }

        public boolean add(Offer offer, User user, int teacherScore, int studentScore) {
            return(executeUpdate(
                    "INSERT INTO trainingclasses (offer_id, user_id, teacher_score, student_score) VALUES(" +
                            Integer.toString(offer.getOffer_id()) + ", " + Integer.toString(user.getUser_id()) + ", " + Integer.toString(teacherScore)
                            + ", " + Integer.toString(studentScore) + ")") > 0);
        }

        public boolean delete(Offer offer, User user) {
            return(executeUpdate(
                    "DELETE FROM trainingClasess WHERE offer_id = " +
                            Integer.toString(offer.getOffer_id())+ "user_id = " +Integer.toString(user.getUser_id())) > 0);
        }

        public boolean update(Offer offer, User user, int teacherScore, int studentScore) {
            return(executeUpdate(
                    "UPDATE trainingClasess SET offer_id = " + Integer.toString(offer.getOffer_id())
                            + ", user_id = " + Integer.toString(user.getUser_id())
                            + ", teacher_score = " + Integer.toString(teacherScore)
                            + ", student_score = " + Integer.toString(studentScore)) > 0);
        }
    }


