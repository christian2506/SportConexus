package com.sportteamwebapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 10/03/2017.
 */
public class UsersEntity extends BaseEntity{
private static String DEFAULT_SQL = "SELECT * FROM db_sport.users";
public List<User> findAll(){return findByCriteria(DEFAULT_SQL);}
public User findById(int id){
    List<User> users = findByCriteria( DEFAULT_SQL + "Where user_id = "+String.valueOf(id));
    return (users != null) ? users.get(0): null;
}
public User findByName(String firstname){
    List<User> users = findByCriteria ( DEFAULT_SQL + "WHERE first_name = '"+ firstname + "'");
    return (users.isEmpty()) ? null : users.get(0);
}

private List<User> findByCriteria(String sql){
   List<User> users;
   if(getConnection() !=null){
       users = new ArrayList<>();
       try{
           ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
           while (resultSet.next()){
               User user = new User(users);
               users.add(user);
           }
           return users;
       }catch (SQLException e){
           e.printStackTrace();
       }

   }
   return  null;
}
private int getMaxId(){
    String sql = "SELECT MAX(region_id) as max_id FROM users";
    if(getConnection()   !=null ){
        try{
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt(1) :0;
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
    return 0 ;
}


public User create (String firstname){
   if(null == findByName(firstname))
       if(getConnection() !=null){
           String sql = " INSERT INTO users(user_id, firstname) VALUES("+
                   String.valueOf(getMaxId()+1)+" ,'"+firstname + "')";
           try{
               int results = getConnection().createStatement().executeUpdate(sql);
               if(results >0){
                   User user = new User();
                   return  user;
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
       }
    return null;
}

}
