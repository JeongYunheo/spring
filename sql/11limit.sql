USE w3schools;

# LIMIT : 조회 결과 수를 제한

SELECT *
FROM Customers
LIMIT 5;

SELECT *
FROM Products
ORDER BY Price DESC
LIMIT 5;

SELECT *
FROM Employees
ORDER BY BirthDate DESC
LIMIT 2;

SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY Price
LIMIT 3;

# 최조로 주문된 주문1개
# 가장 최근에 주문된 주문 5개
# 가장 나이가 많은 직원
# CategoryId가 3인 상품 중 가장 비싼 2개
SELECT *
FROM Orders
ORDER BY OrderDate DESC
LIMIT 1;

SELECT *
FROM Orders
ORDER BY OrderDate DESC
LIMIT 5;

SELECT *
FROM Employees
ORDER BY BirthDate
LIMIT 1;

SELECT *
FROM Products
WHERE CategoryID = 3
ORDER BY Price DESC
LIMIT 2;

# LIMIT OFFSET, 5
# OFFSET 부터 5개
SELECT *
FROM Products
ORDER BY Price
LIMIT 5;

SELECT *
FROM Products
ORDER BY Price
LIMIT 1, 5;

# paging

# 한페이지에 10개씩 조회할 때
# 1페이지: LIMIT 0,10
SELECT CustomerID, CustomerName
FROM Customers
LIMIT 0,10;

# 2페이지 : LIMIT 10,10
SELECT CustomerName, CustomerID
FROM Customers
ORDER BY CustomerID
LIMIT 10,10;

# 3패이지 : LIMIT 20,10
SELECT CustomerID, CustomerName
FROM Customers
ORDER BY Customers.CustomerID
LIMIT 20,10;

# n페이지 : LIMIT (n-1)*한 페이지의 게시물 수, 한 페이지의 게시물 수

