table: LOCATIONS
location_id  street_address        postal_code  city        state_province  country_id
-----------  --------------------  -----------  ----------  --------------  ----------
1000         1297 Via Cola di Rie  989          Roma                        IT
1100         93091 Calle della Te  10934        Venice                      IT
1200         2017 Shinjuku-ku      1689         Tokyo       Tokyo Pref      JP
1400         2014 Jabberwocky Rd   26192        Southlake   Texas           US

table: COUNTRIES
country_id  country_name  region_id
----------  ------------  ----------
DE          Germany       1
IT          Italy         1
JP          Japan         3
US          United State  2

table: DEPARTMENTS
+---------------+----------------------+------------+-------------+
| DEPARTMENT_ID | DEPARTMENT_NAME      | MANAGER_ID | LOCATION_ID |
+---------------+----------------------+------------+-------------+
|            10 | Administration       |        200 |        1100 |
|            20 | Marketing            |        201 |        1200 |
|            30 | Purchasing           |        202 |        1400 |

table: EMPLOYEES
+-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
| EMPLOYEE_ID | FIRST_NAME  | LAST_NAME   | EMAIL    | PHONE_NUMBER       | HIRE_DATE  | JOB_ID     | SALARY   | COMMISSION_PCT | MANAGER_ID | DEPARTMENT_ID |
+-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
|         100 | Steven      | King        | SKING    | 515-1234567        | 1987-06-17 | ST_CLERK   | 24000.00 |           0.00 |        109 |            10 |
|         101 | Neena       | Kochhar     | NKOCHHAR | 515-1234568        | 1987-06-18 | MK_REP     | 17000.00 |           0.00 |        103 |            20 |
|         102 | Lex         | De Haan     | LDEHAAN  | 515-1234569        | 1987-06-19 | AC_ACCOUNT | 17000.00 |           0.00 |        108 |            30 |
|         103 | Alexander   | Hunold      | AHUNOLD  | 590-4234567        | 1987-06-20 | MK_REP     |  9000.00 |           0.00 |        105 |            20 |

table: JOB_HISTORY
employee_id  start_date  end_date    job_id      department_id
-----------  ----------  ----------  ----------  -------------
102          1993-01-13  1998-07-24  IT_PROG     20
101          1989-09-21  1993-10-27  AC_ACCOUNT  10
101          1993-10-28  1997-03-15  AC_MGR      30
100          1996-02-17  1999-12-19  MK_REP      30
103          1998-03-24  1999-12-31  ST_CLERK    20

1. Create all the above tables, with the provided structures and PK/ FK if required.
2. Insert some data, you can add your own data.
3. Write a query to find the location_id, street_address, city, state_province, country_name of locations
4. Write a query to find the first_name, last name, department ID of all the employees.
5. Write a query to find the first_name, last_name, job_id, department ID of the employees who works in Japan.
6. Write a query to find the employee id, last_name along with their manager_id and last_name.
7. Write a query to find the first_name, last_name and hire date of the employees who was hired after 'Lex De Haan'.
8. Write a query to get the department name and number of employees for each the department.
9. Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 30.
10. Write a query to display all department name, manager name, and city.
12. Create table JOBS
13. Write a query to display the average salary of each department.