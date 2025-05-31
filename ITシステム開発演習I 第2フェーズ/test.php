<?php

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

// SQLクエリの作成
$sql = "SELECT link url FROM wish_list";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html>
<head>
    <title>URL Links</title>
</head>
<body>
    <h1>URL Links</h1>
    <ul>
        <?php
        // データが存在するか確認
        if ($result->num_rows > 0) {
            // 各行データを出力
            while($row = $result->fetch_assoc()) {
                echo "<li><a href='" . $row["url"] . "'>" . $row["url"] . "</a></li>";
            }
        } else {
            echo "0 results";
        }
        $conn->close();
        ?>
    </ul>
</body>
</html>
