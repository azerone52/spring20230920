USE w3schools;

SELECT *
FROM employees e1 JOIN employees e2;

SELECT e1.LastName, e1.BirthDate, e2.LastName, e2.BirthDate
FROM employees e1 JOIN employees e2
WHERE e1.BirthDate < e2.BirthDate AND e2.LastName='Leverling';

-- 예) 'Ipoh Coffee' 보다 비싼 상품명 조회
SELECT p1.ProductName
FROM products p1 JOIN products p2
WHERE p2.ProductName='Ipoh Coffee'
    AND p1.Price > p2.Price;

-- 서브 쿼리
SELECT ProductName
FROM products
WHERE price > (SELECT price FROM products WHERE ProductName = 'Ipoh Coffee');

SELECT BirthDate FROM employees
WHERE LastName = 'Leverling';

SELECT LastName, FirstName, BirthDate FROM employees
WHERE BirthDate < (SELECT BirthDate FROM employees
                   WHERE LastName = 'Leverling');

