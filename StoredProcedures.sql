-- "addFarm" - used to create an entry for a farm

CREATE OR REPLACE PROCEDURE `addFarm`
    (IN `farm_addr` VARCHAR(40), 
     IN `farm_city` VARCHAR(20), 
     IN `farm_state` VARCHAR(2), 
     IN `farm_zip` VARCHAR(5)) 
BEGIN 

DECLARE max_farm_id INT;

START TRANSACTION;

-- FARM ID -> INT(11)
SELECT MAX(farm_id) INTO max_farm_id
FROM farm;

IF (max_farm_id IS NULL) THEN 
    SET max_farm_id = 1;
ELSE 
    SET max_farm_id = max_farm_id + 1;
END IF;

INSERT INTO farm (farm_id, addr, city, state, zip) 
VALUES (max_farm_id, farm_addr, farm_city, farm_state, farm_zip);

COMMIT;

END;

-- "addCow" - used for new cows to farming environment (does not include transfers between farms in this system)

CREATE OR REPLACE PROCEDURE `addCow`
      (IN `ear_tag` CHAR(8),
      IN `name` VARCHAR(15), 
      IN `farm` INT)
  BEGIN 

      DECLARE farm_num INT;

      START TRANSACTION;

      SELECT COUNT(farm_id) INTO farm_num 
        FROM farm 
        WHERE farm_id = farm;

  
      IF (farm_num = 0) THEN 
          ROLLBACK;
          SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FARM DOES NOT EXIST';
    
      END IF;

      -- Inserting the new cow record
      INSERT INTO cow (cow_tag, cow_name, cow_farm)
      VALUES (ear_tag, name, farm);

      COMMIT;

  END;

  -- "transferCow" - used to transfer a cow from one farm to another

CREATE OR REPLACE PROCEDURE `transferCow`
    (IN `cow_id` CHAR(8),
    IN `farm` INT)

BEGIN

DECLARE cow_count INT DEFAULT 0;
DECLARE new_farm INT DEFAULT 0;

proc: BEGIN

  START TRANSACTION;

  SELECT COUNT(cow_tag) INTO cow_count
  FROM cow 
  WHERE cow_tag = cow_id;

  IF cow_count = 0 THEN 
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'COW DOES NOT EXIST!!!';
    ROLLBACK;
    LEAVE proc;
  END IF;

  SELECT COUNT(farm_id) INTO new_farm
  FROM farm 
  WHERE farm_id = farm;

  IF new_farm = 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FARM DOES NOT EXIST!!!';
    ROLLBACK;
    LEAVE proc;
  END IF;

  UPDATE cow SET cow_farm = farm WHERE cow_tag = cow_id;

  COMMIT;

END proc;

END;

-- "purchaseFeed" - used to record the purchase of feed for a farm

CREATE OR REPLACE PROCEDURE `purchaseFeed`
    (IN `farm_feed` INT, 
    IN `datetime` DATETIME, 
    IN `oz` INT, 
    IN `kind_of_feed` VARCHAR(16))
    
  BEGIN 

  DECLARE farm INT;

  START TRANSACTION;

  SELECT COUNT(farm_id) INTO farm
  FROM farm 
  WHERE farm_id = farm;

  IF (farm = 0) THEN
  ROLLBACK;
  SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FARM DOES NOT EXIST!!!';
  END IF;

  INSERT INTO feed (f_farm, f_datetime, f_oz, kind) 
    VALUES (farm_feed, datetime, oz, kind_of_feed);

  COMMIT;

  END;

-- "hireHand" - used to record the onboarding of a new farm worker

CREATE OR REPLACE PROCEDURE `hireHand`
  (IN `first_name` VARCHAR(16), 
  IN `last_name` VARCHAR(16), 
  IN `farm_num` INT(11))

BEGIN 

DECLARE farm INT;
DECLARE new_id INT;

START TRANSACTION;

