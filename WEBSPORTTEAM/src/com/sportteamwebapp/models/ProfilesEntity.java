package com.sportteamwebapp.models;

/**
 * Created by CHRISTIAN on 05/03/2017.
 */
import com.sportteamwebapp.STService;
import com.sportteamwebapp.models.UsersEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franklin on 21/10/2016.
 */
public class ProfilesEntity extends BaseEntity {
    private static String DEFAULT_QUERY =
            "SELECT * FROM profiles";
    STService service;

    public void setService(STService service) { this.service = service; }

    private List<Profile> findAllByCriteria(String criteria) {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(DEFAULT_QUERY +
                    " " + criteria);
            if(resultSet != null) {
                List<Profile> profiles = new ArrayList<>();
                while(resultSet.next()) {
                    Profile profile = Profile.buildFromResultSet(resultSet, service);
                    profiles.add(profile);
                }
                return profiles;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Profile> findAll()  {
        return findAllByCriteria("");
    }

    private Profile findBy(String condition) {
        String query = DEFAULT_QUERY + " "+ condition;
        try {
            ResultSet resultSet = getConnection().createStatement()
                    .executeQuery(query);
            if(resultSet == null) return null;
            if(resultSet.next()) {
                Profile profile = Profile.buildFromResultSet(resultSet);
                return profile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Profile findById(int id_p) {
        return findBy(" WHERE profile_id = " +
                Integer.toString(id_p));
    }

    public Profile findByUserId(int id) {
        return findBy(" p, users s  AND p.user_id = s.user_id WHERE p.user_id = " +
                Integer.toString(id));
    }

    public Profile findByUserEmail(String email){
        return findBy(" WHERE user_id = (SELECT user_id FROM users WHERE email = '" + email + "'");
    }

    public boolean add(int id_p, User user, String birthdate, String phone, String description, double price) {
        return(executeUpdate(
                "INSERT INTO profiles(profile_id, user_id, birthdate, phone, description, price) VALUES(" +
                        Integer.toString(id_p) + Integer.toString(user.getUser_id()) + ", '"+ birthdate + ", '" + phone + ", '" + description + "', " + Double.toString(price) + ")") > 0);
    }

    public boolean delete(int id) {
        return(executeUpdate(
                "DELETE FROM profiles WHERE profile_id = " +
                        Integer.toString(id)) > 0);
    }

    public boolean update(int id_p, User user, String birthdate, String phone, String description, double price) {
        return(executeUpdate(
                "UPDATE profiles SET profile_id = " + Integer.toString(id_p)
                        + ", user_id = " + Integer.toString(user.getUser_id())
                        + ", birthdate = '" + birthdate
                        + "', phone = '" + phone
                        + "', description = '" + description
                        + "', price = " + Double.toString(price) +
                        " WHERE profile_id = " + Integer.toString(id_p)) > 0);

    }
}


