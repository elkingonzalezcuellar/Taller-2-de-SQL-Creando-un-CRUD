CREATE SCHEMA IF NOT EXISTS User_contact DEFAULT CHARACTER SET utf8 ;


USE User_contact ;

-- -----------------------------------------------------
-- Table  mydb . table1
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contact (
   Phone_Contact  INT NOT NULL AUTO_INCREMENT,
   full_name  VARCHAR(45) NULL,
   phone_number  VARCHAR(45)  NULL,
   email  VARCHAR(45) NULL,
  PRIMARY KEY ( Phone_Contact ),
  UNIQUE INDEX  Phone_Contact_UNIQUE  ( Phone_Contact  ASC) VISIBLE)
ENGINE = InnoDB;

-- Insertar Datos
INSERT INTO contact (full_name, phone_number, email)
VALUES
  ( 'Phoebe Guerrero ', '1-787-962-3774 ', 'urna.convallis@icloud.couk '),
  ( 'Byron Guthrie ', '(613) 777-1517 ', 'dolor@protonmail.com '),
  ( 'Palmer May ', '1-186-269-0758 ', 'magna@aol.com '),
  ( 'Alexis Mullins ', '(120) 798-5335 ', 'vitae.sodales.at@yahoo.com '),
  ( 'Nasim Sears ', '(437) 624-5765 ', 'mauris.blandit@google.com '),
  ( 'Lareina Nunez ', '(851) 895-2656 ', 'nulla.facilisi@google.net '),
  ( 'MacKenzie David ', '1-467-218-5534 ', 'risus.donec@aol.couk '),
  ( 'Roth Browning ', '(820) 406-2791 ', 'vulputate.ullamcorper@icloud.ca '),
  ( 'Jhon Bruce ', '1-174-216-7420 ', 'in.faucibus.orci@google.com '),
  ( 'Fritz Dorsey ', '(534) 418-7076 ', 'non@google.ca ');