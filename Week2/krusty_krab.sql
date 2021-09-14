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






