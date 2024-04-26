USE w3schools;

SELECT *
FROM Products
WHERE ProductID = 1;

# 1번 상품의 카테고리명 조회
SELECT *
FROM Products p
         JOIN Categories c ON p.ProductID = c.CategoryID
WHERE p.ProductID = 1;

# 10번 상품의 이름, 공급자 이름, 공급자의 국가 조회
# Products Suppliers JOIN
SELECT ProductName, SupplierName, Country
FROM Products p
         JOIN Suppliers s ON s.SupplierID = p.SupplierID
WHERE ProductID = 10;

# 10249번 주문(Orders) 을 한 고객의 이름(Customers) 조회
SELECT CustomerName
FROM Orders o
         JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE OrderID = 10249;

# 10249 주문을 처리한 직원의 이름 조회
SELECT e.FirstName, e.LastName
FROM Orders o
         JOIN Employees e ON e.EmployeeID = o.EmployeeID
WHERE OrderID = 10249;

# 10249 주문을 배달한 Shipper의 이름
SELECT ShipperName
FROM Orders o
         JOIN Shippers s ON o.ShipperID = s.ShipperID
WHERE OrderID = 10249;

# 90번 고객의 이름과 주문한 날짜들을 오름차순으로 조회
SELECT c.CustomerName, o.OrderDate
FROM Orders o
         JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE c.CustomerID = 90
ORDER BY o.OrderDate;

# 3번 직원이 주문을 처리한 날짜들을 오름차순 조회(직원이름, 날짜)
SELECT e.LastName, e.FirstName, o.OrderDate
FROM Orders o
         JOIN Employees e ON e.EmployeeID = o.EmployeeID
WHERE e.EmployeeID = 3
ORDER BY o.OrderDate;