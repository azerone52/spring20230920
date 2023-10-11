-- DATABASE, SCHEMA : 테이블들이 있는 공간

-- DATABASE 만들기
CREATE DATABASE mydb1;
CREATE SCHEMA mydb2;

SELECT * FROM w3schools.customers;

-- DATABASE 옮기기
USE mydb1;
SELECT * FROM w3schools.products;

-- DATABASE 지우기
DROP DATABASE mydb2;
DROP DATABASE mydb1;

USE w3schools;

CREATE DATABASE mydb1;
