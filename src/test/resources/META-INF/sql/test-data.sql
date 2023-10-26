--
-- LANGUAGE
--
INSERT INTO language (language_id,name,last_update) VALUES (1,'English','2006-02-15 04:02:19');
--
-- COUNTRY
--
INSERT INTO country (country_id, country, last_update) VALUES (1, 'España', '2006-02-15 04:02:19');
--
-- CITY
--
INSERT INTO city (city_id, city, country_id, last_update) VALUES (1,'Madrid',1,'2006-02-15 03:45:25');
INSERT INTO city (city_id, city, country_id, last_update) VALUES (2,'Barcelona',1,'2006-02-15 03:45:25');
INSERT INTO city (city_id, city, country_id, last_update) VALUES (3,'Oviedo',1,'2006-02-15 03:45:25');
INSERT INTO city (city_id, city, country_id, last_update) VALUES (4,'Gijón',1,'2006-02-15 03:45:25');
--
-- ADDRESS
--
INSERT INTO address (address_id,address,address2,district,city_id,postal_code,phone,location,last_update) VALUES (1,'C/ Seco 3',NULL,'Distrito 1',1,'28007','',NULL,'2014-09-25 20:30:27');
INSERT INTO address (address_id,address,address2,district,city_id,postal_code,phone,location,last_update) VALUES (2,'C/ Montserrat de Casanovas 215',NULL,'Distrito 1',2,'08032','',NULL,'2014-09-25 20:30:09');
INSERT INTO address (address_id,address,address2,district,city_id,postal_code,phone,location,last_update) VALUES (3,'C/ Martínez Cachero 30',NULL,'Distrito 1',3,'33013','14033335568',NULL,'2014-09-25 20:30:27');
INSERT INTO address (address_id,address,address2,district,city_id,postal_code,phone,location,last_update) VALUES (4,'C/ Corrida 5',NULL,'Distrito 1',4,'33206','6172235589',NULL,'2014-09-25 20:30:09');
INSERT INTO address (address_id,address,address2,district,city_id,postal_code,phone,location,last_update) VALUES (5,'C/ Uria 1','','Distrito 1',3,'33003','28303384290',NULL,'2014-09-25 20:31:53');
--
-- FILM
--
INSERT INTO film (film_id,title,description,release_year,language_id,original_language_id,rental_duration,rental_rate,length,replacement_cost,rating,special_features,last_update) VALUES (1,'ACADEMY DINOSAUR','A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies',2006,1,NULL,6,0.99,86,20.99,'PG','Deleted Scenes,Behind the Scenes','2006-02-15 04:03:42');
--
-- STORE
--
INSERT INTO store (store_id, manager_staff_id, address_id, last_update) VALUES (1,NULL,1,'2006-02-15 03:57:12');
INSERT INTO store (store_id, manager_staff_id, address_id, last_update) VALUES (2,NULL,2,'2006-02-15 03:57:12');
--
-- STAFF
--
INSERT INTO staff (staff_id, first_name, last_name, address_id, picture, email, store_id, active, username, password, last_update) VALUES (1,'Antonio','García',3,NULL,'chino@sakilastaff.com',1,1,'Mike',NULL,'2006-02-15 02:57:16');
INSERT INTO staff (staff_id, first_name, last_name, address_id, picture, email, store_id, active, username, password, last_update) VALUES (2,'José','Fernández',4,NULL,'juju@sakilastaff.com',2,1,'Jon',NULL,'2006-02-15 02:57:16');




COMMIT;