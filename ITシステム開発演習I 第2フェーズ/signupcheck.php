<?php

require_once __DIR__ . "./def.php"; // パスを修正

$result = [
    "status"  => true,
    "message" => null,
    "result"  => null,
];

// フォームから送られた値を取得する
$id = filter_input(INPUT_POST, "id");
$name = filter_input(INPUT_POST, "name");
$mail = filter_input(INPUT_POST, "mail");
$password = filter_input(INPUT_POST, "password");

// 名前の空白文字を置き換える
$name = str_replace(" ", "", $name); // 半角スペースを削除
$name = str_replace("　", "", $name); // 全角スペースを削除

// 名前が空かどうかのチェック
if (!$name) {
    $result["status"] = false;
    $result["message"] .= "名前を入力してください。<br>";
}

// 社員番号が空かどうかのチェック
if (!$id) {
    $result["status"] = false;
    $result["message"] .= "IDを入力してください。<br>";
}

// メールアドレスが空かどうかのチェック
if (!$mail) {
    $result["status"] = false;
    $result["message"] .= "メールアドレスを入力してください。<br>";
}

// パスワードが空かどうかのチェック
if (!$password) {
    $result["status"] = false;
    $result["message"] .= "パスワードを入力してください。<br>";
}

// 入力チェックがOKの場合はINSERT処理を行う
if ($result["status"]) {
    try {
        $dsn = "mysql:host=localhost;dbname=SM;charset=utf8mb4";
        $db = new PDO($dsn, DB_USER, DB_PASS);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
        $db->beginTransaction(); // トランザクション開始

        // 入力されたIDのレコードがあるかチェックする
        $sqlSelect = "SELECT COUNT(ID) FROM USER WHERE ID = :ID LIMIT 1";
        $stmt = $db->prepare($sqlSelect);
        $stmt->bindParam(':ID', $id, PDO::PARAM_STR);
        $stmt->execute();
        $count = $stmt->fetchColumn();

        if ($count == 0) {
            // プレースホルダーを使用したSQL文の作成
            $sql = "INSERT INTO USER (ID, NAME, MAIL_ADDRESS, PASSWORD) VALUES (:ID, :NAME, :MAIL_ADDRESS, :PASSWORD)";
            // SQLの準備
            $stmt = $db->prepare($sql);
            // プレースホルダーのバインド
            $stmt->bindParam(':ID', $id, PDO::PARAM_STR);
            $stmt->bindParam(':NAME', $name, PDO::PARAM_STR);
            $stmt->bindParam(':MAIL_ADDRESS', $mail, PDO::PARAM_STR);
            $stmt->bindParam(':PASSWORD', $password, PDO::PARAM_STR);
            // SQL実行
            $stmt->execute();
            // SQL実行結果件数の取得
            $result["result"] = $stmt->rowCount(); // 直前のexecuteした件数

            // 挿入件数によってコミットかロールバックする
            if ($result["result"] === 1) {
                // トランザクション確定
                $db->commit();
                header("location:login.php");
            } else {
                $db->rollBack();
                $result["message"] = "アカウントの登録に失敗しました。<br>";
            }
        } else {
            $result["message"] = "アカウントがすでに存在します。<br>";
        }
    } catch (PDOException $poe) {
        exit("DBエラー" . $poe->getMessage());
    } finally {
        // DB切断
        $stmt = null;
        $db = null;
    }
}
?>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    
</body>
</html>
