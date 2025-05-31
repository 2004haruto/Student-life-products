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

if (isset($_POST['id']) && isset($_SESSION['user_id'])) {
    $pNumber = $_POST['id'];
    $user_id = $_SESSION['user_id'];

    try {
        $db = getDbConnection();
        $db->beginTransaction();

        // ステータスを更新
        $sql = "UPDATE wish_list SET VISIBLE = CASE WHEN VISIBLE = 1 THEN 0 ELSE 1 END WHERE PNumber = :pNumber";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(':pNumber', $pNumber, PDO::PARAM_INT);
        $stmt->execute();

        // 残高を更新
        $price_sql = "SELECT PRICE, VISIBLE FROM wish_list WHERE PNumber = :pNumber";
        $price_stmt = $db->prepare($price_sql);
        $price_stmt->bindParam(':pNumber', $pNumber, PDO::PARAM_INT);
        $price_stmt->execute();
        $row = $price_stmt->fetch(PDO::FETCH_ASSOC);

        if ($row) {
            $price = $row['PRICE'];
            $visible = $row['VISIBLE'];

            // 残高を更新するクエリ
            $update_sql = "UPDATE deposit 
                           SET AMOUNT = AMOUNT + CASE 
                               WHEN :visible = 1 THEN - :price 
                               ELSE :price 
                           END 
                           WHERE USER_ID = :user_id";
            $update_stmt = $db->prepare($update_sql);
            $update_stmt->bindParam(':price', $price, PDO::PARAM_INT);
            $update_stmt->bindParam(':visible', $visible, PDO::PARAM_INT);
            $update_stmt->bindParam(':user_id', $user_id, PDO::PARAM_STR);
            $update_stmt->execute();
        } else {
            echo "error: 商品が見つかりませんでした。";
        }

        $db->commit();
        echo "success";
    } catch (PDOException $e) {
        $db->rollBack();
        echo "error: " . $e->getMessage();
    }
} else {
    echo "invalid request";
}
?>
