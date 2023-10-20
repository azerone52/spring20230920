USE w3schools;

CREATE TABLE bank (
    name VARCHAR(10) PRIMARY KEY ,
    money INT NOT NULL DEFAULT 0
);

INSERT INTO bank (name, money)
VALUES ('son', 10000),
       ('kim', 10000);

-- transaction을 수동(manual)로 뒀기 때문에 1000원 출금 업무를 실행시켜도
-- 다른 연결에서 보면 실행 결과를 반영하지 않는다

-- 반영 시키려면 ROLLBACK(되돌리기), COMMIT(반영하기)

-- 송금 업무 son -> kim 1000 원 송금
UPDATE bank
SET money = money - 1000
WHERE name = 'son';

UPDATE bank
SET money = money + 1000
WHERE name = 'kim';

UPDATE bank
SET money=10000
WHERE name > '';

ROLLBACK ;
COMMIT ;

SELECT * FROM bank;