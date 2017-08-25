-- You can use this file to load seed data into the database using SQL statements
CREATE TABLE Users (
  user_id INT NOT NULL AUTO_INCREMENT,  
  username VARCHAR(50) NOT NULL,
  password CHAR(41) NOT NULL,
  email VARCHAR(80) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE INDEX (email)
);

INSERT INTO Users (user_id,username,password, email) 
VALUES (0, 'Benny','Benny@YFM','pholo.benny@gmail.com');
