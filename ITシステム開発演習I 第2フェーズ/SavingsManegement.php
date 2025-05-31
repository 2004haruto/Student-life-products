<?php

require_once "./def.php"; // データベース接続情報

function groupByMonth($data) {
    $groupedData = [];
    foreach ($data as $item) {
        $month = date("Y-m", strtotime($item['date']));
        if (!isset($groupedData[$month])) {
            $groupedData[$month] = [];
        }
        $groupedData[$month][] = $item;
    }
    return $groupedData;
}

try {
    // PDOクラスのインスタンス化
    $dsn = "mysql:host=localhost;dbname=SM;charset=utf8mb4";
    $db = new PDO($dsn, DB_USER, DB_PASS);
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // セッションを開始してログインしているユーザーのIDを取得
    session_start();
    $user_id = isset($_SESSION['user_id']) ? $_SESSION['user_id'] : null;

    if ($user_id === null) {
        throw new Exception("ユーザーIDがセッションに設定されていません。");
    }

    // 給料データの取得
    $incomeSql = "SELECT date, salary FROM income WHERE USER_ID = :user_id";
    $incomeStmt = $db->prepare($incomeSql);
    $incomeStmt->bindValue(':user_id', $user_id, PDO::PARAM_STR);
    $incomeStmt->execute();
    $incomeData = [];
    while ($row = $incomeStmt->fetch(PDO::FETCH_ASSOC)) {
        $incomeData[] = ["date" => $row['date'], "salary" => $row['salary']];
    }

    // 固定支出データの取得
    $fixedSpendingSql = "SELECT fixed_expenses, price FROM fixed_spending WHERE USER_ID = :user_id";
    $fixedSpendingStmt = $db->prepare($fixedSpendingSql);
    $fixedSpendingStmt->bindValue(':user_id', $user_id, PDO::PARAM_STR);
    $fixedSpendingStmt->execute();
    $fixedSpendingData = [];
    while ($row = $fixedSpendingStmt->fetch(PDO::FETCH_ASSOC)) {
        $fixedSpendingData[] = ["fixed_expenses" => $row['fixed_expenses'], "price" => $row['price']];
    }

    // 支出データの取得
    $spendingSql = "SELECT date, buyproduct, price FROM spending WHERE USER_ID = :user_id ORDER BY date ASC";
    $spendingStmt = $db->prepare($spendingSql);
    $spendingStmt->bindValue(':user_id', $user_id, PDO::PARAM_STR); // ユーザーIDをバインド（VARCHAR型なのでPDO::PARAM_STRを使用）
    $spendingStmt->execute();
    $spendingData = [];
    while ($row = $spendingStmt->fetch(PDO::FETCH_ASSOC)) {
        $spendingData[] = ["date" => $row['date'], "buyproduct" => $row['buyproduct'], "price" => $row['price']];
    }

    // 貯金残高の取得
    $depositSql = "SELECT SUM(amount) AS total_amount FROM deposit WHERE USER_ID = :user_id";
    $depositStmt = $db->prepare($depositSql);
    $depositStmt->bindValue(':user_id', $user_id, PDO::PARAM_STR);
    $depositStmt->execute();
    $depositData = $depositStmt->fetch(PDO::FETCH_ASSOC);
    $balance = $depositData['total_amount'];

    // 月ごとにデータをグループ化
    $groupedIncomeData = groupByMonth($incomeData);
    $groupedSpendingData = groupByMonth($spendingData);

    // 月ごとの支出合計を計算
    $monthlyTotalSpending = []; // 合計支出を格納する配列を初期化
    foreach ($groupedSpendingData as $month => $data) {
        $total = 0;
        foreach ($data as $item) {
            $total += $item['price']; // 支出データを合計
        }
        // 固定支出も合計に加算
        foreach ($fixedSpendingData as $fixedItem) {
            $total += $fixedItem['price'];
        }
        $monthlyTotalSpending[$month] = $total; // 月ごとの合計支出を配列に追加
    }

} catch (PDOException $poe) {
    exit("DBエラー: " . $poe->getMessage());
} catch (Exception $e) {
    exit("エラー: " . $e->getMessage());
} finally {
    // DB切断
    $incomeStmt = null;
    $spendingStmt = null;
    $depositStmt = null;
    $db = null;
}
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>家計簿サイト</title>
    <link rel="stylesheet" href="./styles/styles.css">
    <style>
        .column:last-child {
            margin-right: 0;
        }

        .expense-header {
            text-decoration: underline;
            text-decoration-color: red;
            font-size: 40px;
        }

        .income-header {
            text-decoration: underline;
            text-decoration-color: blue;
            font-size: 40px;
        }

        .fixed-expense-header {
            text-decoration: underline;
            text-decoration-color: green;
            font-size: 40px;
        }

        .month-header {
            text-decoration: underline;
            text-decoration-color: black;
            font-size: 40px;
        }
        .flex-container {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            flex-wrap: wrap;
        }
        .flex-container .column {
            width: 48%;
        }
        .column {
            float: left;
            width: 48%;
            margin-right: 2%;
            box-sizing: border-box;
        }

        .column:last-child {
            margin-right: 0;
        }

        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }
    </style>
