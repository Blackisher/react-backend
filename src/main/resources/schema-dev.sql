--LAB3TASK2dot3
--create entity User that will hold the following details: 
--generated by the hibernate id, login, first name, last name, date of birth, an indicator saying if a user is active or not.
CREATE TABLE "user"
(
    id SERIAL PRIMARY KEY,
    login varchar (100) NOT NULL,
    firstName varchar (100) NOT NULL ,
    lastName varchar (100) DEFAULT NULL,
    dateOfBirth date DEFAULT NULL, --4713 BC 	5874897 AD
    active varchar (1) DEFAULT 'T' -- 'T' or 'F'
);