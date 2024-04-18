USE w3schools;

# ORDER BY: 조회 순서 결정
# ORDER BY 컬럼명
SELECT *
FROM Products
ORDER BY ProductID;

# ASC : 오름차순
SELECT *
FROM Products
ORDER BY Price ASC;

# DESC : 내림차순
SELECT *
FROM Products
ORDER BY Price DESC;

# 여러 컬럼 기준
SELECT *
FROM Products
ORDER BY CategoryID, Price, ProductName;

SELECT *
FROM Products
ORDER BY CategoryID ASC, Price DESC;
SELECT *
FROM Products
ORDER BY CategoryID, Price DESC;

# 컬럼명 대신 index
SELECT *
FROM Products
ORDER BY 4, 6;

# SELECT 에 명시한 컬럼명의 순서를 따라야함
SELECT ProductName, CategoryID, Price, Unit
FROM Products
ORDER BY 2, 3;
-- ORDER BY CategoryID , Price

# todo : 나이가 많은 직원부터 나이가 적은 직원순으로 직원 조회
# todo : 국가명, 도시명 순으로 고객 조회
# todo : 도시명 순으로 공급자 조회
# todo : First Name의 역순으로 직원 조회
SELECT *
FROM Employees
ORDER BY BirthDate;
SELECT *
FROM Employees
ORDER BY 4;

SELECT *
FROM Customers
ORDER BY Country, City;
SELECT *
FROM Customers
ORDER BY 7, 5;

SELECT *
FROM Suppliers
ORDER BY City;
SELECT *
FROM Suppliers
ORDER BY 5;

SELECT *
FROM Employees
ORDER BY FirstName DESC;
