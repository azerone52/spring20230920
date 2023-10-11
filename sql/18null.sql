SELECT * FROM customers ORDER BY 1 DESC;
INSERT INTO customers (CustomerName)
VALUE ('흥민');
INSERT INTO customers (CustomerName, ContactName)
VALUE ('강인', '');
INSERT INTO customers (CustomerName, ContactName)
VALUE ('민재', null); -- null을 넣고 싶으면 null 키워드 사용

SELECT ProductID, ProductName, Price FROM products ORDER BY 1 DESC;
INSERT INTO products (ProductName, Price)
VALUE ('피자', 0.00);
INSERT INTO products (ProductName, Price)
VALUE ('햄버거', null);

-- NULL : 값이 없음
SELECT * FROM products
WHERE Price = 0.00
ORDER BY 1 DESC; -- null 서치 안됨
SELECT * FROM products
WHERE Price != 0.00
ORDER BY 1 DESC; -- null 서치 안됨
-- 비교연산 시 피연산자가 NULL이면 결과는 항상 false

SELECT * FROM products
WHERE Price IS NULL; -- IS NULL : 컬럼의 값이 null인지 확인
SELECT * FROM products
WHERE NOT Price IS NULL;
SELECT * FROM products
WHERE Price IS NOT NULL;

SELECT ProductName, Price*100
FROM products; -- 산술연산 시 null이 피연산자면 결과 null

SELECT ProductName, Price
FROM products
ORDER BY ProductID DESC;

-- null인 값을 조회할 때 null인 값을 다른 값으로 대체하기: IFNULL이라는 함수
SELECT ProductName, IFNULL(price, 0.00)
FROM products
ORDER BY ProductID DESC;

SELECT * FROM customers WHERE ContactName IS NULL;
SELECT * FROM customers WHERE Address IS NULL;
SELECT CustomerName, IFNULL(Country, '없음') FROM customers;