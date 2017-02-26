package com.sportteamwebapp.sportslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 25/02/2017.
 */
public class UsersEntity {
    private static String DEFAULT_SQL = "SELECT * FROM bd_sportspace.users";

    public List<User> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public User findById(int id) {
        List<User> users = findByCriteria(DEFAULT_SQL + " WHERE user_id = " + String.valueOf(id));
        return (users != null) ? users.get(0) : null;
    }

    public User findByName(String name) {
        List<User> users = findByCriteria(DEFAULT_SQL + " WHERE first_name = '" + name + "'");
        return (users.isEmpty()) ? null : users.get(0);
    }

    private List<User> findByCriteria(String sql) {
        List<User> users;
        if(getConnection() != null) {
            users = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    User user = User.build(resultSet);
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(user_id) as max_id FROM users";
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
    public User create(String firstname) {
        if(findByName(firstname) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO regions(user_id, first_name,last_name,password,email) VALUES(" +
                        String.valueOf(getMaxId()+1) + ", '" +
                        firstname + "')";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        User user = new User(getMaxId(), firstname);
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
                String.valueOf(id)) > 0;
    }

    public boolean delete(String firstname) {
        return updateByCriteria("DELETE FROM users WHERE first_name = '"+
                firstname + "'") > 0;
    }

    public boolean update(User user) {
        return updateByCriteria("UPDATE users SET region_name = '" +
                user.getFirstname() + "' WHERE user_id = " + String.valueOf(user.getId())) > 0;
    }

}
