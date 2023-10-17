-- 제약 사항 변경

USE mydb1;
CREATE TABLE my_table46 (
    col1 INT,
    col2 INT,
    col3 INT,
    col4 INT,
    col5 INT
);

-- NOT NULL 제약 사항 추가
ALTER TABLE my_table46
MODIFY col1 INT NOT NULL;

DESC my_table46;

-- NOT NULL 제약사항 삭제
ALTER TABLE my_table46
MODIFY col1 INT NULL;

-- 예) col2에 not null 제약 사항 추가
ALTER TABLE my_table46
MODIFY COLUMN col2 INT NOT NULL;

-- 예) col2에 not null 제약 사항 추가
ALTER TABLE my_table46
MODIFY COLUMN col2 INT NULL;

-- DEFAULT 제약사항 추가
ALTER TABLE my_table46
ALTER col3 SET DEFAULT 100;

-- DEFAULT 제약 사항 삭제
ALTER TABLE my_table46
ALTER col3 DROP DEFAULT;

-- 예) col4에 기본 값 0 제약 사항 추가
ALTER TABLE my_table46
ALTER col4 SET DEFAULT 0;
-- 예) col4의 기본 값 제약 사항 삭제
ALTER TABLE my_table46
ALTER col4 DROP DEFAULT;

-- UNIQUE 제약 사항 추가
ALTER TABLE my_table46
ADD UNIQUE (col5);

-- UNIQUE 제약 사항 삭제
SHOW CREATE TABLE my_table46; -- 제약 사항 확인
ALTER TABLE my_table46
DROP INDEX col5;

-- PRIMARY KEY 제약 사항 추가
ALTER TABLE my_table46
ADD PRIMARY KEY (col1);

-- PRIMARY KEY 제약 사항 삭제
SHOW CREATE TABLE my_table46;
CREATE TABLE `my_table46` (
                              `col1` int(11) NOT NULL,
                              `col2` int(11) DEFAULT NULL,
                              `col3` int(11),
                              `col4` int(11),
                              `col5` int(11) DEFAULT NULL,
                              PRIMARY KEY (`col1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE my_table46
DROP PRIMARY KEY; -- KEY의 PRI 제거
ALTER TABLE my_table46
MODIFY col1 INT NULL; -- NULL 허용

CREATE TABLE my_talble47 (
    id INT AUTO_INCREMENT primary key,
    name VARCHAR(10)
);

-- FOREIGN KEY 제약 사항 추가
ALTER TABLE my_table46
ADD FOREIGN KEY (col5) REFERENCES my_talble47(id);

-- FOREIGN KEY 제약 사항 삭제
SHOW CREATE TABLE my_table46;
ALTER TABLE my_table46
DROP FOREIGN KEY my_table46_ibfk_1;
ALTER TABLE my_table46
DROP INDEX col5; -- UNIQUE 속성을 삭제하는 것이 아니라 INDEX 속성을 삭제하는 것

DESC my_table46;