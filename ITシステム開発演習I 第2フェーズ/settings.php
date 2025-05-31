<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();

if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit;
}

require_once "./def.php";
$dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_EMULATE_PREPARES => false,
];

function getDbConnection() {
    global $dsn, $options;
    return new PDO($dsn, DB_USER, DB_PASS, $options);
}

function getUser($user_id) {
    $db = getDbConnection();
    $sql = "SELECT * FROM USER WHERE ID = :user_id";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

function getTargetSavings($user_id) {
    $db = getDbConnection();
    $sql = "SELECT * FROM DEPOSIT WHERE USER_ID = :user_id";
    $stmt = $db->prepare($sql);
    $stmt->execute(['user_id' => $user_id]);
    return $stmt->fetch(PDO::FETCH_ASSOC);
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $hourly_wage = isset($_POST['hourly_wage']) ? intval($_POST['hourly_wage']) : null;
    $target_amount = isset($_POST['target_amount']) ? intval($_POST['target_amount']) : null;
    $limit_amount = isset($_POST['limit_amount']) ? intval($_POST['limit_amount']) : null;
    $current_amount = isset($_POST['current_amount']) ? intval($_POST['current_amount']) : null;

    try {
        $db = getDbConnection();

        // 時給を更新するクエリ
        $stmt_update_wage = $db->prepare("UPDATE USER SET HOURLY_WAGE = :hourly_wage WHERE ID = :user_id");
        $stmt_update_wage->execute(['hourly_wage' => $hourly_wage, 'user_id' => $_SESSION["user_id"]]);

        // 貯金目標額、所得制限額、現在の貯金残高をDEPOSITテーブルに挿入または更新
        $stmt_deposit = $db->prepare("SELECT * FROM DEPOSIT WHERE USER_ID = :user_id");
        $stmt_deposit->execute(['user_id' => $_SESSION["user_id"]]);
        $row_count_deposit = $stmt_deposit->rowCount();

        if ($row_count_deposit > 0) {
            $stmt_update_deposit = $db->prepare("UPDATE DEPOSIT SET TARGET_AMOUNT = :target_amount, LIMIT_AMOUNT = :limit_amount, AMOUNT = :current_amount WHERE USER_ID = :user_id");
            $stmt_update_deposit->execute(['target_amount' => $target_amount, 'limit_amount' => $limit_amount, 'current_amount' => $current_amount, 'user_id' => $_SESSION["user_id"]]);
        } else {
            $stmt_insert_deposit = $db->prepare("INSERT INTO DEPOSIT (TARGET_AMOUNT, LIMIT_AMOUNT, AMOUNT, USER_ID) VALUES (:target_amount, :limit_amount, :current_amount, :user_id)");
            $stmt_insert_deposit->execute(['target_amount' => $target_amount, 'limit_amount' => $limit_amount, 'current_amount' => $current_amount, 'user_id' => $_SESSION["user_id"]]);
        }

        // 成功したらteam_friends.phpにリダイレクト
        header("Location: team_friends.php");
        exit;
    } catch (PDOException $poe) {
        exit("DBエラー: " . $poe->getMessage());
    }
}

$db = getDbConnection();
$user = getUser($_SESSION["user_id"]);
$deposit = getTargetSavings($_SESSION["user_id"]);
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>設定</title>
    <link rel="stylesheet" href="./styles/settings.css">
</head>
<body>
    <header>
        <h1>設定</h1>
        <nav>
            <a href="team_friends.php">ホーム</a>
        </nav>
    </header>
    <main>
        <form method="post" action="">
            <div class="form-group">
                <label for="current_amount">現在の貯金残高（円）:</label>
                <input type="number" id="current_amount" name="current_amount" min="0" value="<?= htmlspecialchars($deposit['AMOUNT'] ?? '', ENT_QUOTES, 'UTF-8'); ?>">
            </div>
            <div class="form-group">
                <label for="hourly_wage">時給（円）:</label>
                <input type="number" id="hourly_wage" name="hourly_wage" min="0" value="<?= htmlspecialchars($user['HOURLY_WAGE'] ?? '', ENT_QUOTES, 'UTF-8'); ?>">
            </div>
            <div class="form-group">
                <label for="target_amount">貯金目標額（円）:</label>
                <input type="number" id="target_amount" name="target_amount" min="0" value="<?= htmlspecialchars($deposit['TARGET_AMOUNT'] ?? '', ENT_QUOTES, 'UTF-8'); ?>">
            </div>
            <div class="form-group">
                <label for="limit_amount">所得制限額（円）:</label>
                <input type="number" id="limit_amount" name="limit_amount" min="0" value="<?= htmlspecialchars($deposit['LIMIT_AMOUNT'] ?? '', ENT_QUOTES, 'UTF-8'); ?>">
            </div>
            <div class="form-group submit-group">
                <button type="submit">更新</button>
            </div>
        </form>
    </main>
</body>
</html>
