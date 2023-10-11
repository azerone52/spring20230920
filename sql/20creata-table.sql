USE mydb1;

-- 테이블 만들기

# CREATE TABLE 테이블명 (
#     컬럼명 컬럼타입,
#     컬럼명 컬럼타입
# )

-- 테이블명, 컬럼명 작성 관습
-- lower_snake_case (*)
-- UPPER_SNAKE_CASE
-- UpperCamelCase
-- lowerCamelCase

CREATE TABLE my_table1(
    col_name1 varchar(100),
    col_name2 varchar(100),
    col_name3 varchar(100)
);

SELECT * FROM my_table1;
INSERT INTO my_table1
VALUE ('민재', '흥민', '강인');

CREATE TABLE my_table2(
    tb2_name varchar(10),
    tb2_age int,
    tb2_sex char(2),
    tb2_phone varchar(13)
);
desc my_table2;
