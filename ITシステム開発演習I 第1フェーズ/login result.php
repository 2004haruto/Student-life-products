<?php
// ユーザーがフォームを送信した場合の処理
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // フォームから送信された社員番号とパスワードを取得
    $id = $_POST["id"];
    $password = $_POST["password"];

    // データベース接続情報を含む外部ファイルを読み込む
    require_once "./Safety indication def.php";
    require_once "./Safety indication utils.php";
    
    try {
        // データベースに接続
        $dsn = "mysql:host=localhost;dbname=COS;charset=utf8mb4";
        $db = new PDO($dsn, DB_USER, DB_PASS);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        // SQLクエリを準備
        $sql = "SELECT * FROM staff WHERE id = :id AND password = :password";
        $stmt = $db->prepare($sql);

        // パラメータをバインド
        $stmt->bindParam(":id", $id);
        $stmt->bindParam(":password", $password);

        // SQLクエリを実行
        $stmt->execute();

        // ユーザーが見つかった場合はログイン成功
        if ($stmt->rowCount() > 0) {
            // ログイン情報をセッションに保存
            session_start();
            $_SESSION["logged_in"] = true;
            $_SESSION["user_id"] = $id;

            // ログイン成功後にリダイレクトする場合はここに遷移先のURLを記述
            header("Location: Safety indication.php");
            exit;
        } else {
            // ユーザーが見つからなかった場合はログイン失敗
            $error_message = "社員番号またはパスワードが間違っています。";
        }
    } catch (PDOException $e) {
        // エラーが発生した場合はエラーメッセージを表示
        $error_message = "データベースエラー: " . $e->getMessage();
    }
}
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link href="./styles/login result.css" rel="stylesheet">
    <title>ログイン結果</title>
</head>
<body>
    <h1>ログイン結果</h1>
    <?php if (isset($error_message)): ?>
        <p><?php echo $error_message; ?></p>
    <?php endif; ?>
</body>
</html>
