//*
//Author:  Younggil Lee
//  Student ID: 991 395 505
//  Description: Create sign-up Application that stores users data, handles attributes
*/               between logical components. Also, filter to prevent pages from unauthorized access.


-- Make sure we are using ejd database
USE ejd;

-- delete tables if already exist
DROP TABLE IF EXISTS ejdUser;

-- create tables
CREATE TABLE ejdUser
(
  id VARCHAR(25) NOT NULL PRIMARY KEY,
  password VARCHAR(128) NOT NULL,
  nickname VARCHAR(25) NOT NULL,
  email VARCHAR(50) NOT NULL
);
