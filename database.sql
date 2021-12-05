

DROP DATABASE IF EXISTS ENSF480;
CREATE DATABASE ENSF480; 
USE ENSF480;

SET @amount = 45;
SET @period = 1;

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
	username        VARCHAR(150) NOT NULL,
    password        VARCHAR(150) NOT NULL,
    account_type     VARCHAR(150) NOT NULL,
    PRIMARY KEY     (username)
);

INSERT INTO USERS (username, password, accounttype)
VALUES
    ('landlord1', 'ensf480', 'landlord'),
    ('landlord2', 'ensf480', 'landlord'),
    ('landlord3', 'ensf480', 'landlord'),
    ('renter1', 'ensf490', 'renter'),
    ('renter2', 'ensf490', 'renter'),
    ('renter3', 'ensf490', 'renter'),
    ('manager1', 'ensf500', 'manager'),
    ('manager2', 'ensf500', 'manager');

DROP TABLE IF EXISTS PROPERTIES;
CREATE TABLE PROPERTIES (
	id          INT unsigned NOT NULL AUTO_INCREMENT,
    owner       VARCHAR(150) NOT NULL,
	address 	VARCHAR(150) NOT NULL,
    type        VARCHAR(150) NOT NULL,
    bedrooms    INT unsigned NOT NULL,
    bathrooms   INT unsigned NOT NULL,
    furnished   VARCHAR(150) NOT NULL,
    quadrant    VARCHAR(150) NOT NULL,
    daysleft    DATE NOT NULL,
    occupied    VARCHAR(150) NOT NULL,
    state    	VARCHAR(150) NOT NULL,
    PRIMARY KEY (id),
	FOREIGN KEY (owner) REFERENCES USERS(username) ON UPDATE CASCADE
);

INSERT INTO PROPERTIES (owner, type, bedrooms, bathrooms, furnished, quadrant, daysleft, occupied, address)
VALUES
    ('landlord1',   'apartment',	    1,	2,	'yes',	'NE',	60, 'no', '123 street', 'active'),
    ('landlord1',   'apartment',	    1,	2,	'yes',	'NE',	60, 'no', '124 street', 'rented'),
    ('landlord2',   'attached house',	1,	2,	'yes',	'NW',	60, 'no', '125 street', 'cancelled'),
    ('landlord2',   'attached house',	1,	2,	'yes',	'NW',	60, 'no', '126 street', 'suspended'),
    ('landlord3',   'townhouse',	    1,	2,	'yes',	'SE',	60, 'no', '127 street', 'active'),
    ('landlord3',   'townhouse',	    1,	2,	'yes',	'SW',	60, 'no', '128 street', 'active');

    
DROP TABLE IF EXISTS MESSAGES;
CREATE TABLE MESSAGES (
    receiver	VARCHAR(150) NOT NULL,
    message		VARCHAR(150) NOT NULL,
	FOREIGN KEY (receiver) REFERENCES USERS(username) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS SUBSCRIPTION;
CREATE TABLE SUBSCRIPTION (
    receiver	VARCHAR(150) NOT NULL,
    message		VARCHAR(150) NOT NULL,
	FOREIGN KEY (receiver) REFERENCES USERS(username) ON UPDATE CASCADE
);

