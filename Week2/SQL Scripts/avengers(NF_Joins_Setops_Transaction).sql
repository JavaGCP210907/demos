--This script will demonstrate Normal Forms 0-3NF

--Then we'll get into Joins and Set Operations

--I ALSO want to fit a transaction in here. (TCL)


--0NF
--We have a table. No other rules.

CREATE TABLE avengers (
	hero_name TEXT,
	hero_power TEXT,
	real_name TEXT,
	home_base TEXT,
	home_address TEXT 
);

INSERT INTO avengers (hero_name, hero_power, real_name, home_base, home_address)
VALUES ('Spiderman', 'Webby Boi', 'Peter Parker', 'His Aun''ts House', '225 his aunt'' house'),
											--you need two apostrophes to put on apostrophe in a text value
	   ('Hawkeye', 'handsome ugly and has a bow and arrow', 'Clint Barton', 'A Farm', '123 Farmville rd');
	  --Note how if we had a different spiderman (like Miles Morales), it would be harder to uniquely identify them 
	  
SELECT * FROM avengers;
	   
DROP TABLE IF EXISTS avengers;

--1NF
--Tables must have a Primary Key (can be a composite key)
--Columns must be atomic

--Notice we don't have an avenger_id primary key... we're using hero_name and the f_name/l_name fields to uniquely identify
CREATE TABLE avengers (
	hero_name TEXT,
	hero_power TEXT,
	f_name TEXT,
	l_name TEXT,
	home_base TEXT,
	street_number TEXT,
	city TEXT,
	state char(2), --remember me? This will restrict the values to only 2 characters
	PRIMARY KEY(f_name, l_name) --composite key!!!
);
	   
INSERT INTO avengers (hero_name, hero_power, f_name, l_name, home_base, street_number, city, state)
VALUES ('Spiderman', 'Webby Boi', 'Peter', 'Parker', 'His Aun''ts House', '225 his aunt'' house', 'Queens', 'NY'),
	   ('Spiderman', 'Webby Boi', 'Miles', 'Morales', 'His Aun''ts House', '225 his aunt'' house', 'Queens', 'NY'),	
	   --Note how everything in the spidermen records are identical, except for the fields comprising the composite key
	   --Just remember, a composite key is a primary key spanning multiple columns
	   ('Thor', 'Hammer Boi and nice hair', 'Thor', 'Odinson', 'Asgard', '5678 Rainbow Rd', 'Asgard', 'NY');
	   
--ALTER TABLE avengers ADD PRIMARY KEY (f_name, l_name); 
--when ben goofed, he could have also added a PK this way

SELECT * FROM avengers;

DROP TABLE IF EXISTS avengers;
	  
--2NF 
--Remove Partial Dependencies
--You can eliminate partial dependencies by having a single column Primary Key (no composite keys!)

CREATE TABLE avengers (
	hero_id serial PRIMARY KEY,
	hero_name TEXT,
	hero_power TEXT,
	f_name TEXT,
	l_name TEXT,
	home_base TEXT,
	street_number TEXT,
	city TEXT,
	state char(2)
);

INSERT INTO avengers (hero_name, hero_power, f_name, l_name, home_base, street_number, city, state)
VALUES ('Spiderman', 'Webby Boi', 'Peter', 'Parker', 'His Aun''ts House', '225 his aunt'' house', 'Queens', 'NY'),
	   ('Spiderman', 'Webby Boi', 'Miles', 'Morales', 'His Aun''ts House', '225 his aunt'' house', 'Queens', 'NY'),	
	   ('Black Widow', 'She pretty and deadly', 'Natasha', 'Romanov', 'Avengers Tower', '645 Street St', 'New York', 'NY');

SELECT * FROM avengers;


--3NF
--Remove Transitive Dependencies (by separating them into new tables)
--The only columns depended on should be primary keys!!

DROP TABLE IF EXISTS avengers;

--home data should be its own table

CREATE TABLE homes (
	home_base TEXT PRIMARY KEY, --example of a non-serial id primary key (which typically we'd want to avoid)
	street_number TEXT,
	city TEXT,
	state char(2)
);

--Now, we need to insert some homes for avengers to references
INSERT INTO homes (home_base, street_number, city, state)
VALUES ('Stark Tower', '455 Street st', 'Manhattan', 'NY'),
	   ('Sanctum Sanctorum', '127 Main st', 'Greenwich', 'NJ'),
	   ('Avengers Tower', '763 Broad st', 'New York', 'NY');

CREATE TABLE avengers (
	hero_id serial PRIMARY KEY,
	hero_name TEXT,
	hero_power TEXT, 
	f_name TEXT,
	l_name TEXT,
	home_base_fk TEXT REFERENCES homes(home_base)
);	   

INSERT INTO avengers (hero_name, hero_power, f_name, l_name, home_base_fk)
VALUES ('Ironman', 'Rich and Snarky', 'Tony', 'Stark', 'Stark Tower'),
	   ('Dr. Strange', 'Time Wizard', 'Stephen', 'Strange', 'Sanctum Sanctorum');


SELECT * FROM avengers;

--cool, this is a fully normalized database now.


-----------------------------------------------------------------------------------------------(Joins)

--one more insert statement to better demonstrate left/right joins
INSERT INTO avengers (hero_name, hero_power, f_name, l_name) 
VALUES ('Hancock', 'He''s trying', 'Will', 'Smith'); --empty home base field!!!

--Remember, joins combine data from two tables. Multi-table queries!

--note the keywords:
--we specify the type of JOIN, and what column we're joining ON

--INNER JOIN
--returns rows with matching data in both tables
SELECT * FROM avengers INNER JOIN homes ON home_base = home_base_fk; --inner join is the default join 
																	 --so you could just use "JOIN" on its own

--FULL OUTER JOIN
--return everything from both tables, regardless of matches
SELECT * FROM avengers FULL OUTER JOIN homes ON home_base = home_base_fk;

--LEFT OUTER JOIN
--return everything in the left table, plus matching records in the right table
SELECT * FROM avengers LEFT OUTER JOIN homes ON home_base = home_base_fk;

--RIGHT OUTER JOIN
--return everything in the right table, plus matching records in the left table
SELECT * FROM avengers RIGHT OUTER JOIN homes ON home_base = home_base_fk;

--I'll throw in implementation for a method using a join in the P0Demo

---------------------------------------------------------------------------------------------(Set Operations)

--We use set operations to combine multiple queries
	--DON'T confuse them with joins... think joins -> tables, setops -> queries
	

--UNION
--All DISTINCT rows from each query, no duplicates
SELECT home_base_fk FROM avengers UNION SELECT home_base FROM homes;

--UNION ALL
--All distinct rows from each query including duplicates
SELECT home_base_fk FROM avengers UNION ALL SELECT home_base FROM homes;

--INTERSECT
--Return unique rows found in BOTH queries
SELECT home_base_fk FROM avengers INTERSECT SELECT home_base FROM homes;
--both queries contain the two record that get returned here

--EXCEPT 
--Return unique rows found in the first query that DON'T appear in the second query
SELECT home_base_fk FROM avengers EXCEPT SELECT home_base FROM homes;
--every home base in avengers exists in homes... so we only get Hancock's null value
SELECT home_base FROM homes EXCEPT SELECT home_base_fk FROM avengers;
--avengers tower only exists in the homes table




	  
