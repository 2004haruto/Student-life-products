<?php
ob_start();
//ファイルの読み込み
require_once "./def.php";
require_once "./utils.php";

$result=[];

//課題9 getデータの取得
$name = filter_input(INPUT_GET,"name");
$category = filter_input(INPUT_GET,"category",FILTER_VALIDATE_INT);

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
$where = " WHERE 1=1";//WHEREの前にスペース忘れずに

//商品名のあいまい検索 $nameが存在する場合のみ実行
if($name){
 //"%"を含めたLIKE句で設定する文字列を作成
 $nameLike = "%" . $name . "%";
 //$whereを設定
 $where .= " AND PNAME like :name";//ANDの前にスペース忘れずに
}

//カテゴリーの検索
if($category && $category !== 1){
  //ピザかドリンクの文字列を取得
  if($category===2){
    //ピザ
    $cname='ピザ';
  }elseif($category===3){
    //ドリンク
    $cname='ドリンク';
  }
  //where句の作成
  $where.=" AND CATEGORY = :category";
}

//****************************************************************************************/
//echo ($sql.$where);
$stmt=$db->prepare($sql.$where);

//商品名の値をバインド
if($name){
$stmt->bindParam(':name',$nameLike, PDO::PARAM_STR);
}

//カテゴリーの値をバインド
if($category && $category !== 1){
$stmt->bindParam(':category',$cname, PDO::PARAM_STR);
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
ob_flush();
?>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>kadai08_1 商品検索</title>


  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
  <!-- ▼▼ヘッダー▼▼--------------------------------- -->
  <header class="bg-info">
    <div class="text-light ms-5 pt-5 pb-3">
      <h1 class="h6">サーバーサイドスクリプト演習１</h1>
      <h2 class="pt-3">データベース検索</h2>
    </div><!--/.container-->
  </header>
  <!-- ▲▲ヘッダー▲▲--------------------------------- -->

  <div class="container-field">
    <div class="row">
      <div class=" p-3 d-grid gap-2 d-md-flex justify-content-md-end">
        <a class="btn btn-danger btn-lg me-md-5" href="kadai10_1.php">新規登録</a>
      </div>
    </div>
    <div class="row border h-75">
      <div class="col-3 border">
        <form action="kadai08_1.php" method="GET" class="mt-5 m-3">

          <!-- 検索 -->
          <div class="row">
            <label class="form-label" for="name">NAME</label>
            <input class="form-control form-control-lg" type="text" name="name" value="">
          </div><!-- .row -->

          <div class="row">
            <label class="form-label" for="category">CATEGORY</label>
            <select class="form-select form-select-lg mb-3" name="category">
              <option value="1">全ての商品</option>
              <option value="2">ピザ</option>
              <option value="3">ドリンク</option>
            </select>
          </div><!-- .row -->

          <div class="row">
            <div class="pt-5 px-0 d-grid gap-2 d-md-flex justify-content-md-end">
              <input class="btn btn-primary btn-lg" type="submit" value="検索">
            </div><!-- .p-5 d-grid gap-2 d-md-flex justify-content-md-end -->
          </div><!-- .row -->

        </form>
      </div><!-- .col-3 border -->

      <div class="col-9 border">

        <table class="table table-hover mt-5 form-control-lg">
          <thead class="table-light text-secondary">
            <tr>
              <th>商品番号</th>
              <th>商品名</th>
              <th>カテゴリ</th>
              <th>価格</th>
              <th>編集</th>
              <th>削除</th>
            </tr>
          </thead>
          <tbody>
            <!--ここから-->
            <?php foreach ($result as $r): ?>
            <tr>
              <td><?=h($r["product_no"])?></td>
              <td><?=h($r["pname"])?></td>
              <td><?=h($r["category"])?></td>
              <td><?=h($r["price"])?></td>
              <!-- TODO:「編集」「削除」各リンク先は課題10以降で追加。 -->
              <td><a class="btn btn-primary" href="kadai11_1.php?product_no=<?=$r["product_no"]?>">編集</a></td>
              <td><a class="btn btn-secondary" href="kadai11_3.php?product_no=<?=$r["product_no"]?>">削除</a></td>
            </tr>
            <?php endforeach?>
            <!--ここまで-->
          </tbody>
        </table>

      </div><!-- .col-9 border -->
    </div><!-- .row border h-75 -->
  </div><!-- .container-field -->

</body>

</html>
