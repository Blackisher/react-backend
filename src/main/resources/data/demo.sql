CREATE TABLE "user"
(
    id SERIAL PRIMARY KEY,
    login varchar (100) NOT NULL,
    firstName varchar (100) NOT NULL ,
    lastName varchar (100) DEFAULT NULL,
    dateOfBirth date DEFAULT NULL, --4713 BC 	5874897 AD
    active varchar (1) DEFAULT 'T' -- 'T' or 'F'
);