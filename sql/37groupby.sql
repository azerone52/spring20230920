-- GROUP BY : 그룹함수 사용 시 그룹함수의 범위(그룹) 지정

SELECT MAX(Price) FROM products;

-- 그룹으로 묶었기 때문에 여기의 CategoryID는 의미 있음
SELECT CategoryID,MAX(Price)
FROM products
GROUP BY CategoryID;

SELECT CategoryID, MAX(Price), MIN(Price)
FROM products
GROUP BY CategoryID
ORDER BY MAX(Price) DESC;

SELECT OrderDate, SUM(price*Quantity) AS 매출액
FROM products p
            JOIN orderdetails od ON p.ProductID = od.ProductID
            JOIN orders o ON o.OrderID = od.OrderID
GROUP BY o.OrderDate;

-- 예) 직원 별 주문 처리 금액(employees products orders orderDetail)
SELECT CONCAT(FirstName, ' ', LastName) 직원명, SUM(Price*Quantity) 처리액
FROM employees JOIN orders ON orders.EmployeeID = employees.EmployeeID
                JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
                JOIN products ON products.ProductID = orderdetails.ProductID
GROUP BY FirstName, LastName; -- employeeID 이게 더 정확할 듯...

-- 예) 고객별 총 주문 금액 조회
SELECT CustomerName 고객명, IFNULL(SUM(Price*Quantity),0) `총 주문 금액`
FROM customers LEFT JOIN orders ON orders.CustomerID = customers.CustomerID
                LEFT JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
                LEFT JOIN products ON products.ProductID= orderdetails.ProductID
GROUP BY customers.CustomerID; -- 그룹으로 묶을 때 어떤 컬럼을 선택할지 꼭 잘 생각해보기

SELECT CustomerName 고객명, IFNULL(SUM(Price*Quantity),0) `총 주문 금액`
FROM products JOIN orderdetails ON products.ProductID= orderdetails.ProductID
                JOIN orders ON orderdetails.OrderID = orders.OrderID
                RIGHT JOIN customers ON orders.CustomerID = customers.CustomerID
GROUP BY customers.CustomerID;

SELECT * FROM customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM orders);
SELECT * FROM customers;

-- 10만달러 이상 소비한 고객
SELECT *
 FROM (SELECT CustomerName 고객명, IFNULL(SUM(Price*Quantity),0) `총 주문 금액`
FROM customers LEFT JOIN orders ON orders.CustomerID = customers.CustomerID
               LEFT JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
               LEFT JOIN products ON products.ProductID= orderdetails.ProductID
GROUP BY customers.CustomerID) t1
WHERE t1.`총 주문 금액` >= 100000;