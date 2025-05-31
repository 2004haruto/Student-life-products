/*
データベース演習I 課題7
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/

/*
  従業員の熟練度ですが、ポイントのみの表示だと自分のランクが分かりにくいと指摘を受けました。
  従業員表とランク表の結合を行い従業員のランクを表示しましょう。
*/

-- 問１：ランク表(RANKPOINT)の情報を表示して下さい。
SELECT RANK_NAME,RANK_DESC,LO_POINT,HI_POINT
FROM RANKPOINT;

-- 問２：ランク表のベテラン以上の従業員の情報を取得してください。
SELECT EMPLOYEE.EMP_NO, EMPLOYEE.ENAME, EMPLOYEE.RANK_POINT, RANKPOINT.RANK_NAME
FROM EMPLOYEE
JOIN RANKPOINT ON EMPLOYEE.RANK_POINT BETWEEN RANKPOINT.LO_POINT AND RANKPOINT.HI_POINT
WHERE RANKPOINT.LO_POINT >= 2001;

/*
  結合により、従業員の情報をより詳しく調べることが可能になりました。
  従業員表と店舗表の結合を行い、必要なデータを取得していきましょう。
*/

-- 問３：定休日が土曜、日曜日の店舗に勤務する従業員の情報を取得してください。
SELECT STORE.SNAME, STORE.STATUS, EMPLOYEE.EMP_NO, EMPLOYEE.ENAME, EMPLOYEE.JOB
FROM EMPLOYEE
JOIN STORE ON EMPLOYEE.WORK_STORE = STORE.STORE_NO
WHERE STORE.HOLIDAY = ('土日');


-- 問４：都道府県別で働いている従業員の数を調べてください。
SELECT STORE.PREFECTURES AS '店舗エリア', COUNT(EMPLOYEE.EMP_NO) AS '人数'
FROM STORE
LEFT JOIN EMPLOYEE ON STORE.STORE_NO = EMPLOYEE.WORK_STORE
GROUP BY STORE.PREFECTURES
ORDER BY COUNT(EMPLOYEE.EMP_NO);

/*
  材料表があるので、商品で使用する原材料を調べたいと思います。
  しかし、商品表と材料表を紐づける結合条件が見当たりません。
*/

-- 問５：商品のレシピ情報を管理しているレシピ表(RECIPE)を取得してください。
SELECT * FROM RECIPE;


/*
  このように、レシピ表には商品番号と原材料番号および数量を持っているので
  レシピ表を管理することで商品を作るのに必要な材料がわかるようになっています。
  レシピ表と商品表、材料表を結合して必要なデータを取得していきましょう。
*/

-- 問６：レシピ表と材料表からマルゲリータのレシピ情報を表示してください。
SELECT P.PNAME, M.MNAME, M.ORIGIN, R.QUANTITY
FROM PRODUCT P
JOIN RECIPE R ON P.PRODUCT_NO = R.PRODUCT_NO
JOIN MATERIAL M ON R.MATERIAL_NO = M.MATERIAL_NO
WHERE P.PNAME = 'マルゲリータ';

-- 問７：レシピ表を元に商品ごとの原価を調べてください。
SELECT P.PNAME AS PNAME, SUM(M.COST * R.QUANTITY) AS 商品原価
FROM PRODUCT P
JOIN RECIPE R ON P.PRODUCT_NO = R.PRODUCT_NO
JOIN MATERIAL M ON R.MATERIAL_NO = M.MATERIAL_NO
GROUP BY P.PNAME;

