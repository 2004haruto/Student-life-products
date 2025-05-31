<?php
// ファイルの読み込み
require_once "./Safety indication def.php";
require_once "./Safety indication utils.php";

$result = [];

// 課題9 getデータの取得
$name = filter_input(INPUT_GET, "name");
$id = filter_input(INPUT_GET, "id");
$filter = filter_input(INPUT_GET, "filter", FILTER_VALIDATE_INT);
$department = filter_input(INPUT_GET, "department");
$comment = filter_input(INPUT_GET,"comment");

// GETデータがない場合は一覧画面に遷移
if (!$id) {
    header("Location: Safety indication.php");
    exit();
}

try {
    // 1. PDOクラスのインスタンス化
    $dsn = "mysql:host=localhost;dbname=COS;charset=utf8mb4";
    $db = new PDO($dsn, DB_USER, DB_PASS);

    // 2. PDOの動作オプションを指定
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

    // 3. SQLの準備
    $sql = "SELECT * FROM STAFF";
    // 課題9追加処理　product_noの値からWHERE句の作成する
    $where = " WHERE id=:id";
    $stmt = $db->prepare($sql . $where);

    // 商品番号の値をバインド
    if ($id) {
        $stmt->bindParam(':id', $id, PDO::PARAM_STR);
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
    <title>災害時連絡掲示板</title>
    <link href="./styles/delete.css" rel="stylesheet">
</head>

<body>
    <!-- ▼▼ヘッダー▼▼--------------------------------- -->
    <header class="bg-info">
        <div class="text-light ms-5 pt-5 pb-3">
            <h1>災害時連絡掲示板</h1>
        </div><!--/.text-light ms-5 pt-5 pb-3-->
    </header>
    <!-- ▲▲ヘッダー▲▲--------------------------------- -->

    <!-- ▼▼メイン▼▼----------------------------------- -->
    <main>
        <div class="form-control">
            <form action="delete result.php" method="POST" novalidate>
                <div class="p-5 row">
                    <div class="col-md-5">

                        <!-- 確認メッセージ -->
                        <div class="col">
                            <p class="text-danger fs-5 fw-bold">
                                下記のデータを削除します。
                            </p>
                        </div>

                        <!-- 名前 -->
                        <div class="col">
                            <label class="form-label" for="name">名前</label>
                            <p name="sname" id="sname" class="form-control form-control-lg border-info bg-light">
                                <?= htmlspecialchars($result[0]['sname'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                            </p>
                        </div><!-- .col -->

                        <!-- 社員番号 -->
                        <div class="col">
                            <label class="form-label" for="id">社員番号</label>
                            <p name="id" id="id" class="form-control form-control-lg border-info bg-light">
                                <?= htmlspecialchars($result[0]['id'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                            </p>
                        </div><!-- .col -->

                        <!-- 被害報告 -->
                        <div class="col">
                            <label class="form-label" for="filter">被害報告</label>
                            <p name="filter" id="filter" class="form-control form-control-lg border-info bg-light">
                                <?= htmlspecialchars($result[0]['filter'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                            </p>
                        </div><!-- .col -->

                        <!-- 部署 -->
                        <div class="col">
                            <label class="form-label" for="department">部署</label>
                            <p name="department" id="department" class="form-control form-control-lg border-info bg-light">
                                <?= htmlspecialchars($result[0]['department'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                            </p>
                        </div><!-- .col -->

                        <!-- コメント -->
                        <div class="col">
                            <label class="form-label" for="comment">コメント</label>
                            <p name="comment" id="comment" class="form-control form-control-lg border-info bg-light">
                                <?= htmlspecialchars($result[0]['comment'] ?? '', ENT_QUOTES, 'UTF-8') ?>
                            </p>
                        </div><!-- .col -->


                    </div><!-- .col-md-5 -->

                </div><!-- .p-5 row -->

                <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-start">
                    <button type="submit" class="btn btn-danger btn-lg">削除</button>
                    <a class="btn btn-secondary btn-lg" href="Safety indication.php">戻る</a>
                </div><!-- .p-5 d-grid gap-2 d-md-flex justify-content-md-end -->
            </form>
        </div><!--/.form-control-->
    </main>
    <!-- ▲▲メイン▲▲------------------------------------ -->

</body>

</html>
