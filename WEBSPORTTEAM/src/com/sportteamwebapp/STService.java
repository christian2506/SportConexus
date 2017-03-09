package com.sportteamwebapp;

import com.sportteamwebapp.models.*;
import com.sportteamwebapp.models.UsersEntity;
import com.sportteamwebapp.models.ProfilesEntity;
import com.sportteamwebapp.models.OffersEntity;
import com.sportteamwebapp.models.TrainingClassesEntity;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.ws.Service;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by GrupoUTP on 30/09/2016.
 */
public class STService implements Serializable {
    private Connection connection;
    private UsersEntity usersEntity;
    private ProfilesEntity profilesEntity;
    private OffersEntity offersEntity;
    private TrainingClassesEntity trainingClassesEntity;

    public STService() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private UsersEntity getUsersEntity() {
        if(usersEntity == null) {
            usersEntity = new UsersEntity();
            usersEntity.setConnection(connection);
        }
        return usersEntity;
    }

    public List<User> getUsers() {
        if(getConnection() != null) {
            return getUsersEntity().findAll();
        }
        return null;
    }

    public int getUsersCount() { return this.getUsers().size();}

    public User getUser(int id) {
        if(getConnection() != null) {
            return getUsersEntity().findById(id);
        }
        return null;
    }

    public User getUser(String email) {
        if(getConnection() != null) {
            return getUsersEntity().findByEmail(email);
        }
        return null;
    }

    public User getName(String email) {
        if(getConnection() != null) {
            return getUsersEntity().findNamebyEmail(email);
        }
        return null;
    }

    public boolean getUser(String email, String password) {
        if(getConnection() != null) {

            log("entre");
            if (getUsersEntity().findUser(email, password) != null){
                return true;
            }
        }
        return false;
    }

    public boolean addUser(String email, String password, String first_name, String last_name) {
        return ((getConnection() != null) ?
                getUsersEntity().add(email, password, first_name, last_name) &
                        getUsersEntity().add(email) : false);

    }

    public boolean deleteUser(int id) {
        return ((getConnection() != null) ?
                getUsersEntity().delete(id) : false);
    }

    public boolean updateUser(int id, String email, String password) {
        return ((getConnection() != null) ?
                getUsersEntity().update(id, email, password) : false);
    }

    public boolean updateUser(User user) {
        return updateUser(user.getUser_id(), user.getEmail(), user.getPassword());
    }

    public ProfilesEntity getProfilesEntity() {
        if(profilesEntity == null) {
            profilesEntity = new ProfilesEntity();
            profilesEntity.setConnection(connection);
        }
        return profilesEntity;
    }

    public List<Profile> getProfiles() {
        if(connection != null) {
            return getProfilesEntity().findAll();
        }
        return null;
    }

    public Profile getProfile(String email){
        if(getConnection()!=null){
            return getProfilesEntity().findByUserEmail(email);
        }
        return null;
    }

    public Profile getProfile(int id) {
        if(getConnection() != null) {
            return getProfilesEntity().findById(id);
        }
        return null;
    }

    public boolean addProfile(int id_p, User user, String birthdate, String phone, String description, double price) {
        return ((getConnection() != null) ?
                getProfilesEntity().add(id_p, user, birthdate, phone, description, price) : false);
    }

    public boolean deleteProfile(int id) {
        return ((getConnection() != null) ?
                getProfilesEntity().delete(id) : false);
    }

    public boolean updateProfile(int id_p, User user, String birthdate, String phone, String description, double price) {
        return ((getConnection() != null) ?
                getProfilesEntity().update(id_p, user, birthdate, phone, description, price) : false);
    }

    public boolean updateProfile(Profile profile) {
        return updateProfile(profile.getProfile_id(), profile.getUser(), profile.getBirthdate(), profile.getPhone(), profile.getDescription(), profile.getPrice());
    }

    private OffersEntity getOffersEntity() {
        if(offersEntity== null) {
            offersEntity = new OffersEntity();
            offersEntity.setConnection(connection);
        }
        return offersEntity;
    }

    public List<Offer> getOffers() {
        if(getConnection() != null) {
            return getOffersEntity().findAll();
        }
        return null;
    }

    public List<Offer> getOffersbyUser(String id) {
        if(getConnection() != null) {
            return getOffersEntity().findByTeacher(id);
        }
        return null;
    }

    public int getOffersCount() { return this.getOffers().size();}

    public Offer getOffer(int id_o) {
        if(getConnection() != null) {
            return getOffersEntity().findById(id_o);
        }
        return null;
    }

    public Offer getOffer(String service) {
        if(getConnection() != null) {
            return getOffersEntity().findByService(service);
        }
        return null;
    }

    public boolean addOffer(int id_o, User user, String service, String level, String start_date, String end_date, String days,
                            String hour, String description, int vacant, String status) {
        return ((getConnection() != null) ?
                getOffersEntity().add(id_o, user, service, level, start_date, end_date, days,
                        hour, description, vacant, status) : false);
    }



    public boolean updateOffer(int id_o, User user, String service, String level, String start_date, String end_date, String days,
                               String hour, String description, int vacant, String status) {
        return ((getConnection() != null) ?
                getOffersEntity().update(id_o, user, service, level, start_date, end_date, days,
                        hour, description, vacant, status) : false);
    }

    public boolean updateOffer(Offer offer) {
        return updateOffer(offer.getOffer_id(), offer.getUser(), offer.getInstrument(),
                offer.getLevel(), offer.getStartdate(), offer.getEnddate(), offer.getDays(), offer.getHour(),
                offer.getDescription(), offer.getVacant(), offer.getStatus());
    }

    private TrainingClassesEntity getTrainingClassesEntity() {
        if(trainingClassesEntity== null) {
            trainingClassesEntity = new TrainingClassesEntity();
            trainingClassesEntity.setConnection(connection);
        }
        return trainingClassesEntity;
    }

    public List<TrainingClass> getTrainingClasses() {
        if(getConnection() != null) {
            return getTrainingClassesEntity().findAll();
        }
        return null;
    }

    public int getTrainingClassCount() { return this.getTrainingClasses().size();}

    public TrainingClass gettrainingClass(int id_t, int id) {
        if(getConnection() != null) {
            return getTrainingClassesEntity().findUserbyOffer(id_t, id);
        }
        return null;
    }

    public boolean addTrainingClass(Offer offer, User user, int teamScore, int matchScore) {
        return ((getConnection() != null) ?
                getTrainingClassesEntity().add(offer, user, teamScore, matchScore) : false);
    }

    public boolean deleteTrainingClass(Offer offer, User user) {
        return ((getConnection() != null) ?
                getTrainingClassesEntity().delete(offer , user) : false);
    }

    public boolean updateTrainingClass(Offer offer, User user, int teamScore, int matchScore) {
        return ((getConnection() != null) ?
                getTrainingClassesEntity().update(offer, user, teamScore, matchScore) : false);
    }

    public boolean updateTrainingClass(TrainingClass trainingClass) {
        return updateTrainingClass(trainingClass.getOffer(), trainingClass.getUser(),
                trainingClass.getTeamScore(), trainingClass.getMatchScore());
    }


}
