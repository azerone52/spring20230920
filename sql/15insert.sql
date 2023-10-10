# INSERT INTO tableName (columName1, columName2)
# VALUES (value1, value2, ...)

INSERT INTO employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (10, '손', '흥민', '2000-01-01', '사진10', 'eql 득점왕');

SELECT * FROM employees ORDER BY EmployeeID DESC;

INSERT INTO employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (11, '이', '강인', '2000-02-02', '사진11', '드리블 잘함');

-- 모든 컬럼에 값을 넣을 때는 컬럼명 나열 생략 가능
INSERT INTO  employees
VALUE (12, '김', '민재', '2000-03-03', '사진12', '수비 잘함');

-- 특정 컬럼에만 값을 넣을 때 컬럼명 나열 생략하면 안됨
INSERT INTO employees (EmployeeID, LastName, FirstName)
VALUE (13,'박','지성'); -- 나열된 컬럼명과 값의 순서, 개수가 같아야 함

INSERT INTO employees (EmployeeID, FirstName, LastName)
VALUE (14, '차', '범금');

-- 값의 타입에 따라 넣는 방법이 다름
INSERT INTO employees (EmployeeID)
VALUE (15); -- 권장

INSERT INTO employees (EmployeeID)
VALUE ('16'); -- 되긴 됨

INSERT INTO employees (LastName)
VALUE ('son');

INSERT INTO employees (LastName)
VALUE ('10000');

INSERT INTO employees (LastName)
VALUE (10000); -- 되긴 됨

INSERT INTO employees (BirthDate)
VALUE ('2000-01-01');

SELECT * FROM employees ORDER BY EmployeeID DESC;

SELECT * FROM products;

INSERT INTO products (price)
VALUE (20.10);

INSERT INTO products (price)
    VALUE ('30.33'); -- 되긴 됨

INSERT INTO products (Price)
VALUE ('thirteen'); -- 안됨

-- 예) 80번 상품 입력(productId, productName, supplierId, unit, price)
INSERT INTO products VALUE (80, 'cookie', 20, 2, '1box', 15.00);
-- 예) 새 상품 입력( productName, supplierId, unit, price)
INSERT INTO products (ProductName, SupplierID, CategoryID, Unit, Price)
VALUE ('김치', 2, 2, '1포기', 50.55);

SELECT * FROM suppliers;