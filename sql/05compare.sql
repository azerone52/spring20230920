-- < 작다, > 크다, >= 크거나 같다, <= 작거나 같다

SELECT * FROM products
WHERE Price < 10.00;

SELECT * FROM products
WHERE Price >= 10.00;

SELECT * FROM products
WHERE Price != 10.00; -- sql 마다 될 수도 있고 안될 수도 잇음

SELECT * FROM products WHERE Price <> 10.00; -- 같지 않다

SELECT * FROM customers
WHERE CustomerID < '3';

SELECT * FROM customers WHERE CustomerName < 'D'; -- 사전순으로

SELECT * FROM employees WHERE BirthDate >='1960-01-01';