-- SELECT : 데이터 조회(읽기, 검색, 가져오기)
SELECT * FROM w3schools.customers;
SELECT * FROM w3schools.employees;
SELECT * FROM w3schools.products;

SELECT * FROM customers;
SELECT * FROM employees;
SELECT * FROM products;
SELECT * FROM categories;
SELECT * FROM orderdetails;
SELECT * FROM orders;
SELECT * FROM shippers;
SELECT * FROM suppliers;

--
SELECT CustomerName -- column 명 나열
FROM customers -- table 명 나열
;

SELECT CustomerID, CustomerName
FROM customers;

SELECT CustomerID, CustomerName, Country
FROM customers;
SELECT CustomerName, CustomerID, Country
FROM customers;

SELECT * -- 전체 컬럼
FROM customers;

-- 예1) 직원(employees)의 lastName, firstName, birthDate 조회
SELECT LastName, FirstName, BirthDate FROM employees;
-- 예2) 상품(products)의 이름, 단위, 가격 조회
SELECT ProductName, Unit, Price FROM products;
-- 예3) 공급자(suppliers)의 이름, 주소, 국가 조회
SELECT SupplierName, Address, Country FROM suppliers;


-- 고객테이블의 국가 컬럼 조회
SELECT Country FROM customers; -- 91개 row
-- DISTINCT 중복 제거
SELECT DISTINCT Country FROM customers; -- 21개 row

SELECT City, Country FROM customers; -- 91개 row
SELECT DISTINCT City, Country FROM customers; -- 69개 row
SELECT DISTINCT Country, City FROM customers; -- 69개 row

-- COUNT : 행(row, record)의 수
SELECT COUNT(Country) FROM customers; -- 91
SELECT COUNT(DISTINCT Country) FROM customers; -- 21

-- 전체 행의 수
SELECT COUNT(*) FROM customers;
SELECT COUNT(*) FROM employees;

-- 예) 공급자들이 있는 나라 수
SELECT COUNT(DISTINCT Country) FROM suppliers;
-- 예) 주문 건 수
SELECT COUNT(*) FROM orders;
-- 예) 몇 개의 카테고리가 있는 지 조회
SELECT COUNT(*) FROM categories;
-- 예) 고객이 있는 도시의 수
SELECT COUNT(DISTINCT City) FROM customers;