CREATE TABLE sys.ORDERS (
  ORDER_DATE TIMESTAMP,
  CUSTOMER_ID NUMERIC(3, 0),
  AMOUNT NUMERIC(13, 2)
);
select * from sys.ORDERS;
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-02 20:10:23', 101, 10000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102, 15000);
INSERT INTO SYS.ORDERS VALUES (NOW(), 103, 17000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID) VALUES (NOW(), 104);
-- INSERT INTO SYS.ORDERS VALUES (103, 17000); -- The DBMS don't know which colums you would like to store the values

-- SELECT STATEMENTS
select * from sys.orders where customer_id = 101;
select amount from sys.orders where customer_id = 101; -- 10000.00
select customer_id from sys.orders where amount >= 15000; -- 102 | 103

-- UPDATE STATEMENTS
UPDATE SYS.ORDERS SET AMOUNT = 30000 WHERE CUSTOMER_ID = 102;
select * from sys.orders;
UPDATE SYS.ORDERS SET AMOUNT = 20000 WHERE CUSTOMER_ID IN (101, 103) AND ORDER_DATE >= '2022-11-02'; -- 2 ROWS UPDATED
UPDATE SYS.ORDERS SET AMOUNT = 40000 WHERE CUSTOMER_ID IN (101, 103) AND ORDER_DATE >= '2022-11-04'; -- 1 ROW UPDATED
SELECT COUNT(*) FROM SYS.ORDERS; -- 4
SELECT COUNT(*) FROM SYS.ORDERS WHERE ORDER_DATE >= '2022-11-04'; -- 3
SELECT 1 FROM SYS.ORDERS WHERE ORDER_DATE >= '2022-11-04'; -- THREE '1' ARE RETURNED
SELECT COUNT(1) FROM SYS.ORDERS WHERE ORDER_DATE >= '2022-11-04'; -- 3

-- DELETE STATEMENETS
DELETE FROM SYS.ORDERS WHERE CUSTOMER_ID IN (102, 104); -- 2 ROWS DELETED
select * from sys.orders;
DELETE FROM SYS.ORDERS; -- DELETE ALL ROWS
select * from sys.orders;

INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-02 20:10:23', 102, 20000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-04 20:10:23', 102, 30000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102, 30000);
select * from sys.orders;
DELETE FROM SYS.ORDERS WHERE CUSTOMER_ID = 102 ORDER BY ORDER_DATE DESC LIMIT 1; -- DELETE THE RECORD WITH LATEST ORDER_DATE
select * from sys.orders;

-- ALTER COLUMNS AND GROUP BY
ALTER TABLE SYS.ORDERS ADD MEMBERSHIP VARCHAR(1);
DELETE FROM SYS.ORDERS; -- DELETE ALL ROWS
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ('2022-11-02 20:10:23', 101, 22000, 'G');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ('2022-11-04 20:10:23', 102, 30000, 'S');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 103, 40000, 'S');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 104, 40000, NULL);
SELECT MEMBERSHIP, COUNT(1) FROM SYS.ORDERS GROUP BY MEMBERSHIP; -- G, 1 | S, 2
SELECT MEMBERSHIP, AVG(AMOUNT) FROM SYS.ORDERS GROUP BY MEMBERSHIP; -- G, 22000 | S, 35000
SELECT MEMBERSHIP, SUM(AMOUNT) FROM SYS.ORDERS GROUP BY MEMBERSHIP; -- G, 22000 | S, 70000
SELECT MEMBERSHIP, COUNT(MEMBERSHIP) FROM SYS.ORDERS GROUP BY MEMBERSHIP HAVING COUNT(MEMBERSHIP) > 1; -- S, 2

SELECT MEMBERSHIP, COUNT(MEMBERSHIP) FROM SYS.ORDERS 
WHERE ORDER_DATE > '2022-11-05' GROUP BY MEMBERSHIP HAVING COUNT(MEMBERSHIP) > 1; -- NO ROWS RETURNED

SELECT DISTINCT MEMBERSHIP FROM SYS.ORDERS; -- G, S, NULL