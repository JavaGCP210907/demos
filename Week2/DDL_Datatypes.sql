--Data Definition Language (DDL): create, alter, truncate, drop
--DDL is any command related to building the structure of your data
--It doesn't deal directly with data!!


--create will CREATE your tables (you can also create schemas/databases this way)
CREATE TABLE users (
	username text
);
--we created a (bad) table of users that simply tracks a username 


--alter lets you change the columns of your table (or add a column)
ALTER TABLE users ADD user_age int;
--in this case, we added a column for user_age

--this command would drop our users table
DROP TABLE users;

--not shown: TRUNCATE, which drops all records in a table 
--TRUNCATE TABLE users;


--so DROP deletes the table... and TRUNCATE clears the data from it


--this is an extremely rudimentary table, mostly to show DDL syntax

-----------------------------------------------------------------------------------

--SQL datatypes







