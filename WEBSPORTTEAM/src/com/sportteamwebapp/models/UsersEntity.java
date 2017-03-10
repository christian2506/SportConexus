package com.sportteamwebapp.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{
    private static String DEFAULT_QUERY =
            "SELECT * FROM users";
    private static String QUERY_FOR_NAME = "SELECT first_name FROM users";

    private User findFirstName(String condition) {
        String query = QUERY_FOR_NAME + " " + condition;
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(query);
            if(resultSet == null) return null;
            if(resultSet.next()) {
                User user = User.buildFromResultSet(resultSet);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private List<User> findAllByCriteria(String criteria) {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(DEFAULT_QUERY +
                    " " + criteria);
            if(resultSet != null) {
                List<User> users = new ArrayList<>();
                while(resultSet.next()) {
                    User user = User.buildFromResultSet(resultSet);

                }
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll()  {
        return findAllByCriteria("");
    }

    private User findBy(String condition) {
        String query = DEFAULT_QUERY + " " + condition;
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(query);
            if(resultSet == null) return null;
            if(resultSet.next()) {
                User user = User.buildFromResultSet(resultSet);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findById(int id) {
        return findBy(" WHERE user_id = " +
                Integer.toString(id));
    }

    public User findUser(String email, String password) {
        return findBy(" WHERE email = '" +
                email + "' AND password = '" +  password + "'");
    }

    public User findNamebyEmail(String email) {
        return findFirstName( "WHERE email = '" +
                email + "'");
    }

    public List<User> findAllWithOffers() {
        return findAllByCriteria(
                "WHERE user_id IN " +
                        "(SELECT DISTINCT user_id FROM offers)");
    }

    public User findByEmail(String email) {
        return findBy("WHERE email = '" +
                email + "'");
    }

    public boolean add( String email, String password, String first_name, String last_name) {
        return(executeUpdate(
                "INSERT INTO users ( email, password, first_name, last_name) VALUES('" + email + "', '"
                        + password + "', '" + first_name + "', '" + last_name + "')") > 0);
    }

    public boolean add( String email) {
        return(executeUpdate(
                "INSERT INTO profiles ( profile_id, user_id) VALUES(" +
                        "(SELECT user_id FROM users WHERE email = '" + email+ "')," +
                        "(SELECT user_id FROM users WHERE email = '" + email+ "'))") > 0);
    }

    public boolean delete(int id) {
        return(executeUpdate(
                "DELETE FROM users WHERE user_id = " +
                        Integer.toString(id)) > 0);
    }

    public boolean update(int id, String email, String password) {
        return (executeUpdate(
                "UPDATE users SET user_id = " +
                        Integer.toString(id) + ", email = '" + email + ", password = '" +
                        password + "'") > 0);
    }

    public User findLast() {
        return findBy("WHERE user_id = (SELECT MAX(user_id) FROM users)");
    }

    public User findOrCreateByEmail(String email, String password , String first_name, String last_name) {
        User user = findByEmail(email);
        if(user != null) return user;
        user = new User(
                findLast().getUser_id() + 1,
                email, password, first_name, last_name);
        return (add( user.getEmail(), user.getPassword(),user.getFirstName(), user.getLastName()) ? user : null);
    }



}
