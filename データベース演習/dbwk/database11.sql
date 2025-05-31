/*
データベース演習I 課題11
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  学習環境のピザ屋のデータベースには制約が全く設定されていません。
  テーブル定義書を元に必要な制約の追加をしましょう。
*/

-- 問１：試作品表シートをもとに仮商品番号に主キー(PRIMARY KEY)制約を追加してください。
ALTER TABLE prototype ADD PRIMARY KEY (prototype_no);

SHOW COLUMNS FROM prototype;

-- 問２：職種表シートをもとに職種番号に主キー制約を職種名にNOT NULL制約を追加してください。
ALTER TABLE JOB
MODIFY COLUMN JNAME VARCHAR(4) NOT NULL,
ADD PRIMARY KEY (JOB_NO);

SHOW COLUMNS FROM job;

-- 問３：ランク表シートをもとに主キー制約とNOT NULL制約を追加してください。
ALTER TABLE RANKPOINT
MODIFY COLUMN RANK_NAME VARCHAR(6) NOT NULL,
MODIFY COLUMN HI_POINT INT NOT NULL,
ADD PRIMARY KEY (LO_POINT);

SHOW COLUMNS FROM rankpoint;

-- 問４：レシピ表シートをもとに主キー制約とNOT NULL制約を追加してください。
--      ※レシピ表の主キーは商品番号と原材料番号の複合キーになります。
ALTER TABLE RECIPE
MODIFY COLUMN QUANTITY int NOT NULL,
ADD PRIMARY KEY (PRODUCT_NO, MATERIAL_NO);

SHOW COLUMNS FROM RECIPE;

-- 問５：車体管理表シートをもとに必要な制約を追加してください。
ALTER TABLE BIKE
MODIFY COLUMN BNAME varchar(50) NOT NULL,
MODIFY COLUMN BUY_DATE date NOT NULL,
MODIFY COLUMN STORE_NO char(3) NOT NULL,
ADD PRIMARY KEY (BIKE_NO);

SHOW COLUMNS FROM BIKE;

-- 問６：サイズ表シートをもとに必要な制約と価格差にデフォルト値の設定をしてください。
ALTER TABLE SIZE
MODIFY COLUMN DIFF int NOT NULL DEFAULT 0,
ADD PRIMARY KEY (CATEGORY, SIZE);

SHOW COLUMNS FROM SIZE;

-- 問７：店舗表シートをもとに電話番号のUNIQUE制約を含む必要な制約と
--      デフォルト値の設定をしてください。
ALTER TABLE STORE
MODIFY COLUMN SNAME varchar(20) NOT NULL,
MODIFY COLUMN TEL varchar(10) UNIQUE,
MODIFY COLUMN HOLIDAY varchar(7) NOT NULL DEFAULT '年中無休',
MODIFY COLUMN STATUS varchar(5) NOT NULL DEFAULT '未オープン',
ADD PRIMARY KEY (STORE_NO);

SHOW COLUMNS FROM STORE;

-- 問８：原材料表シートをもとに原価のCHECK制約含む必要な制約を追加してください。
ALTER TABLE `material`
MODIFY COLUMN `MNAME` varchar(50)  NOT NULL,
MODIFY COLUMN `COST` int NOT NULL CHECK (`COST` >= 0),
ADD PRIMARY KEY (`MATERIAL_NO`);

SHOW  CREATE TABLE  material ;

-- 問９：新従業員表シートをもとに必要な制約を追加してください。
ALTER TABLE `employee`
MODIFY COLUMN `ENAME` varchar(20)  NOT NULL,
MODIFY COLUMN `BIRTHDAY` date NOT NULL,
MODIFY COLUMN `TEL` varchar(10)  NOT NULL UNIQUE,
MODIFY COLUMN `ADDRESS` varchar(100)  NOT NULL,
MODIFY COLUMN `RANK_POINT` int NOT NULL,
MODIFY COLUMN `SALARY` int NOT NULL,
MODIFY COLUMN `WORK_STORE` char(3) ,
ADD CONSTRAINT `employee_chk_1` CHECK ((`SALARY` >= 0)),
ADD PRIMARY KEY (`EMP_NO`);

SHOW  CREATE TABLE  employee;

-- 問１０：税率表シートをもとに表の作成と共に制約の定義をしてください。
CREATE TABLE `tax` (
  `TAX` int NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date,
  `TAKEOUT_FLG` int NOT NULL,
  PRIMARY KEY (`START_DATE`,`TAKEOUT_FLG` )
);

SHOW COLUMNS FROM TAX;

