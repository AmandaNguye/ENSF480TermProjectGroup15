

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
    furnished   BOOLEAN NOT NULL,
    quadrant    VARCHAR(150) NOT NULL,
    daysleft    DATE NOT NULL,
    dateposted  DATE NOT NULL,
    state    	VARCHAR(150) NOT NULL,
    PRIMARY KEY (id),
	FOREIGN KEY (owner) REFERENCES USERS(username) ON UPDATE CASCADE
);

INSERT INTO PROPERTIES (owner, type, bedrooms, bathrooms, furnished, quadrant, daysleft, address, state, dateposted)
VALUES
    ('landlord1',   'apartment',	    1,	2,	true,	'NE',	'2021-12-27', 	'123 street', 'active', 	'2021-11-1'),
    ('landlord1',   'apartment',	    1,	2,	false,	'NE',	'2021-12-28', 	'124 street', 'rented', 	'2021-11-27'),
    ('landlord2',   'attached house',	1,	2,	true,	'NW',	'2021-12-29', 	'125 street', 'cancelled', 	'2021-11-28'),
    ('landlord2',   'attached house',	1,	2,	false,	'NW',	'2021-12-26', 	'126 street', 'suspended', 	'2021-11-29'),
    ('landlord3',   'townhouse',	    1,	2,	true,	'SE',	'2021-12-25', 	'127 street', 'active', 	'2021-11-26'),
    ('landlord3',   'townhouse',	    1,	2,	false,	'SW',	'2021-12-1', 	'128 street', 'active', 	'2021-11-25');

    
DROP TABLE IF EXISTS MESSAGES;
CREATE TABLE MESSAGES (
    receiver	VARCHAR(150) NOT NULL,
    message		VARCHAR(150) NOT NULL,
	FOREIGN KEY (receiver) REFERENCES USERS(username) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS SUBSCRIPTIONS;
CREATE TABLE SUBSCRIPTIONS (
    renter				VARCHAR(150) NOT NULL,
    subscribed			VARCHAR(150) NOT NULL,
    type        		VARCHAR(150) NOT NULL,
    bedrooms    		INT unsigned NOT NULL,
    bathrooms   		INT unsigned NOT NULL,
    furnished   		VARCHAR(150) NOT NULL,
    quadrant    		VARCHAR(150) NOT NULL,
    datesubscribed   	DATE NOT NULL,
	FOREIGN KEY (renter) REFERENCES USERS(username) ON UPDATE CASCADE
);

