-- ユーザ作成(User名：Muser)
DROP USER IF EXISTS muser;
CREATE USER muser IDENTIFIED WITH MYSQL_NATIVE_PASSWORD BY 'mmm';

-- データベース作成
CREATE DATABASE COS;

-- ユーザにデータベース権限付与
GRANT ALL ON COS.* TO muser;

USE COS;

CREATE TABLE staff(
	date     CHAR(10),
	id CHAR(4),
	sname    VARCHAR(50),
	department CHAR(50),
	password CHAR(4),
	filter   int,
	comment CHAR(100)
);

ALTER TABLE STAFF MODIFY COLUMN date DATETIME;


INSERT INTO staff(date,id,sname, department, password,filter,comment)
VALUES ('2024/05/12','1111','正木陽斗','社長','0512',1,'');

INSERT INTO staff(date,id,sname, department, password,filter,comment)
VALUES ('2024/05/12','1112','山本太郎','清掃','0513',2,'重篤');


UPDATE staff
SET comment = '安全な場所にいます';

--DROP TABLE IF EXISTS staff;

