create database coffeeshop_management
use coffeeshop_management

CREATE TABLE login (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  Passwords VARCHAR(255) NOT NULL,
  permission VARCHAR(255) NOT NULL,
  tel VARCHAR(255),
  usual_schedule VARCHAR(255),
  hour_payment int NOT NULL,
  INDEX (username) -- Adding index to the username column
);

CREATE TABLE Employ_working_hour (
  username VARCHAR(255) NOT NULL,
  working_date DATE NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  hour_working int NOT NULL,
  PRIMARY KEY (username, working_date),
  FOREIGN KEY (username) REFERENCES login(username)
);

CREATE TABLE menu (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  item VARCHAR(255) NOT NULL,
  orange INT NULL,
  apple INT NULL,
  pineapple INT NULL,
  lemongrass INT NULL,
  peach INT NULL,
  lime INT NULL,
  sugar INT NULL,
  coffee INT NULL,
  fresh_milk INT NULL,
  condensed_milk INT NULL,
  tea_bag INT NULL,
  ice INT NULL
);

CREATE TABLE imports (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Username VARCHAR(255) NOT NULL,
  working_place VARCHAR(255) NOT NULL,
  Date DATE NOT NULL,
  total_price float,
  orange INT NULL,
  apple INT NULL,
  pineapple INT NULL,
  lemongrass INT NULL,
  peach INT NULL,
  lime INT NULL,
  sugar INT NULL,
  coffee INT NULL,
  fresh_milk INT NULL,
  condensed_milk INT NULL,
  tea_bag INT NULL,
  ice INT NULL,
  orange_price FLOAT NULL,
  pineapple_price FLOAT NULL,
  lemongrass_price FLOAT NULL,
  peach_price FLOAT NULL,
  lime_price FLOAT NULL,
  sugar_price FLOAT NULL,
  coffee_price FLOAT NULL,
  fresh_milk_price FLOAT NULL,
  condensed_milk_price FLOAT NULL,
  tea_bag_price FLOAT NULL,
  ice_price FLOAT NULL
);


CREATE TABLE exports (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Username VARCHAR(255) NOT NULL,
  item VARCHAR(255) NOT NULL,
  amount INT NOT NULL,
  price float,
  total_price float
);

select * from login
select * from imports

drop database coffeeshop_management
