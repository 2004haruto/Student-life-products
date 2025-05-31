/*
データベース演習I 課題12
クラス：IE1A01
制作者：山田　太郎
作成日：2020/09/01
*/


/*
  今回、新たに外部キー制約について学習しました。
  よりデータベースの安全性を高めるためにテーブル定義書を元に外部キー制約の追加をしましょう。
*/

-- 問１：車体管理表シートをもとに管理店舗に店舗表の店舗番号に対する
--      外部キー制約(FOREIGN KEY)制約を追加してください。
ALTER TABLE  BIKE  ADD  FOREIGN KEY ( STORE_NO)
REFERENCES   STORE ( STORE_NO ) ;

SHOW  CREATE TABLE  BIKE ;

-- 問２：新従業員表シートをもとに不足している外部キー制約(FOREIGN KEY)制約を追加してください。
ALTER TABLE  EMPLOYEE
ADD  FOREIGN KEY ( JOB_NO ) REFERENCES  JOB ( JOB_NO ),
ADD  FOREIGN KEY ( MGR_NO ) REFERENCES  EMPLOYEE ( EMP_NO );
SHOW  CREATE TABLE  EMPLOYEE ;

-- 問３：レシピ表シートをもとに必要な外部キー制約(FOREIGN KEY)制約を追加してください。
ALTER TABLE  RECIPE
ADD  FOREIGN KEY ( PRODUCT_NO )REFERENCES  PRODUCT ( PRODUCT_NO ),
ADD  FOREIGN KEY ( MATERIAL_NO )REFERENCES  MATERIAL ( MATERIAL_NO );

SHOW  CREATE TABLE  RECIPE ;

