CREATE SCHEMA `athena` ;

CREATE TABLE `athena`.`doctor` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `qualification` VARCHAR(45) NULL,
  `experience` VARCHAR(45) NULL,
  `specialization` VARCHAR(45) NULL,
  PRIMARY KEY (`doctor_id`));


CREATE TABLE `athena`.`patient` (
  `patient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `phone_no` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`patient_id`));


CREATE TABLE `athena`.`appointment` (
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `time_of_appointment` DATETIME NULL,
  `posting_time` DATETIME NULL,
  `description` VARCHAR(200) NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NULL,
  PRIMARY KEY (`appointment_id`),
  INDEX `fk_appointment_patient_idx` (`patient_id` ASC),
  INDEX `fk_appointment_doctor_idx` (`doctor_id` ASC),
  CONSTRAINT `fk_appointment_patient`
    FOREIGN KEY (`patient_id`)
    REFERENCES `athena`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_doctor`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `athena`.`doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
