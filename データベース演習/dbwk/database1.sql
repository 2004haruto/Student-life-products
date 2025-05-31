/*
データベース演習I 課題1
クラス：IE1A05
制作者 : 正木陽斗
作成日：2023/10/05
*/

/*
  ハンズオンではピザ屋の商品情報を取得しました。演習課題ではピザ屋の店舗情報や
  お店で働く従業員情報などのデータを取得しましょう。
*/

-- 問１：店舗表(STORE)の全てのデータを取得してください。
SELECT * FROM store;


-- 問２：従業員表(EMPLOYEE)の全てのデータを取得してください。
SELECT * FROM EMPLOYEE;


-- 問３：店舗表から森ノ宮店の店舗名と開店時間と閉店時間と定休日のデータを取得してください。
SELECT
	SNAME
	,OPEN_TIME
	,CLOSE_TIME
	,HOLIDAY
FROM
	STORE
WHERE
	SNAME = '森ノ宮店';


-- 問４：商品表から300円を下回るサイドメニューの商品名を取得してください。
SELECT
	PNAME 
FROM 
	PRODUCT
WHERE
	CATEGORY = 'サイド'
	AND PRICE < 300;
	


-- 問５：2016年１月１日以前から働いている店長以外の従業員のデータを取得してください。
--      なお、列名は以下の内容で表示させてください。
SELECT
	EMP_NO AS'従業員名'
	,ENAME AS'氏名'
	,JOB AS'担当'
	,SALARY AS'時給'
FROM
	EMPLOYEE
WHERE
	HIREDATE <= '2016-01-01'
	AND
	JOB <> '店長';

