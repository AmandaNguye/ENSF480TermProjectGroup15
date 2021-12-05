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
    ('renter1', 'ensf480', 'renter'),
    ('renter2', 'ensf480', 'renter'),
    ('renter3', 'ensf480', 'renter'),
    ('manager', 'ensf480', 'manager');

DROP TABLE IF EXISTS PROPERTIES;
CREATE TABLE PROPERTIES (
	id          INT unsigned NOT NULL AUTO_INCREMENT,
    owner       VARCHAR(150) NOT NULL,
    type        VARCHAR(150) NOT NULL,
    bedrooms    INT unsigned NOT NULL,
    bathrooms   INT unsigned NOT NULL,
    furnished   VARCHAR(5) NOT NULL,
    quadrant    VARCHAR(3) NOT NULL,
    daysleft    INT unsigned NOT NULL,
    occupied    VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
	FOREIGN KEY (owner) REFERENCES USERS(username) ON UPDATE CASCADE
);

INSERT INTO PROPERTIES (owner, type, bedrooms, bathrooms, furnished, quadrant, daysleft, occupied)
VALUES
    ('landlord1',   'apartment',	    1,	2,	'yes',	'NE',	60, 'no'),
    ('landlord1',   'apartment',	    1,	2,	'yes',	'NE',	60, 'no'),
    ('landlord2',   'attached house',	1,	2,	'yes',	'NW',	60, 'no'),
    ('landlord2',   'attached house',	1,	2,	'yes',	'NW',	60, 'no'),
    ('landlord3',   'townhouse',	    1,	2,	'yes',	'SE',	60, 'no'),
    ('landlord3',   'townhouse',	    1,	2,	'yes',	'SW',	60, 'no');
