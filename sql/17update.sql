SELECT * FROM products;
SELECT * FROM products WHERE ProductID = 1;

UPDATE products
SET ProductName = '차이즈',
    Unit = '10 박스'
WHERE ProductID = 1;

-- where 꼭 쓸 것!!

-- 예) 1번 고객의 이름 수정하기
SELECT * FROM customers;
UPDATE customers SET CustomerName = 'Ana Trujillo' WHERE CustomerID = 2;
-- 예) 5번 직원의 notes 변경하기
SELECT * FROM employees WHERE EmployeeID = 5;
UPDATE employees SET Notes = '대학 졸업' WHERE EmployeeID = 5;
-- 예) 1번 공금자의 전화번호, 주소 변경하기
SELECT * FROM suppliers WHERE SupplierID=1;
UPDATE suppliers SET Address = '49st', Phone = '171-555-2232' WHERE SupplierID = 1;

-- 원래 가격의 두배로 만들기
SELECT * FROM products WHERE CategoryID=1;
UPDATE products SET Price = Price*2
WHERE CategoryID = 1;

SELECT * FROM employees;