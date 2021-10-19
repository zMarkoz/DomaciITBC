DROP TABLE IF EXISTS contracts;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS users;


CREATE TABLE cars (
  car_id varchar(255) PRIMARY KEY,
  licence_plate varchar(255) NOT NULL,
  make varchar(255) NOT NULL,
  model varchar(255) NOT NULL,
  year int NOT NULL,
  engine_capacity int NOT NULL,
  color varchar(255),
  price decimal NOT NULL,
  doors int,
  size varchar(1),
  power int NOT NULL,
  automatic boolean NOT NULL,
  fuel varchar(255) NOT NULL,
  image varchar(255)
);


CREATE TABLE users (
  user_id varchar(255) PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  email varchar(255) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  first_name varchar(255),
  last_name varchar(255),
  phone_number varchar(255),
  personal_number varchar(255) UNIQUE,
  image varchar(255),
  admin boolean NOT NULL
);


CREATE TABLE contracts (
  contract_id varchar(255) PRIMARY KEY,
  user_id varchar(255) NOT NULL,
  car_id varchar(255) NOT NULL,
  start_date date NOT NULL,
  end_date date NOT NULL,
  total_price decimal NOT NULL,
  signed boolean NOT NULL,
  approved boolean NOT NULL
);

ALTER TABLE contracts
ADD CONSTRAINT FK_UserContract
FOREIGN KEY (user_id) REFERENCES users(user_id);

ALTER TABLE contracts
ADD CONSTRAINT FK_CarContract
FOREIGN KEY (car_id) REFERENCES cars(car_id);

