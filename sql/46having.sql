USE w3schools;

# HAVING : 집계함수의 조건절
SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID;

# 상품 수가 10개 이상인 카테고리
SELECT *
FROM (SELECT CategoryID, COUNT(ProductID) 상품수
      FROM Products
      GROUP BY CategoryID) c
WHERE 상품수 >= 10;

SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID
HAVING COUNT(ProductID) >= 10;

# 고객이 5명 이상 있는 국가들을 조회
SELECT Country, COUNT(CustomerID) 고객수
FROM Customers c
GROUP BY Country
HAVING 고객수 >= 5;

# 97년 7월 상품 매출(상품가격*갯수)이 10000달러 이상인 직원들을 조회
SELECT LastName,
       FirstName,
       SUM(Quantity * Price) qp
FROM Orders o
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Employees e
              ON e.EmployeeID = o.EmployeeID
         JOIN Products p
              ON p.ProductID = od.ProductID
WHERE o.OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY e.EmployeeID
HAVING qp >= 10000;
