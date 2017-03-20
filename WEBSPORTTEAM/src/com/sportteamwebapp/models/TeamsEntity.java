package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyo on 18/03/2017.
 */
public class TeamsEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM db_sport.teams";
    private SportsEntity sportsEntity;

    public List<Team> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Team findById(int id) {
        List<Team> teams = findByCriteria(DEFAULT_SQL +
                " WHERE team_id = '" +String.valueOf(id) + "'");
        return (teams != null) ? teams.get(0) : null;
    }

    public Team findByName(String name) {
        List<Team> teams = findByCriteria(DEFAULT_SQL +
                " WHERE team_name = '" + name + "'");
        return (teams.isEmpty()) ? null : teams.get(0);
    }

    private List<Team> findByCriteria(String sql) {
        List<Team> teams;
        if(getConnection() != null) {
            teams = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Team team = Team.build(resultSet , getSportsEntity());
                    teams.add(team);
                }
                return teams;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public SportsEntity getSportsEntity() {return sportsEntity;}


    public void setSportsEntity(SportsEntity sportsEntity) {
        this.sportsEntity = sportsEntity;
    }

    public Team create(int id, String name,  int rank,int victory, int sportId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO teams(team_id, team_name, team_rank , number_victory , sport_id) VALUES('" +
                        String.valueOf(id) + "', '" +
                        name + "', " +  String.valueOf(rank) + "', '"+ String.valueOf(victory) + "', '" + String.valueOf(sportId) + ")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Team team = new Team(id, name,rank,victory , getSportsEntity().findById(sportId));
                        return team;
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

    public boolean delete(String id) {
        return updateByCriteria("DELETE FROM teams WHERE team_id = '"+
                id + "'") > 0;
    }


    public boolean update(Team team) {
        return updateByCriteria("UPDATE team SET team_name = '" +
                team.getName() + "' WHERE team_id = '" + team.getTeamId() + "'") > 0;
    }


}


