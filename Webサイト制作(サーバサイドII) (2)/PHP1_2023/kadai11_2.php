<?php
require_once __DIR__ . "/def.php";

$result = [
    "status"  => true,
    "message" => null,
    "result"  => null,
];

// form から送られた値を取得する
$product_no = filter_input(INPUT_POST, "product_no");
$category = filter_input(INPUT_POST, "category", FILTER_VALIDATE_INT);
$pname = filter_input(INPUT_POST, "pname");
$price = filter_input(INPUT_POST, "price", FILTER_VALIDATE_INT);

// 商品番号が4桁数字かのチェック（違う場合は登録画面へ遷移）
if (!preg_match("/^([0-9]{4})$/", $product_no)) {
    $result["status"] = false;
    $result["message"] .= "商品番号は4桁の数字を入力してください。<br>";
}

// 商品名の空白文字を置き換え
$pname = str_replace(" ", "", $pname); // 半角スペースを空文字に置き換え
// 全角スペースを空文字に置き換え
$pname = str_replace("　", "", $pname);

// 商品名が空かどうかのチェック
if (!$pname) {
    $result["status"] = false;
    $result["message"] .= "商品名を入力してください。<br>";
}

// 価格が空かどうかのチェック
if (!$price) {
    $result["status"] = false;
    $result["message"] .= "価格を入力してください。<br>";
}

// カテゴリのコードから商品名に置き換え
if ($category === 1) {
    $category_name = 'ピザ';
} elseif ($category === 2) {
    $category_name = 'ドリンク';
} else {
    $category_name = '不明';
}

// 入力チェックが OK の時にここから UPDATE 処理
if ($result["status"]) {

    // DB 接続
    try {
        $dsn = "mysql:host=localhost;dbname=studb;charset=utf8mb4";
        $db = new PDO($dsn, DB_USER, DB_PASS); // PDO クラスのインスタンス化

        // 2.PDO の動作オプションを指定
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); // 例外クラスをスローする
        $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false); // 静的プレースホルダの設定

        ////////商品番号存在チェック///////////////////

        // 入力された商品番号のレコードがあるかチェックする SQL（LIMIT 句はパフォーマンスのため今回はなくても OK）
        $sqlSelect = "SELECT count(PRODUCT_NO) FROM OLDPRODUCT WHERE PRODUCT_NO = :product_no AND 1 LIMIT 1";
        // SQL の準備とバインド
        $stmt = $db->prepare($sqlSelect);
        $stmt->bindParam(':product_no', $product_no, PDO::PARAM_INT);
        // SQL の実行
        $stmt->execute();
        // SQL の実行結果 $count の中に上記 SQL に実行結果がセットされているので、その内容で UPDATE するかどうか
        // 処理を振り分ける
        $count = $stmt->fetchColumn();

        ///////商品番号存在チェックここまで////////////

        // 商品番号が存在した場合のみ UPDATE 文を作成して実行
        if ($count == 1) {

            // プレースホルダーを使用した SQL 文の作成
            $sql = "UPDATE OLDPRODUCT SET PNAME = :pname, CATEGORY = :category, PRICE = :price WHERE PRODUCT_NO = :product_no";

            // SQL の準備
            $stmt = $db->prepare($sql);
            // プレースホルダーに値をバインド
            $stmt->bindParam(':product_no', $product_no, PDO::PARAM_STR);
            $stmt->bindParam(':category', $category_name, PDO::PARAM_STR);  // カテゴリ名を使用
            $stmt->bindParam(':pname', $pname, PDO::PARAM_STR);
            $stmt->bindParam(':price', $price, PDO::PARAM_INT);
            // SQL 実行
            $stmt->execute();
            // SQL 実行結果件数の取得
            $result["result"] = $stmt->rowCount(); // 直前の execute した件数

            // 挿入件数によってコミットかロールバックする
            if ($result["result"] === 1) {
                // トランザクション確定
                $db->commit();
                $result["message"] = "データの更新に成功しました！<br>";
                // 更新成功の場合、kadai08_1.php に遷移
                header("Location: kadai08_1.php");
                exit();
            }
            // 件数が違うのでロールバック
            else {
                $db->rollBack();
                $result["message"] = "データの更新に失敗しました。<br>";
            }
        } // UPDATE 処理ここまで
        else {
            $result["message"] = "商品番号が存在しません。更新に失敗しました。<br>";
        }
    } catch (PDOException $poe) {
        exit("DBエラー" . $poe->getMessage());
    } finally {
        // 6.DB 切断
        $stmt = null;
        $db = null;
    }
} // 入力チェック OK の UPDATE 処理ここまで
?>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>kadai11_2 更新結果</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <!-- ▼▼ヘッダー▼▼--------------------------------- -->
    <header class="bg-info">
        <div class="text-light ms-5 pt-5 pb-3">
            <h1 class="h6">サーバーサイドスクリプト演習１</h1>
            <h2 class="pt-3">データベース更新結果</h2>
        </div><!--/.text-light ms-5 pt-5 pb-3-->
    </header>
    <!-- ▲▲ヘッダー▲▲--------------------------------- -->

    <!-- ▼▼メイン▼▼----------------------------------- -->
    <main>
        <div class="form-control">

            <div class="p-5 row">
                <div class="col-md-5">
                    <!-- エラーメッセージ -->
                    <div class="col">
                        <?php if (!$result["status"]) : ?>
                            <p class="text-danger"><?= $result["message"] ?></p>
                        <?php endif; ?>
                    </div><!-- .col -->

                    <!-- 戻るボタン（入力画面に戻る） -->
                    <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-start">
                        <a class="btn btn-secondary btn-lg" href="kadai11_1.php?product_no=<?= htmlspecialchars($product_no ?? '', ENT_QUOTES, 'UTF-8') ?>">戻る</a>
                    </div><!-- .p-5 d-grid gap-2 d-md-flex justify-content-md-end -->

                </div><!-- .col-md-5 -->

            </div><!-- .p-5 row -->
        </div><!--/.form-control-->
    </main>
    <!-- ▲▲メイン▲▲------------------------------------ -->

</body>

</html>
