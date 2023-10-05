SELECT CustomerName, City, Country FROM customers WHERE City = 'Madrid' AND Country = 'spain';
SELECT CustomerName, City, Country FROM customers WHERE City != 'Madrid' AND Country != 'spain';

SELECT CustomerName, City, Country FROM customers WHERE NOT (City = 'Madrid' AND Country = 'spain');
SELECT CustomerName, City, Country FROM customers WHERE City != 'Madrid' OR Country != 'spain';

-- 예) 스웨덴이나 이탈리아에 있는 공급자들 조회
SELECT SupplierName, Country FROM suppliers WHERE Country='Sweden' OR Country = 'Italy';
-- 예) 1963년 8월 생 직원 조회
SELECT FirstName, LastName, BirthDate FROM employees WHERE BirthDate >= '1963-08-01' AND BirthDate <= '1963-08-31';
-- 예) 가격이 100.00~200.00(포함) 사이인 상품 조회
SELECT ProductName, Price FROM products WHERE Price >= 100.00 AND Price <= 200.00;
-- 예) 1997년에 주문한 주문 조회
SELECT OrderID ,OrderDate FROM orders WHERE OrderDate >= '1997-01-01' AND OrderDate <= '1997-12-31';

-- 여러 연산자 조합시 () 사용해서 우선 순위 결정해 줄 것

-- 예) 1번 카테고리인 상품 중 10달러 미만, 100달러 이상
SELECT * FROM products
WHERE (Price < 10 OR Price >=100) AND (CategoryID = 1);

