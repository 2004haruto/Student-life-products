/*
データベース演習I 課題6
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  ピザ屋では、従業員の時給設定や職種などは各店舗に管理を任せていましたが
  店舗間格差が出ないように店舗ごとの集計情報などを調べることにしました。
*/

-- 問１：従業員表から最も入社日が早い日付を取得してください。
SELECT MIN(HIREDATE) AS'入社日'
FROM EMPLOYEE;

-- 問２：従業員表からランクポイントの最大値と最小値を取得してください。
SELECT MAX(RANK_POINT) AS'最大ポイント',MIN(RANK_POINT) AS'最小ポイント'
FROM EMPLOYEE;

/*
  従業員の店舗格差が無いか調査するため、
  店舗や職種など様々な観点から時給の平均を集計したいと思います。
*/

-- 問３：店長以外の従業員の時給の平均値を取得してください。
SELECT AVG(SALARY) AS'平均時給'
FROM EMPLOYEE
WHERE NOT (JOB = '店長');

-- 問４：店舗ごとに店長を除いた時給の平均値を取得してください。
SELECT  WORK_STORE AS'店舗コード',AVG(SALARY) AS'平均時給'
FROM EMPLOYEE
WHERE NOT (JOB = '店長')
GROUP BY WORK_STORE;

-- 問５：職種ごとの人数を取得してください。
SELECT JOB AS'職種',COUNT(JOB) AS'人数'
FROM EMPLOYEE               
GROUP BY JOB;

-- 問６：店舗、職種ごとの時給の平均値を取得してください。
--       表示順は平均値の高い順とし、フォーマットして表示を行うこと。
SELECT WORK_STORE AS'店舗コード',JOB AS'職種',FORMAT(AVG(SALARY),0) AS'平均時給'
FROM EMPLOYEE
GROUP BY WORK_STORE,JOB
ORDER BY AVG(SALARY) DESC;

/*
  特に大きな格差は発生していないと判断しました。
  次に、上司に指定されている従業員の負担を調査することにしました。
  上司の従業員番号(MGR_NO)を元に集計を進めてください。
*/

-- 問７：上司の従業員番号が設定されている従業員の人数を取得してください。
SELECT COUNT(DISTINCT MGR_NO) AS'マネージャの人数'
FROM EMPLOYEE;

-- 問８：上司が受け持っている従業員(部下)の数を取得してください。
--       ただし、上司の従業員番号がNULLのデータは除いてください。
SELECT MGR_NO AS'マネージャ番号', COUNT(*) AS'部下の人数'
FROM EMPLOYEE
WHERE MGR_NO IS NOT NULL
GROUP BY MGR_NO;

-- 問９：部下の数が４人以下の上司の従業員番号を取得してください。
SELECT MGR_NO AS'マネージャ番号', COUNT(*) AS'部下の人数'
FROM EMPLOYEE
WHERE MGR_NO IS NOT NULL
GROUP BY MGR_NO
HAVING COUNT(*) <= 4;


/*
  こちらも、抱えている部下の数に大きな違いは見られませんでした。
  最後に従業員の入社年度の割合を確認します。
*/

-- 問１０：入社年度ごとの従業員の人数を取得してください。
SELECT YEAR(HIREDATE) AS '入社年度', COUNT(*) AS '人数'
FROM EMPLOYEE
GROUP BY YEAR(HIREDATE)
ORDER BY YEAR(HIREDATE);


