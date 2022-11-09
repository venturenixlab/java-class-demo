-- create new database
CREATE DATABASE ORG;
-- show all database;
SHOW DATABASES;
-- get into database
USE ORG;

-- create table worker
CREATE TABLE WORKER (
	WORKER_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY NUMERIC(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

-- inesrt data to worker
INSERT INTO WORKER 
	(FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		('Monika', 'Arora', 100000, '21-02-20 09:00:00', 'HR'),
		('Niharika', 'Verma', 80000, '21-06-11 09:00:00', 'Admin'),
		('Vishal', 'Singhal', 300000, '21-02-20 09:00:00', 'HR'),
		('Amitabh', 'Singh', 500000, '21-02-20 09:00:00', 'Admin'),
		('Vivek', 'Bhati', 490000, '21-06-11 09:00:00', 'Admin'),
		('Vipul', 'Diwan', 200000, '21-06-11 09:00:00', 'Account'),
		('Satish', 'Kumar', 75000, '21-01-20 09:00:00', 'Account'),
		('Geetika', 'Chauhan', 90000, '21-04-11 09:00:00', 'Admin');

-- create table bonus
CREATE TABLE BONUS (
	WORKER_REF_ID INTEGER,
	BONUS_AMOUNT NUMERIC(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
);

-- Task 1:
-- Vivek, with amount 32000 and bonus date 2021 Nov 02
-- Vivek, with amount 20000 and bonus date 2022 Nov 02
-- Amitabh, with amount 21000 and bonus date 2021 Nov 02
-- Geetika, with amount 30000 and bonus date 2021 Nov 02
-- Satish, with amount 4500 and bonus date 2022 Nov 02

-- Task 2:
-- Write an SQL query to show the second highest salary among all workers.

-- Task 3:
-- Write an SQL query to print the name of employees having the highest salary in each department.

-- Task 4:
-- Write an SQL query to fetch the list of employees with the same base salary.

-- Task 5:
-- Write an SQL query to find the worker names with highest salaries + bonus in 2021

-- Task 6 (Please complete Task 1-5 first):
-- Try to delete all the records in table WORKER
-- Study the reason why the data cannot be deleted
-- Try to delete all the records in table BONUS
-- Try to delete all the records in table WORKER

-- Task 7 (Please complete Task 6 first):
-- Try to drop table WORKER
-- Study the reason why the table cannot be deleted
-- Try to drop table BONUS
-- Try to drop table WORKER