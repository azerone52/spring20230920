-- 비상관 쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용되지 않을 때
-- =33subquery.sql의 쿼리들

-- 상관 쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용될 때
-- 각 공급자가 있는 나라의 고객 수는?

SELECT * FROM suppliers;

SELECT COUNT(*) FROM customers WHERE Country = 'UK'; -- 9
-- 비상관쿼리
SELECT COUNT(*) FROM customers
WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID=1); -- 9
-- 상관쿼리
SELECT s.SupplierID ,(SELECT COUNT(*) FROM customers WHERE customers.Country = s.Country)
FROM suppliers s;

-- 예) 각 직원보다 나이가 많은 직원의 수
SELECT * FROM employees;

SELECT LastName,
       (SELECT COUNT(*) FROM employees e1 WHERE e1.BirthDate < e2.BirthDate) AS `NumberOfEmp`
FROM employees e2;
