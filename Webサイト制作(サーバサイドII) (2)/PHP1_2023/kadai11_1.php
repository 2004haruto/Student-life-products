<?php
//ファイルの読み込み
require_once "./def.php";
require_once "./utils.php";

$result=[];

//課題9 getデータの取得
$product_no = filter_input(INPUT_GET,"product_no");

//****************************************************************************************/

//課題８ではoldProductから全件表示
//1.PDOクラスのインスタンス化
try{
$dsn = "mysql:host=localhost;dbname=studb;charset=utf8mb4";
$db = new PDO($dsn, DB_USER, DB_PASS);//PDOクラスのインスタンス化

////2.PDOの動作オプションを指定
$db->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);//例外クラスをスローする
$db->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);//静的プレースホルダの設定

//3.SQLの準備
$sql="SELECT * FROM OLDPRODUCT";
//課題9追加処理　nameとcategoryの値からWHERE句の作成する
$where = " WHERE product_no=:product_no";//WHEREの前にスペース忘れずに

//****************************************************************************************/
//echo ($sql.$where);
$stmt=$db->prepare($sql.$where);

//商品番号の値をバインド
if($product_no){
$stmt->bindParam(':product_no',$product_no, PDO::PARAM_STR);
}  

//4.SQLの実行
$stmt->execute();

//5.結果セットの取得
while ($rows = $stmt->fetch(PDO::FETCH_ASSOC)) {
  $result[] = $rows;
}

//6.DB切断
$stmt=null;
$db=null;
}catch(PDOException $poe){
  exit("DBエラー".$poe->getMessage());
}

//var_dump($result);

//課題９でNAMEとCATEGORYの条件を追加して検索
?>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>kadai11_1 更新</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
  <!-- ▼▼ヘッダー▼▼--------------------------------- -->
  <header class="bg-info">
    <div class="text-light ms-5 pt-5 pb-3">
      <h1 class="h6">サーバーサイドスクリプト演習１</h1>
      <h2 class="pt-3">データベース更新</h2>
    </div><!--/.text-light ms-5 pt-5 pb-3-->
  </header>
  <!-- ▲▲ヘッダー▲▲--------------------------------- -->

  <!-- ▼▼メイン▼▼----------------------------------- -->
  <main>
    <div class="form-control">
    <form action="kadai11_2.php" method="POST" novalidate>
        <div class="p-5 row">
          <div class="col-md-5">

            <!-- 商品番号 -->
            <div class="col">
              <label class="form-label" for="product_no">商品番号<em class="text-danger">※商品番号は変更不可</em></label>
              <input type="text" name="product_no" id="product_no" class="form-control form-control-lg border-info bg-light" value="<?= htmlspecialchars($product_no ?? '', ENT_QUOTES, 'UTF-8') ?>" readonly>
            </div>

            <!-- カテゴリ＆価格 -->
            <div class="row">
              <div class="col">
                <!-- カテゴリ -->
                <label class="form-label" for="category">カテゴリ</label>
                <select class="form-select form-select-lg mb-3" name="category">
                  <option value="1" <?php if($result[0]["category"]=='ピザ') echo("selected");?>>ピザ</option>
                  <option value="2" <?php if($result[0]["category"]=='ドリンク') echo("selected");?>>ドリンク</option>
                </select>
              </div><!-- .col -->
              <!-- 価格 -->
              <div class="col">
              <label class="form-label" for="price">価格</label>
              <input type="text" name="price" id="price" class="form-control form-control-lg border-info" placeholder="" value="<?= htmlspecialchars($result[0]["price"] ?? '', ENT_QUOTES, 'UTF-8') ?>">
              </div><!-- .col -->
            </div><!-- .row -->

            <!-- 商品名 -->
            <div class="col">
            <label class="form-label" for="pname">商品名</label>
            <input type="text" name="pname" id="pname" class="form-control form-control-lg border-info" placeholder="" value="<?= htmlspecialchars($result[0]["pname"] ?? '', ENT_QUOTES, 'UTF-8') ?>">
          </div><!-- .col -->

          </div><!-- .col-md-5 -->

        </div><!-- .p-5 row -->

        <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-start">
          <button type="submit" class="btn btn-danger btn-lg">更新</button>
          <a class="btn btn-secondary btn-lg" href="kadai08_1.php">戻る</a>
        </div><!-- .p-5 d-grid gap-2 d-md-flex justify-content-md-end -->
      </form>

    </div><!--/.form-control-->
  </main>
  <!-- ▲▲メイン▲▲------------------------------------ -->

</body>

</html>