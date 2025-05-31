<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();

if (isset($_POST['logout'])) {
    $_SESSION = array();
    session_destroy();
    header("Location: login.php");
    exit;
}

if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit;
}

require_once "./def.php"; // DB_USER, DB_PASS, DB_HOST, DB_NAME が定義されているファイルを読み込む

function getDbConnection() {
    $dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
    $options = [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_EMULATE_PREPARES => false,
    ];
    return new PDO($dsn, DB_USER, DB_PASS, $options);
}

function getUserData($user_id) {
    $db = getDbConnection();
    $stmt = $db->prepare("SELECT * FROM USER WHERE ID = :user_id");
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

function getUserDeposit($user_id) {
    $db = getDbConnection();
    $stmt = $db->prepare("SELECT * FROM DEPOSIT WHERE USER_ID = :user_id ORDER BY DNumber DESC LIMIT 1");
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

function getHourlyWage($user_id) {
    $user = getUserData($user_id);
    return isset($user['HOURLY_WAGE']) ? $user['HOURLY_WAGE'] : 0;
}

function getLimitAmount($user_id) {
    $db = getDbConnection();
    $sql = "SELECT LIMIT_AMOUNT FROM DEPOSIT WHERE USER_ID = :user_id ORDER BY DNumber DESC LIMIT 1";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetchColumn();
}

function getTotalIncomeForYear($user_id, $year) {
    $db = getDbConnection();
    $sql = "SELECT SUM(SALARY) FROM INCOME WHERE USER_ID = :user_id AND YEAR(DATE) = :year";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id, 'year' => $year]);
    return $stmt->fetchColumn();
}

function getRemainingLimitAfterIncome($user_id, $year) {
    $limit_amount = getLimitAmount($user_id);
    $total_income_for_year = getTotalIncomeForYear($user_id, $year);
    return $limit_amount - $total_income_for_year;
}

function getWorkedHours($user_id) {
    // ここで実際の実装が必要
    return 0; // 仮の値を返す
}

function getTargetAmount($user_id) {
    $db = getDbConnection();
    $sql = "SELECT TARGET_AMOUNT FROM DEPOSIT WHERE USER_ID = :user_id ORDER BY DNumber DESC LIMIT 1";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetchColumn();
}

function getCurrentAmount($user_id) {
    $db = getDbConnection();
    $sql = "SELECT AMOUNT FROM DEPOSIT WHERE USER_ID = :user_id ORDER BY DNumber DESC LIMIT 1";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetchColumn();
}

