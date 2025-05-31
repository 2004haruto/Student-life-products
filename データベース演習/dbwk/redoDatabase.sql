/*
データベース演習Iで、やり直しがきかない失敗をしたときに
環境を元に戻すためのSQLファイル

今まで作成してきたSQLを１から再実行を行う。
必要に応じて、sourceコマンドの有効化して実行してください。
*/

-- 環境のテーブルを初期状態に戻す。
source createTables.sql

-- 課題1
source database1.sql


-- 課題2
source database2.sql
-- 課題3
source database3.sql
-- 課題4
source database4.sql

-- 課題5
source database5.sql

-- 課題6
source database6.sql

-- 課題7
source database7.sql

-- ハンズオン8
INSERT INTO EMPLOYEE VALUES ('00018','山名文和','1980-07-03','0748112222','滋賀県東近江市八日市緑町１０－５',DATE(NOW()),NULL,0,800,'004',NULL);
INSERT INTO EMPLOYEE VALUES ('00019','秋山賢太','1983-06-24','0729991000','兵庫県川辺郡猪名川町上野字北畑１１－１',DATE(NOW()),NULL,0,800,NULL,NULL);
INSERT INTO STORE VALUES ('006', '尼崎店', '0664879999', '兵庫県','尼崎市昭和通２－１７－１６', '9:00:00', '24:00:00', '金', '未オープン');
COMMIT;


-- 課題8
source database8.sql

-- 課題9
source database9.sql

-- ハンズオン10
CREATE TABLE JOB(
    JOB_NO  INT(1),
    JNAME   VARCHAR(4)  DEFAULT '未設定'
);
INSERT INTO JOB (JOB_NO, JNAME) VALUES (1, '店長'), (2 , '配達'),(3, '受付'),(4, '調理');
INSERT INTO JOB (JOB_NO) VALUES (5);
COMMIT;


-- 課題10
source database10.sql

-- ハンズオン11
ALTER TABLE PRODUCT  MODIFY  CATEGORY VARCHAR(4) NOT NULL,
                     MODIFY  PRICE INT(5)  NOT NULL,
                     ADD  PRIMARY KEY( PRODUCT_NO ),
                     ADD  UNIQUE( PNAME ),
                     ADD  CHECK( PRICE >= 0 );
                     

-- 課題11
source database11.sql


-- ハンズオン12
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(WORK_STORE) REFERENCES STORE(STORE_NO);


-- 課題12
source database12.sql

-- ハンズオン13
CREATE VIEW PRODVIEW AS
SELECT PRODUCT_NO, PNAME, CATEGORY, PRICE
FROM PRODUCT
UNION
SELECT PROTOTYPE_NO, PROTONAME, CATEGORY, PRICE
FROM PROTOTYPE ;

/* ←これを移動させる

-- 課題13
source database13.sql

*/

COMMIT;

