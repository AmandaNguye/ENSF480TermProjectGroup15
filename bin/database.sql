DROP DATABASE IF EXISTS ENSF480;
CREATE DATABASE ENSF480; 
USE ENSF480;


DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
	username        VARCHAR(150) NOT NULL,
    password        VARCHAR(150) NOT NULL,
    accounttype     VARCHAR(150) NOT NULL,
    PRIMARY KEY     (username)
);

INSERT INTO USERS (username, password, accounttype)
VALUES
    ('landlord1', 'ensf480', 'landlord'),
    ('landlord2', 'ensf480', 'landlord'),
    ('landlord3', 'ensf480', 'landlord'),
    ('moussavifan', 'ensf480', 'landlord'),
    ('renter1', 'ensf480', 'renter'),
    ('renter2', 'ensf480', 'renter'),
    ('renter3', 'ensf480', 'renter'),
    ('manager', 'ensf480', 'manager');

DROP TABLE IF EXISTS PROPERTIES;
DROP TABLE IF EXISTS PROPERTIES;
CREATE TABLE PROPERTIES (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    address VARCHAR(150) NOT NULL,
    owner VARCHAR(150) NOT NULL,
    type VARCHAR(150) NOT NULL,
    bedrooms INT unsigned NOT NULL,
    bathrooms INT unsigned NOT NULL,
    furnished INT NOT NULL,
    quadrant VARCHAR(3) NOT NULL,
    status VARCHAR(15) NOT NULL,
    expirydate DATE NOT NULL,
    PRIMARY KEY (id), 
    FOREIGN KEY (owner) REFERENCES USERS(username) ON UPDATE CASCADE
  );

INSERT INTO PROPERTIES (address, owner, type, bedrooms, bathrooms, furnished, quadrant, status, expirydate)
VALUES
    ('funkyhouse',          'moussavifan',   'apartment',	        1,	2,	1,	'NE',	'active', '2021-12-12'),
    ('nice apartment',      'moussavifan',   'apartment',	        1,	2,	1,	'NE',	'active', '2021-12-12'),
    ('my doghouse',         'moussavifan',   'attached house',	    1,	2,	1,	'NW',	'active', '2021-12-12'),
    ('plsrentthishouse',    'moussavifan',   'attached house',	    1,	2,	1,	'NW',	'active', '2021-12-12'),
    ('townhousekensignton', 'moussavifan',   'townhouse',	        1,	2,	1,	'SE',	'active', '2021-12-12'),
    ('universityofcalgary', 'moussavifan',   'townhouse',	        1,	2,	1,	'SW',	'active', '2021-12-12');
