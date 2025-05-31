/*
データベース演習I 課題8
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  外部結合を使うことで、データが正しく登録できているか確認できるようになりました。
  まずは、従業員情報から調査を進めていきましょう。
*/

-- 問１：全従業員の上司の名前を取得してください。
SELECT 
    E1.EMP_NO, E1.ENAME, E1.MGR_NO, E2.ENAME 
FROM 
    employee AS E1
LEFT JOIN 
    employee AS E2 ON E1.MGR_NO = E2.EMP_NO
ORDER BY E1.EMP_NO;


/*
  小林友治は従業員のトップにあたる人なので、上司がいないのは正しいです。
  しかし、山名文和さんと秋山賢太さんに関しては上司が存在しない状態はまずいので
  もう少し調査を行います。
*/

-- 問２：店舗表をさらに結合して、全従業員の勤務店舗を表示してください。
SELECT E1.WORK_STORE, S.SNAME, E1.ENAME, E1.MGR_NO, E2.ENAME
FROM EMPLOYEE AS E1
LEFT JOIN STORE AS S ON E1.WORK_STORE = S.STORE_NO
LEFT JOIN EMPLOYEE AS E2 ON E1.MGR_NO = E2.EMP_NO
ORDER BY E1.WORK_STORE;


/*
  山名文和さんと秋山賢太さんはデータ登録時のミスによるものでした。
  正しい情報に修正したいと思います。
*/

-- 問３：以下の内容で従業員の情報を更新して下さい。※SQL文は２つになります。
UPDATE employee
SET job = '店長', RANK_POINT = 1200, WORK_STORE = '006', MGR_NO = '00001'
WHERE emp_no = '00018';

UPDATE employee
SET job = '調理', RANK_POINT = 100, WORK_STORE = '006', MGR_NO = '00018'
WHERE emp_no = '00019';

-- 問４：２名の従業員情報を表示してください。
--       正しく更新されていればトランザクションの確定をしてください。
select EMP_NO, ENAME, JOB, RANK_POINT, WORK_STORE, MGR_NO from employee
where EMP_NO IN ('00018','00019');

commit;

/*
  従業員の情報は修正することが出来ました。
  次に、商品情報が正しく登録できているか調査を進めていきます。
*/

-- 問５：カテゴリーがピザである商品情報を試作品も含めて表示してください。
SELECT product_no AS 'PRODUCT_NO', pname AS 'PNAME', price AS 'PRICE'
FROM product
WHERE category = 'ピザ'
UNION ALL
SELECT prototype_no AS 'PRODUCT_NO', protoname AS 'PNAME', price AS 'PRICE'
FROM prototype
WHERE category = 'ピザ';


/*
  以前、商品名称を変更したBBQチキンとBBQシーフードの商品を調査します。
*/

-- 問６：商品名にBBQが含まれる商品のレシピ情報を表示してください。
SELECT 
        P.PRODUCT_NO,P.PNAME,M.MNAME,R.QUANTITY 
    FROM
        PRODUCT AS P 
    LEFT 
        JOIN RECIPE AS R ON R.PRODUCT_NO = P.PRODUCT_NO
    LEFT 
        JOIN MATERIAL AS M ON R.MATERIAL_NO = M.MATERIAL_NO
    WHERE P.PNAME LIKE '%BBQ%'
    ORDER BY P.PRODUCT_NO,M.MATERIAL_NO;


/*
  BBQシーフードのレシピ情報が取得できませんでした。
  レシピ情報が正しいかチェックして原因を探りたいと思います。
*/

-- 問７：レシピ情報を元に結合を行い、商品が存在しないレシピ情報の確認をしてください。
SELECT R.product_no, P.pname, M.mname, R.quantity
FROM recipe R
LEFT JOIN product P ON R.product_no = P.product_no
LEFT JOIN material M ON R.material_no = M.material_no
WHERE P.product_no IS NULL;



/*
  調査を進めたところ、レシピ表には試作品のレシピ情報も管理されており
  商品表との結合では、結合できないレシピが存在していました。
*/

-- 問８：試作品表との結合を行い、試作品のレシピ情報を表示してください。
SELECT R.PRODUCT_NO AS PROTOTYPE_NO, PR.PROTONAME, M.MNAME, R.QUANTITY
FROM RECIPE R
RIGHT JOIN PROTOTYPE PR ON R.PRODUCT_NO = PR.PROTOTYPE_NO
LEFT JOIN MATERIAL M ON R.MATERIAL_NO = M.MATERIAL_NO
ORDER BY R.PRODUCT_NO;

/*
  前回ＢＢＱシーフードを試作品表から商品表にデータを移し替えた時に
  レシピの情報を登録し忘れていました。
*/

-- 問９：レシピ表の更新を行い、BBQシーフードのレシピ情報の結合が正しくされるようにして下さい。
--       データの内容に問題が無ければトランザクションの確定をして下さい。
    
UPDATE recipe
SET product_no ='0007'
WHERE product_no = '9003' ;


SELECT P.product_no, P.pname, M.mname, R.quantity
         FROM product P
         LEFT JOIN recipe R ON R.product_no = P.product_no
         LEFT JOIN material M ON R.material_no = M.material_no
         where P.product_no = '0007'
         ORDER BY M.material_no;
    
    commit;
