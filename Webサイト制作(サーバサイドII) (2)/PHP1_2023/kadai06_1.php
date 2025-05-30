<?php
require_once "./kadai06_resource.php";

//クッキーを取得する
$cookie = filter_input(INPUT_COOKIE,"php1_kadai06",FILTER_DEFAULT,FILTER_REQUIRE_ARRAY);

//クッキー値が存在しない場合は、空配列を代入する(表示部分にエラーを起こさないため)
if(empty($cookie) || !is_array($cookie)){
  $cookie = array();
}

?>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- TODO:Bootstrap読み込み -->
  <!-- link -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <title>php1 - kadai06_1</title>
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
      <h2 class="p-5 d-grid gap-2 d-md-flex">取り扱いクッキー</h2>
      <div class="row" style="border-top: 2px solid hotpink;">

        <!-- TODO:kadai06_resourceファイルの情報を読み込み -->
        <?php foreach($products as $p): ?>
        <div class="col-sm-3 p-3">
          <div class="card h-100 shadow-sm" style="max-width:25rem;">
            <a class="link-secondary" style="text-decoration:none;" href="kadai06_2.php?product_id=<?= $p["id"]?>">

              <img class="img-fluid img-thumbnail h-50" style="width:100%;" src="./asset/images/<?= $p["thumbnail"]["small"]?>">

              <div class="card-body">
                <p class="card-text"><?=$p["name"]?></p>
                <p class="card-text" style="color:hotpink;">¥<?=$p["price"]?></p>
              </div>
            </a>
          </div>
        </div>
        <?php endforeach ?>


      </div>

      <div class="row">
        <h2 class="p-5 d-grid gap-2 d-md-flex" style="border-bottom: 2px solid hotpink;">閲覧したクッキー</h2>
        <div class="col m-3" style="display: flex; overflow:auto;">

          <!-- TODO:閲覧したクッキー情報を表示する -->
          <?php foreach($cookie as $c): ?>
          <div class="card m-3" style="max-width:10rem; min-width:10rem;">
                       <a class="link-secondary" style="text-decoration:none;" href="kadai06_2.php?product_id=<?= $products[$c]["id"]?>">
              

              <img class="img-fluid img-thumbnail h-50" style="width:100%;" src="./asset/images/<?= $products[$c]["thumbnail"]["small"]?>">


              <div class="card-body">
                <p class="card-text"><?= $products[$c]["name"] ?></p>
                <p class="card-text" style="color:hotpink;">¥<?= $products[$c]["price"] ?></p>
              </div>
            </a>
          </div>
            <?php endforeach?>
        </div>

      </div>

    </div>
  </main>
  <!-- ▲▲メイン▲▲----------------------------------- -->

</body>

</html>