# Normalization : 정규화(정규형)

# First Normal Form : 1NF, 제1 정규화(형)
# 1) 각 행을 유일하게 구분하는 컬럼이 존재한다
#  -> Primary Key(PK) 가 있다
# 2) 모든 데이터는 원자적으로 저장된다
#  -> 같은 형식의 데이터를 저장하는 여러 컬럼이 없다
#  -> 한 컬럼에 여러 값이 저장되지 않는다
CREATE DATABASE mydb1;
USE mydb1;

# Primary Key
# NOT NULL, UNIQUE
# 바뀔 가능성이 현저히 낮아야함
# 가장 좋은 PK는 의미없는 컬럼

# ex) 고객정보들 저장한 테이블
# 이메일,이름,전화번호,주소,주민등록번호
CREATE TABLE customer
(
    id           INT PRIMARY KEY AUTO_INCREMENT, -- 내부 키
    email        VARCHAR(300),                   -- 후보 키
    name         VARCHAR(100),
    phone_number VARCHAR(100),
    address      VARCHAR(200),
    ssn          VARCHAR(13)                     -- 후보 키 Candidate Key
);

DROP TABLE customer;

INSERT INTO customer
    (email, name, phone_number, address, ssn)
VALUES ('', '', '', '', '');
INSERT INTO customer
    (email, name, phone_number, address, ssn)
VALUES ('', '', '', '', '');
INSERT INTO customer
    (email, name, phone_number, address, ssn)
VALUES ('', '', '', '', '');
SELECT *
FROM customer;

CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3)
);

CREATE TABLE phone_number
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    customer_id  INT,
    phone_number VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

DROP TABLE customer;
DROP TABLE phone_number;


# FOREIGN KEY: 외래키 제약사항
INSERT INTO customer
    (first_name, last_name)
VALUES ('son', 'hm'),
       ('lee', 'ki');
SELECT *
FROM customer; -- 부모테이블


INSERT INTO phone_number
    (customer_id, phone_number)
VALUES (1, '1234');
INSERT INTO phone_number
    (customer_id, phone_number)
VALUES (1, '4321');
INSERT INTO phone_number
    (customer_id, phone_number)
VALUES (2, '4321');
INSERT INTO phone_number
    (customer_id, phone_number)
VALUES (3, '7890');
SELECT *
FROM phone_number;
-- 1:n/일대다 관계


# Second Normal Form : 2NF, 제2 정규화(형)


# Third Normal Form : 3NF, 제3 정규화(형)