SELECT COUNT(farm_id) INTO farm
FROM farm 
WHERE farm_id = farm_num;

IF (farm = 0) THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FARM DOES NOT EXIST!!!';
END IF;

SELECT MAX(hand_id) INTO new_id
  FROM hand;

IF (new_id IS NULL) THEN
  SET new_id = 1;
ELSE 
  SET new_id = new_id + 1;
END IF;

INSERT INTO hand (hand_id, hand_fname, hand_lname, hand_primaryFarm) 
VALUES (new_id, first_name, last_name, farm_num);

COMMIT;

END;

-- "purchaseMachine" - used to record the purchase of a milking machine

CREATE OR REPLACE PROCEDURE `purchaseMachine`
  (IN `farm_num` INT(11))

BEGIN 

DECLARE farm INT;
DECLARE new_id INT;

START TRANSACTION;

SELECT COUNT(farm_id) INTO farm
FROM farm 
WHERE farm_id = farm_num;

IF (farm = 0) THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FARM DOES NOT EXIST!!!';
END IF;

SELECT MAX(mm_id) INTO new_id
  FROM milkingMachine;

IF (new_id IS NULL) THEN
  SET new_id = 1;
ELSE 
  SET new_id = new_id + 1;
END IF;

INSERT INTO milkingMachine (mm_id, mm_farm) 
VALUES (new_id, farm_num);

COMMIT;

END;

-- "machineMaintenance" - used to record a maintenance event for a milking machine

CREATE OR REPLACE PROCEDURE `machineMaintenance`
  (IN `machine_affected` INT(11),
  IN `primary_hand` INT(11),
  IN  `maintenance_date` DATE,
  IN `was_success` TINYINT(1))

BEGIN 

DECLARE machine INT;
DECLARE new_id INT;
DECLARE hand INT;

START TRANSACTION;

SELECT COUNT(mm_id) INTO machine
FROM milkingMachine
WHERE mm_id = machine_affected; 

IF (machine = 0) THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'MACHINE DOES NOT EXIST!!!';
END IF;

SELECT COUNT(hand_id) INTO hand
  FROM hand 
  WHERE hand_id = primary_hand;

IF (hand = 0) THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'HAND DOES NOT EXIST!!!';
END IF;

SELECT MAX(maintenance_id) INTO new_id
  FROM maintenance;

IF (new_id IS NULL) THEN
  SET new_id = 1;
ELSE 
  SET new_id = new_id + 1;
END IF;

INSERT INTO maintenance (maintenance_id, m_affected, m_primary, m_date, m_wasSuccess) 
VALUES (new_id, machine_affected, primary_hand, maintenance_date, was_success);

COMMIT;

END;

-- "purchaseTank" - used to record the purchase of a new milk tank for a farm

CREATE OR REPLACE PROCEDURE `purchaseTank`
  (IN `farm_num` INT(11),
  IN  `purchase_date` DATE,
  IN  `retired_date` DATE)

BEGIN 

DECLARE farm INT;
DECLARE new_id INT;

START TRANSACTION;

SELECT COUNT(farm_id) INTO farm
FROM farm 
WHERE farm_id = farm_num;

IF (farm = 0) THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FARM DOES NOT EXIST!!!';
END IF;

SELECT MAX(tank_id) INTO new_id
  FROM tank;

IF (new_id IS NULL) THEN
  SET new_id = 1;
ELSE 
  SET new_id = new_id + 1;
END IF;

INSERT INTO tank (tank_id, t_farm, t_purchase, t_retired) 
VALUES (new_id, farm_num, purchase_date, retired_date);

COMMIT;

END;

-- "milkingEvent" - used by the milking machine to record a milking event from a cow, this will include which tank the milk was put in

