package com.sportteamwebapp.models;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 * Created by CHRISTIAN on 20/03/2017.
 */
public class UserEntity extends  BaseEntity {

    private static String DEFAULT_SQL = "SELECT * FROM db_sport.teams";
    private TeamsEntity teamsEntity;

    public List<User> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public User findById(int id) {
        List<User> users = findByCriteria(DEFAULT_SQL +
                " WHERE user_id = '" +String.valueOf(id) + "'");
        return (users != null) ? users.get(0) : null;
    }

    public User findByName(String name) {
        List<User> users = findByCriteria(DEFAULT_SQL +
                " WHERE last_name = '" + name + "'");
        return (users.isEmpty()) ? null : users.get(0);
    }

    private List<User> findByCriteria(String sql) {
        List<User> users;
        if(getConnection() != null) {
            users = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    User user = User.build(resultSet , getTeamsEntity());
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public TeamsEntity getTeamsEntity() {return teamsEntity;}


    public void setTeamsEntity(TeamsEntity teamssEntity) {
        this.teamsEntity = teamsEntity;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(team_id) as max_id FROM teams";
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


    public User create( String password, String firstName , String name, int age  , int phone, String email,String gender,int dni ,int teamId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO users(user_id, password, first_name , last_name , age , phone , email , gender, dni , team_id) VALUES(" +
                        Integer.toString(getMaxId()+1) + ", '" +
                        password + "' , '" +  firstName + "', '"+ name + "'," +String.valueOf(age)+","+String.valueOf(phone)+",'"+email+"','"+gender+"',"+String.valueOf(dni)+","+ teamId+")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        User user = new User
                                (getMaxId(), password,firstName,name,  age,phone ,email,gender,dni,getTeamsEntity().findById(teamId));
                        return user;
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
        return updateByCriteria("DELETE FROM users WHERE user_id = "+
                Integer.toString(id) ) > 0;
    }


    public boolean update(User user) {
        return updateByCriteria("UPDATE team SET password = '" +
                user.getPassword() + "' ,first_name = '" + user.getFirstName() +
                "' ,  last_name = '"+ user.getLastName()+"', age = " +Integer.toString(user.getAge()) +", phone = "+
                Integer.toString(user.getPhone())+", email = '"+user.getEmail()+"', gender = '"+ user.getGender()+"', dni ="
                +Integer.toString(user.getDni())+" WHERE user_id = " + Integer.toString(user.getUserId() )) > 0;
    }



}
