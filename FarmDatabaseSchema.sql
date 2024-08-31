CREATE TABLE milkingMachine (
  milking_machine_id INTEGER,
  farm INTEGER,
  CONSTRAINT PK_MilkingMachine PRIMARY KEY (milking_machine_id)
);

CREATE TABLE milk (
  milk_id INTEGER,
  milk_machine INTEGER,
  cow INTEGER,
  collected_date DATE,
  start_time TIME,
  end_time TIME,
  ozs INTEGER,
  CONSTRAINT PK_Milk PRIMARY KEY (milk_id)
);

CREATE TABLE cow (
  ear_tag INTEGER,
  name VARCHAR(255),
  farm INTEGER,
  CONSTRAINT PK_Cow PRIMARY KEY (ear_tag)
);

CREATE TABLE farm (
  farm_id INTEGER,
  address VARCHAR(255),
  city VARCHAR(255),
  state CHAR(2),
  zip CHAR(5),
  CONSTRAINT PK_Farm PRIMARY KEY (farm_id)
);

CREATE TABLE feed (
  farm_id INTEGER,
  lbs INTEGER,
  kind VARCHAR(255)
);

CREATE TABLE transport (
  transport_id INTEGER,
  transport_company_id INTEGER,
  processor_id INTEGER,
  truckNum VARCHAR(255),
  fromTank INTEGER,
  transport_date DATE,
  transport_time TIME,
  CONSTRAINT PK_Transport PRIMARY KEY (transport_id)
);

CREATE TABLE maintenance (
    maintenance_id INTEGER,
    milking_machine_affected INTEGER,
    primary_hand INTEGER,
    maintance_date DATE,
    maintance_wasSuccess BOOL,
    CONSTRAINT PK_Maintenance PRIMARY KEY (maintenance_id)
);

CREATE TABLE tankInput(
  tank INTEGER,
  milkAdded INTEGER,
  tankInput_date DATE,
  tankInput_time TIME
);

CREATE TABLE processingCompany (
  processingCompany_id INTEGER,
  name VARCHAR(255)
  CONSTRAINT PK_ProcessingCompany PRIMARY KEY (processingCompany_id)
);

CREATE TABLE tank (
  tank_id INTEGER,
  farm INTEGER,
  purchase DATE,
  retired DATE,
  CONSTRAINT PK_Tank PRIMARY KEY (tank_id)
); 

CREATE TABLE hand (
  hand_id INTEGER,
  fname VARCHAR(255),
  lname VARCHAR(255),
  farm INTEGER,
  CONSTRAINT PK_Hand PRIMARY KEY (hand_id)
);

CREATE TABLE transportCompany (
  transportCompany_id INTEGER,
  name VARCHAR(255),
  CONSTRAINT PK_TransportCompany PRIMARY KEY (transportCompany_id)
);

-- CONSTRAINTS, FORIEGN KEYS, and DATA: I'm adding them one table @ a time 

-- milkingMachine

ALTER TABLE milkingMachine 
ADD CONSTRAINT FK_milkingMachine_Farm FOREIGN KEY (farm) REFERENCES farm(farm_id);

INSERT INTO milkingMachine (milking_machine_id, farm)
VALUES
    (1, 1),
    (2, 2);

-- milk

ALTER TABLE milk 
ADD CONSTRAINT FK_milk_milkingMachine FOREIGN KEY (milk_machine) REFERENCES milkingMachine(milking_machine_id),
ADD CONSTRAINT FK_milk_cow FOREIGN KEY (cow) REFERENCES cow(ear_tag),
ADD CONSTRAINT positive_ozs CHECK (ozs > 0),
ADD CONSTRAINT milk_times CHECK (start_time < end_time);

-- the amount of milk is always positive

-- start time has to be before end time

INSERT INTO milk (milk_id, milk_machine, cow, collected_date, start_time, end_time, ozs)
VALUES
    (1, 1, 1, '2024-03-02', '08:00:00', '90:00:00', 32),
    (2, 2, 2, '2024-03-02', '09:00:00', '10:00:00', 28);

