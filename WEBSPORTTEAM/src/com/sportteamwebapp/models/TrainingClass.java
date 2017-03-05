package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by CHRISTIAN on 05/03/2017.
 */
public class TrainingClass {


        private Offer offer;
        private User user;
        private int teamScore;
        private int matchScore;

        public TrainingClass(Offer offer, User user, int teamScore, int matchScore) {
            this.setOffer(offer);
            this.setUser(user);
            this.setTeamScore(teamScore);
            this.setMatchScore(matchScore);
        }

        public Offer getOffer() {
            return offer;
        }

        public void setOffer(Offer offer) {
            this.offer = offer;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public int getTeamScore() {
            return teamScore;
        }

        public void setTeamScore(int teamScore) {
            this.teamScore = teamScore;
        }

        public int getMatchScore() {
            return matchScore;
        }

        public void setMatchScore(int matchScore) {
            this.matchScore = matchScore;
        }


        public static TrainingClass buildFromResultSet(ResultSet resultSet) {
            TrainingClass trainingclass = null;
            try {
                trainingclass = new TrainingClass(
                        null,
                        null,
                        resultSet.getInt("teamScore"),
                        resultSet.getInt("matchScore")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return trainingclass;
        }
    }




