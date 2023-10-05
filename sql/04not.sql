SELECT * FROM customers;
select * from  customers where Country='Germany';
select  CustomerName, Country from customers where not Country='Germany';

-- 예) 1번 카테고리에 속하지 않는 상품들 조회
select ProductID, ProductName, CategoryID from products where not CategoryID = 1;
-- 예) Japan에 있지 않은 공급자들 조회
select SupplierName, Country from suppliers where not Country='Japan';