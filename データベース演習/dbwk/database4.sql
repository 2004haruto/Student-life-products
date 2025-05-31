/*
データベース演習I 課題4
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  社会情勢が不安定になるとの報道を受けて
  輸入品や産地が不明の原材料の原価を調査することになりました。
*/

-- 問１：材料表(MATERIAL)にあるソースの原価を増額する予定です。
--       原価(COST)に10円足した「新原価(仮)」を表示してください。
SELECT MNAME,COST+10 AS'新原価(仮)'
FROM MATERIAL
WHERE MNAME LIKE '%ソース%';

-- 問２：アメリカとの関税が増えたため、原価を上げることになりました。産地(ORIGIN)が
--       アメリカの原価を1.2倍に更新してトランザクションの確定をしてください。
UPDATE MATERIAL
SET COST = COST * 1.2
WHERE ORIGIN  = 'アメリカ';

SELECT MATERIAL_NO,MNAME,ORIGIN,COST
FROM MATERIAL
WHERE ORIGIN = 'アメリカ';

COMMIT;
/*
  Web広告でピザ屋の宣伝をすることにしました。店舗情報を業者に伝える必要があります。
*/

-- 問３：店舗表から店舗名と都道府県付きの住所を表示してください。
SELECT SNAME, CONCAT(PREFECTURES,ADDRESS) AS'住所'
FROM STORE;

-- 問４：現在、営業中の店舗名と営業時間と定休日を表示してください。
SELECT SNAME AS'店舗名',CONCAT(OPEN_TIME,'~',CLOSE_TIME) AS'営業時間',CONCAT(HOLIDAY,'曜日') AS'定休日'
FROM STORE
WHERE STATUS = '営業中';
/*
  中崎町店の売上が減少傾向にあります。
  アルバイトの勤務状況や給与を調査することになりました。
*/

-- 問５：河井ゆずると友保隼平の１ヵ月のアルバイト代を算出します。
--       二人とも勤務時間は週３回、５時間勤務をしていました。
SELECT ENAME ,SALARY*12*5 AS'アルバイト代'
FROM EMPLOYEE
WHERE EMP_NO = '00003' OR EMP_NO = '00005';

-- 問６：店長の給与を調査するため月収の計算を行います。
--       店長は社員なので月20日、８時間勤務で月収を算出してください。
SELECT ENAME ,JOB,SALARY*20*8 AS'月給'
FROM EMPLOYEE
WHERE JOB = '店長';


-- 問７：店長の給与を見直し、小林圭輔と村上信五の月給を46万円にします。
--       給与を160時間換算で時給に直してデータの更新をして下さい。
--       正しく更新されれば、トランザクションの確定をしてください。
UPDATE EMPLOYEE
SET SALARY = 2875
WHERE EMP_NO = '00002' OR EMP_NO = '00006';

SELECT ENAME,JOB,SALARY*20*8 AS'月給'
FROM EMPLOYEE
WHERE JOB = '店長';

COMMIT;

/*
  従業員のスキル向上や従業員評価を明確にするため、熟練度を取り入れることにしました。
  従業員の情報を更新していきます。
*/

-- 問８：ランク表(RANKPOINT)の情報を表示してください。
SELECT RANK_NAME,RANK_DESC,LO_POINT,HI_POINT
FROM RANKPOINT;

-- 問９：現時点で働いている従業員は職種によって熟練度(RANK_POINT)に初期ポイントを付与するものとします。
--       店長には2500、配達には700、それ以外の職種には600ポイントを付与してください。
--       正しく更新されていればトランザクションの確定をしてください。
UPDATE EMPLOYEE
SET RANK_POINT = 
CASE JOB
WHEN '店長' THEN 2500
WHEN '配達' THEN 700
ELSE 600
END;

SELECT EMP_NO,ENAME,JOB,RANK_POINT
FROM EMPLOYEE;

COMMIT;
/*
  顧客から消費税が反映されたメニューがないため支払い金額が分かりにくいとクレームがありました。
  メニューを新しく作成するため商品表の情報を取得していきます。
*/

-- 問１０：商品表の情報から税込み価格を盛り込んだ商品メニューの表示をして下さい。
SELECT CATEGORY AS'カテゴリ',PNAME AS'商品名',CONCAT(PRICE ,'円') AS'価格(税抜)',CONCAT(PRICE+PRICE*0.1,'円') AS'店内(10%)',CONCAT(PRICE+PRICE*0.08,'円') AS'店外(8%)'
FROM PRODUCT;

