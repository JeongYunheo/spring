USE w3schools;

# SELECT 컬럼명
# FROM 테이블명
# WHERE 솎아낼 레코드 조건
SELECT CustomerName, City, Country
FROM Customers
WHERE City = 'Berlin';

SELECT CustomerName, City, Country
FROM Customers
WHERE Country = 'Germany';

# 컬럼명 비교연산자 값
# 값에 '' 로 감싸기 (but, 수 형식은 생략 가능)
SELECT *
FROM Customers
WHERE CustomerID = '1';
SELECT *
FROM Customers
WHERE CustomerID = 1;
# 권장

# 비교연산자 : 같다=, 작다<, 작거나 같다<=, 크다 >, 크거나 같다>=
#            같지 않다 != , <>
SELECT *
FROM Customers
WHERE CustomerID = 3;
SELECT *
FROM Customers
WHERE CustomerID < 3;
SELECT *
FROM Customers
WHERE CustomerID > 89;
SELECT *
FROM Customers
WHERE CustomerID <= 3;
SELECT *
FROM Customers
WHERE CustomerID >= 89;
SELECT *
FROM Customers
WHERE CustomerID != 1;
SELECT *
FROM Customers
WHERE CustomerID <> 1;

# 문자열 형식(대소문자 구분 없음)
SELECT *
FROM Customers
WHERE CustomerName >= 'S';
SELECT *
FROM Customers
WHERE CustomerName >= 's';
SELECT *
FROM Customers
WHERE Country = 'Germany';
SELECT *
FROM Customers
WHERE Country = 'GeRmAnY';

# 날짜 형식
SELECT *
FROM Employees
WHERE BirthDate = '1968-12-08';
SELECT *
FROM Employees
WHERE BirthDate > '1955-01-01';

# 미국에 있는 공급자(Suppliers)
# last name= fuller 직원(Employees) 조회
# CategoryID 3번인 상품(Product) 조회
# 가격이 20.00 이상인 상품(Product) 조회
# 주문일이 1997년 이전인 주문(Order) 조회

SELECT *
FROM Suppliers
WHERE Country = 'usa';

SELECT *
FROM Employees
WHERE LastName = 'fuller';

SELECT *
FROM Products
WHERE CategoryID = 3;

SELECT *
FROM Products
WHERE Price >= 20.00;

SELECT *
FROM Orders
WHERE OrderDate < '1997.01.01';
SELECT *
FROM Orders
WHERE OrderDate <= '1996.12.31';

SELECT *
FROM Customers;