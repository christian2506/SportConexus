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

    public Team create( String name,  int rank,int victory, int sportId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO teams(team_id, team_name, team_rank , number_victory , sport_id) VALUES(" +
                        Integer.toString(getMaxId()+1) + ", '" +
                        name + "' , " +  Integer.toString(rank) + ", "+ Integer.toString(victory) + "," + Integer.toString(sportId) + ")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Team team = new Team(getMaxId(), name,rank,victory , getSportsEntity().findById(sportId));
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

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM teams WHERE team_id = "+
                Integer.toString(id) ) > 0;
    }


    public boolean update(Team team) {
        return updateByCriteria("UPDATE teams SET team_name = '" +
                team.getName() + "' ,team_rank = " +Integer.toString(team.getRank()) +
                " ,  number_victory = "+ Integer.toString(team.getNumberOfVictory())+" WHERE team_id = " +Integer.toString(team.getTeamId()) ) > 0;
    }


}


