/*
データベース演習I 課題10
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  DDL(データ定義言語)を学習したことにより、データベースにテーブルを追加することが出来ます。
  ピザ屋で配達に利用するバイクを管理したいですが、情報を保存するためのテーブルがありません。
  バイクを管理する車体管理表の作成をしていきましょう。
*/

-- 問１：テーブル定義書_車体管理表.xlsをもとに車体管理表を作成して列構造を表示してください。
CREATE TABLE BIKE (
    BIKE_NO char(5),
    BNAME varchar(50),
    BUY_DATE date,
    LENGTH int(4),
    HEIGHT int(4),
    WIDTH int(4),
    SEAT_HEIGHT int(4),
    WEIGHT int(4),
    CAPACITY double(4,1),
    DISPLACEMENT int(4),
    STORE_NO char(3)
);

SHOW COLUMNS FROM BIKE;

/*
  車体を管理できるようになったので、新しく配達用のバイクを購入することにしました。
  森ノ宮店に「スーパーカブ50 プロ」、阿倍野店に「ジャイロ キャノピー」を配置するのでデータを登録しましょう。
*/

-- 問２：上記、バイクの情報を登録してください。
--       データの表示を行い内容に間違いがなければトランザクションの確定をしてください。
--       本田技研工業：https://www.honda.co.jp/motor-lineup/
INSERT INTO BIKE
(BIKE_NO, BNAME, BUY_DATE, LENGTH, HEIGHT, WIDTH, SEAT_HEIGHT, WEIGHT, CAPACITY, DISPLACEMENT, STORE_NO)
VALUES
('00001', 'スーパーカブ50 プロ', CURRENT_DATE, 1860, 695, 1040, 735, 96, 4.3, 49, '002'),
('00002', 'ジャイロ キャノピー', CURRENT_DATE, 1895, 660, 1690, 700, 139, 5.9, 49, '005');

SELECT* FROM BIKE;

commit;

/*
  大きめや小さめの商品を提供するために一部の商品をサイズ管理できるようにしたいです。
  しかし、商品表にサイズ情報を持たせるとデータが正しく管理できなくなるので
  サイズ表を作成することにしました。
*/

-- 問３：テーブル定義書_サイズ表.xlsをもとにサイズ表を作成して列構造を表示してください。
CREATE TABLE SIZE (
    CATEGORY varchar(4) ,
    SIZE char(1) ,
    DIFF int(5) DEFAULT 0
);

SHOW COLUMNS FROM SIZE;

-- 問４：カテゴリーがピザとドリンクのサイズ情報を登録してください。
--       正しくデータが登録されていればトランザクションの確定をしてください。
INSERT INTO SIZE (CATEGORY, SIZE, DIFF) VALUES
('ピザ', 'S', 0),
('ピザ', 'M', 500),
('ピザ', 'L', 1000),
('ドリンク', 'S', -30),
('ドリンク', 'M', 0),
('ドリンク', 'L', 50);

SELECT * FROM SIZE;

commit;

-- 問５；サイズに合わせた商品価格を含む情報を表示してください。（計51件表示）
SELECT
    PRODUCT.PRODUCT_NO,
    PRODUCT.PNAME,
    SIZE.SIZE,
    PRODUCT.PRICE + SIZE.DIFF AS PRICE
FROM
    PRODUCT
JOIN
    SIZE ON PRODUCT.CATEGORY = SIZE.CATEGORY
ORDER BY
    PRODUCT.PRODUCT_NO, PRICE + SIZE.DIFF;


/*
  今回、新たに職種の管理を職種表で行うことにしました。
  今のままだと従業員表と職種表のリレーションが出来ないので従業員表を作り直します。
  同じ名前のテーブルは作成できないので、現在の従業員表を退避させて作業を進めていきます。
*/

-- 問６：現在の従業員表のテーブル名をOLD_EMPに変更してください。
--       ※テーブル一覧を確認するにはSHOW TABLESを実行してください
RENAME TABLE EMPLOYEE TO OLD_EMP;

SHOW TABLES; 

-- 問７：テーブル定義書_新従業員表.xlsをもとに新従業員表を作成して列構造を表示してください。
CREATE TABLE EMPLOYEE (
    EMP_NO char(5) ,
    ENAME varchar(20) ,
    BIRTHDAY date ,
    TEL varchar(10) ,
    ADDRESS varchar(100) ,
    HIREDATE date ,
    JOB_NO int(1) ,
    RANK_POINT int(4) ,
    SALARY int(4) ,
    WORK_STORE char(3),
    MGR_NO char(5)
);

 SHOW COLUMNS FROM employee;

-- 問８：旧従業員にあるデータを新従業員表に全てのデータを移行してください。
--       正しくデータが更新されていればトランザクションの確定をしてください。
--       ※INSERT SELECT文を使用してください。
INSERT INTO EMPLOYEE (EMP_NO, ENAME, BIRTHDAY, TEL, ADDRESS, HIREDATE, JOB_NO, RANK_POINT, SALARY, WORK_STORE, MGR_NO)
SELECT e.EMP_NO, e.ENAME, e.BIRTHDAY, e.TEL, e.ADDRESS, e.HIREDATE, j.JOB_NO, e.RANK_POINT, e.SALARY, e.WORK_STORE, e.MGR_NO
FROM OLD_EMP e
LEFT JOIN JOB j ON e.JOB = j.JNAME;

SELECT EMP_NO, ENAME, JOB_NO FROM EMPLOYEE;

commit;

-- 問９：旧従業員表を削除してテーブル一覧を確認してください。
drop table old_emp;

SHOW TABLES; 


