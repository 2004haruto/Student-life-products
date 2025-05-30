<?php
require_once "./def.php";
require_once "./utils.php";

// POSTデータの取得
$product_no = filter_input(INPUT_POST, "product_no");

// POSTデータがない場合は一覧画面に遷移
if (!$product_no) {
    header("Location: kadai08_1.php");
    exit();
}

// エラーメッセージ格納用変数
$error_message = "";
// 削除成功時のメッセージ
$message = "";

try {
    // 商品番号の入力値チェック
    if (!preg_match('/^\d{4}$/', $product_no)) {
        throw new Exception("商品番号は4桁の数字で入力してください。");
    }

    // データベースへの接続
    $dsn = "mysql:host=localhost;dbname=studb;charset=utf8mb4";
    $db = new PDO($dsn, DB_USER, DB_PASS);

    // エラーモードとエミュレートプリペアドステートメントを設定
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

    // トランザクション開始
    $db->beginTransaction();

    // SQLの準備
    $sqlSelect = "SELECT * FROM OLDPRODUCT WHERE PRODUCT_NO = :product_no";
    $stmtSelect = $db->prepare($sqlSelect);
    $stmtSelect->bindParam(':product_no', $product_no, PDO::PARAM_STR);
    $stmtSelect->execute();

    // レコードが存在する場合は削除処理
    if ($stmtSelect->rowCount() > 0) {
        $sqlDelete = "DELETE FROM OLDPRODUCT WHERE PRODUCT_NO = :product_no";
        $stmtDelete = $db->prepare($sqlDelete);
        $stmtDelete->bindParam(':product_no', $product_no, PDO::PARAM_STR);
        $stmtDelete->execute();

        // コミット
        $db->commit();

        // 削除成功時のメッセージ
        $message = "データを削除しました。";
    } else {
        // ロールバック
        $db->rollBack();
        // レコードが存在しない場合のエラーメッセージ
        $error_message = "指定された商品番号のデータが見つかりません。";
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
    <title>kadai11_4 削除結果</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <!-- ヘッダー -->
    <header class="bg-info">
        <div class="text-light ms-5 pt-5 pb-3">
            <h1 class="h6">サーバーサイドスクリプト演習１</h1>
            <h2 class="pt-3">データベース削除結果</h2>
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
                        <a class="btn btn-secondary btn-lg" href="kadai08_1.php">一覧・検索画面へ戻る</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>

</html>
