<?php
session_start();
require_once "./def.php"; // データベース接続情報

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_FULL_SPECIAL_CHARS);

    if ($id && $password) {
        try {
            $dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
            $db = new PDO($dsn, DB_USER, DB_PASS);

            $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

            // ユーザー名とパスワードをチェックするためのクエリを作成
            $sql = "SELECT * FROM USER WHERE ID = :id AND PASSWORD = :password";
            $stmt = $db->prepare($sql);
            $stmt->execute(['id' => $id, 'password' => $password]);
            $user = $stmt->fetch(PDO::FETCH_ASSOC);

            if ($user) {
                // 認証成功時の処理
                $_SESSION['user_id'] = $id;
                header("Location: team_friends.php");
                exit();
            } else {
                // 認証失敗時の処理
                echo "IDまたはパスワードが間違っています";
            }
        } catch (PDOException $poe) {
            exit("DBエラー: " . $poe->getMessage());
        }
    } else {
        echo "すべてのフィールドを入力してください。";
    }
}
?>
