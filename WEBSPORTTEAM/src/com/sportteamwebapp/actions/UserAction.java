package com.sportteamwebapp.actions;

import com.sportteamwebapp.models.User;
import com.sportteamwebapp.models.Sport;
import com.sportteamwebapp.services.HrService;

import java.util.List;

/**
 * Created by yeyo on 25/03/2017.
 */
public class UserAction{
        private String usersCount;
        private List<User> users;
        private HrService service;

        public UserAction() {
            service = new HrService();
        }


        public String getUsersCount() {
            usersCount = String.valueOf(service.getAllCount());
            return usersCount;
        }

        public void setUsersCount(String usersCount) {
            this.usersCount = usersCount;
        }

        public String execute() {
            if(Integer.parseInt(getUsersCount()) > 10) {
                return "success";
            } else {
                return "error";
            }

        }

        public List<User> getUsers() { return users;}

        public String list() {
            users = service.findAllUsers();
            return "success";
        }





}
