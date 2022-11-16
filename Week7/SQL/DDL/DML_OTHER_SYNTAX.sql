-- Create a new table by cloning table struture from another table
-- No data will be cloned
CREATE TABLE worker_clone LIKE worker;

-- Clone data, if the table structure are same
 -- You can add where clause to filter targeted data set to be cloned.
INSERT INTO worker_clone SELECT * FROM worker;

-- return current date
SELECT CURDATE();
-- return current date and time
SELECT NOW();