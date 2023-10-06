SELECT Price FROM products WHERE ProductID = 1;
SELECT Price + 1 FROM products WHERE ProductID = 1;
SELECT Price - 10.5 FROM products WHERE ProductID = 1;
SELECT Price * 3 FROM products WHERE ProductID = 1;
SELECT Price / 3 FROM products WHERE ProductID = 1;

SELECT ProductName, Price FROM products;
SELECT ProductName, (Price*2) FROM products;

SELECT ProductName + 1, Price FROM products; -- 문자열 연결 연산은 안됨
SELECT CONCAT(ProductName, 1), Price FROM products; -- 문자열 연결은 concat 사용

-- 1968-12-08
SELECT LastName, BirthDate FROM employees WHERE EmployeeID = 1;
-- 19681209
SELECT LastName, BirthDate+1 FROM employees WHERE EmployeeID = 1;
-- 1968-12-09
SELECT LastName, ADDDATE(BirthDate, INTERVAL 1 DAY) FROM employees WHERE EmployeeID = 1;
-- 날짜 변경 함수 사용

SELECT * FROM employees;
SELECT EmployeeID, CONCAT(LastName, FirstName) FROM employees;
SELECT EmployeeID, CONCAT(LastName, ' ', FirstName) FROM employees;

-- 예) 주문수량(quantity) * 2 결과 조회
SELECT Quantity*2 FROM orderdetails;
-- 예) "city, country" 고객 테이블 조회
SELECT CONCAT(City, ' ', Country) FROM customers;