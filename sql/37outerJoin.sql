USE mydb2;

SELECT *
FROM product;

SELECT *
FROM category;

SELECT *
FROM category c
         JOIN product p
              ON c.id = p.category_id;

# 상품이 존재하지 않는 카테고리
SELECT *
FROM category c
         LEFT JOIN product p
                   ON c.id = p.category_id
WHERE p.id IS NULL;

USE w3schools;
# 한번도 주문한 적 없는 고객의 이름을 조회
SELECT c.CustomerName
FROM Orders o
         RIGHT JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE o.OrderID IS NULL;

# 1996년에 주문한적 있는 고객들
SELECT DISTINCT c.CustomerName
FROM Orders o
         JOIN Customers c ON c.CustomerID = o.CustomerID

WHERE o.OrderDate BETWEEN '1996-01-01' AND '1996-12-31'
ORDER BY c.CustomerName;

DELETE
FROM Orders
WHERE OrderDate >= '1997-01-01';

# 1996년에 주문한적 없는 고객들 이름
SELECT c.CustomerName
FROM Orders o
         RIGHT JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL
ORDER BY c.CustomerName;

INSERT INTO Employees
    (LastName, FirstName)
VALUES ('흥민', '손'),
       ('강인', '이');

# 한번도 주문을 처리한적 없는 직원명 조회
SELECT e.LastName, e.FirstName
FROM Orders o
         RIGHT JOIN Employees e ON e.EmployeeID = o.EmployeeID
WHERE o.OrderID IS NULL;

SELECT e.FirstName, e.LastName
FROM Employees e
         LEFT JOIN Orders o ON e.EmployeeID = o.EmployeeID
WHERE o.EmployeeID IS NULL;

