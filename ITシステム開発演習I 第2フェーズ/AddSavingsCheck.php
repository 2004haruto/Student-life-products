<?php
// データベース接続設定
$host = 'localhost';
$db = 'sm';
$user = 'oda';
$pass = 'taka';
$charset = 'utf8mb4';

$dsn = "mysql:host=$host;dbname=$db;charset=$charset";
$options = [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES   => false,
];

try {
    $pdo = new PDO($dsn, $user, $pass, $options);
} catch (\PDOException $e) {
    throw new \PDOException($e->getMessage(), (int)$e->getCode());
}

session_start(); // セッションを開始
$user_id = isset($_SESSION['user_id']) ? $_SESSION['user_id'] : null; // ログインしているユーザーのIDを取得

if ($user_id === null) {
    echo "<script>alert('ユーザーIDがセッションに設定されていません。ログインしてください。'); window.location.href = 'login.php';</script>";
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $date = date('Y-m-d H:i:s');
    $type = $_POST['type'];

    if ($type === 'income') {
        $amount = $_POST['income-amount'];
        $pdo->beginTransaction();
        try {
            // 給料の追加
            $sql = "INSERT INTO income (user_id, date, salary) VALUES (:user_id, :date, :salary)";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['user_id' => $user_id, 'date' => $date, 'salary' => $amount]);

            // 貯金残高の更新
            $sql = "UPDATE deposit SET amount = amount + :amount WHERE user_id = :user_id";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['user_id' => $user_id, 'amount' => $amount]);

            $pdo->commit();
            echo "<script>alert('給料が追加され、貯金残高が更新されました。'); window.location.href = 'SavingsManegement.php';</script>";
        } catch (\Exception $e) {
            $pdo->rollBack();
            throw $e;
        }
    } elseif ($type === 'expense') {
        $description = $_POST['description'];
        $amount = $_POST['expense-amount'];
        $pdo->beginTransaction();
        try {
            // 支出の追加
            $sql = "INSERT INTO spending (user_id, date, buyproduct, price) VALUES (:user_id, :date, :buyproduct, :price)";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['user_id' => $user_id, 'date' => $date, 'buyproduct' => $description, 'price' => $amount]);

            // 貯金残高の更新
            $sql = "UPDATE deposit SET amount = amount - :amount WHERE user_id = :user_id";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['user_id' => $user_id, 'amount' => $amount]);

            $pdo->commit();
            echo "<script>alert('支出が追加され、貯金残高が更新されました。'); window.location.href = 'SavingsManegement.php';</script>";
        } catch (\Exception $e) {
            $pdo->rollBack();
            throw $e;
        }
    } elseif ($type === 'fixed-expense') {
        $description = $_POST['fixed-description'];
        $amount = $_POST['fixed-amount'];
        $start_date = date('Y-m-01'); // 今月の初日を取得
        $next_due_date = date('Y-m-d', strtotime('+1 month', strtotime($start_date))); // 次回の支払日を計算
        $pdo->beginTransaction();
        try {
            // 固定支出の追加
            $sql = "INSERT INTO fixed_spending (user_id, fixed_expenses, price, start_date, next_due_date) VALUES (:user_id, :fixed_expenses, :price, :start_date, :next_due_date)";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['user_id' => $user_id, 'fixed_expenses' => $description, 'price' => $amount, 'start_date' => $start_date, 'next_due_date' => $next_due_date]);

            // 初回の支出を貯金残高から引く
            $sql = "UPDATE deposit SET amount = amount - :amount WHERE user_id = :user_id";
            $stmt = $pdo->prepare($sql);
            $stmt->execute(['user_id' => $user_id, 'amount' => $amount]);

            $pdo->commit();
            echo "<script>alert('固定支出が追加され、初回の支払いが貯金残高から引かれました。'); window.location.href = 'SavingsManegement.php';</script>";
        } catch (\Exception $e) {
            $pdo->rollBack();
            throw $e;
        }
    }
}
?>
<link rel="icon" href="/favicon.ico" type="image/x-icon">

