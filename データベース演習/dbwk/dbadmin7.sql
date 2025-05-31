--問８：addStudb.sqlを実行してデータベースの構築をしてください。
--※source文を使用してください。

mysql> source addStudb.sql;
--------------
CREATE TABLE REDUCTION(
    CLASS INT,
    RNAME VARCHAR(10) NOT NULL,
    PRIMARY KEY(CLASS)
)
--------------

Query OK, 0 rows affected (0.01 sec)

--------------
CREATE TABLE DELIVERY(
    CLASS INT,
    DNAME VARCHAR(10) NOT NULL,
    PRIMARY KEY(CLASS)
)
--------------

Query OK, 0 rows affected (0.01 sec)

--------------
CREATE TABLE PAYMENT(
    CLASS INT,
    PNAME VARCHAR(10) NOT NULL,
    PRIMARY KEY(CLASS)
)
--------------

Query OK, 0 rows affected (0.01 sec)

--------------
CREATE TABLE CAMPAIGN(
    CAMP_CODE CHAR(4),
    EXP_TEXT VARCHAR(256) NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    COUPON_NAME VARCHAR(50) NOT NULL,
    RED_CLASS INT NOT NULL,
    RED_VALUE INT NOT NULL,
    USE_PERIOD DATE NOT NULL,
    VALID_COUNT INT NOT NULL,
    APPLY_MONEY INT NOT NULL,
    PRIMARY KEY(CAMP_CODE),
    FOREIGN KEY(RED_CLASS) REFERENCES REDUCTION(CLASS)
)
--------------

Query OK, 0 rows affected (0.04 sec)

--------------
CREATE TABLE USER(
    USER_NO INT AUTO_INCREMENT,
    UNAME VARCHAR(20) NOT NULL,
    RUBY VARCHAR(60) NOT NULL,
    MAIL VARCHAR(256) NOT NULL UNIQUE,
    PASSWORD CHAR(255) NOT NULL,
    TEL VARCHAR(10) NOT NULL UNIQUE,
    CARD_NO CHAR(16) UNIQUE,
    PRIMARY KEY(USER_NO)
)
--------------

Query OK, 0 rows affected (0.04 sec)

--------------
CREATE TABLE DELIADDRESS(
    USER_NO INT,
    DELI_NO INT,
    POST_NO INT NOT NULL,
    ADDRESS VARCHAR(100) NOT NULL,
    PRIMARY KEY(USER_NO, DELI_NO),
    FOREIGN KEY(USER_NO) REFERENCES USER(USER_NO)
)
--------------

Query OK, 0 rows affected (0.01 sec)

--------------
CREATE TABLE OWNEDCP(
    USER_NO INT,
    CAMP_CODE CHAR(4),
    COUPON_NAME VARCHAR(50),
    RED_CLASS INT,
    RED_VALUE INT,
    USE_PERIOD DATE,
    REMAIN_COUNT INT,
    PRIMARY KEY(USER_NO, CAMP_CODE),
    FOREIGN KEY(USER_NO) REFERENCES USER(USER_NO),
    FOREIGN KEY(CAMP_CODE) REFERENCES CAMPAIGN(CAMP_CODE),
    FOREIGN KEY(RED_CLASS) REFERENCES REDUCTION(CLASS)
)
--------------

Query OK, 0 rows affected (0.04 sec)

