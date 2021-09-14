--First thing I want to do is create two tables with a relationship
--(Using primary key and foreign key constraints)

--This schema will be made to track dogs and their owners


--owners table
CREATE TABLE owners(
	owner_id serial PRIMARY KEY, 
	--serial is an auto incrementing data type. We don't need to add a value to it
	--whenever we insert a new owner, the owner_id will be generated for us
	name TEXT NOT null
);

--dogs table
CREATE TABLE dogs(
	dog_id serial PRIMARY KEY,
	name TEXT,
	breed TEXT,
	age int CHECK (age > 1),
	weight decimal(5, 2),
	owner_id int REFERENCES owners (owner_id) --this is a foreign key (note the use of "references")
	--this is saying, this foreign key as bound to the primary key (owner_id) of the owners table
	--THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN OUR DATA (in a relational database)
);

--You want to create the tables that other tables depend on FIRST
--Notice how we can't create the dogs table if the owners table doesn't exist

--Since the dogs table has a refernce to the owners table, there's a relationship
--In this case, one owner can have many dogs - a "one-to-many" relationship
--we'll talk about cardinality later today (one-to-one, one-to-many, many-to-many)


--DROP TABLE owners;

--why can't we drop the owners table? It's a problem because the dogs table depends on it
--we COULD drop the owner's table by using the CASCADE keyword, which we'll take notes on later

DROP TABLE owners cascade;
DROP TABLE dogs;

--don't forget to recreate the tables so we can do some DML below

-----------------------------------------------------------------------------------------

--now, let's use some Data Manipulation Language (DML): Select, Insert, Update, Delete


--INSERT some owners into the owners table, and dogs into the dogs table
--after each insert, we'll use SELECT to show the new data

--we specify what table and what columns we're inserting data in
--and then we can specify one or many records to insert. In this case, we're insert 4 records.
INSERT INTO owners (name) 
VALUES ('Eric'), ('Paul'), ('Mesfin'), ('Lucas');

--return all the owner records (rows) we just created
SELECT * FROM owners; --we use * to select every column from the records (as opposed to certain columns)


INSERT INTO dogs (name, breed, age, weight, owner_id)
VALUES ('Fido', 'Yorkie', 10, 15, 1),
	   ('Sparky', 'Terrier', 13, 12, 2),
	   ('Max', 'Mastiff', 5, 140.55, 3),
	   ('Rex', 'Lab', 7, 50.65, 3); --note: an owner may have many dogs or none at all
	   

SELECT * FROM dogs;


--We can also select data from specific columns instead of all columns

SELECT name FROM dogs; --return all dog names

SELECT name, age, owner_id FROM dogs; --return these three columns only

--ALTER SEQUENCE dogs_dog_id_seq RESTART WITH 4615793;
--we can start out serial ids from a specific number like this^

--Let's explore the WHERE clause-------------------------------------------------------------------

--There are a lot of operators we can use with WHERE, all of which filter data differently

--dogs who are yorkies (=)
SELECT * FROM dogs WHERE breed = 'Yorkie';

--as you can assume, != works in the opposite way
SELECT * FROM dogs WHERE breed != 'Yorkie';

--dogs younger than 8 (<)
SELECT * FROM dogs WHERE age < 8;

--dogs with names that start with M (like) (%)
SELECT * FROM dogs WHERE name LIKE 'M%'; --nothing after M matters, it can be anything (wildcard)

--dogs with names that end in x (like) (%)
SELECT * FROM dogs WHERE name LIKE '%x';

--dogs who weigh between 20-200 pounds (between) (and)
SELECT * FROM dogs WHERE weight BETWEEN 50.65 AND 140.55; --with between, the bounds ARE included

--dogs who are Yorkies or Labs (or) (in)
SELECT * FROM dogs WHERE breed = 'Yorkie' OR breed = 'Lab'; --(expression) or (expression)
SELECT * FROM dogs WHERE breed IN ('Yorkie', 'Lab'); --checks if the column is within an array of values

--dogs who are NOT Yorkies or Labs (not in)
SELECT * FROM dogs WHERE breed NOT IN ('Yorkie', 'Lab');

--Also important is the ORDER BY keyword, which lets us return our data in a certain order

SELECT * FROM dogs ORDER BY age; --ascending order by default, can specify "asc" if you want

SELECT * FROM dogs ORDER BY age desc; --you have to specify if you want descending order 



