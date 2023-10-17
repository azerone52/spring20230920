USE w3schools;
-- aggregate function (집계함수, 집합함수, 그룹함수)
-- MAX, MIN, COUNT, SUM, AVG

SELECT * FROM products;

-- MAX 최대값
SELECT MAX(price) FROM products;

-- 원하는대로 최댓값을 갖는 제품명과 가격이 안나옴
-- 레코드 productName 컬럼 중 임의로 선택됨
-- 가격은 최댓값
SELECT productName, MAX(price) FROM products;
-- 원하는대로 조회
SELECT * FROM products
WHERE Price = (SELECT MAX(price) FROM products);


-- MIN (최소값)
SELECT MIN(price) FROM products;
SELECT * FROM products
WHERE Price = (SELECT MIN(price) FROM products);

-- 예) 가장 어린 직원명 조회
SELECT * FROM employees WHERE BirthDate=(SELECT MAX(BirthDate) FROM employees);
-- 예) 가장 나이 많은 직원명 조회
SELECT * FROM employees WHERE BirthDate=(SELECT MIN(BirthDate) FROM employees);

-- COUNT: 개수
SELECT * FROM employees;
SELECT COUNT(EmployeeID) FROM employees;
SELECT COUNT(LastName) FROM employees;

-- NULL은 집계함수에서 포함하지 않음
INSERT INTO employees (LastName)
VALUE ('흥민');
SELECT COUNT(LastName) FROM employees; -- 10
SELECT COUNT(FirstName) FROM employees; -- 9\

SELECT MIN(BirthDate) FROM employees; -- 1952-02-19(NULL이 아님)

INSERT INTO products (ProductName)
VALUE ('커피');
SELECT * FROM products ORDER BY 1 DESC;
SELECT MIN(Price) FROM products; -- 2.50
SELECT MIN(IFNULL(Price, 0)) FROM products; -- 0.00
SELECT * FROM products
WHERE IFNULL(Price, 0) = (SELECT MIN(IFNULL(Price, 0)) FROM products);
SELECT * FROM products
WHERE Price IS NULL OR Price = 0;

-- SUM: 합
SELECT * FROM products;
SELECT SUM(Price) FROM products;

SELECT SUM(Quantity) FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID
WHERE OrderDate = '1996-07-04';

-- 예) 96년 7월 4일 매출액 구하기
SELECT SUM(Price*Quantity) FROM products p
                                JOIN orderdetails od ON od.ProductID=p.ProductID
                                JOIN orders o ON o.OrderID=od.OrderID
WHERE OrderDate = '1996-07-04';

-- AVG : 평균
SELECT AVG(Price) FROM products; -- 28.866364
SELECT SUM(Price) FROM products; -- 2222.71
SELECT COUNT(ProductID) FROM products; -- 78
SELECT COUNT(Price) FROM products; -- 77


