/*-- データベース演習I  環境構築スクリプト */

-- ユーザ作成(User名：dbuser)
DROP USER IF EXISTS dbuser;
CREATE USER dbuser IDENTIFIED WITH MYSQL_NATIVE_PASSWORD BY 'ecc';

-- データベース削除
DROP DATABASE IF EXISTS studb;
-- DROP DATABASE IF EXISTS trdb;

-- データベース作成(studb：学習環境、trdb：練習環境)
CREATE DATABASE studb;
-- CREATE DATABASE trdb;

-- ユーザにデータベース権限付与
GRANT ALL ON studb.* TO dbuser;
-- GRANT ALL ON trdb.* TO dbuser;


-- データベース移動にテーブル作成(練習環境)
-- USE trdb;
-- source createTables.sql

-- データベース移動にテーブル作成(学習環境)
USE studb;
source createTables.sql

SELECT * FROM product;
SELECT * FROM prototype;
SELECT * FROM material;
SELECT * FROM recipe;
SELECT * FROM store;
SELECT * FROM employee;
SELECT * FROM rankpoint;


