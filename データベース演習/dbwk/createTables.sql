/*-- データベース演習I  テーブル作成スクリプト */

/*---------------以下テーブル削除----------------------*/
DROP VIEW IF EXISTS prodview;
DROP VIEW IF EXISTS recipeview;

DROP TABLE IF EXISTS old_emp;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS bike;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS rankpoint;

DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS size;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS prototype;
DROP TABLE IF EXISTS oldproduct;
DROP TABLE IF EXISTS tax;

/*---------------以下テーブル作成----------------------*/
-- 商品表
CREATE TABLE  product(
    product_no CHAR(4),
    pname      VARCHAR(50),
    category   VARCHAR(4),
    price      INT
);

-- 試作品表
CREATE TABLE  prototype(
    prototype_no CHAR(4),
    protoname    VARCHAR(50),
    category     VARCHAR(4),
    price        INT
);

-- 材料表
CREATE TABLE  material(
    material_no CHAR(5),
    mname       VARCHAR(50),
    origin      VARCHAR(20),
    cost        INT
);

-- レシピ表
CREATE TABLE  recipe(
    product_no  CHAR(4),
    material_no CHAR(5),
    quantity    INT
);

-- 店舗表
CREATE TABLE  store(
    store_no    CHAR(3),
    sname       VARCHAR(20),
    tel         VARCHAR(10),
    prefectures VARCHAR(3),
    address     VARCHAR(100),
    open_time   TIME,
    close_time  TIME,
    holiday     VARCHAR(7),
    status      VARCHAR(5)
);

-- 従業員表
CREATE TABLE  employee(
    emp_no     CHAR(5),
    ename      VARCHAR(20),
    birthday   DATE,
    tel        VARCHAR(10),
    address    VARCHAR(100),
    hiredate   DATE,
    job        VARCHAR(4),
    rank_point INT,
    salary     INT,
    work_store CHAR(3),
    mgr_no     CHAR(5)
);

-- ランク表
CREATE TABLE  rankpoint(
    rank_name VARCHAR(6),
    rank_desc VARCHAR(50),
    lo_point  INT,
    hi_point  INT
);

-- 旧商品表
CREATE TABLE  oldproduct(
    product_no CHAR(4),
    pname      VARCHAR(50),
    category   VARCHAR(4),
    price      INT
);


/*---------------------データ挿入---------------------------*/
-- 商品表
INSERT INTO product(product_no, pname, category, price)
VALUES ('0001','マルゲリータ','ピザ',1200);
INSERT INTO product(product_no, pname, category, price)
VALUES ('0002','デラックスピザ','ピザ',1700);
INSERT INTO product(product_no, pname, category, price)
VALUES ('0003','シーフードピザ','ピザ',1500);
INSERT INTO product(product_no, pname, category, price)
VALUES ('0004','ギガミート','ピザ',2500);
INSERT INTO product(product_no, pname, category, price)
VALUES ('0005','チキン＆ベーコン','ピザ',2200);
INSERT INTO product(product_no, pname, category, price)
VALUES ('0006','バーベキューチキン','ピザ',2200);

INSERT INTO product(product_no, pname, category, price)
VALUES ('1001','ポテトフライ','サイド',380);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1002','コンソメポテト','サイド',380);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1003','バターポテト','サイド',380);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1004','チキンナゲット','サイド',450);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1005','シーザーサラダ','サイド',550);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1006','ごまだれサラダ','サイド',510);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1007','コーンポタージュ','サイド',210);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1008','クラムチャウダー','サイド',240);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1009','ミネストローネ','サイド',240);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1010','エッグタルト','サイド',260);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1011','アップルパイ','サイド',250);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1012','バニラアイス','サイド',370);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1013','ストロベリーアイス','サイド',370);
INSERT INTO product(product_no, pname, category, price)
VALUES ('1014','ポテトサラダ','サイド',510);

INSERT INTO product(product_no, pname, category, price)
VALUES ('2001','コーラ','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2002','ゼロコーラ','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2003','ジンジャエール','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2004','メロンソーダ','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2005','カフェラテ','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2006','コーヒー','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2007','オレンジジュース','ドリンク',160);
INSERT INTO product(product_no, pname, category, price)
VALUES ('2008','アップルジュース','ドリンク',160);

