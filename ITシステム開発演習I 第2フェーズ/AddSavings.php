<?php
session_start();
require_once "./def.php"; // データベース接続情報

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

// IDでアイテムを取得する関数
function getItemById($id) {
    try {
        $db = getDbConnection();
        $sql = "SELECT PRODUCT, PRICE FROM wish_list WHERE PNumber = :id";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_ASSOC);
    } catch (PDOException $e) {
        return false;
    }
}

// GETパラメータからIDを取得
if (isset($_GET['id'])) {
    $id = $_GET['id'];
    
    // IDに基づいてアイテムを取得
    $item = getItemById($id);
    if ($item) {
        $product = htmlspecialchars($item['PRODUCT']);
        $price = htmlspecialchars($item['PRICE']);
    } else {
        $error_message = "Failed to fetch item details.";
    }
} else {
}
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>家計管理</title>
    <link rel="stylesheet" href="./styles/styles.css">
</head>
<body>
<header>
    <h1>カケイボ</h1>
</header>
<main>
    <?php if (!empty($error_message)): ?>
        <p><?php echo $error_message; ?></p>
    <?php else: ?>
        <section id="add-entry">
            <form id="income-form" action="AddSavingsCheck.php" method="post">
                <h3>給料の追加</h3>
                <input type="hidden" name="type" value="income">
                <label for="income-amount">金額:</label>
                <input type="number" id="income-amount" name="income-amount" required>
                <button type="submit">追加</button>
            </form>
            <form id="expense-form" action="AddSavingsCheck.php" method="post">
                <h3>支出の追加</h3>
                <input type="hidden" name="type" value="expense">
                <label for="description">内容:</label>
                <input type="text" id="description" name="description" value="<?php echo isset($product) ? $product : ''; ?>" required>
                <label for="expense-amount">金額:</label>
                <input type="number" id="expense-amount" name="expense-amount" value="<?php echo isset($price) ? $price : ''; ?>" required>
                <button type="submit">追加</button>
            </form>
            <form id="fixed-expense-form" action="AddSavingsCheck.php" method="post">
                <h3>固定支出の追加</h3>
                <input type="hidden" name="type" value="fixed-expense">
                <label for="fixed-description">内容:</label>
                <input type="text" id="fixed-description" name="fixed-description" required>
                <label for="fixed-amount">金額:</label>
                <input type="number" id="fixed-amount" name="fixed-amount" required>
                <button type="submit">追加</button>
            </form>
        </section>
    <?php endif; ?>
    <button onclick="location.href='SavingsManegement.php'" id="back-button">戻る</button>
</main>
</body>
</html>

