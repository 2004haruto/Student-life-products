<?php

require_once __DIR__ . "/def.php";

// TODO:第2段階で追加（各入力値チェック）　↓↓↓-------------------
$result = [
  "status"  => true,
  "message" => null,
  "result"  => null,
];

//formから送られた値を取得する
$product_no=filter_input(INPUT_POST,"product_no");
$category=filter_input(INPUT_POST,"category",FILTER_VALIDATE_INT);
$pname=filter_input(INPUT_POST,"pname");
$price =filter_input(INPUT_POST,"price",FILTER_VALIDATE_INT);

//商品番号が4桁数字かのチェック（違う場合は登録画面へ遷移）
if(!preg_match("/^([0-9]{4})$/",$product_no)){
  $result["status"] = false;
  $result["message"] .= "商品番号は4桁の数字を入力してください。<br>";
}

//商品名の空白文字を置き換え
$pname=str_replace(" ","",$pname);//半角スペースを空文字に置き換え
//全角スペースを空文字に置き換え
$pname=str_replace("　","",$pname);

//商品名が空かどうかのチェック
if(!$pname){
  $result["status"] = false;
  $result["message"] .= "商品名を入力してください。<br>";
}

//価格が空かどうかのチェック
if(!$price){
  $result["status"] = false;
  $result["message"] .= "価格を入力してください。<br>";
}


//カテゴリのコードから商品名に置き換え
if($category === 1){
  $category_name = 'ピザ';
}else{
  $category_name = 'ドリンク';
}

//入力チェックがOKの時にここからINSERT処理
if($result["status"]){

//DB接続
try{
  $dsn = "mysql:host=localhost;dbname=studb;charset=utf8mb4";
  $db = new PDO($dsn, DB_USER, DB_PASS);//PDOクラスのインスタンス化
  
  ////2.PDOの動作オプションを指定
  $db->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);//例外クラスをスローする
  $db->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);//静的プレースホルダの設定

////////商品番号存在チェック///////////////////

//入力された商品番号のレコードがあるかチェックするSQL(LIMIT句はパフォーマンスのため今回はなくてもOK)
$sqlSelect = "SELECT count(PRODUCT_NO) FROM OLDPRODUCT WHERE PRODUCT_NO = :product_no LIMIT 1";
//SQLの準備とバインド
$stmt = $db->prepare($sqlSelect);
$stmt->bindParam('product_no', $product_no, PDO::PARAM_INT);
//SQLの実行
$stmt->execute();
//SQLの実行結果$countの中に上記SQLに実行結果がセットされているので、その内容でINSERTするかどうか
//処理を振り分ける
$count = $stmt->fetchColumn();

///////商品番号存在チェックここまで////////////

//商品番号が存在しなかった場合のみINSERT文を作成して実行
if($count == 0){

  //プレースホルダーを使用したSQL文の作成
$sql = "INSERT INTO OLDPRODUCT VALUES(:product_no,:pname,:category,:price)";

//SQLの準備
$stmt = $db->prepare($sql);
//プレースホルダーのバインド
$stmt->bindParam('product_no', $product_no, PDO::PARAM_STR);
$stmt->bindParam('category', $category, PDO::PARAM_STR);
$stmt->bindParam('pname', $pname, PDO::PARAM_STR);
$stmt->bindParam('price', $price, PDO::PARAM_INT);

//SQL実行
$stmt->execute();
//SQL実行結果件数の取得
$result["result"] = $stmt->rowCount();//直前のexecuteした件数

//挿入件数によってコミットかロールバックする
if ($result["result"] === 1) {
    // トランザクション確定
    $db->commit();
    $result["message"] = "データの登録に成功しました!******。<br>";
}
//件数が違うのでロールバック
else {
    $db->rollBack();
    $result["message"] = "データの登録に失敗しました↓↓↓↓↓↓。<br>";
}
}//INSERT処理ここまで
else{
    $result["message"] = "商品番号が既に存在します。別の番号を試してください。<br>";
}

}catch(PDOException $poe){
  exit("DBエラー".$poe->getMessage());
}finally{
  //6.DB切断
  $stmt=null;
  $db=null;

}


}//入力チェックOKのINSERT処理ここまで


?>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>php1 - kadai10_2</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
  <div class="w-100">

    <!-- ▼▼ヘッダー▼▼--------------------------------- -->
    <header class="bg-info">
      <div class="text-light ms-3 pt-4 pb-3">
        <h1 class="h6">サーバーサイドスクリプト演習１</h1>
        <h2 class="pt-3">データベース登録結果</h2>
      </div><!--/.container-->
    </header>
    <!-- ▲▲ヘッダー▲▲--------------------------------- -->

    <!-- ▼▼メイン▼▼----------------------------------- -->
    <main>

      <div class="form-control">

        <h3 class="border-bottom border-3 border-info mb-4 mt-2 pb-2">データベース登録結果</h3>

        <div id="frame" class="p-5 border-info rounded" style="border:1px dashed;">

          <!-- 処理結果表示 -->
          <div class="text-center">


            <p class="text-danger"><?=$result["message"]?></p>
          </div>
        </div>

        <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-end">
          <a class="btn btn-secondary btn-lg" href="kadai10_1.php">戻る</a>
        </div>

      </div>
    </main>

  </div><!--/.w100-->

</body>

</html>