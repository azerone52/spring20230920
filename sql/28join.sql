USE w3schools;

SELECT * FROM products;
SELECT * FROM categories;

-- chais 상품의 카테고리 명은?
SELECT CategoryID FROM products
WHERE ProductName = 'chais';
SELECT CategoryName FROM categories
WHERE CategoryID = 1;

-- JOIN : 두개의 테이블 결합
SELECT *
FROM categories, products;
SELECT *
FROM categories JOIN products; -- 616행

SELECT COUNT(*)
FROM categories; -- 8
SELECT COUNT(*)
FROM products; -- 77
-- 8*77=616

CREATE TABLE table_a (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(20),
    category_id INT -- 레퍼런스 생략
);
CREATE TABLE table_b (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(20)
);

INSERT INTO table_b (category_name)
VALUES ('음료수'), ('반찬');
INSERT INTO table_a (product_name, category_id)
VALUES ('콜라', 1),
       ('사이다', 1),
       ('제육', 2),
       ('돈까스', 2),
       ('두부', 2);

SELECT *
FROM table_a JOIN table_b;
-- 두 테이블을 결합하면
-- 조회된 레코드 수는 A테이블 row * B테이블 row
-- 컬럼 수는 A테이블 열 + B테이블 열

SELECT *
FROM table_a JOIN table_b
WHERE table_a.product_name = '콜라'
  AND table_b.category_id = table_a.category_id;
-- 컬럼명이 하나만 있을 때 생략 가능(product_name)
-- 같은 컬럼명이 여러 테이블에 있다면 테이블 명 작성

SELECT *
FROM table_a JOIN table_b
WHERE table_a.category_id = table_b.category_id -- join 조건
AND product_name = '콜라';
SELECT * FROM table_a JOIN table_b
    ON table_a.category_id = table_b.category_id -- on으로 join 조건 많이 씀
WHERE product_name = '콜라';

SELECT ProductID, ProductName, CategoryName
FROM products p JOIN categories c
    ON p.CategoryID = c.CategoryID
WHERE ProductName = 'chais';

-- 예) chais 상품의 공급자명, 전화번호
SELECT SupplierName, Phone
FROM suppliers s JOIN products p ON s.SupplierID = p.SupplierID
WHERE ProductName = 'chais';

-- 예) 1996년 7월 4일에 주문한 고객명
SELECT CustomerName
FROM customers c JOIN orders o ON c.CustomerID = o.CustomerID
WHERE OrderDate = '1996-07-04';

-- 예) 1996년 7월 4일에 주문을 담당한 직원명
SELECT CONCAT(FirstName, ' ', LastName) Name
FROM employees JOIN orders
ON employees.EmployeeID = orders.EmployeeID
WHERE OrderDate = '1996-07-08';

SELECT * FROM products;

-- 3개 테이블 조회
SELECT * FROM products, suppliers, categories; -- 77*29*8=17864개의 rows
SELECT *
FROM products p
    JOIN suppliers s ON p.SupplierID = s.SupplierID
    JOIN categories c ON p.CategoryID = c.CategoryID
WHERE p.ProductName = 'chais';

-- 예) 'Chang' 상품의 공급자명, 카테고리명 조회
SELECT SupplierName, CategoryName
FROM products p
    JOIN suppliers s ON p.SupplierID = s.SupplierID
    JOIN categories c on p.CategoryID = c.CategoryID
WHERE ProductName = 'chang';

-- 예) 1996년 7월 9일에 주문한 고객명과 처리한 직원명
SELECT CustomerName, CONCAT(FirstName, ' ', LastName) EmployeeName
FROM orders o
    JOIN customers c ON c.CustomerID = o.CustomerID
    JOIN employees e ON e.EmployeeID = o.EmployeeID
WHERE OrderDate = '1996-07-09';

-- 예) 1996년 7월 9일에 주문한 상품명
SELECT ProductName
FROM orderdetails od JOIN orders o ON o.OrderID = od.OrderID
                     JOIN products p ON p.ProductID = od.ProductID
WHERE OrderDate = '1996-07-09';
-- JOIN 순서 상관 없음

-- 예) 'chang' 상품이 주문된 날들
SELECT ProductName ,OrderDate, CustomerName, CONCAT(FirstName, ' ', LastName) FUllName
FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID
              JOIN products p ON p.ProductID = od.ProductID
              JOIN customers c ON c.CustomerID = o.CustomerID
              JOIN employees e ON e.EmployeeID = o.EmployeeID
WHERE ProductName = 'chang';
