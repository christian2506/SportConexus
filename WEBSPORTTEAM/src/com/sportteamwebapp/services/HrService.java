package com.sportteamwebapp.services;

import com.sportteamwebapp.models.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yeyo on 20/03/2017.
 */
public class HrService {

    private Connection connection;
    private SportsEntity sportsEntity;
    private PlacesEntity placesEntity;
    private BusinessPartnersEntity businessPartnersEntity;
    private SportSpacesEntity sportSpacesEntity;
    private UsersEntity usersEntity;
    private TeamsEntity teamsEntity;
    public HrService() {

    }
    public int getAllCount() {
        return 10;
    }


    public boolean validateUser(String userName, String password) {
        return (userName.equalsIgnoreCase("admin") &&
                password.equalsIgnoreCase("password"));
    }

    public Connection getConnection() {
        if(connection == null) {
            try {
                InitialContext ctx = new InitialContext();
                connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSourceSport")).getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected SportsEntity getSportsEntity() {
        if(sportsEntity == null) {
            sportsEntity = new SportsEntity();
            sportsEntity.setConnection(getConnection());
        }
        return sportsEntity;
    }

    public void setSportsEntity(SportsEntity sportsEntity) {
        this.sportsEntity = sportsEntity;
    }

    public List<Sport> findAllSports() {
        return getSportsEntity().findAll();
    }

    protected BusinessPartnersEntity getBusinessPartnersEntity() {
        if(businessPartnersEntity == null) {
            businessPartnersEntity = new BusinessPartnersEntity();
            businessPartnersEntity.setConnection(getConnection());
        }
        return businessPartnersEntity;
    }

    public void setBusinessPartnersEntity(BusinessPartnersEntity businessPartnersEntity) {
        this.businessPartnersEntity = businessPartnersEntity;
    }

    public List<BusinessPartner> findAllBusinessPartners() {return getBusinessPartnersEntity().findAll();
    }


 //--

    protected PlacesEntity getPlacesEntity() {
        if(placesEntity == null) {
            placesEntity = new PlacesEntity();
            placesEntity.setConnection(getConnection());
        }
        return placesEntity;
    }

    public void setPlacesEntity(PlacesEntity placesEntity) {
        this.placesEntity = placesEntity;
    }

    public List<Place> findAllPlaces() {
        return getPlacesEntity().findAll();
    }






    //----

    protected SportSpacesEntity getSportSpacesEntity() {
        if(sportSpacesEntity == null) {
            sportSpacesEntity = new SportSpacesEntity();
            sportSpacesEntity.setConnection(getConnection());
        }
        return sportSpacesEntity;
    }

    public void setSportSpacesEntity(SportSpacesEntity sportSpacesEntity) {this.sportSpacesEntity = sportSpacesEntity;
    }

    public List<SportSpace> findAllSportSpaces() {
        return getSportSpacesEntity().findAll();
    }




//--



    protected TeamsEntity getTeamsEntity() {
        if(teamsEntity == null) {
            teamsEntity = new TeamsEntity();
            teamsEntity.setConnection(getConnection());
        }
        return teamsEntity;
    }

    public void setTeamsEntity(TeamsEntity teamsEntity) {this.teamsEntity = teamsEntity;
    }

    public List<Team> findAllTeams() {
        return getTeamsEntity().findAll();
    }




//--


    protected UsersEntity getUsersEntity() {
        if(usersEntity == null) {
            usersEntity = new UsersEntity();
            usersEntity.setConnection(getConnection());
        }
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {this.usersEntity = usersEntity;
    }

    public List<User> findAllUsers() {
        return getUsersEntity().findAll();
    }


}
