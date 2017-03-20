package com.sportteamwebapp.services;

import com.sportteamwebapp.models.Sport;
import com.sportteamwebapp.models.SportsEntity;

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
    public HrService() {

    }

    public int getSportsCount() {
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
                connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource")).getConnection();
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

    public List<Sport> findAllRegions() {
        return getSportsEntity().findAll();
    }

}