INSERT INTO product(product_no, pname, category, price)
VALUES ('3001','タバスコ','その他',250);
INSERT INTO product(product_no, pname, category, price)
VALUES ('3002','保温バック','その他',500);
INSERT INTO product(product_no, pname, category, price)
VALUES ('3003','エコバック','その他',400);


-- 試作品表
INSERT INTO prototype(prototype_no, protoname, category, price)
VALUES ('9001','MAXチーズピザ','ピザ',3000);
INSERT INTO prototype(prototype_no, protoname, category, price)
VALUES ('9002','夏野菜ピザ','ピザ',3000);
INSERT INTO prototype(prototype_no, protoname, category, price)
VALUES ('9003','バーベキューシーフード','ピザ',3000);

-- 材料表
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00001','チーズ','北海道',50);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00002','モッツァレラチーズ','北海道',700);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00003','パルメザンチーズ','イタリア',450);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00004','チェダーチーズ','イギリス',550);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00005','ブルーチーズ','デンマーク',600);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00006','ソーセージ','アメリカ',250);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00007','サラミ','アメリカ',200);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00008','ベーコン','北海道',350);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00009','ローストチキン',NULL,400);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00010','マッシュルーム',NULL,700);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00011','シーフードミックス',NULL,500);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00012','バジル','イタリア',30);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00013','パセリ','長野',10);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00014','トマト','熊本',55);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00015','ピーマン','茨木',25);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00016','オニオン','兵庫',70);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00017','アスパラガス','長野',120);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00018','コーン','北海道',35);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00019','ナス','高知',70);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00020','トマトソース',NULL,30);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00021','ホワイトソース',NULL,35);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00022','バーベキューソース',NULL,20);
INSERT INTO material(material_no, mname, origin, cost)
VALUES ('00023','メイプルソース',NULL,30);


-- レシピ表
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0001', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0001', '00002', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0001', '00012', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0001', '00014', 3);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0001', '00020', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00006', 3);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00007', 3);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00010', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00015', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00016', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0002', '00020', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0003', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0003', '00003', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0003', '00011', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0003', '00014', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0003', '00015', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0003', '00020', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0004', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0004', '00006', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0004', '00007', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0004', '00008', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0004', '00020', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0005', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0005', '00008', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0005', '00009', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0005', '00013', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0005', '00021', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0006', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0006', '00009', 3);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0006', '00018', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0006', '00020', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('0006', '00021', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9001', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9001', '00002', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9001', '00003', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9001', '00004', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9001', '00005', 2);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9001', '00023', 1);


INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00012', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00014', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00015', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00016', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00017', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00018', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00019', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9002', '00021', 1);

INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9003', '00001', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9003', '00003', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9003', '00011', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9003', '00014', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9003', '00015', 1);
INSERT INTO recipe (product_no, material_no, quantity)
VALUES ('9003', '00022', 1);


-- 店舗表
INSERT INTO store (store_no, sname, tel, prefectures, address, open_time, close_time, holiday, status)
VALUES ('001', '中崎町店', '0663740144', '大阪府', '大阪市北区中崎西２－３－３５', '10:00:00', '22:00:00', '水', '営業中');
INSERT INTO store (store_no, sname, tel, prefectures, address, open_time, close_time, holiday, status)
VALUES ('002', '森ノ宮店', '0669413044', '大阪府', '大阪市中央区大阪城１－１', '9:00:00', '22:00:00', '水', '営業中');
INSERT INTO store (store_no, sname, tel, prefectures, address, open_time, close_time, holiday, status)
VALUES ('003', '生駒店', '0743742173', '奈良県', '生駒市菜畑２３１２－１', '10:00:00', '24:00:00', '土日', '閉店済');
INSERT INTO store (store_no, sname, tel, prefectures, address, open_time, close_time, holiday, status)
VALUES ('004', '三宮店', '0783213851', '兵庫県', '神戸市中央区下山手通１－２－１', '9:00:00', '24:00:00', '金', '未オープン');


