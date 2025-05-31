<?php
session_start(); // セッションを開始
// echo "Session user ID: " . $_SESSION['user_id'] . "<br>";
// echo "Result array: <pre>" . print_r($result, true) . "</pre>";
// セッションにユーザーIDが保存されているかをチェックし、保存されていない場合はログインページにリダイレクトする
if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit;
}

// セッションからユーザーIDを取得
$user_id = $_SESSION["user_id"];

// ログアウト処理
if (isset($_POST['logout'])) {
    // セッション変数を破棄
    session_unset();
    session_destroy();
    // ログインページなどへリダイレクトする
    header("Location: login.php");
    exit();
}

ob_start();

// ファイルの読み込み
require_once "./Safety indication def.php";
require_once "./Safety indication utils.php";

$result = [];

// getデータの取得
$date = filter_input(INPUT_GET, "date");
$name = filter_input(INPUT_GET, "name");
$id = filter_input(INPUT_GET, "id");
$filter = filter_input(INPUT_GET, "filter", FILTER_VALIDATE_INT);
$department = filter_input(INPUT_GET, "department");
$comment = filter_input(INPUT_GET, "comment");

//****************************************************************************************/

// 1.PDOクラスのインスタンス化
try {
    $dsn = "mysql:host=localhost;dbname=COS;charset=utf8mb4";
    $db = new PDO($dsn, DB_USER, DB_PASS);

    // 2.PDOの動作オプションを指定
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

    // 3.SQLの準備
    $sql = "SELECT * FROM STAFF WHERE 1";

    // パラメータをバインド
    $params = [];

    if ($name) {
        $nameLike = "%" . $name . "%";
        $sql .= " AND SNAME LIKE ?";
        $params[] = $nameLike;
    }
    if ($id) {
        $idLike = "%" . $id . "%";
        $sql .= " AND id LIKE ?";
        $params[] = $idLike;
    }
    if ($department) {
        $departmentLike = "%" . $department . "%";
        $sql .= " AND department LIKE ?";
        $params[] = $departmentLike;
    }
    if ($filter && $filter !== 0) {
        if ($filter === 1) {
            $fname = '無事';
        } elseif ($filter === 2) {
            $fname = '被害あり';
        }
        $sql .= " AND FILTER = ?";
        $params[] = $filter;
    }

    // 登録日が新しい順に並べ替える
    $sql .= " ORDER BY date DESC";

    $stmt = $db->prepare($sql);

    // SQLの実行
    $stmt->execute($params);

    // 結果の取得
    while ($rows = $stmt->fetch(PDO::FETCH_ASSOC)) {
        if ($rows['filter'] !== null) { // 安否がnullでない場合のみ結果に追加
            $result[] = $rows;
        }
    }

    // DB切断
    $stmt = null;
    $db = null;
} catch (PDOException $poe) {
    exit("DBエラー" . $poe->getMessage());
}

ob_flush();
?>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>災害時連絡掲示板</title>
    <link href="./styles/Safety indication2.css" rel="stylesheet">
</head>

<body>
    <!-- ヘッダー -->
    <header class="bg-info">
        <div class="text-light ms-5 pt-5 pb-3">
            <h1>災害時連絡掲示板</h1>
        </div>
    </header>

    <div class="container-field">

        

        <div class="row">
            <div class=" p-3 d-grid gap-2 d-md-flex justify-content-md-end">
                <a class="btn btn-danger btn-lg me-md-5" href="Reanpi.php">安否登録</a>
            </div>
        </div>

        <div class="row border h-75">
            <div class="col-3 border">
                <form action="Safety indication.php" method="GET" class="mt-5 m-3">
                    <div class="row">
                        <label class="form-label" for="name">名前</label>
                        <input id="name" class="form-control form-control-lg" type="text" name="name" value="<?= isset($name) ? htmlspecialchars($name, ENT_QUOTES) : '' ?>" placeholder="例:山本太郎">

                        <label class="form-label" for="id">社員番号</label>
                        <input id="id" class="form-control form-control-lg" type="text" name="id" value="<?= isset($id) ? htmlspecialchars($id, ENT_QUOTES) : '' ?>" placeholder="例:123456">

                        <label class="form-label" for="department">部署</label>
                        <input id="department" class="form-control form-control-lg" type="text" name="department" value="<?= isset($department) ? htmlspecialchars($department, ENT_QUOTES) : '' ?>" placeholder="例:営業">
                    </div>

                    <div class="row">
                        <label class="form-label" for="filter">安否状況</label>
                        <select class="form-select form-select-lg mb-3" name="filter" id="filter">
                            <option value="0" <?= ($filter == 0) ? 'selected' : '' ?>>全て</option>
                            <option value="1" <?= ($filter == 1) ? 'selected' : '' ?> style="color: green;">無事</option>
                            <option value="2" <?= ($filter == 2) ? 'selected' : '' ?> style="color: red;">被害あり</option>
                        </select>
                    </div>

                    <div class="row">
                        <div class="pt-5 px-0 d-grid gap-2 d-md-flex justify-content-md-end">
                            <input class="btn btn-primary btn-lg" type="submit" value="検索">
                        </div>
                    </div>
                </form>
            </div>

            <div class="col-9 border">
                <table class="table table-hover mt-5 form-control-lg">
                    <thead class="table-light text-secondary">
                        <tr>
                            <th>登録日</th>
                            <th>社員番号</th>
                            <th>名前</th>
                            <th>部署</th>
                            <th>安否</th>
                            <th>コメント</th>
                            <th>編集</th>
                            <th>削除</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--ここから-->
                        <?php foreach ($result as $r): ?>
                        <tr>
                            <td><?= isset($r["date"]) ? htmlspecialchars($r["date"], ENT_QUOTES) : '' ?></td>
                            <td><?= isset($r["id"]) ? htmlspecialchars($r["id"], ENT_QUOTES) : '' ?></td>
                            <td><?= isset($r["sname"]) ? htmlspecialchars($r["sname"], ENT_QUOTES) : '' ?></td>
                            <td><?= isset($r["department"]) ? htmlspecialchars($r["department"], ENT_QUOTES) : '' ?></td>
                            <td style="color: <?= ($r["filter"] == 1) ? 'green' : (($r["filter"] == 2) ? 'red' : 'black') ?>">
                                <?= isset($r["filter"]) && $r["filter"] == 1 ? '無事' : (isset($r["filter"]) && $r["filter"] == 2 ? '被害あり' : '') ?></td>
                            <td><?= isset($r["comment"]) ? htmlspecialchars($r["comment"], ENT_QUOTES) : '' ?></td>
                            <!-- ユーザーの社員番号とデータベースの社員番号を比較して、編集と削除のリンクを表示する -->
                            <?php if (isset($_SESSION['user_id']) && isset($r['id']) && $_SESSION['user_id'] === $r['id']): ?>
                            <td><a class="btn btn-primary" href="edit.php?id=<?= isset($r["id"]) ? htmlspecialchars($r["id"], ENT_QUOTES) : '' ?>">編集</a></td>
                            <td><a class="btn btn-secondary" href="delete.php?id=<?= isset($r["id"]) ? htmlspecialchars($r["id"], ENT_QUOTES) : '' ?>">削除</a></td>
                            <?php else: ?>
                            <td>-</td>
                            <td>-</td>
                            <?php endif; ?>
                        </tr>
                        <?php endforeach ?>
                        <!--ここまで-->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- ログアウトボタン -->
    <form action="" method="post">
            <div class="text-end mt-3 me-5">
                <button class="btn btn-secondary" type="submit" name="logout">ログアウト</button>
            </div>
        </form>
</body>

</html>
