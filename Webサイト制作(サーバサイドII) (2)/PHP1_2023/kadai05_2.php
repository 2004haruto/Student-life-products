<?php

// TODO：課題の仕様を確認
//echo"<pre>";
//echo var_dump($_FILES('upfile'));
//echo"<pre>";

// POST形式でなければ
if ($_SERVER["REQUEST_METHOD"] !== "POST") {
  header("Location: kadai05_1.php");	//kadai05_1.phpへ画面遷移
  exit;	// 処理を終了させる
}


  // $_FILES['upfile']が存在しない場合は強制終了
if(!isset($_FILES['upfile']['error'])|| !is_int($_FILES['upfile']['error'])){
  exit("エラー");
}



//変数の定義
$message = "";//エラーメッセージ
$status = true;//アップロード成功かどうか
$newfile="";//新しいファイル名
$extension="";//拡張子
if ($_FILES["upfile"]["error"] === UPLOAD_ERR_OK) {
  switch($_FILES["upfile"]["type"]){
    case "image/gif":
      $extension = ".gif";//拡張子の設定
      break;
    case "image/jpeg":
      $extension = ".jpg";
      break;
    case "image/png":
      $extension = ".png";
      break;
    default:
    $status=false;
    $message="画像ファイル以外はアップロードできません";
  }

  if($status){
    // リネーム処理
    $newfile = uniqid().$extension;
   // ・・・・・・・・・・・・・・・・・・・・・・・・・以下ファイル保存処理…………………………………

//アップロードはできているので、画像保存処理
    if(!move_uploaded_file($_FILES["upfile"]["tmp_name"],"./asset/storage/".$newfile)) {
        //保存できなかった場合は、エラーメッセージを出力
        $status = false;
        $message = "画像ファイルを保存できませんでした";
      }
    }
}else{
  //ファイルアップロードエラー
  $status = false;
  switch ($_FILES["upfile"]["error"]) {
    case UPLOAD_ERR_INI_SIZE:
    case UPLOAD_ERR_FORM_SIZE:
      $message =  "ファイルのサイズが大きすぎます";
      break;
    case UPLOAD_ERR_PARTIAL:
      $message ="通信環境が良くなってからもう一度お試しください";
      break;
    case UPLOAD_ERR_NO_FILE:
        $message="ファイルがありません";
        break;
      default:
        $message="システムの復旧後に再度アップロードしてください";
        break;
  }
}?>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>php1 - kadai05_2</title>
  <!-- TODO:bootstrapCSS読み込み -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
  <div class="w-100">

    <!-- ▼▼ヘッダー▼▼--------------------------------- -->
    <header class="bg-info">
      <div class="text-light ms-3 pt-4 pb-3">
        <h1 class="h6">サーバーサイドスクリプト演習１</h1>
        <h2 class="pt-3">画像のアップロード結果</h2>
      </div><!--/.container-->
    </header>
    <!-- ▲▲ヘッダー▲▲--------------------------------- -->

    <!-- ▼▼メイン▼▼----------------------------------- -->
    <main>

      <div class="form-control">

        <h3 class="border-bottom border-3 border-info mb-4 mt-2 pb-2">アップロード結果</h3>

        <div id="frame" class="p-5 border-info rounded" style="border:1px dashed;">

          <!-- ファイル結果表示箇所 -->
          <div class="text-center">
            <!-- TODO:ファイル結果表示 -->
            <!-- TODO:画像は正しく画像ファイルがアップロードされた場合のみ -->
            <?php if ($status) : ?>
            <figure class="d-inline-block me-1 mt-1 mb-5">
              <img src="./asset/storage/<?=$newfile?>">
            </figure>
            <!-- TODO:エラーがあった場合はメッセージのみ -->
            <?php else : ?>
              <p class="text-danger"><?= $message ?></p>
            <?php endif ?>
          </div>
        </div>

        <!-- TODO:戻るボタン押下で入力画面に戻る -->
        <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-end">
          <a class="btn btn-secondary btn-lg" href="kadai05_1.php">戻る</a>
        </div>

      </div>
    </main>

  </div><!--/.w100-->

</body>

</html>
