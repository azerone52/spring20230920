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

-- subquery
-- 행 1개 열 1개
SELECT BirthDate FROM employees
WHERE LastName = 'Leverling';

-- 행 여러개 열 1개
SELECT ShipperID FROM orders WHERE OrderDate = '1996-07-08';
SELECT CustomerName FROM customers WHERE Country = 'mexico';

-- 행 여러개 열 여러개
SELECT CustomerID, CustomerName FROM customers WHERE Country = 'mexico';

-- 행 1개 열 1개 예제
-- 예) 'Tofu' 상품을 공급하는 공급자 명
SELECT SupplierName FROM suppliers WHERE SupplierID = (SELECT SupplierID FROM products WHERE ProductName= 'tofu');

-- 여러행 1개열
-- 멕시코 고객이 주문한 일자들 조회
SELECT OrderDate FROM orders
WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'Mexico');

-- 예) 1번 카테고리에 있는 상품이 주문된 주문 번호
SELECT DISTINCT OrderID FROM orderdetails
WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = 1);

SELECT * FROM orderdetails;

-- 예) 1번 카테고리에 있는 상품이 주문된 날짜 (orderDetails, products)
SELECT OrderDate FROM orders
WHERE OrderID IN (SELECT OrderID FROM orderdetails
                  WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = 1));

SELECT DISTINCT od.OrderID
FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID
              JOIN products p ON od.ProductID = p.ProductID
WHERE p.CategoryID = 1;

-- 예) 주문한 적 없는 고객들
SELECT CustomerID FROM orders;
SELECT * FROM customers WHERE CustomerID NOT IN (SELECT CustomerID FROM orders);

-- 행 여러개 열 여러개
SELECT * FROM customers;

SELECT SupplierName, Address, Country FROM suppliers;

INSERT INTO customers (CustomerName, Address, Country)
(SELECT SupplierName, Address, Country FROM suppliers);

INSERT INTO customers (CustomerName, Address, Country)
(SELECT ContactName, City, Phone FROM suppliers);

INSERT INTO customers (CustomerName, Address, Country)
(SELECT ContactName, City, Phone, Country FROM suppliers); -- 안됨

SELECT * FROM customers
WHERE (City, Country) IN (SELECT City, Country FROM suppliers);

CREATE TABLE table_c
SELECT CustomerName, City, Country FROM customers;

SELECT * FROM table_c;
DESC table_c;

-- 예) 1번 카테고리에 있는 상품들로 새 테이블을 만드는데
--     새로운 테이블(table_d)은 productName, categoryName, price
CREATE TABLE table_d
SELECT ProductName, CategoryName, price
FROM products p JOIN categories c ON c.CategoryID = p.CategoryID
WHERE p.CategoryID=1;

SELECT * FROM table_d;

SELECT * FROM categories WHERE CategoryID = 1;