CREATE OR REPLACE PROCEDURE `milkingEvent`
    (IN `machine` INT(11),
    IN `cow` VARCHAR(8),
    IN `date` DATE,
    IN `start_time` TIME,
    IN `stop_time` TIME,
    IN `oz` INT(11))

  BEGIN 

  DECLARE machine_num INT; 
  DECLARE cow_num INT;
  DECLARE new_id INT;

  START TRANSACTION;

  SELECT COUNT(mm_id) INTO machine_num
    FROM milkingMachine
    WHERE mm_id = machine;

  IF (machine_num = 0) THEN
    ROLLBACK;
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'MACHINE DOES NOT EXIST!!!';
    END IF;

  SELECT COUNT(cow_tag) INTO cow_num
    FROM cow
    WHERE cow_tag = cow;

  IF (cow_num = 0) THEN 
    ROLLBACK;
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'COW DOES NOT EXIST!!!';
    END IF;

  SELECT MAX(milk_id) INTO new_id
    FROM milk;

  IF (new_id IS NULL) THEN
    SET new_id = 1;
  ELSE 
    SET new_id = new_id + 1;
  END IF;

  INSERT INTO milk (milk_id, milk_machine, milk_cow, milk_date, milk_start) 
    VALUES (new_id, machine, cow, `date`, start_time);

  COMMIT;

  END;

-- "newCompany" - used to record a new company for processing or transportation

CREATE OR REPLACE PROCEDURE `newCompany`
    (IN `name` VARCHAR(30), 
     IN `transport` TINYINT(1), 
     IN `processing` TINYINT(1)) 
BEGIN 

DECLARE max_company_id INT;

START TRANSACTION;

-- FARM ID -> INT(11)
SELECT MAX(company_id) INTO max_company_id
FROM company;

IF (max_company_id IS NULL) THEN
    SET max_company_id = 1;
ELSE 
    SET max_company_id = max_company_id + 1;
END IF;

INSERT INTO company (company_id, company_name, c_doesProcessing, c_doesTransport) 
VALUES (max_company_id, name, transport, processing);

COMMIT;

END;

-- "editCompany" - used to update a company record

CREATE OR REPLACE PROCEDURE `editCompany`
    (IN `company_id` INT(11),
     IN `name` VARCHAR(30), 
     IN `transport` TINYINT(1), 
     IN `processing` TINYINT(1)) 
BEGIN 

DECLARE id INT;

START TRANSACTION;

-- FARM ID -> INT(11)
SELECT COUNT(company_id) INTO id
  FROM company
  WHERE company_id = company_id;

IF (id = 0) THEN
  ROLLBACK;
  SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'COMPANY DOES NOT EXIST!!!';
  END IF;

UPDATE company SET company_name = name, c_doesProcessing = processing, c_doesTransport = transport WHERE company_id = company_id;

COMMIT;

END;

-- "milkDelivery" - used to record when a tank is emptied into a truck for transportation to a processor

CREATE OR REPLACE PROCEDURE `milkDelivery`
    (IN `transporter` INT(11),
     IN `processor` INT(11), 
     IN `truck_num` VARCHAR(8),
     IN `from_tank` INT(11),
     IN `pickup_date` DATETIME) 
BEGIN 

DECLARE tank INT;
DECLARE max_transport_id INT;

START TRANSACTION;


SELECT COUNT(tank_id) INTO tank
FROM tank 
WHERE tank_id = from_tank;

IF (tank = 0) THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'TANK DOES NOT EXIST!!!';
END IF;


-- FARM ID -> INT(11)
SELECT MAX(transport_id) INTO max_transport_id
FROM transport;

IF (max_transport_id IS NULL) THEN
    SET max_transport_id = 1;
ELSE 
    SET max_transport_id = max_transport_id + 1;
END IF;

INSERT INTO transport (transport_id, t_transporter, t_processor, t_truckNum, t_fromTank, t_pickup) 
VALUES (max_transport_id, transporter, processor, truck_num, from_tank, pickup_date);

COMMIT;

END;