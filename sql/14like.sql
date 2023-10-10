SELECT * FROM customers
WHERE CustomerName='Alfreds Futterkiste';

SELECT * FROM customers
WHERE CustomerName LIKE 'A%';

SELECT * FROM customers
WHERE CustomerName LIKE '%A%';

SELECT * FROM customers
WHERE CustomerName LIKE '%the%';

-- LIKE : 검색
-- %, _ 기호(wildcard)와 같이

-- ch로 시작하는
SELECT * FROM customers
WHERE CustomerName LIKE 'ch%'; -- % : 0개 이상의 문자

-- er로 끝나는
SELECT * FROM customers
WHERE CustomerName LIKE '%er'; -- % : 0개 이상의 문자

-- er이 있는
SELECT * FROM customers
WHERE CustomerName LIKE '%er%'; -- % : 0개 이상의 문자

-- 퍼스트네임이 다섯 글자인
SELECT * FROM employees
WHERE FirstName LIKE '_____'; -- _ : 1개의 문자 아무거나

-- 라스트네임의 두번째 글자가 e인
SELECT * FROM employees
WHERE LastName LIKE '_e%';

-- 예) ch로 시작하는 상품명 조회
SELECT * FROM products WHERE ProductName LIKE 'ch%';
-- 예) es로 끝나는 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '%es';
-- 예) 중간에 use가 들어간 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '%use%';

-- 예) 두번째 글자가 u인 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '_u%';

SELECT * FROM employees;