--This schema will model krusty krab employees and their roles

--This is a one-to-many relationship. the roles table is considered the "one" side and employees is considered the "many" side
--Because one role can have many employees assigned to it.

CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_title TEXT,
	role_salary int
);

CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	f_name TEXT,
	l_name TEXT,
	hire_date date, --YYYY-MM-DD
	role_id int REFERENCES roles (role_id) --foreign key: establishes a relationship between the tables
);


--inserting some data into our tables

INSERT INTO roles (role_title, role_salary) 
VALUES ('Manager', 100000),
	   ('Fry Cook', 50000),
	   ('Cashier', 40000),
	   ('Marketing Director', 100000),
	   ('Nepotism', 100000);
	  
SELECT * FROM roles;


INSERT INTO employees (f_name, l_name, hire_date, role_id)
VALUES ('Eugene', 'Krabs', '1999-05-01', 1),
	   ('Spongebob', 'Squarepants', '2000-07-21', 2),
	   ('Pete', 'Fishman', '1999-05-01', 2),
	   ('Squidward', 'Tentacles', '1999-05-01', 3),
	   ('Sheldon', 'Plankton', '2000-04-18', 4),
	   ('Peal', 'Krabs', '1999-05-01', 5);

SELECT * FROM employees;


------------------------------------------------------------------------------------------

--I want to demonstrate functions, group by, having, limit, and aliases

--scalar functions: upper, lower, length, now

SELECT upper(role_title) FROM roles; --upper returns data in all caps... lower works in the opposite way

SELECT l_name, length(l_name) FROM employees; --length returns an int of the length of value

SELECT f_name FROM employees WHERE length(f_name) > 8; --just for practice, returns names longer than 8 characters

SELECT now(); --just kind of cool, returns a current timestamp


--aggregate functions: avg, max, min, sum, count

SELECT avg(role_salary) FROM roles;

SELECT sum(role_salary) FROM roles;

SELECT min(f_name) FROM employees; --text data types go from A being minimum

SELECT max(hire_date) FROM employees; --date data types go from the latest date being the maximum

--(of course you can use min and max for int types as well)

SELECT count(employee_id) FROM employees; --how many employees are there?
--I like to use the primary key to count on, but you can use any column

--slight aside, the DISTINCT keyword will ignore any duplicate values
SELECT count(DISTINCT hire_date) FROM employees; --how many different hire dates are there?

--NOTE: count will NOT count null values... maybe a good reason as to why we tend to count on the primary key

--Now let's explore using GROUP BY and HAVING-----------------------
--For the most part, we use these with aggregate functions


--GROUP BY lets us combine records based on equivalent values
SELECT role_salary, count(role_id)
FROM roles GROUP BY role_salary; --retrieves salaries and counts of each salary
--the salary rows have been combined, and we also add the count of each in the returned row


SELECT hire_date, count(employee_id)
FROM employees GROUP BY hire_date ORDER BY count(employee_id); --retrieves count of each hire date
--we also ordered by the count of employee_ids this time

--HAVING behaves like WHERE, but it's only used with aggregate functions

--select roles with more than one employee
SELECT role_id, count(employee_id)
FROM employees GROUP BY role_id HAVING count(employee_id) > 1;

--select salaries assigned to 2 or more roles
SELECT role_salary, count(role_id)
FROM roles GROUP BY role_salary HAVING count(role_id) >= 2; 

