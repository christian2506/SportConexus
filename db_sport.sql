DROP SCHEMA

IF EXISTS db_sport;
	CREATE SCHEMA db_sport COLLATE = utf8_general_ci;

USE db_sport;

/*CREANDO LAS TABLAS */

 
  
  CREATE TABLE sports (
  sport_id int(11) UNSIGNED NOT NULL,
  sport_name varchar(45) NOT NULL,
  PRIMARY KEY (sport_id));
  
  
   CREATE TABLE teams (
  team_id int(11) UNSIGNED NOT NULL,
  team_name varchar(45) NOT NULL,
  team_rank int(11) DEFAULT NULL,
  number_victory int(11) DEFAULT NULL,
  sport_id int(11) UNSIGNED  NOT NULL,
  PRIMARY KEY (team_id),
  CONSTRAINT teams_sports FOREIGN KEY (sport_id) REFERENCES sports (sport_id));
  
  
  
   CREATE TABLE places (
  place_id int(11) UNSIGNED NOT NULL,
  location varchar(45) NOT NULL,
  PRIMARY KEY (place_id));
  
  
  
  
  
  CREATE TABLE users (
  user_id int(11) UNSIGNED NOT NULL,
  password varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  birth_date date NOT NULL,
  phone int(11) NOT NULL,
  email varchar(45) NOT NULL,
  gender varchar(45) NOT NULL,
  dni int(8) NOT NULL,
  team_id int(11)  UNSIGNED DEFAULT NULL,
  PRIMARY KEY (user_id),
  CONSTRAINT users_teams FOREIGN KEY (team_id) REFERENCES teams (team_id));
  
  
CREATE TABLE business_partners(
business_partner_id int(11) UNSIGNED NOT NULL,
  name_partner varchar(45) NOT NULL,
  phone int(11) NOT NULL,
  place_id int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (business_partner_id),
  CONSTRAINT partners_places FOREIGN KEY (place_id) REFERENCES places (place_id)
  );
  
 
  
 
  CREATE TABLE sport_space (
  sport_space_id int(11) UNSIGNED NOT NULL,
  sport_space_name varchar(45) NOT NULL,
  maximum_capacity int(11) NOT NULL,
  status varchar(2) NOT NULL,
  place_id int(11) UNSIGNED NOT NULL,
  sport_id int(11) UNSIGNED  NOT NULL,
  PRIMARY KEY (sport_space_id),
  CONSTRAINT sportspaces_places FOREIGN KEY (place_id) REFERENCES places(place_id) ,
  CONSTRAINT sportspaces_sports FOREIGN KEY (sport_id) REFERENCES sports (sport_id));
  

 
  
  


  
  