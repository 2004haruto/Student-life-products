/*
データベース演習I 課題3
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  新商品開発に向けてピザの原材料を整理することにしました。
  材料表(MATERIAL)の情報を確認してみましょう。
*/

-- 問１：ピザの原材料に使われているチーズの種類を調べます。
--       原材料名(MNAME)にチーズが含まれるデータを取得してください。
	SELECT * FROM 	MATERIAL
	WHERE MNAME LIKE'%チーズ%';

-- 問２：新商品にゴーダチーズを使いたいと考えています。材料表にデータを追加して
--       正しく登録されているか確認をしてトランザクションの確定をしてください。
	INSERT INTO MATERIAL VALUES('00024','ゴーダチーズ','オランダ',550);
	
	SELECT * FROM MATERIAL
	WHERE MATERIAL_NO = '00024';
	
	COMMIT;
-- 問３：新しい産地の原材料を追加したので、最新の産地一覧を表示してください。
	SELECT  DISTINCT ORIGIN 
	FROM MATERIAL;

-- 問４：産地が不明の原材料が存在しています。
--       原価(COST)の安い順にデータを表示してください。
	SELECT  * FROM  MATERIAL 
	WHERE  ORIGIN  
	IS NULL
	ORDER BY  
		COST;   

-- 問５：マッシュルームは千葉県の農家から原価450円で取引できるように契約しました。
--       データの更新を行い、正しく更新出来ればトランザクションの確定をしてください。
--       ※更新パラメータがQuery OK, 1 row affected以外の場合ROLLBACKを行うこと。
	UPDATE MATERIAL
	SET ORIGIN = '千葉',
		COST = 450
	WHERE MATERIAL_NO = '00010';
		
	SELECT * FROM MATERIAL
	WHERE MATERIAL_NO = '00010';
		
	COMMIT;

-- 問６：他の原材料もコストカット出来ないか検証することにしました。
--       産地が北海道で最も高い原価のデータを取得してください。
	SELECT  *  FROM  MATERIAL 
	WHERE ORIGIN = '北海道'
	ORDER BY  COST DESC
			LIMIT  1; 
		

-- 問７：牧場と商談をした結果、原価を650円にすることが出来ました。
--       データの更新をして、トランザクションの確定をしてください。
	UPDATE MATERIAL
	SET COST = 650
	WHERE MATERIAL_NO = '00002';

	SELECT * FROM MATERIAL
	WHERE MATERIAL_NO = '00002';
	
	COMMIT;
/*
  店舗に勤務する従業員の給与を調査することにしました。
*/

-- 問８：従業員を店舗ごとに給与が高い順に表示していください。
--       ただし、職種が店長は対象外とします。
	SELECT  WORK_STORE  AS'店舗番号',ENAME AS'氏名',JOB AS'職種',SALARY AS'時給'  
	FROM  EMPLOYEE 
	WHERE JOB NOT IN('店長')
	ORDER BY  WORK_STORE,  SALARY DESC; 

-- 問９：従業員で給与が800円以上900円未満の従業員を表示してください。
	SELECT ENAME,JOB,SALARY
	FROM EMPLOYEE
	WHERE SALARY >=800 AND SALARY < 900
	ORDER BY  SALARY;

-- 問１０：給与が800円と850円の従業員を890円に更新してください。
--         正しく更新されていれば、トランザクションの確定をしてください。
	UPDATE EMPLOYEE
	SET SALARY = 890
	WHERE SALARY IN (800,850);
	
	
		SELECT ENAME,JOB,SALARY
		FROM EMPLOYEE
		WHERE SALARY = 890;
		COMMIT;