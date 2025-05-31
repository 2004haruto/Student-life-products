<?php
// add_item.php

session_start(); // セッションの開始

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // データベース接続設定
    require_once "./def.php"; // DB_USER, DB_PASS, DB_HOST, DB_NAME が定義されているファイルを読み込む
    
    // データベースに接続
    $dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
    $options = [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_EMULATE_PREPARES => false,
    ];

    try {
        // データベース接続
        $conn = new PDO($dsn, DB_USER, DB_PASS, $options);
        
        // POSTデータを取得
        $item_name = $_POST["item_name"];
        $price = $_POST["price"];
        $url = $_POST["url"];
        
        // セッションからユーザーIDを取得（仮の実装）
        $user_id = isset($_SESSION["user_id"]) ? $_SESSION["user_id"] : 1; // 仮の値。実際にはセッションから取得する必要があります。

        // SQL文を準備
        $sql = "INSERT INTO wish_list (USER_ID, PRODUCT, price, link) VALUES (:user_id, :item_name, :price, :url)";
        $stmt = $conn->prepare($sql);

        // バインドパラメータを設定して実行
        $stmt->bindValue(':user_id', $user_id, PDO::PARAM_INT); // ユーザーIDのバインド
        $stmt->bindValue(':item_name', $item_name, PDO::PARAM_STR);
        $stmt->bindValue(':price', $price, PDO::PARAM_INT);
        $stmt->bindValue(':url', $url, PDO::PARAM_STR);
        
        $stmt->execute();

        echo "New record created successfully";
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }

    // 接続を閉じる
    $conn = null;

    // リダイレクト
    header("Location: test2.php");
    exit;
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>追加</title>
    <link rel="stylesheet" href="./styles/hosiimono.css">
</head>
<body>

<h2>商品追加フォーム</h2>
<form method="post" action="test4.php">
  商品名: <input type="text" name="item_name" required>
  <br><br>
  値段: <input type="text" name="price" required>
  <br><br>
  URL: <input type="text" name="url" required>
  <br><br>
  <input type="submit" name="submit" value="登録">
</form>

</body>
</html>
