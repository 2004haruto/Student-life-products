<?php

require_once "./Safety indication def.php";
require_once "./Safety indication utils.php";

// POSTデータの取得
$date = filter_input(INPUT_POST, "date");
$name = filter_input(INPUT_POST, "name");
$id = filter_input(INPUT_POST, "id");
$filter = filter_input(INPUT_POST, "filter", FILTER_VALIDATE_INT);
$department = filter_input(INPUT_POST, "department");
$comment = filter_input(INPUT_POST,"comment");

// // POSTデータがない場合は一覧画面に遷移
// if (!$id) {
//     header("Location: Safety indication.php");
//     exit();
// }

// エラーメッセージ格納用変数
$error_message = "";
// 削除成功時のメッセージ
$message = "";

try {

    // データベースへの接続
    $dsn = "mysql:host=localhost;dbname=COS;charset=utf8mb4";
    $db = new PDO($dsn, DB_USER, DB_PASS);

    // エラーモードとエミュレートプリペアドステートメントを設定
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

    // トランザクション開始
    $db->beginTransaction();

    // SQLの準備
    $sqlSelect = "SELECT * FROM STAFF WHERE ID = :id";
    $stmtSelect = $db->prepare($sqlSelect);
    $stmtSelect->bindParam(':id', $id, PDO::PARAM_STR);
    $stmtSelect->execute();

    // レコードが存在する場合は削除処理
    if ($stmtSelect->rowCount() > 0) {
        $sqlDelete = "DELETE FROM STAFF WHERE ID = :id";
        $stmtDelete = $db->prepare($sqlDelete);
        $stmtDelete->bindParam(':id', $id, PDO::PARAM_STR);
        $stmtDelete->execute();

        // コミット
        $db->commit();

        // 削除成功時のメッセージ
        $message = "データを削除しました。";
    } else {
        // ロールバック
        $db->rollBack();
        // レコードが存在しない場合のエラーメッセージ
        $error_message = "指定された社員番号のデータが見つかりません。";
    }
} catch (PDOException $poe) {
    // エラーメッセージ
    $error_message = "エラー：" . $poe->getMessage();
    // ロールバック
    $db->rollBack();
} catch (Exception $e) {
    // 入力値エラーメッセージ
    $error_message = $e->getMessage();
    // ロールバック
    $db->rollBack();
} finally {
    // データベース接続を閉じる
    $stmtSelect = null;
    $stmtDelete = null;
    $db = null;
}
?>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>災害時連絡掲示板</title>

</head>

<body>
    <!-- ヘッダー -->
    <header class="bg-info">
        <div class="text-light ms-5 pt-5 pb-3">
            <h1>災害時連絡掲示板</h1>
        </div>
    </header>

    <!-- メイン -->
    <main>
        <div class="form-control">
            <div class="p-5 row">
                <div class="col-md-5">
                    <!-- エラーメッセージまたは削除成功メッセージの表示 -->
                    <div class="col">
                        <?php if (!empty($error_message)) : ?>
                            <p class="text-danger"><?= $error_message ?></p>
                        <?php else : ?>
                            <p class="text-success"><?= $message ?></p>
                        <?php endif; ?>
                    </div>

                    <!-- 戻るボタン -->
                    <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-start">
                        <a class="btn btn-secondary btn-lg" href="Safety indication.php">一覧・検索画面へ戻る</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>

</html>
