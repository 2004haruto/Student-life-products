<?php
session_start();

// データベース接続設定
require_once "./def.php"; // DB_USER, DB_PASS, DB_HOST, DB_NAME が定義されているファイルを読み込む
$dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_EMULATE_PREPARES => false,
];

// データベース接続関数
function getDbConnection() {
    global $dsn, $options;
    return new PDO($dsn, DB_USER, DB_PASS, $options);
}

// ユーザー情報を取得する関数
function getUser($user_id) {
    $db = getDbConnection();
    $sql = "SELECT * FROM USER WHERE ID = :user_id";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

// ユーザーがログインした場合にセッション変数にユーザーIDを設定する
$_SESSION["user_id"] = "1111"; // ここで適切なユーザーIDを設定する必要があります

// ユーザー情報を取得
$user = getUser($_SESSION["user_id"]);

// 時給を取得する関数
function getHourlyWage($user_id) {
    $user = getUser($user_id);
    return isset($user['HOURLY_WAGE']) ? $user['HOURLY_WAGE'] : 0;
}

// 働いた時間を取得する関数
function getWorkedHours($user_id) {
    // ここで働いた時間を取得する処理を追加
    // デモのため、0を返すようにします
    return 0;
}

// 貯金目標額を取得する関数
function getTargetAmount($user_id) {
    $db = getDbConnection();
    $sql = "SELECT TARGET_AMOUNT FROM DEPOSIT WHERE USER_ID = :user_id ORDER BY DNumber DESC LIMIT 1";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetchColumn();
}

// 現在の貯金残高を取得する関数
function getCurrentAmount($user_id) {
    $db = getDbConnection();
    $sql = "SELECT AMOUNT FROM DEPOSIT WHERE USER_ID = :user_id ORDER BY DNumber DESC LIMIT 1";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetchColumn();
}

// 所得制限額を計算する関数
function getLimitAmount($user_id) {
    $target_amount = getTargetAmount($user_id);
    $current_amount = getCurrentAmount($user_id);
    return $target_amount - $current_amount;
}

// データベースから情報を取得する
try {
    $db = getDbConnection();

    // ユーザー情報取得
    $user = getUser($_SESSION["user_id"]);

    // 貯金情報取得
    $stmt = $db->query("SELECT * FROM DEPOSIT ORDER BY DNumber DESC LIMIT 1");
    $deposit = $stmt->fetch(PDO::FETCH_ASSOC);

    // 欲しいものリストの取得（フィルターに基づいて取得）
    $filter = filter_input(INPUT_GET, 'filter', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    switch ($filter) {
        case 'unpurchased':
            $filter_query = "WHERE VISIBLE = 0";
            break;
        case 'purchased':
            $filter_query = "WHERE VISIBLE = 1";
            break;
        default:
            $filter_query = "";
            break;
    }
    $sql = "SELECT * FROM WISH_LIST {$filter_query} ORDER BY PNumber DESC"; // LIMIT句を追加して上位3つのアイテムを取得
    $stmt = $db->prepare($sql);
    $stmt->execute();
    $wish_list = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // DB切断
    $stmt = null;
    $db = null;
} catch (PDOException $poe) {
    exit("DBエラー: " . $poe->getMessage());
}

?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欲しいものリスト</title>
    <link rel="stylesheet" href="./styles/team_friends.css">
</head>
<body>
<section id="wish_list">
    <h2>欲しいものリスト</h2>
    <form method="get" action="edit_wish.php">
            <button type="submit">編集</button>
        </form>
    <!-- フィルターオプション -->
    <form method="get" action="">
        <label for="filter">フィルター:</label>
        <select name="filter" id="filter" onchange="this.form.submit()">
            <option value="all" <?= $filter == 'all' ? 'selected' : ''; ?>>すべて</option>
            <option value="unpurchased" <?= $filter == 'unpurchased' ? 'selected' : ''; ?>>未購入</option>
            <option value="purchased" <?= $filter == 'purchased' ? 'selected' : ''; ?>>購入済み</option>
        </select>
    </form>
    <!-- 欲しいものリストのアイテムをここに表示 -->
    <table>
        <thead>
            <tr>
                <th>商品名</th>
                <th>金額</th>
                <th>購入後の貯金</th>
                <th>商品リンク</th>
                <th>ステータス</th>
            </tr>
        </thead>
        <tbody>
            <?php
            if (!empty($wish_list)) {
                foreach ($wish_list as $item) {
                    $product = htmlspecialchars($item['PRODUCT'] ?? '', ENT_QUOTES, 'UTF-8');
                    $price = htmlspecialchars($item['PRICE'] ?? '', ENT_QUOTES, 'UTF-8');
                    $link = htmlspecialchars($item['LINK'] ?? '', ENT_QUOTES, 'UTF-8'); // リンクもエスケープ
                    $difference = $deposit['AMOUNT'] - $price;
                    $class = $item['VISIBLE'] == 0 ? 'unpurchased' : 'purchased';
                    echo "<tr>";
                    echo "<td>{$product}</td>";
                    echo "<td>¥" . number_format($price) . "</td>";
                    echo "<td>¥" . number_format($difference) . "</td>";
                    echo "<td><a href='{$link}' target='_blank'>{$link}</a></td>"; // リンクをクリック可能にし、テキストとして表示
                    echo "<td class='$class'>";
                    if ($item['VISIBLE'] == 0) {
                        echo "未購入";
                    } else {
                        echo "購入済み";
                    }
                    echo "</td>";
                    echo "</tr>";
                }
            } else {
                echo "<tr><td colspan='5'>欲しいものリストはありません。</td></tr>";
            }
            ?>
        </tbody>
    </table>
</section>
<footer></footer>
<!-- JavaScriptファイルのリンク -->
<script src="./scripts/team_friends.js"></script>
</body>
</html>
