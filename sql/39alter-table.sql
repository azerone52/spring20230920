USE w3schools;

-- ALTER TABLE : 테이블 수정

-- 컬럼 추가, 변경, 삭제

-- 제약 사항 변경
-- NOT NULL, UNIQUE, PRIMARY KEY, DEFAULT, FOREIGN KEY


-- 컬럼 추가
ALTER TABLE products
    ADD COLUMN col1 INT;
ALTER TABLE products
    ADD COLUMN col2 VARCHAR(10);
-- 특정 컬럼 후에 추가
ALTER TABLE products
    ADD COLUMN col3 VARCHAR(10) AFTER ProductName;
-- 컬럼 순서 지정 해서 추가: 기존 컨트롤러 등이 어그러질 수 있으므로 주의해서 사용
ALTER TABLE products ADD COLUMN col4 VARCHAR(10) FIRST;
-- 제약 사항을 추가하여 컬럼 추가
ALTER TABLE products
ADD COLUMN col5 INT NOT NULL DEFAULT 1 REFERENCES  employees(EmployeeID);

DESC products;

-- 예) 직원 테이블에 SALARY 컬럼 마지막에 추가
-- DATA TYPE : DEC(10,2), NULL 허용 안함, DEFAULT는 0.00
ALTER TABLE employees
ADD COLUMN salary DEC(10,2) NOT NULL DEFAULT 0.00;

DESC employees;

-- 컬럼 삭제
ALTER TABLE products
DROP COLUMN col1;

-- 예) products 테이블에서 col2 컬럼 삭제
ALTER TABLE products
    DROP COLUMN col2;
DESC products;

-- 컬럼 변경 (type)
-- 이미 값이 있고 그것이 데이터 타입에 맞지 않으면 안됨
-- VARCHAR 등 수를 늘리는 건 되지만 줄이는 건 안됨
ALTER TABLE products
    MODIFY COLUMN col3 INT;

INSERT INTO products (col4)
    VALUE ('pizza');
SELECT * FROM products ORDER BY productID DESC;

ALTER TABLE products
    MODIFY COLUMN col4 INT; -- x

ALTER TABLE products
    MODIFY COLUMN col4 VARCHAR(20);

ALTER TABLE products
    MODIFY COLUMN col4 VARCHAR(10);

ALTER TABLE products
    MODIFY COLUMN col4 VARCHAR(3); -- x(pizza 보다 작은 수)

-- 제약 사항 변경
