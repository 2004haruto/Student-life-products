<?php
session_start();
require_once "./def.php"; // データベース接続情報

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

// VISIBLEをトグルする関数
function toggleVisible($pNumber) {
    try {
        $db = getDbConnection();
        $sql = "UPDATE wish_list SET VISIBLE = CASE WHEN VISIBLE = 1 THEN 0 ELSE 1 END WHERE PNumber = :pNumber";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(':pNumber', $pNumber, PDO::PARAM_INT);
        $stmt->execute();
        return true;
    } catch (PDOException $e) {
        return false;
    }
}

// POSTリクエストがあるか確認
if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_POST['id'])) {
    $pNumber = $_POST['id']; // POSTされたアイテムのID

    // VISIBLEをトグルする
    if (toggleVisible($pNumber)) {
        // 成功したらAddSavings.phpにリダイレクト
        $redirectUrl = "AddSavings.php?id=" . $pNumber;
        header("Location: $redirectUrl");
        exit;
    } else {
        echo "Failed to toggle VISIBLE.";
    }
} else {
    echo "Invalid request.";
}
?>
