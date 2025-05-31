<?php
require_once __DIR__ . "/Safety indication def.php";
require_once "./Safety indication utils.php";

$result = [
    "status"  => true,
    "message" => null,
    "result"  => null,
];

// フォームからの入力を取得する
$name = filter_input(INPUT_POST, "name");
$id = filter_input(INPUT_POST, "id");
$filter = filter_input(INPUT_POST, "filter", FILTER_VALIDATE_INT);
$department = filter_input(INPUT_POST, "department");
$comment = filter_input(INPUT_POST, "comment");

// 更新日をDATETIME形式に変換する
$date = date('Y-m-d H:i:s'); // 現在の日付と時刻を取得


// 名前が空でない場合のみ空白文字を処理する
if ($name !== null) {
    $name = trim($name); // 先頭と末尾の空白を削除する
    if ($name === "") {
        $result["status"] = false;
        $result["message"] .= "名前を入力してください。<br>";
    }
}

// 社員番号が空かどうかをチェックする
if (!$id) {
    $result["status"] = false;
    $result["message"] .= "社員番号を入力してください。<br>";
}

// 部署が空かどうかをチェックする
if (!$department) {
    $result["status"] = false;
    $result["message"] .= "部署を入力してください。<br>";
}

// カテゴリコードからフィルタ名に変換する
if ($filter === 1) {
    $filter_name = 1; // 整数に変換
} elseif ($filter === 2) {
    $filter_name = 2; // 整数に変換
} else {
    $filter_name = 0; // 整数に変換
}

// 入力チェックがOKの場合はUPDATE処理を行う
if ($result["status"]) {
    try {
        $dsn = "mysql:host=localhost;dbname=COS;charset=utf8mb4";
        $db = new PDO($dsn, DB_USER, DB_PASS);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

        $db->beginTransaction(); // トランザクション開始

        // 更新日を現在の日付に設定する
        $date = date("Y-m-d H:i:s");

        // 社員番号が存在するかどうかをチェックする
        $sqlSelect = "SELECT count(ID) FROM STAFF WHERE ID = :id AND 1 LIMIT 1";
        $stmt = $db->prepare($sqlSelect);
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);
        $stmt->execute();
        $count = $stmt->fetchColumn();

        if ($count == 1) {
            $sql = "UPDATE STAFF SET SNAME = :name, FILTER = :filter, DATE = :date, DEPARTMENT = :department, COMMENT = :comment WHERE ID = :id";
            $stmt = $db->prepare($sql);
            $stmt->bindParam(':id', $id, PDO::PARAM_STR);
            $stmt->bindParam(':filter', $filter_name, PDO::PARAM_STR);
            $stmt->bindParam(':name', $name, PDO::PARAM_STR);
            $stmt->bindParam(':date', $date, PDO::PARAM_STR);
            $stmt->bindParam(':department', $department, PDO::PARAM_STR);
            $stmt->bindParam(':comment', $comment, PDO::PARAM_STR);
            $stmt->execute();
            $result["result"] = $stmt->rowCount();

            if ($result["result"] === 1) {
                $db->commit(); // コミット
                $result["message"] = "データの更新に成功しました！<br>";
                header("Location: Safety indication.php");
                exit();
            } else {
                $db->rollBack(); // ロールバック
                $result["message"] = "データの更新に失敗しました。<br>";
            }
        } else {
            $result["message"] = "商品番号が存在しません。更新に失敗しました。<br>";
        }
    } catch (PDOException $poe) {
        exit("DBエラー" . $poe->getMessage());
    } finally {
        $stmt = null;
        $db = null;
    }
}
?>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>更新</title>
    <link href="./styles/Safety indication.css" rel="stylesheet">
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
                    <!-- エラーメッセージ -->
                    <div class="col">
                        <?php if (!$result["status"]) : ?>
                            <p class="text-danger"><?= $result["message"] ?></p>
                        <?php endif; ?>
                    </div>

                    <!-- 戻るボタン -->
                    <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-start">
                        <a class="btn btn-secondary btn-lg" href="edit.php?id=<?= htmlspecialchars($id ?? '', ENT_QUOTES, 'UTF-8') ?>">戻る</a>
                    </div>

                </div>
            </div>
        </div>
    </main>
</body>

</html>
