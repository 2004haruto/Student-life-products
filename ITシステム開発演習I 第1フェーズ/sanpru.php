<!DOCTYPE html>
<html lang="ja">
    
<head>
    <meta charset="UTF-8">
    <title>登録結果</title>
    <link rel="stylesheet" href="./styles/sanpru.css">
</head>
<body>
    <h1>登録結果</h1>
    <?php
    // データベースに接続するための情報
    $dsn = 'mysql:dbname=COS;host=localhost';
    $username = 'muser';
    $password = 'mmm';

    // データベースに登録する情報を取得
    $sname = $_GET['uname']; // 名前
    $department = $_GET['department'];
    $id = $_GET['ruby']; // 社員番号
    $password2 = $_GET['password']; // パスワード

    // 登録した情報を表示
    echo "<p>お名前: $sname</p>";
    echo "<p>所属部署: $department</p>";
    echo "<p>社員番号: $id</p>";
    echo "<p>パスワード: $password2</p>";

    try {
        // データベースに接続
        $db = new PDO($dsn, $username, $password);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        // SQLクエリを準備
        $sql = "INSERT INTO staff (sname, department, id, password) VALUES (:sname, :department, :id, :password)";
        $stmt = $db->prepare($sql);

        // パラメータをバインド
        $stmt->bindParam(':sname', $sname);
        $stmt->bindParam(':department',$department);
        $stmt->bindParam(':id', $id);
        $stmt->bindParam(':password', $password2);

        // SQLクエリを実行
        $stmt->execute();

        // 登録成功メッセージ
        echo "<p>登録が完了しました。</p>";

        // データベース接続を閉じる
        $db = null;
    } catch (PDOException $e) {
        // エラーメッセージを表示
        echo "エラー: " . $e->getMessage();
    }
    ?>
    <!-- ログイン画面に遷移するボタン -->
    <a href="login.php">ログイン画面に戻る</a>
</body>
</html>
