<?php
require_once "./kadai06_resource.php";

//GETで送られてきた商品IDを取得
$product_id =filter_input(INPUT_GET,"product_id",FILTER_VALIDATE_INT);

//product_idがなければエラー
if(!$product_id){
  exit("商品番号が送られていない");
}

//配列productsの中にproduct_idが一致した行番目を取得
foreach($products as $key => $p){
  if($p["id"]===$product_id){
    $array_no = $key;//行番号を保存
    $syouhin = $p;//商品情報を保存
  }
}

//product_idがなければエラー
if(!isset($array_no)){
  header("Location: kadai06_1.php");
  exit("商品番号が間違ってる");
}

//クッキー値の保存(表示された商品の行番号を保持する)
setcookie("php1_kadai06[".$syouhin["id"]."]",$array_no,time() + (60 * 1));

?>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- TODO:Bootstrap読み込み -->
  <!-- link -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <title>php1 - kadai06_2</title>
</head>

<body>
  <!-- ▼▼ヘッダー▼▼--------------------------------- -->
  <header class="bg-info">
    <div class="text-light ms-5 pt-5 pb-3">
      <h1 class="h6">サーバーサイドスクリプト演習１</h1>
      <h2 class="pt-3">クッキー</h2>
    </div><!--/.text-light ms-5 pt-5 pb-3-->
  </header>
  <!-- ▲▲ヘッダー▲▲--------------------------------- -->

  <!-- ▼▼メイン▼▼----------------------------------- -->
  <main>
    <div class="container-field">
      <h2 class="p-5 d-grid gap-2 d-md-flex border-bottom" style="border-color:deeppink;">取り扱い商品の詳細</h2>
      <div class="p-5 row">
        <div class="col-md-7">
          <!-- 画像 -->
          <figure class="img-fluid"><img class="" style="width:100%;" src="./asset/images/<?= $syouhin["thumbnail"]["small"]?>"></figure>
        </div>

        <div class="col-md-3">
          <div class="row">
            <h3 class=""><?=$syouhin["name"]?></h3>
            <p class=""><?=$syouhin["description"]?></p>
            <p class="" style="color:deeppink;">¥<?=$syouhin["price"]?></p>
            <a class="mt-5 btn btn-secondary" href="kadai06_1.php">一覧に戻る</a>
          </div>

        </div>
      </div>

    </div>
  </main>
  <!-- ▲▲メイン▲▲----------------------------------- -->
</body>

</html>