--------------
CREATE TABLE ORDERHEADER(
    ODR_NO INT auto_increment,
    ODR_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    EMP_NO CHAR(5),
    STORE_NO CHAR(3),
    USER_NO INT,
    UNAME VARCHAR(20),
    TEL VARCHAR(10),
    POST_NO INT,
    ADDRESS VARCHAR(100),
    CAMP_CODE CHAR(4),
    COUPON_NAME VARCHAR(50),
    USE_PERIOD DATE,
    DELI_CLASS INT,
    PAY_CLASS INT,
    TAX INT NOT NULL,
    APPLY_CAMP_CODE CHAR(4),
    APPLY_COUPON_NAME VARCHAR(50),
    APPLY_USE_PERIOD DATE,
    APPLY_VALID_COUNT INT,
    PRIMARY KEY(ODR_NO),
    FOREIGN KEY(EMP_NO) REFERENCES EMPLOYEE(EMP_NO),
    FOREIGN KEY(STORE_NO) REFERENCES STORE(STORE_NO),
    FOREIGN KEY(USER_NO) REFERENCES USER(USER_NO),
    FOREIGN KEY(DELI_CLASS) REFERENCES DELIVERY(CLASS),
    FOREIGN KEY(PAY_CLASS) REFERENCES PAYMENT(CLASS),
    FOREIGN KEY(APPLY_CAMP_CODE) REFERENCES OWNEDCP(CAMP_CODE)
)
--------------

Query OK, 0 rows affected (0.05 sec)

--------------
CREATE TABLE ORDERDETAIL(
    ODR_NO INT,
    DET_NO INT,
    PRODUCT_NO CHAR(4),
    PNAME VARCHAR(50),
    CATEGORY CHAR(4),
    SIZE CHAR(1),
    PRICE INT,
    QTY INT,
    PRIMARY KEY(ODR_NO, DET_NO),
    FOREIGN KEY(ODR_NO) REFERENCES ORDERHEADER(ODR_NO),
    FOREIGN KEY(PRODUCT_NO) REFERENCES PRODUCT(PRODUCT_NO)
)
--------------

Query OK, 0 rows affected (0.04 sec)

--------------
INSERT INTO REDUCTION (CLASS, RNAME) VALUES (1, '金額値引')
--------------

Query OK, 1 row affected (0.00 sec)

--------------
INSERT INTO REDUCTION (CLASS, RNAME) VALUES (2, '％値引')
--------------

Query OK, 1 row affected (0.00 sec)

--------------
INSERT INTO DELIVERY (CLASS, DNAME) VALUES (1, '受取')
--------------

Query OK, 1 row affected (0.00 sec)

--------------
INSERT INTO DELIVERY (CLASS, DNAME) VALUES (2, '配達')
--------------

Query OK, 1 row affected (0.00 sec)

--------------
INSERT INTO PAYMENT (CLASS, PNAME) VALUES (1, '現金')
--------------

Query OK, 1 row affected (0.00 sec)

--------------
INSERT INTO PAYMENT (CLASS, PNAME) VALUES (2, 'カード')
--------------

Query OK, 1 row affected (0.00 sec)

--------------
COMMIT
--------------

Query OK, 0 rows affected (0.00 sec)

-- 問９：作成した全てのテーブルの列構造を確認してください。


--------------
DESCRIBE REDUCTION
--------------

+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| CLASS | int         | NO   | PRI | NULL    |       |
| RNAME | varchar(10) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

--------------
DESCRIBE DELIVERY
--------------

+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| CLASS | int         | NO   | PRI | NULL    |       |
| DNAME | varchar(10) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

--------------
DESCRIBE PAYMENT
--------------

+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| CLASS | int         | NO   | PRI | NULL    |       |
| PNAME | varchar(10) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

--------------
DESCRIBE CAMPAIGN
--------------

+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| CAMP_CODE   | char(4)      | NO   | PRI | NULL    |       |
| EXP_TEXT    | varchar(256) | NO   |     | NULL    |       |
| START_DATE  | date         | NO   |     | NULL    |       |
| END_DATE    | date         | NO   |     | NULL    |       |
| COUPON_NAME | varchar(50)  | NO   |     | NULL    |       |
| RED_CLASS   | int          | NO   | MUL | NULL    |       |
| RED_VALUE   | int          | NO   |     | NULL    |       |
| USE_PERIOD  | date         | NO   |     | NULL    |       |
| VALID_COUNT | int          | NO   |     | NULL    |       |
| APPLY_MONEY | int          | NO   |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
10 rows in set (0.00 sec)

--------------
DESCRIBE USER
--------------

