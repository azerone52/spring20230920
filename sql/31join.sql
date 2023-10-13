USE w3schools;

-- 주문한 적 없는 고객 조회하기
SELECT DISTINCT CustomerID FROM orders ORDER BY 1;

-- 서브 쿼리 이용
SELECT CustomerName
FROM customers
WHERE CustomerID NOT IN (SELECT DISTINCT CustomerID FROM orders ORDER BY 1);

-- JOIN 이용
SELECT c.CustomerName
FROM customers c LEFT JOIN orders o
ON c.CustomerID = o.CustomerID
WHERE o.CustomerID IS NULL;

SELECT e.LastName, e.FirstName
FROM employees e LEFT JOIN orders o
    ON e.EmployeeID = o.EmployeeID
WHERE o.EmployeeID IS NULL;

SELECT DISTINCT EmployeeID FROM orders ORDER BY 1; -- 9
SELECT COUNT(*) FROM employees; -- 9

INSERT INTO employees (LastName, FirstName, BirthDate, Photo, Notes)
VALUE ('손', '흥민', '2000-01-01', '사진1', '축구선수');