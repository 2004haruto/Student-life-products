<?php
// データベース接続設定
require_once "./def.php"; // DB_USER, DB_PASS, DB_HOST, DB_NAME が定義されているファイルを読み込む

// パラメータからIDを取得
$id = $_POST['id'] ?? null;

if ($id) {
    try {
        // データベース接続
        $dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
        $options = [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::ATTR_EMULATE_PREPARES => false,
        ];
        $db = new PDO($dsn, DB_USER, DB_PASS, $options);

        // SQLクエリの実行
        $sql = "DELETE FROM WISH_LIST WHERE ID = ?";
        $stmt = $db->prepare($sql);
        $stmt->execute([$id]);

        // 成功した場合、ステータスコード200を返す
        http_response_code(200);
    } catch (PDOException $e) {
        // エラーが発生した場合はエラーメッセージを返す
        http_response_code(500);
        echo "データベースエラー: " . $e->getMessage();
    }
} else {
    // IDが提供されていない場合はエラーを返す
    http_response_code(400);
    echo "IDが提供されていません";
}
?>
