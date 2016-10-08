
COMMENT ON DATABASE finalproject
  IS 'The database for the ZooKeepr project';
  
-- Table: food_category
-- DROP TABLE food_category;

CREATE TABLE food_category
(
  category_id serial NOT NULL,
  category character varying(255),
  CONSTRAINT category_id PRIMARY KEY (category_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE food_category
  OWNER TO postgres;

-- Table: condition
-- DROP TABLE condition;

CREATE TABLE condition
(
  condition_id serial NOT NULL,
  condition character varying(255),
  CONSTRAINT condition_id PRIMARY KEY (condition_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE condition
  OWNER TO postgres;

-- Table: food
-- DROP TABLE food;

CREATE TABLE food
(
  food_id serial NOT NULL,
  category_id integer,
  name character varying(255),
  vendor character varying(255),
  CONSTRAINT food_id PRIMARY KEY (food_id),
  CONSTRAINT category_id FOREIGN KEY (category_id)
      REFERENCES food_category (category_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

ALTER TABLE food
  OWNER TO postgres;

  -- Index: fki_category_id
-- DROP INDEX fki_category_id;

CREATE INDEX fki_category_id
  ON food
  USING btree
  (category_id);

-- Table: animal
-- DROP TABLE animal;

CREATE TABLE animal
(
  animal_id serial NOT NULL,
  common_name character varying(255),
  scientific_name character varying(255),
  food_id integer,
  info_link character varying(255),
  CONSTRAINT animal_id PRIMARY KEY (animal_id),
  CONSTRAINT food_id FOREIGN KEY (food_id)
      REFERENCES food (food_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

ALTER TABLE animal
  OWNER TO postgres;

-- Index: fki_food_id
-- DROP INDEX fki_food_id;

CREATE INDEX fki_food_id
  ON animal
  USING btree
  (food_id);

-- Table: enclosure
-- DROP TABLE enclosure;

CREATE TABLE enclosure
(
  enclosure_id serial NOT NULL,
  animal_id integer,
  name character varying(255),
  animal_quantity integer,
  feeding_time character varying(7),
  condition_id integer,
  CONSTRAINT enclosure_id PRIMARY KEY (enclosure_id),
  CONSTRAINT animal_id FOREIGN KEY (animal_id)
      REFERENCES animal (animal_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT condition_id FOREIGN KEY (condition_id)
      REFERENCES condition (condition_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

ALTER TABLE enclosure
  OWNER TO postgres;

-- Index: fki_animal_id
-- DROP INDEX fki_animal_id;

CREATE INDEX fki_animal_id
  ON enclosure
  USING btree
  (animal_id);

-- Index: fki_condition_id
-- DROP INDEX fki_condition_id;

CREATE INDEX fki_condition_id
  ON enclosure
  USING btree
  (condition_id);

INSERT INTO condition (condition) VALUES ('Excellent'),('Good'),('Fair'),('Average'),('Poor'),('Terrible'),('Squalid');

INSERT INTO food_category (category) VALUES ('Meat'),('Fish'),('Poultry'),('Grain'),('Fruit'),('Vegetable'),('Dairy');

INSERT INTO food (name,category_id,vendor)
  VALUES ('Beef Haunch',1,'ButcherMart'),
         ('Chum',2,'Deep Sea Catcheries'),
         ('Raw Chicken',3,'ButcherMart'),
         ('Carrots',6,'FarmFresh Jungle'),
         ('Badger Milk',7,'BadgerCo'),
         ('Apples',5,'JungleFresh Farms'),
         ('Bananas',5,'JungleFresh Farms'),
         ('Rye Biscuits',4,'ZooBake Inc.'),
         ('Live Mice',1,'Disneyland');

INSERT INTO animal (common_name, scientific_name, food_id, info_link) 
  VALUES ('Zebra','Equus quagga',8,'https://en.wikipedia.org/wiki/Zebra'),
         ('Rattlesnake','Crotalus adamanteus',9,'https://en.wikipedia.org/wiki/Rattlesnake'),
         ('Honey Badger','Mellivora capensis capensis',1,'https://en.wikipedia.org/wiki/Honey_badger'),
         ('Flying Squirrel','Hylopetes baberi',5,'https://en.wikipedia.org/wiki/Flying_squirrel'),
         ('Kookaburra','Dacelo novaeguineae',9,'https://en.wikipedia.org/wiki/Kookaburra'),
         ('Hammerhead Shark','Sphyrna corona',2,'https://en.wikipedia.org/wiki/Hammerhead_shark');

INSERT INTO enclosure (name, animal_id, animal_quantity, condition_id, feeding_time)
  VALUES ('Zebraporium',1,17,3,'1:23AM'),
         ('House of Snakes',2,3269,1,'3:33PM'),
         ('Birds of the World',5,100,5,'2:45AM'),
         ('Aquarium',6,3,1,'12:23PM'),
         ('Badger Exhibit',3,12,7,'8:00AM');