</head>
<body>
<header>
    <h1>カケイボ</h1>
</header>
<main>
    <section id="balance-section">
        <h2>貯金残高: <?= isset($balance) ? number_format($balance) : '0'; ?> 円</h2>
        <button onclick="location.href='AddSavings.php'" id="settings-button">追加</button>
    </section>
    <section id="monthly-summary">
        <h3 id="monthly-total-header">今月の総計: <span id="monthly-total">0</span> </h3>
        <label for="month-select">月を選択:</label>
        <select id="month-select">
            <option value="all">すべて</option>
            <?php
            $start = new DateTime('2022-01');
            $end = new DateTime('2026-01');
            for ($date = $start; $date < $end; $date->modify('+1 month')) {
                $monthValue = $date->format('Y-m');
                $monthText = $date->format('Y年 n月');
                echo "<option value=\"$monthValue\">$monthText</option>";
            }
            ?>
        </select>
        <button id="select-button">決定</button>
    </section>
    <section id="data-section">
        <div class="column">
            <h3 class="expense-header">支出履歴</h3>
            <?php
            foreach ($groupedSpendingData as $month => $data) {
                $formattedMonth = date("Y年 n月", strtotime($month . "-01"));
                echo "<div class='month-data' id='spending-$month'>";
                echo "<h4 class='month-header'>$formattedMonth</h4>";
                echo "<table>";
                echo "<thead><tr><th>日付</th><th>内容</th><th>金額</th></tr></thead><tbody>";
                foreach ($data as $item) {
                    $formattedDate = date("Y年 n月 j日", strtotime($item['date']));
                    echo "<tr>";
                    echo "<td>" . htmlspecialchars($formattedDate, ENT_QUOTES, 'UTF-8') . "</td>";
                    echo "<td>" . htmlspecialchars($item['buyproduct'], ENT_QUOTES, 'UTF-8') . "</td>";
                    echo "<td>" . htmlspecialchars($item['price'], ENT_QUOTES, 'UTF-8') . " 円</td>";
                    echo "</tr>";
                }
                echo "</tbody></table>";
                echo "<p>合計支出: " . htmlspecialchars($monthlyTotalSpending[$month], ENT_QUOTES, 'UTF-8') . " 円</p>";
                echo "</div>";
            }
            ?>
        </div>
        <div class="column">
            <h3 class="income-header">給料履歴</h3>
            <?php
            foreach ($groupedIncomeData as $month => $data) {
                $formattedMonth = date("Y年 n月", strtotime($month . "-01"));
                echo "<div class='month-data' id='income-$month'>";
                echo "<h4 class='month-header'>$formattedMonth</h4>";
                echo "<table>";
                echo "<thead><tr><th>日付</th><th>給料</th></tr></thead><tbody>";
                foreach ($data as $item) {
                    $formattedDate = date("Y年 n月 j日", strtotime($item['date']));
                    echo "<tr>";
                    echo "<td>" . htmlspecialchars($formattedDate, ENT_QUOTES, 'UTF-8') . "</td>";
                    echo "<td>" . htmlspecialchars($item['salary'], ENT_QUOTES, 'UTF-8') . " 円</td>";
                    echo "</tr>";
                }
                echo "</tbody></table></div>";
            }
            ?>
        </div>
        <div class="column">
            <h3 class="fixed-expense-header">固定支出</h3>
            <table>
                <thead><tr><th>内容</th><th>金額</th></tr></thead><tbody>
                <?php
                foreach ($fixedSpendingData as $item) {
                    echo "<tr>";
                    echo "<td>" . htmlspecialchars($item['fixed_expenses'], ENT_QUOTES, 'UTF-8') . "</td>";
                    echo "<td>" . htmlspecialchars($item['price'], ENT_QUOTES, 'UTF-8') . " 円</td>";
                    echo "</tr>";
                }
                ?>
                </tbody>
            </table>
        </div>
    </section>
    <form method="get" action="team_friends.php">
        <button type="submit">ホーム</button>
    </form>
</main>
<!-- <script src="../js/SavingsManegement.js"></script> -->
</body>
</html>

