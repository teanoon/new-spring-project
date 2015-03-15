create table account (
    id INT NOT NULL auto_increment,
    loginName VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    birth TIMESTAMP,
    abilities TEXT,
    gender CHAR(10),
    PRIMARY KEY (id)
)