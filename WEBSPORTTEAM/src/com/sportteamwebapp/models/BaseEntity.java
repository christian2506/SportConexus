package com.sportteamwebapp.models;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 01/10/2016.
 */
public class BaseEntity {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected int executeUpdate(String sql) {
        try {
            int result = getConnection()
                    .createStatement()
                    .executeUpdate(sql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
