package com.sportteamwebapp.sportslist.models;

import java.sql.Connection;

/**
 * Created by yeyo on 25/02/2017.
 */
public class BaseEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
