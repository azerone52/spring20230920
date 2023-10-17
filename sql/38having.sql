-- HAVING : 그룹 함수 연산 결과를 조건으로 줄 수 있는 키워드

-- 10만달러 이상 소비한 고객
SELECT *
FROM (SELECT CustomerName 고객명, IFNULL(SUM(Price*Quantity),0) `총 주문 금액`
      FROM customers LEFT JOIN orders ON orders.CustomerID = customers.CustomerID
                     LEFT JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
                     LEFT JOIN products ON products.ProductID= orderdetails.ProductID
      GROUP BY customers.CustomerID) t1
WHERE t1.`총 주문 금액` >= 100000;

-- HAVING
SELECT CustomerName 고객명, IFNULL(SUM(Price*Quantity),0) `총 주문 금액`
FROM customers LEFT JOIN orders ON orders.CustomerID = customers.CustomerID
               LEFT JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
               LEFT JOIN products ON products.ProductID= orderdetails.ProductID
GROUP BY customers.CustomerID
HAVING `총 주문 금액` >= 100000
ORDER BY `총 주문 금액` DESC;

-- 예) 총 처리 금액이 10만 달러 미만인 직원 조회(orders, orderDetails, products, employees)
SELECT CONCAT(FirstName, ' ', LastName) 직원명, SUM(Price*Quantity) `총 처리 금액`
FROM employees JOIN orders ON orders.EmployeeID = employees.EmployeeID
                JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
                JOIN products ON products.ProductID = orderdetails.ProductID
GROUP BY employees.EmployeeID
HAVING `총 처리 금액` < 100000;