-- cow

ALTER TABLE cow 
ADD CONSTRAINT FK_cow_farm FOREIGN KEY (farm) REFERENCES farm(farm_id);

INSERT INTO cow (ear_tag, name, farm)
VALUES
    (1, 'Rohan', 1),
    (2, 'MooMoo', 1);

-- farm

INSERT INTO farm (farm_id, address, city, state, zip)
VALUES
    (1, '123 Random St', 'ACity', 'MN', '12345'),
    (2, '456 WTF St', 'AnotherCity', 'MN', '67890');

-- feed

ALTER TABLE feed 
ADD CONSTRAINT FK_feed_farm FOREIGN KEY (farm_id) REFERENCES farm(farm_id)
ADD CONSTRAINT positive_lbs CHECK (lbs > 0);

-- the amount of feed is always positive

INSERT INTO feed (farm_id, lbs, kind)
VALUES
    (1, 100, 'Hay'),
    (1, 50, 'Grain');

-- transport

ALTER TABLE transport 
ADD CONSTRAINT FK_transport_transportCompany FOREIGN KEY (transport_company_id) REFERENCES transportCompany(transportCompany_id),
ADD CONSTRAINT FK_transport_processor FOREIGN KEY (processor_id) REFERENCES processingCompany(processingCompany_id),
ADD CONSTRAINT FK_transport_tank FOREIGN KEY (fromTank) REFERENCES tank(tank_id);

INSERT INTO transport (transport_id, transport_company_id, processor_id, truckNum, fromTank, transport_date, transport_time)
VALUES
    (1, 1, 1, 'ABC123', 1, '2024-03-02', '08:00:00'),
    (2, 2, 2, 'DEF456', 2, '2024-03-02', '09:00:00');

-- maintenance

ALTER TABLE maintenance 
ADD CONSTRAINT FK_maintenance_milkingMachine FOREIGN KEY (milking_machine_affected) REFERENCES milkingMachine(milking_machine_id),
ADD CONSTRAINT FK_maintenance_hand FOREIGN KEY (primary_hand) REFERENCES hand(hand_id);

INSERT INTO maintenance (maintenance_id, milking_machine_affected, primary_hand, maintance_date, maintance_wasSuccess)
VALUES
    (1, 1, 1, '2024-03-01', TRUE),
    (2, 2, 2, '2024-03-02', FALSE);

-- tankInput

ALTER TABLE tankInput 
ADD CONSTRAINT FK_tankInput_milk FOREIGN KEY (milkAdded) REFERENCES milk(milk_id),
ADD CONSTRAINT positive_milkAdded CHECK (milkAdded > 0);

-- the amount of milkAdded is always positive

INSERT INTO tankInput (tank, milkAdded, tankInput_date, tankInput_time)
VALUES
    (1, 1, '2024-03-01', '08:00:00'),
    (2, 1, '2024-03-01', '09:00:00');

-- processingCompany

INSERT INTO processingCompany (processingCompany_id, name)
VALUES
    (1, 'Company A'),
    (2, 'Company B');

-- tank

ALTER TABLE tank 
ADD CONSTRAINT FK_tank_farm FOREIGN KEY (farm) REFERENCES farm(farm_id),
ADD CONSTRAINT tank_dates CHECK (purchase < retired);

-- purchase date has to be before the retire date

INSERT INTO tank (tank_id, farm, purchase, retired)
VALUES
    (1, 1, '2023-01-01', NULL),
    (2, 2, '2022-05-15', '2024-02-28');

-- hand

ALTER TABLE hand 
ADD CONSTRAINT FK_hand_farm FOREIGN KEY (farm) REFERENCES farm(farm_id);

-- would make fname and lname unique but each column already distinct from primary key

INSERT INTO hand (hand_id, fname, lname, farm)
VALUES
    (1, 'Rohan', 'Kumar', 1),
    (2, 'Another', 'Name', 2);

-- transportCompany

INSERT INTO transportCompany (transportCompany_id, name)
VALUES
    (1, 'Transport Company A'),
    (2, 'Transport Company B');
