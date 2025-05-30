<?php
// ファイルの読み込み
require_once "./def.php";
require_once "./utils.php";

$result = [];

// 課題9 getデータの取得
$product_no = filter_input(INPUT_GET, "product_no");

// GETデータがない場合は一覧画面に遷移
if (!$product_no) {
    header("Location: kadai08_1.php");
    exit();
}

try {
    // 1. PDOクラスのインスタンス化
    $dsn = "mysql:host=localhost;dbname=studb;charset=utf8mb4";
    $db = new PDO($dsn, DB_USER, DB_PASS);

    // 2. PDOの動作オプションを指定
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

    // 3. SQLの準備
    $sql = "SELECT * FROM OLDPRODUCT";
    // 課題9追加処理　product_noの値からWHERE句の作成する
    $where = " WHERE product_no=:product_no";
    $stmt = $db->prepare($sql . $where);

    // 商品番号の値をバインド
    if ($product_no) {
        $stmt->bindParam(':product_no', $product_no, PDO::PARAM_STR);
    }

    // 4. SQLの実行
    $stmt->execute();

    // 5. 結果セットの取得
    while ($rows = $stmt->fetch(PDO::FETCH_ASSOC)) {
        $result[] = $rows;
    }
} catch (PDOException $poe) {
    exit("DBエラー" . $poe->getMessage());
} finally {
    // 6. DB切断
    $stmt = null;
    $db = null;
}

// 課題９でNAMEとCATEGORYの条件を追加して検索
?>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>kadai11_3 削除</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <!-- ▼▼ヘッダー▼▼--------------------------------- -->
    <header class="bg-info">
        <div class="text-light ms-5 pt-5 pb-3">
            <h1 class="h6">サーバーサイドスクリプト演習１</h1>
            <h2 class="pt-3">データベース削除</h2>
        </div><!--/.text-light ms-5 pt-5 pb-3-->
    </header>
    <!-- ▲▲ヘッダー▲▲--------------------------------- -->

    <!-- ▼▼メイン▼▼----------------------------------- -->
    <main>
        <div class="form-control">
            <form action="kadai11_4.php" method="POST" novalidate>
                <div class="p-5 row">
                    <div class="col-md-5">

                        <!-- 確認メッセージ -->
                        <div class="col">
                            <p class="text-danger fs-5 fw-bold">
                                下記のデータを削除します。
                            </p>
                        </div>

                        <!-- 商品番号 -->
                        <div class="col">
                            <label class="form-label" for="product_no">商品番号</label>
                            <input type="text" name="product_no" id="product_no" class="form-control form-control-lg border-info bg-light" value="<?= htmlspecialchars($result[0]['product_no'] ?? '', ENT_QUOTES, 'UTF-8') ?>" readonly>
                        </div>

                        <!-- カテゴリ＆価格 -->
                        <div class="row">
                            <div class="col">
                                <!-- カテゴリ -->
                                <label class="form-label" for="category">カテゴリ</label>
                                <p class="form-control form-control-lg border-info bg-light" name="category">
                                    <?= htmlspecialchars($result[0]['category'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                                </p>
                            </div><!-- .col -->

                            <!-- 価格 -->
                            <div class="col">
                                <label class="form-label" for="price">価格</label>
                                <p name="price" id="price" class="form-control form-control-lg border-info bg-light">
                                    <?= htmlspecialchars($result[0]['price'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                                </p>
                            </div><!-- .col -->
                        </div><!-- .row -->

                        <!-- 商品名 -->
                        <div class="col">
                            <label class="form-label" for="pname">商品名</label>
                            <p name="pname" id="pname" class="form-control form-control-lg border-info bg-light">
                                <?= htmlspecialchars($result[0]['pname'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                            </p>
                        </div><!-- .col -->

                    </div><!-- .col-md-5 -->

                </div><!-- .p-5 row -->

                <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-start">
                    <button type="submit" class="btn btn-danger btn-lg">削除</button>
                    <a class="btn btn-secondary btn-lg" href="kadai08_1.php">戻る</a>
                </div><!-- .p-5 d-grid gap-2 d-md-flex justify-content-md-end -->
            </form>
        </div><!--/.form-control-->
    </main>
    <!-- ▲▲メイン▲▲------------------------------------ -->

</body>

</html>
