package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by CHRISTIAN on 05/03/2017.
 */
public class Offer {

        private int offer_id;
        private User user;
        private String service;
        private String level;
        private String startDate;
        private String endDate;
        private String days;
        private String hour;
        private String description;
        private int vacant;
        private String status;

        public Offer(int offer_id, User user, String service, String level, String startdate, String enddate, String days, String hour, String description, int vacant, String status) {
            this.setOffer_id(offer_id);
            this.setUser(user);
            this.setInstrument(service);
            this.setLevel(level);
            this.setStartdate(startdate);
            this.setEnddate(enddate);
            this.setDays(days);
            this.setHour(hour);
            this.setDescription(description);
            this.setVacant(vacant);
            this.setStatus(status);
        }

        public int getOffer_id() {
            return offer_id;
        }

        public void setOffer_id(int offer_id) {
            this.offer_id = offer_id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getInstrument() {
            return service;
        }

        public void setInstrument(String instrument) {
            this.service = service;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getStartdate() {
            return startDate;
        }

        public void setStartdate(String startdate) {
            this.startDate = startdate;
        }

        public String getEnddate() {
            return endDate;
        }

        public void setEnddate(String enddate) {
            this.endDate = enddate;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getVacant() {
            return vacant;
        }

        public void setVacant(int vacant) {
            this.vacant = vacant;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public static Offer buildFromResultSet(ResultSet resultSet) {
            Offer offer = null;
            try {
                offer = new Offer(
                        resultSet.getInt("offer_id"),
                        null,
                        resultSet.getString("service"),
                        resultSet.getString("level"),
                        resultSet.getString("startmkDate"),
                        resultSet.getString("end_Date"),
                        resultSet.getString("days"),
                        resultSet.getString("hour"),
                        resultSet.getString("description"),
                        resultSet.getInt("vacant"),
                        resultSet.getString("status")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return offer;
        }


    }