+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| USER_NO  | int          | NO   | PRI | NULL    | auto_increment |
| UNAME    | varchar(20)  | NO   |     | NULL    |                |
| RUBY     | varchar(60)  | NO   |     | NULL    |                |
| MAIL     | varchar(256) | NO   | UNI | NULL    |                |
| PASSWORD | char(255)    | NO   |     | NULL    |                |
| TEL      | varchar(10)  | NO   | UNI | NULL    |                |
| CARD_NO  | char(16)     | YES  | UNI | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)

--------------
DESCRIBE DELIADDRESS
--------------

+---------+--------------+------+-----+---------+-------+
| Field   | Type         | Null | Key | Default | Extra |
+---------+--------------+------+-----+---------+-------+
| USER_NO | int          | NO   | PRI | NULL    |       |
| DELI_NO | int          | NO   | PRI | NULL    |       |
| POST_NO | int          | NO   |     | NULL    |       |
| ADDRESS | varchar(100) | NO   |     | NULL    |       |
+---------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

--------------
DESCRIBE OWNEDCP
--------------

+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| USER_NO      | int         | NO   | PRI | NULL    |       |
| CAMP_CODE    | char(4)     | NO   | PRI | NULL    |       |
| COUPON_NAME  | varchar(50) | YES  |     | NULL    |       |
| RED_CLASS    | int         | YES  | MUL | NULL    |       |
| RED_VALUE    | int         | YES  |     | NULL    |       |
| USE_PERIOD   | date        | YES  |     | NULL    |       |
| REMAIN_COUNT | int         | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
7 rows in set (0.00 sec)

--------------
DESCRIBE ORDERHEADER
--------------

+-------------------+--------------+------+-----+-------------------+-------------------+
| Field             | Type         | Null | Key | Default           | Extra             |
+-------------------+--------------+------+-----+-------------------+-------------------+
| ODR_NO            | int          | NO   | PRI | NULL              | auto_increment    |
| ODR_DATE          | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| EMP_NO            | char(5)      | YES  | MUL | NULL              |                   |
| STORE_NO          | char(3)      | YES  | MUL | NULL              |                   |
| USER_NO           | int          | YES  | MUL | NULL              |                   |
| UNAME             | varchar(20)  | YES  |     | NULL              |                   |
| TEL               | varchar(10)  | YES  |     | NULL              |                   |
| POST_NO           | int          | YES  |     | NULL              |                   |
| ADDRESS           | varchar(100) | YES  |     | NULL              |                   |
| CAMP_CODE         | char(4)      | YES  |     | NULL              |                   |
| COUPON_NAME       | varchar(50)  | YES  |     | NULL              |                   |
| USE_PERIOD        | date         | YES  |     | NULL              |                   |
| DELI_CLASS        | int          | YES  | MUL | NULL              |                   |
| PAY_CLASS         | int          | YES  | MUL | NULL              |                   |
| TAX               | int          | NO   |     | NULL              |                   |
| APPLY_CAMP_CODE   | char(4)      | YES  | MUL | NULL              |                   |
| APPLY_COUPON_NAME | varchar(50)  | YES  |     | NULL              |                   |
| APPLY_USE_PERIOD  | date         | YES  |     | NULL              |                   |
| APPLY_VALID_COUNT | int          | YES  |     | NULL              |                   |
+-------------------+--------------+------+-----+-------------------+-------------------+
19 rows in set (0.00 sec)

--------------
DESCRIBE ORDERDETAIL
--------------

+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| ODR_NO     | int         | NO   | PRI | NULL    |       |
| DET_NO     | int         | NO   | PRI | NULL    |       |
| PRODUCT_NO | char(4)     | YES  | MUL | NULL    |       |
| PNAME      | varchar(50) | YES  |     | NULL    |       |
| CATEGORY   | char(4)     | YES  |     | NULL    |       |
| SIZE       | char(1)     | YES  |     | NULL    |       |
| PRICE      | int         | YES  |     | NULL    |       |
| QTY        | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
8 rows in set (0.00 sec)

mysql> notee
