SELECT * FROM employees;

SELECT *
FROM employees
ORDER BY BirthDate;

SELECT *
FROM employees
ORDER BY 4; -- 컬럼의 순서

SELECT EmployeeID,LastName,BirthDate
FROM employees
ORDER BY BirthDate;

SELECT EmployeeID,LastName,BirthDate
FROM employees
ORDER BY 3;

SELECT * FROM products;

SELECT * FROM products
ORDER BY CategoryID;

SELECT * FROM products
ORDER BY CategoryID, price;

SELECT * FROM products
ORDER BY CategoryID ASC; -- 오름차순(생략가능)

SELECT * FROM products
ORDER BY CategoryID DESC; -- 내림차순

SELECT * FROM products
ORDER BY CategoryID DESC, Price;

SELECT * FROM products
ORDER BY CategoryID DESC, Price DESC;

-- 예) 고객을 국가명 오름차순으로 조회
SELECT CustomerName, Country FROM customers ORDER BY Country;
-- 예) 가격이 비싼 상품이 먼저 조회 되도록 코드 작성
SELECT ProductName, Price FROM products ORDER BY Price DESC;
-- 예) 가장 어린 직원 먼저 조회 되도록
SELECT FirstName, LastName, BirthDate FROM employees ORDER BY BirthDate DESC;

select COUNT(*) from suppliers;