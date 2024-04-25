USE w3schools;

# DEFAULT : 값을 주지 않을 때의 기본값을 정의
CREATE TABLE my_table13
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) DEFAULT 'abc'
);
INSERT INTO my_table13
    (col1, col2)
VALUES ('qwe', 'asd');
INSERT INTO my_table13
    (col2)
VALUES ('iop');
INSERT INTO my_table13
    (col1)
VALUES ('jkl');
INSERT INTO my_table13
    (col1, col2)
VALUES ('dfg', NULL);

SELECT *
FROM my_table13;

DESC my_table13;


# my_table14 4개의 컬럼 정의,
# 제약없이, not null, default, not null default
CREATE TABLE my_table14
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) NOT NULL,
    col3 VARCHAR(10)          DEFAULT 'qwer',
    col4 VARCHAR(10) NOT NULL DEFAULT 'asdf'
);

INSERT INTO my_table14
    (col1, col2, col3, col4)
VALUES ('a', 'b', 'c', 'd');
INSERT INTO my_table14
    (col1)
VALUES ('a');
INSERT INTO my_table14
    (col1, col2)
VALUES ('a', 'b');
INSERT INTO my_table14
    (col2)
VALUES ('b');

SELECT *
FROM my_table14;