INSERT INTO cars
VALUES('7312cfff-0738-4d62-bc95-2406b6482f6f', 'NI-0000-OO', 'Honda', 'Civic', 2018, 1498, 'Aegean Blue Metallic', 51.99, 4, 'M', 174, true, 'Gasoline', NULL);
INSERT INTO cars
VALUES('2a0e7c0d-89aa-481b-9083-bf58b4894cde', '333-221', 'Opel', 'Insignia', 2016, 1568, 'Red', 50.90, 4, 'M', 136, true, 'Diesel', NULL);
INSERT INTO cars
VALUES('5241hzzz-5412-5g22-zu21-1331h6633i8i', 'MI-2222-00', 'Audi', 'TT', 2017, 1984, 'Black', 60.25, 6, 'M', 200, true, 'Diesel', NULL);
INSERT INTO cars
VALUES('b3i2cfsf-9038-4d62-bc95-2407b5482m6n', 'NS-2340-HI', 'Ford', 'Focus', 2017, 1380, 'Grey Metallic', 21.00, 4, 'M', 95, false, 'Diesel', NULL);
INSERT INTO cars
VALUES('a2e99685-be6e-4ee4-be3b-d3c86b445c8b', '7AAA476', 'Toyota', 'Prius 3', 2016, 1798, 'Red', 25, 5, 'M', 121, true, 'Diesel', NULL);
INSERT INTO cars
VALUES('ddd3c9c9-c68d-436c-aec9-dc5f3f13fc0d', 'AL92063', 'Alfa Romeo', 'Spider', 2007, 2198, 'Blue', 27.5, 3, 'S', 136, false, 'Gasoline', NULL);
INSERT INTO cars
VALUES('9735bddd-1977-5b95-vc96-5509d8483g8g', 'NI-4892-AO', 'Nissan', 'Qashqai', 2018, 1461, 'White', 55.00, 5, 'L', 115, true, 'Diesel', NULL);
INSERT INTO cars
VALUES('8945gals-7166-4k88-ht00-1432i1957l5j', 'NI-7747-BN', 'Opel', 'Insignia', 2018, 1955, 'Black', 60.00, 5, 'M', 174, false, 'Diesel', NULL);
INSERT INTO cars
VALUES('7641hzzz-5719-5i13-zu21-7651h6933i4j', 'SU-262-C0', 'BMW', 'X3', 2018, 1995, 'Blue Sky', 58.25, 6, 'L', 190, true, 'Diesel', NULL);
INSERT INTO cars
VALUES('7882cfff-0007-4d62-bc95-7776b6482f6f', 'BG-777-LL', 'Audi', 's3', 2012, 1984, 'White', 55.22, 5, 'L', 265, true, 'Gasoline', NULL);
INSERT INTO cars
VALUES('7312cfff-0007-4d62-bc95-2406b6482f6f', 'BG-007-TP', 'Peugeot', '407', 2004, 1997, 'Gray', 35.22, 5, 'M', 136, false, 'Diesel', NULL);
INSERT INTO cars
VALUES('a7m4cfsb-p0d7-4d32-k8v5-2157b548qi8g', 'KG-3157-SK', 'Volvo', 'S60', 2016, 1969, 'Navy Blue Metallic', 47.89, 4, 'M', 168, false, 'Gasoline', NULL);
INSERT INTO cars
VALUES('7312fccc-1734-4f52-aa11-2406b6482g5h', 'BG-4511-CS', 'Porsche', 'Panamera', 2020, 2894, 'Silver Metallic', 109.99, 3, 'M', 434, true, 'Diesel', NULL);
INSERT INTO cars
VALUES('5400fccc-2044-555c-cc55-1403b6482j6j', 'BG-1078-JS', 'Renault', 'Citroen', 2008, 1139, 'Azzurro', 29.99, 5, 'M', 69, false, 'Gasoline', NULL);
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('01a6ed50-0df4-4833-b924-04a3a9baebcb', 'VB-2844-CV', 'Cadillac', 'Seville', 1995, 1567, 'Aquamarine', 76.5, 2, 'M', 138, false, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('c396ff4b-fbf6-4d06-a08e-a2db0e6cf14d', 'EF-802-WM', 'Dodge', 'Ram 1500', 2004, 2011, 'Mauv', 68.67, 3, 'L', 97, false, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('30431950-8c4e-4023-bcdc-dadb709bbe72', 'HF-336-BM', 'Land Rover', 'Range Rover Evoque', 2012, 2350, 'Mauv', 53.07, 2, 'M', 283, true, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('706f4ca7-955c-4088-9568-1ca2514685c7', 'MN-5653-VP', 'Honda', 'Insight', 2003, 1239, 'Teal', 31.1, 5, 'L', 170, true, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('6d5c6a7e-b442-4339-be2b-e0f668cb78f6', 'FM-497-HS', 'Oldsmobile', 'Ciera', 1993, 1844, 'Orange', 63.57, 5, 'L', 103, false, 'Gasoline');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('d63d5ce2-1266-44eb-a7ab-8931a9efcf50', 'DS-2994-EQ', 'Chevrolet', 'Camaro', 1993, 2226, 'Purple', 61.48, 3, 'L', 144, true, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('f1dc0404-9d29-4dcc-bcd1-2ac61f3113fa', 'WY-5891-QH', 'Dodge', 'Dakota', 2007, 1983, 'Goldenrod', 34.34, 2, 'L', 298, false, 'Gasoline');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('6d7af3b2-5004-4822-802d-36c08983cb9e', 'UJ-198-IC', 'Oldsmobile', 'Cutlass Supreme', 1993, 1406, 'Goldenrod', 41.46, 3, 'M', 296, true, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('25a57c79-9b74-4a47-bd1a-77a53dcb5bb6', 'BE-884-FR', 'GMC', 'Jimmy', 1994, 1642, 'Crimson', 63.87, 4, 'L', 185, false, 'Gasoline');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('3aa46622-0120-48cd-8bf4-04c7a2d4acdf', 'FG-4792-WF', 'Aston Martin', 'DBS', 2010, 1826, 'Mauv', 87.17, 5, 'L', 159, true, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('dae7a055-748f-4bdb-bdbd-296a72f14095', 'GA-9612-SV', 'Cadillac', 'SRX', 2010, 2213, 'Fuscia', 93.59, 2, 'L', 106, false, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('eb971796-10dc-48e3-8676-33d03db0568f', 'CG-5345-XB', 'Land Rover', 'Range Rover Sport', 2008, 2354, 'Teal', 74.43, 4, 'L', 276, true, 'Gasoline');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('74774f34-f1b2-47da-a63d-338b1f699323', 'CK-9306-PU', 'Infiniti', 'QX', 2002, 1941, 'Puce', 52.41, 4, 'S', 275, true, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('d71d77db-9540-43e4-834e-d4fa9fc7a4d9', 'RQ-1616-PA', 'Dodge', 'Stratus', 1995, 2382, 'Crimson', 81.65, 4, 'L', 240, false, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('861f170d-39bb-4797-8899-70d96db70544', 'OK-348-LM', 'Infiniti', 'G', 2000, 2121, 'Crimson', 46.08, 5, 'S', 132, false, 'Diesel');
insert into cars (car_id, licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel) values ('7f92a225-f87a-41a7-9c39-c21394345f18', 'WL-214-EP', 'Mazda', 'CX-7', 2012, 2028, 'Blue', 71.8, 2, 'M', 235, true, 'Diesel');

insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin)
values ('7106bf3f-b68d-4195-8afc-e1230c5618cb', 'user', 'user@user.com', 'user', 'Ime', 'Prezime', '+38164123456', '184334879', null, false);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin)
values ('7106bf3f-b68d-4195-8afc-e1230c5618cc', 'admin', 'admin@admin.com', 'admin', 'Ime2', 'Prezime2', '+38164123457', '184334971', null, true);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('e7823531-a004-4fde-b689-9800e23ffecf', 'mpadginton0', 'mpadginton0@dion.ne.jp', 'bfa64a6f6fec223dc35b75ac5db8ff90d1ae78f60e6377f81192ae9efc25d8c9', 'Melony', 'Padginton', '+381646506841', '184334715', null, false);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('aa84955d-8a63-4ca9-b05f-92a8ccd82ed5', 'jhusset1', 'jhusset1@chron.com', '0c1e25375fcb1ab829fa7db454a91270f967b898f663b697453972758efecb4f', 'Jock', 'Husset', '+381602449403', '527821009', null, true);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('21e18e89-999f-4e5e-92b0-4455c3fcf468', 'chighway2', 'chighway2@salon.com', 'ffbbb61ced6c1574d01d950875b88cff4145c89afca67c4bf67a979be795f9b5', 'Cynthie', 'Highway', '+381675654901', '190753147', 'http://dummyimage.com/215x100.png/ff4444/ffffff', true);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('4272d53a-2a79-46d8-9f1c-01eba871fe5e', 'volyhane3', 'volyhane3@cbc.ca', '43c53f85072184cd7e91503e02d12e2b2b63236b3bcc4d78b391568f1a9bb1a3', 'Vi', 'O''Lyhane', '+381678468964', '565790027', null, false);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('e1f5908f-3c0e-4b03-98a3-8774d0789c0c', 'mswaffer4', 'mswaffer4@msn.com', 'eb43c7c2e67d5ac164267296ff9c0fb51b0489d56c4c41e40d3c9908678f21b7', 'Mitch', 'Swaffer', '+38168098377', '236447751', null, false);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('f8628981-e0c8-4575-8548-8afde57f204b', 'cheales5', 'cheales5@blinklist.com', '9c9f1bc5a98e8850ec013e6459d4084503f47f3937ca343abf70a350167b9a52', 'Caitlin', 'Heales', '+38164309280', '011114648', null, true);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('2541b1ee-72b5-4691-80e6-8b94e4bbe54e', 'phawtin6', 'phawtin6@a8.net', '0690fad803bfec54fd56426ab1cafc628ca6aaf39d5f6516a92b7314ccfbdd16', 'Paige', 'Hawtin', '+381657695428', '373669772', 'http://dummyimage.com/204x100.png/cc0000/ffffff', true);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('c074259e-703a-4592-bd21-3fd6a7646391', 'ccrapper7', 'ccrapper7@shutterfly.com', '2ee4d6ef6893b68a1dfe7bc6cd8b19cee2883618999bb4b7a10c33253710c0b3', 'Carol-jean', 'Crapper', '+381620084440', '281880022', null, false);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('3966b84d-015f-406d-9279-a12f5c9a30f4', 'rchinge8', 'rchinge8@gnu.org', 'e258ef670c237d05df5b33e68ebf39c076c853b4bc1fe0c9877aa2754d63f209', 'Rachelle', 'Chinge', '+38162688603', '369264542', null, false);
insert into users (user_id, username, email, password, first_name, last_name, phone_number, personal_number, image, admin) values ('dcf8fdbe-3b8e-4148-a7fc-ada75d9c0818', 'edavall9', 'edavall9@amazon.co.uk', '3ed33053d8161eb860beeabca1c893f985665cebf9a5996ff7025b6829015b56', 'Ettore', 'Davall', '+381606921092', '896615738', null, false);