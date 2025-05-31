/*
データベース演習I 課題13
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  データの検索処理を高速化するためにインデックスの定義を行います。
  データベース定義書を元にインデックスの作成をして下さい。
*/

-- 問１：店舗表シートをもとに、定休日にインデックスを作成してください。
CREATE INDEX  STO_STA_IDX  ON  STORE( STATUS ) ;
SHOW INDEX  FROM  STORE ;

-- 問２：新従業員表シートをもとに、必要なインデックスを作成してください。
ALTER TABLE EMPLOYEE ADD INDEX EMP_HIR_IDX( HIREDATE ),
                                ADD INDEX EMP_SAL_IDX( SALARY );

SHOW INDEX  FROM  EMPLOYEE ;

/*
  レシピを確認する時に、毎回テーブルを結合するSQLを書くのは大変なので
  レシピビューを作成して、簡単に情報を取得できるようにします。
*/

-- 問３：以下の情報を持つ、レシピビュー(RECIPEVIEW)を作成してください。
CREATE VIEW RECIPEVIEW AS
SELECT P.PRODUCT_NO, PNAME, MNAME, QUANTITY
FROM PRODUCT AS P
JOIN RECIPE AS R  ON R.PRODUCT_NO = P.PRODUCT_NO
JOIN MATERIAL AS M ON M.MATERIAL_NO = R.MATERIAL_NO;

SHOW COLUMNS  FROM RECIPEVIEW;

-- 問４：レシピビューから夏野菜ピザの情報を取得してください。
SELECT * FROM RECIPEVIEW
WHERE PRODUCT_NO = '0009';

/*
  従業員表にはセキュリティ度の高い情報が管理されています。
  一般ユーザ向けに情報を限定したビューを作成することにしました。
*/

-- 問５：以下の情報を持つ、従業員ビューを作成してください。
CREATE VIEW EMP_VIEW AS 
SELECT S.SNAME, J.JNAME, R.RANK_NAME, E.ENAME
FROM  EMPLOYEE  AS E
JOIN  STORE     AS S  ON S.STORE_NO = E.WORK_STORE
JOIN  JOB       AS J  ON J.JOB_NO = E.JOB_NO 
JOIN  RANKPOINT AS R  ON R.LO_POINT <= E.RANK_POINT AND R.HI_POINT >= E.RANK_POINT;

SHOW COLUMNS  FROM EMP_VIEW;


-- 問６：従業員ビューから尼崎店で勤務している従業員情報を取得してください。
SELECT * FROM EMP_VIEW
WHERE SNAME = '尼崎店';

