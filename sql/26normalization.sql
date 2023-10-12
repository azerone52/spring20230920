-- 정규화 NORMALIZATION

-- 첫번째 정규화 (FIRST NORMAL FORM) 1NF
-- : 원자적 데이터를 가진 테이블, PK 컬럼 있어야 함

-- 책(369p)
-- 두번째 정규화 (SECOND NORMAL FORM) 2NF
-- : 1NF이고, 부분적 함수 의존이 없어야 함

-- 부분적 함수 의존(partial functional dependency)
-- 키가 아닌 컬럼의 값이 키 컬럼 일부에 종속 되지 않아야 한다.
-- 키의 일부가 변경 되면 키가 아닌 컬럼이 변경 되어야 하면 부분적 함수 의존.

-- 책(374p)
-- 세번째 정규화 (THIRD NORMAL FORM) 3NF
-- : 2NF이고, 이행적 종속이 없어야 함

-- 이행적 종속 (transitive dependency)
-- 키가 아닌 컬럼이 키가 아닌 다른 컬럼에 의존
-- 키가 아닌 컬럼이 변경 되면 다른 키가 아닌 컬럼이 변경 되어야 할 때

USE mydb1;
-- 입사지원자
-- id, 이름, 학교, 학교주소
CREATE TABLE my_table30_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school VARCHAR(10),
    school_address VARCHAR(10)
);
INSERT INTO my_table30_person (name, school, school_address)
VALUES ('흥민', '서울대', '관악'),
       ('강인', '고려대', '안암'),
       ('민재', '연세대', '신촌'),
       ('지성', '고려대', '안암'),
       ('범근', '연세대', '신촌');
SELECT * FROM my_table30_person;

CREATE TABLE my_table31_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school VARCHAR(10)
);
CREATE TABLE my_table31_school (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    address VARCHAR(10)
);
INSERT INTO my_table31_person (name, school)
VALUES ('흥민', '서울대'),
       ('강인', '고려대'),
       ('민재', '연세대'),
       ('지성', '고려대'),
       ('범근', '연세대');
INSERT INTO my_table31_school (name, address)
VALUES ('서울대', '관악'),
       ('고려대', '안암'),
       ('연세대', '신촌');
SELECT * FROM my_table31_person;
SELECT * FROM my_table31_school;
-- 한 테이블의 어떤 컬럼이 다른 테이블을 참조하면 다른 테이블의 pk를 사용해야 함
CREATE TABLE my_table32_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school_id INT
);
CREATE TABLE my_table32_school (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    address VARCHAR(10)
);
INSERT INTO my_table32_person (name, school_id)
VALUES ('흥민', 1),
       ('강인', 2),
       ('민재', 1);
INSERT INTO my_table32_school (name, address)
VALUES ('서울대', '관악'),
       ('연세대', '신촌'),
       ('고려대', '안암');

INSERT INTO my_table32_person (name, school_id)
VALUES ('지성', 4); -- 안 되어야 하는데 됨
SELECT * FROM my_table32_person;
SELECT * FROM my_table32_school;

CREATE TABLE my_table33_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    -- my_table33_school의 id(pk) 컬럼을 참조해서 있는 것만
    -- 외래키(foreign key) 제약 사항
    school_id INT REFERENCES my_table33_school(id)
);
CREATE TABLE my_table33_school (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    address VARCHAR(10)
);
INSERT INTO my_table33_person (name, school_id)
VALUES ('흥민', 1),
       ('강인', 2),
       ('민재', 1);
INSERT INTO my_table33_school (name, address)
VALUES ('서울대', '관악'),
       ('연세대', '신촌'),
       ('고려대', '안암');
INSERT INTO my_table33_person (name, school_id)
VALUES ('지성', 4); -- 안 되어야 함

-- 다른 테이블에서 이미 참조 중인 레코드이기 때문에 지울 수 없음
DELETE FROM my_table33_school WHERE id = 1;

SELECT * FROM my_table33_person;
SELECT * FROM my_table33_school;

-- 외래키, 참조키, FK