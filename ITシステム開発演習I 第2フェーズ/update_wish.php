<?php
session_start();

// データベース接続設定
require_once "./def.php"; // DB_USER, DB_PASS, DB_HOST, DB_NAME が定義されているファイルを読み込む
$dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_EMULATE_PREPARES => false,
];

// データベース接続関数
function getDbConnection() {
    global $dsn, $options;
    return new PDO($dsn, DB_USER, DB_PASS, $options);
}

try {
    $db = getDbConnection();

    // フォームから送信されたデータを取得
    $products = $_POST['product'] ?? [];
    $prices = $_POST['price'] ?? [];
    $links = $_POST['link'] ?? [];
    $statuses = $_POST['status'] ?? [];

    // データベースの欲しいものリストを更新
    for ($i = 0; $i < count($products); $i++) {
        $product = $products[$i];
        $price = $prices[$i];
        $link = $links[$i];
        $status = $statuses[$i];

        // プリペアドステートメントを使用してデータを更新
        $stmt = $db->prepare("UPDATE WISH_LIST SET PRODUCT = ?, PRICE = ?, LINK = ?, VISIBLE = ? WHERE PNumber = ?");
        $stmt->execute([$product, $price, $link, $status, $i + 1]);
    }

    // データベースの更新が完了したらwish_list.phpにリダイレクト
    header("Location: wish_list.php");
    exit();
} catch (PDOException $e) {
    echo "データベースエラー: " . $e->getMessage();
}
?>
