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
    ('111 North ST',        'moussavifan',   'apartment',	        1,	2,	1,	'NE',	'active', '2022-1-1'),
    ('23 North Blvd',       'moussavifan',   'apartment',	        1,	2,	1,	'NE',	'active', '2022-1-1'),
    ('100 St Albert Rd',    'moussavifan',   'attached house',	    1,	2,	1,	'NW',	'active', '2022-1-1'),
    ('22 Shawnnesay Rd',    'moussavifan',   'attached house',	    1,	2,	1,	'NW',	'active', '2022-1-1'),
    ('33 Chinook Hhwy',     'moussavifan',   'townhouse',	        1,	2,	1,	'SE',	'active', '2022-1-1'),
    ('1 St SE',             'moussavifan',   'townhouse',	        1,	2,	1,	'SW',	'active', '2022-1-1');

DROP TABLE IF EXISTS FEEINFO;
CREATE TABLE FEEINFO (
    integrity_keeper ENUM('') NOT NULL PRIMARY KEY,
    price INT unsigned NOT NULL,
    perioddays INT unsigned NOT NULL
);

INSERT INTO FEEINFO (price, perioddays)
VALUES
    (80, 60);

DROP TABLE IF EXISTS NOTIFICATIONS;
CREATE TABLE NOTIFICATIONS (
    listingid INT unsigned NOT NULL,
    renter VARCHAR(150) NOT NULL,
    FOREIGN KEY (listingid) REFERENCES PROPERTIES(id) ON UPDATE CASCADE,
    FOREIGN KEY (renter) REFERENCES USERS(username) ON UPDATE CASCADE
);
DROP TABLE IF EXISTS RENTEDHISTORY;

CREATE TABLE RENTEDHISTORY (
    listingid INT unsigned NOT NULL,
    FOREIGN KEY (listingid) REFERENCES PROPERTIES(id) ON UPDATE CASCADE
);
DROP TABLE IF EXISTS EMAILS;

CREATE TABLE EMAILS (
    renter VARCHAR(150) NOT NULL,
    landlord VARCHAR(150) NOT NULL,
    message VARCHAR(200) NOT NULL,
    FOREIGN KEY (renter) REFERENCES USERS(username) ON UPDATE CASCADE,
    FOREIGN KEY (landlord) REFERENCES USERS(username) ON UPDATE CASCADE
);
DROP TABLE IF EXISTS SUBSCRIPTIONS;

CREATE TABLE SUBSCRIPTIONS (
    renter VARCHAR(150) NOT NULL,
    type VARCHAR(150) NOT NULL,
    bedrooms INT unsigned NOT NULL,
    bathrooms INT unsigned NOT NULL,
    furnished INT NOT NULL,
    quadrant VARCHAR(3) NOT NULL,
    FOREIGN KEY (renter) REFERENCES USERS(username) ON UPDATE CASCADE
);
