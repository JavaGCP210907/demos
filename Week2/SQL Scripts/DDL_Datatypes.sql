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

--this is a horribly designed table (no primary key, not normalized)
--we wont' use it, it's just to list out some datatypes

CREATE TABLE datatypes (
	small_number int2, --2 bytes, smaller numbers
	normal_number int, --4 bytes, most common int type, same as int4
	big_number int8, --8 bytes, BIG numbers
	standard_decimal decimal(10, 2), --2 parameters: (total digits, decimal places)
									--left parameter is including decimal places	
	
	"boolean" boolean, --double quotes let you assigns to things 
	
	fixed_length_text char(10), --will be 10 characters, not best practice generally
	variable_length_text varchar(10), --can be from 0-10 characters, ok practice
	unlimited_length_text TEXT, --best practice, unlimited length
	
	"date" date, --YYYY-MM-DD
	"timestamp" timestamp --YYYY-MM-DD HH-MM-SS 
	
	--This is NOT all of the datatypes. There are so many
	--But... most of the time, data will just be numbers, text, and times
);




