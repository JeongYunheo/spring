USE w3schools;

# GROUP BY : 집계함수(avg, sum, min, max)를 그룹별로 결과 내게 함
SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID;

SELECT CategoryID,
       (SELECT c.CategoryName
        FROM Categories c
        WHERE c.CategoryID = p.CategoryID),
       COUNT(ProductID)
FROM Products p
GROUP BY CategoryID;

SELECT c.CategoryID       번호,
       c.CategoryName     이름,
       COUNT(p.ProductID) 상품수
FROM Categories c
         JOIN Products p
              ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID;

SELECT e.EmployeeID,
       e.LastName,
       e.FirstName,
       SUM(od.Quantity * p.Price) 총매출액
FROM Orders o
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON od.ProductID = p.ProductID
         JOIN Employees e
              ON o.EmployeeID = e.EmployeeID
WHERE OrderDate BETWEEN '1997-01-01' AND '1997-01-31'
GROUP BY e.EmployeeID
ORDER BY 총매출액 DESC;

# 1997년 7월 기준으로 고객별 소비금액이 높은 순서대로 조회
SELECT c.CustomerID,
       c.CustomerName,
       SUM(od.Quantity * p.Price) 소비금액
FROM Customers c
         JOIN Orders o
              ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON p.ProductID = od.ProductID
WHERE o.OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY c.CustomerID
ORDER BY 소비금액 DESC
LIMIT 5;

SELECT Country,
       City,
       COUNT(CustomerID)
FROM Customers
GROUP BY Country, City;

# 고객별, 상품별, 주문량
SELECT c.CustomerID  고객번호,
       c.CustomerName,
       p.ProductID,
       p.ProductName,
       SUM(Quantity) 주문수
FROM OrderDetails od
         JOIN Orders o
              ON o.OrderID = od.OrderID
         JOIN Customers c
              ON o.CustomerID = c.CustomerID
         JOIN Products p
              ON p.ProductID = od.ProductID
GROUP BY c.CustomerID, p.ProductID
ORDER BY 고객번호, 주문수 DESC;

# 국가별, 상품별 판매 갯수 조회(국가-오름차순, 상품판매수-내림차순 정렬)
SELECT c.Country,
       ProductName,
       SUM(Quantity) 상품판매수
FROM Products p
         JOIN OrderDetails od
              ON p.ProductID = od.ProductID
         JOIN Orders o
              ON o.OrderID = od.OrderID
         JOIN Customers c
              ON c.CustomerID = o.CustomerID
GROUP BY c.Country, p.ProductID
ORDER BY c.Country, 상품판매수 DESC;

# 상품별, 국가별 판매 갯수 조회(국가-오름차순, 상품판매수-내림차순 정렬)
SELECT ProductName,
       c.Country,
       SUM(Quantity) 상품판매수
FROM Products p
         JOIN OrderDetails od
              ON p.ProductID = od.ProductID
         JOIN Orders o
              ON o.OrderID = od.OrderID
         JOIN Customers c
              ON c.CustomerID = o.CustomerID
GROUP BY p.ProductID, c.Country
ORDER BY p.ProductID, 상품판매수 DESC;

