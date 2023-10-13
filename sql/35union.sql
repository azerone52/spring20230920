-- union 합집합
USE w3schools;
SELECT Country FROM customers;
SELECT Country FROM suppliers;

-- 중복데이터 제거
SELECT Country FROM customers
UNION
SELECT Country FROM suppliers;

-- 중복데이터 제거 x
SELECT Country FROM customers
UNION ALL
SELECT Country FROM suppliers;

-- 열의 개수만 맞으면 됨
SELECT CustomerName, Country, City FROM customers
UNION
SELECT SupplierName, Country, City FROM suppliers;

-- 예) 직원의 lastName과 firstName을 name이라는 하나의 컬럼으로 조회
SELECT LastName name FROM employees
UNION ALL
SELECT FirstName FROM employees;

-- FULL OUTER JOIN
USE mydb1;

-- LEFT OUTER JOIN
SELECT *
FROM my_table44_a a LEFT JOIN my_table44_b b
    ON a.col1 = b.col1;
-- RIGHT OUTER JOIN
SELECT *
FROM my_table44_a a RIGHT JOIN my_table44_b b
    ON a.col1 = b.col1;
-- FULL OUTER JOIN
SELECT *
FROM my_table44_a a LEFT JOIN my_table44_b b
    ON a.col1 = b.col1
UNION
SELECT * FROM my_table44_a a RIGHT JOIN my_table44_b b
    ON a.col1 = b.col1;