function getWishList($user_id, $filter) {
    $db = getDbConnection();
    switch ($filter) {
        case 'unpurchased':
            $stmt = $db->prepare("SELECT * FROM WISH_LIST WHERE USER_ID = :user_id AND VISIBLE = 0");
            break;
        case 'purchased':
            $stmt = $db->prepare("SELECT * FROM WISH_LIST WHERE USER_ID = :user_id AND VISIBLE = 1");
            break;
        default:
            $stmt = $db->prepare("SELECT * FROM WISH_LIST WHERE USER_ID = :user_id");
            break;
    }
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

$user_id = $_SESSION["user_id"];
$user = getUserData($user_id);
$deposit = getUserDeposit($user_id);
$wish_list = getWishList($user_id, filter_input(INPUT_GET, 'filter', FILTER_SANITIZE_FULL_SPECIAL_CHARS) ?? 'all');

try {
    // 所得制限を計算
    $limit_amount = getLimitAmount($user_id);
    $hourly_wage = getHourlyWage($user_id);
    $hours_workable = $hourly_wage > 0 ? $limit_amount / $hourly_wage : 0;
    $hours_remaining = $hours_workable - getWorkedHours($user_id);

    // 年ごとの収入を取得
    $year = filter_input(INPUT_GET, 'year', FILTER_SANITIZE_NUMBER_INT) ?? date('Y');
    $remaining_limit_after_income = getRemainingLimitAfterIncome($user_id, $year);
    $total_income_for_year = getTotalIncomeForYear($user_id, $year);

    // フィルターの取得
    $filter = filter_input(INPUT_GET, 'filter', FILTER_SANITIZE_FULL_SPECIAL_CHARS) ?? 'all';
} catch (PDOException $poe) {
    exit("DBエラー: " . $poe->getMessage());
}
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カケイボ</title>
    <!-- CSSファイルのリンク -->
    <link rel="stylesheet" href="./styles/team_friends.css">
</head>
<body>
<header>
    <h1>カケイボ</h1>
    <!-- ナビゲーションメニューやログイン情報などの追加 -->
    <form method="post" action="">
        <button type="submit" name="logout">ログアウト</button>
    </form>
    <form method="get" action="settings.php">
        <button type="submit">設定</button>
    </form>
    <form method="get" action="SavingsManegement.php">
        <button type="submit">収支・支出</button>
    </form>
</header>
<main>
    <section id="balance">
        <h2>貯金残高</h2>
        <p id="balanceAmount">
            ¥<?= isset($deposit['AMOUNT']) ? number_format($deposit['AMOUNT']) : '0'; ?>
        </p>
    </section>

    <section id="hourly_wage">
        <div style="display: flex; justify-content: space-between;">
            <div id="hourly_wage_now">
                <h2>現在の時給</h2>
                <p><?= isset($user['HOURLY_WAGE']) ? $user['HOURLY_WAGE'] : '未登録'; ?>円</p>
            </div>
        </div>
    </section>

    <section id="savings">
        <h2>貯金目標の¥<?= isset($deposit['TARGET_AMOUNT']) ? number_format($deposit['TARGET_AMOUNT']) : '0'; ?>まで残り</h2>
        <p id="savingsGoal">
            ¥<?= isset($deposit['TARGET_AMOUNT']) && isset($deposit['AMOUNT']) ? number_format($deposit['TARGET_AMOUNT'] - $deposit['AMOUNT']) : '0'; ?>
        </p>
    </section>

    <section id="limittime">
        <h2>所得制限の¥<?= isset($deposit['LIMIT_AMOUNT']) ? number_format($deposit['LIMIT_AMOUNT']) : '0'; ?>まで残り勤務可能時間</h2>
        <p id="limitTimeRemaining">
            <?= $hours_remaining > 0 ? number_format($hours_remaining, 2) : '0'; ?> 時間
        </p>
    </section>

    <section id="limitmoney">
    <h2>所得制限の<?= isset($deposit['LIMIT_AMOUNT']) ? '¥' . number_format($deposit['LIMIT_AMOUNT']) : '0'; ?>までの残り金額</h2>
    <p id="limitAmountRemaining">
        <?= isset($remaining_limit_after_income) ? '¥' . number_format($remaining_limit_after_income) : '¥0'; ?>
    </p>
    <form method="get" action="">
        <label for="year">年を選択:</label>
        <select name="year" id="year" onchange="this.form.submit()">
            <?php
            $current_year = date('Y');
            for ($y = $current_year; $y >= $current_year - 10; $y--) {
                $selected = ($y == $year) ? "selected" : "";
                echo "<option value='$y' $selected>$y</option>";
            }
            ?>
        </select>
    </form>
    <p>選択した年の総所得: <?= isset($total_income_for_year) ? '¥' . number_format($total_income_for_year) : '¥0'; ?></p>
</section>

    <section id="wish_list">
            <form method="get" action="test2.php">
            <h2>欲しいものリスト</h2>
                <button type="submit">詳細</button>
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
                        <th>ステータス</th>
                    </tr>
                </thead>
                <tbody>
    <?php
    if (!empty($wish_list)) {
        foreach ($wish_list as $item) {
            $product = htmlspecialchars($item['PRODUCT'], ENT_QUOTES, 'UTF-8');
            $price = htmlspecialchars($item['PRICE'], ENT_QUOTES, 'UTF-8');
            $difference = $deposit['AMOUNT'] - $price;
            $class = $item['VISIBLE'] == 0 ? 'unpurchased' : 'purchased';
            echo "<tr>";
            echo "<td>{$product}</td>";
            echo "<td>¥" . number_format($price) . "</td>";
            echo "<td>¥" . number_format($difference) . "</td>";
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
        echo "<tr><td colspan='4'>欲しいものリストはありません。</td></tr>";
    }
    ?>
                </tbody>
            </table>
        </section>
</main>
<footer>
    <p>&copy; <?= date('Y'); ?> お助け隊</p>
</footer>

<script>
    function applyFilter() {
        var filter = document.getElementById('filter').value;
        var year = document.getElementById('year').value; // 年の選択値を取得
        var url = 'team_friends.php?filter=' + filter + '&year=' + year; // リダイレクト先のURLを組み立て
        window.location.href = url; // ページをリダイレクト
    }
</script>

</body>
</html>
