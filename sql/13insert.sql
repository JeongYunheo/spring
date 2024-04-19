USE w3schools;

# INSERT INTO 테이블명 (컬럼명)
# VALUES (데이터들..)

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;

INSERT INTO Employees (LastName)
VALUES ('ironman');

# null : 값이 없음
INSERT INTO Employees(FirstName)
VALUES ('tony');

INSERT INTO Employees (LastName, FirstName, BirthDate, Photo, Notes)
VALUES ('captin', 'steve', '1990-01-01', 'pic1', 'america');

INSERT INTO Employees (FirstName, LastName)
VALUES ('natasha', 'widow');

# 새 고객을 2개 입력하세요
SELECT *
FROM Customers
ORDER BY CustomerID DESC;

INSERT INTO Customers (CustomerName)
VALUES ('woodz');


INSERT INTO Customers(CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('Kangin', 'lee', 'korea', 'seoul', '12345', 'korea');

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;