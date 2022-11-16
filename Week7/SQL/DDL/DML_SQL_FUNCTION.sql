-- Upper case the string
Select upper(FIRST_NAME) from Worker;
-- Lower case the string
Select lower(FIRST_NAME) from Worker;

-- Yes, SQL substring like Java string.substrin()
Select substring(FIRST_NAME,1,3) from Worker;

-- Remove the space from the right hand side of the string
Select RTRIM(FIRST_NAME) from Worker;
-- Remove the space from the left hand side of the string
Select LTRIM(FIRST_NAME) from Worker;
-- Remove the space from the string
Select TRIM(FIRST_NAME) from Worker;

-- Replace
Select REPLACE(FIRST_NAME,'a','A') from Worker;
-- Concat
Select CONCAT(FIRST_NAME,'a') from Worker;