-- 従業員表
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00001', '小林友治',   '1972-07-04', '0660030001', '京都府京都市下京区東塩小路町７２１－１', '2007-06-15', '店長', 0, 5000, '003', NULL);
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00002', '小林圭輔',   '1986-03-06', '0660010001', '大阪市中央区大手前１－１－１', '2010-04-01', '店長', 0, 3500, '001', '00001');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00003', '友保隼平',   '1985-08-11', '0660010002', '大阪市中央区大手前１－１－２', '2013-09-10', '受付', 0, 950, '001', '00002');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00004', '稲田直樹',   '1984-12-28', '0660010003', '大阪市中央区大手前１－１－３', '2013-04-01', '配達', 0, 900, '001', '00002');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00005', '河井ゆずる', '1980-11-28', '0660010004', '大阪市中央区大手前１－１－４', '2013-05-15', '調理', 0, 900, '001', '00002');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00006', '村上信五',   '1982-01-26', '0660020001', '大阪府大阪市浪速区恵美須東１－１８－１', '2010-04-01', '店長', 0, 3000, '002', '00001');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00007', '横山裕',     '1981-05-09', '0660020002', '大阪府大阪市浪速区恵美須東１－１８－２', '2010-04-01', '配達', 0, 850, '002', '00006');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00008', '大倉忠義',   '1985-05-16', '0660020003', '大阪府大阪市浪速区恵美須東１－１８－３', '2013-09-20', '配達', 0, 1000, '002', '00006');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00009', '安田章大',   '1984-09-11', '0660020004', '大阪府大阪市浪速区恵美須東１－１８－４', '2013-12-01', '調理', 0, 850, '002', '00006');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00010', '丸山隆平',   '1983-11-26', '0660010005', '大阪府大阪市浪速区恵美須東１－１８－５', '2016-10-01', '受付', 0, 850, '002', '00006');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00011', '秋元真夏',   '1993-08-20', '0331112222', '東京都港区芝公園４－２－８', '2015-05-10', '店長', 0, 2800, '004', '00002');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00012', '生田絵梨花', '1997-01-22', '0331113333', '東京都港区芝公園４－２－７', '2015-05-10', '配達', 0, 800, '004', '00011');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00013', '斎藤飛鳥',   '1998-08-10', '0331114444', '東京都港区芝公園４－２－６', '2018-12-01', '調理', 0, 800, '004', '00011');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00014', '白石麻衣',   '1992-08-20', '0331115555', '東京都港区芝公園４－２－５', '2016-10-01', '調理', 0, 800, '004', '00011');
INSERT INTO employee (emp_no, ename, birthday, tel, address, hiredate, job, rank_point, salary, work_store, mgr_no)
VALUES ('00015', '高山一実',   '1994-02-08', '0331116666', '東京都港区芝公園４－２－４', '2015-09-25', '受付', 0, 800, '004', '00011');


-- ランク表
INSERT INTO rankpoint (rank_name, rank_desc, lo_point, hi_point) VALUES('ビギナー','仕事内容が未習得の従業員。ベテラン以上と一緒に仕事を行う',0,500);
INSERT INTO rankpoint (rank_name, rank_desc, lo_point, hi_point) VALUES('ミドル','ピークタイム以外であれば仕事を1人でこなせる',501,2000);
INSERT INTO rankpoint (rank_name, rank_desc, lo_point, hi_point) VALUES('ベテラン','見本となる勤務が出来てビギナーに仕事を教えることが出来る',2001,4000);
INSERT INTO rankpoint (rank_name, rank_desc, lo_point, hi_point) VALUES('エキスパート','ピークタイム時に主軸となれる人材',4001,8000);
INSERT INTO rankpoint (rank_name, rank_desc, lo_point, hi_point) VALUES('マスター','仕事に精通しており最高峰のサービスを提供できる人材',8001,9999);

-- 旧商品表
INSERT INTO oldproduct(product_no, pname, category, price)
VALUES ('0901','エビマヨネーズ','ピザ',1600);
INSERT INTO oldproduct(product_no, pname, category, price)
VALUES ('0902','アスパラベーコン','ピザ',1800);
INSERT INTO oldproduct(product_no, pname, category, price)
VALUES ('2901','ビール','ドリンク',500);
INSERT INTO oldproduct(product_no, pname, category, price)
VALUES ('2902','レモンチューハイ','ドリンク',350);
INSERT INTO oldproduct(product_no, pname, category, price)
VALUES ('2903','ウイスキー','ドリンク',3400);

COMMIT;

