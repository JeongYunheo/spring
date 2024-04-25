USE w3schools;

# UNIQUE : 다른 레코드의 컬럼값이 중복되지 않음
# key - primary key(pri) = not null unique
CREATE TABLE my_table15
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) UNIQUE
);

INSERT INTO my_table15(col1, col2)
VALUES ('abc', 'def');
INSERT INTO my_table15(col1, col2)
VALUES ('qwe', 'qwe');
INSERT INTO my_table15(col1, col2)
VALUES ('abc', 'abc');
INSERT INTO my_table15(col1, col2)
VALUES ('def', 'def');
INSERT INTO my_table15(col1)
VALUES ('qwe');
INSERT INTO my_table15(col1)
VALUES ('asd');

DESC my_table15;

SELECT *
FROM my_table15;

# my_table16
# 제약사항 없이 UNIQUE, NOT NULL UNIQUE
CREATE TABLE my_table16
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) UNIQUE,
    col3 VARCHAR(3) NOT NULL UNIQUE
);
DESC my_table16;

INSERT INTO my_table16(col1, col2, col3)
VALUES ('qwe', 'qwe', 'qwe');
INSERT INTO my_table16(col1, col2, col3)
VALUES ('qwe', 'qwe', 'qwe');
INSERT INTO my_table16(col1, col2, col3)
VALUES ('qwe', 'asd', 'asd');
INSERT INTO my_table16(col1, col3)
VALUES ('qwe', 'zxc');

SELECT *
FROM my_table16;