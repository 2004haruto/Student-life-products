<?php
session_start();
require_once "./def.php"; // データベース接続情報

$dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_EMULATE_PREPARES => false,
];

function getDbConnection() {
    global $dsn, $options;
    return new PDO($dsn, DB_USER, DB_PASS, $options);
}

if (isset($_POST['id'])) {
    $pNumber = $_POST['id'];
    try {
        $db = getDbConnection();
        $sql = "UPDATE wish_list SET VISIBLE = CASE WHEN VISIBLE = 1 THEN 0 ELSE 1 END WHERE PNumber = :pNumber";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(':pNumber', $pNumber, PDO::PARAM_INT);
        $stmt->execute();
        echo "success";
    } catch (PDOException $e) {
        echo "error: " . $e->getMessage();
    }
} else {
    echo "invalid request";
}
?>
