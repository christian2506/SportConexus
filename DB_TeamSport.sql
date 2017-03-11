CREATE DATABASE `bd_teamsport`;
USE bd_teamsport;

/*tabla Usuario*/
create table users(
user_id int auto_increment not null,
first_name varchar(60) not null,
last_name varchar(60) not null,
email varchar(50)  not null,
password varchar(30) not null,
primary key(user_id)
); 

/*Tabla de los Perfiles por Usuario*/
create table profiles(
profile_id int auto_increment not null,
user_id int not null,
birthdate date null,
study_center varchar(200) null,
phone char(9) null,
description varchar(100) null,
price smallint null,
primary key(profile_id),
foreign key (user_id) references Users(user_id)
);


/*Tabla equipos*/
create table team(
team_id int auto_increment not null,
name_team varchar(60) not null,
primary key(team_id)
);


create table Training_classes(
offer_id int not null,
user_id int not null,
team_score int null,
match_score int null
);


create table sport(
sport_id int not null,
name_sport varchar(60),
primary key(sport_id)
);


create table offers(
offer_id int primary key auto_increment not null,
user_id int not null,
service varchar(50) not null,
level varchar(15) not null,
start_date datetime not null,
end_date datetime not null,
days varchar(50) not null,
hour time not null,
description varchar(100) not null,
vacant int not null,
status char(1) not null,
foreign key (user_id) references users(user_id)
);


alter table Training_classes
add constraint pk_training_classes
primary key(offer_id,user_id);

insert into users (first_name,last_name,email,password) values("christian","huaynate","jhonnatan@gmail.com","123");
insert into users (first_name,last_name,email,password) values("accent","amayo","amayo25e@gmail.com","456");
