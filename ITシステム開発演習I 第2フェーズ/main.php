<?php

require_once "./def.php"; // DB_USER, DB_PASS, DB_HOST, DB_NAME が定義されているファイルを読み込む

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

    // 給料データの取得
    $incomeSql = "SELECT date, salary FROM income";
    $incomeStmt = $db->query($incomeSql);
    $incomeData = [];
    while ($row = $incomeStmt->fetch(PDO::FETCH_ASSOC)) {
        $incomeData[] = ["date" => $row['date'], "salary" => $row['salary']];
    }

    // 支出データの取得
    $spendingSql = "SELECT date, buyproduct, price FROM spending ORDER BY date ASC"; // 日付順に並べる
    $spendingStmt = $db->query($spendingSql);
    $spendingData = [];
    while ($row = $spendingStmt->fetch(PDO::FETCH_ASSOC)) {
        $spendingData[] = ["date" => $row['date'], "buyproduct" => $row['buyproduct'], "price" => $row['price']];
    }

    // 固定支出データの取得
    $fixedSpendingSql = "SELECT fixed_expenses, price FROM fixed_spending";
    $fixedSpendingStmt = $db->query($fixedSpendingSql);
    $fixedSpendingData = [];
    while ($row = $fixedSpendingStmt->fetch(PDO::FETCH_ASSOC)) {
        $fixedSpendingData[] = ["fixed_expenses" => $row['fixed_expenses'], "price" => $row['price']];
    }

    // 月ごとにデータをグループ化
    $groupedIncomeData = groupByMonth($incomeData);
    $groupedSpendingData = groupByMonth($spendingData);

    // 月の初回処理時に固定支出を追加
    $processedMonths = []; // 処理済みの月を記録
    foreach ($groupedSpendingData as $month => &$data) {
        if (!isset($processedMonths[$month])) {
            foreach ($fixedSpendingData as $fixedItem) {
                $data[] = ["date" => $month . "-01", "buyproduct" => $fixedItem['fixed_expenses'] . " (固)", "price" => $fixedItem['price']];
            }
            $processedMonths[$month] = true; // 月を処理済みに設定
        }
    }

    // 月ごとの支出合計を計算
    $monthlySpendingTotals = [];
    foreach ($groupedSpendingData as $month => $data) {
        $total = 0;
        foreach ($data as $item) {
            if (isset($item['price'])) {
                $total += $item['price'];
            }
        }
        $monthlySpendingTotals[$month] = $total;
    }

} catch (PDOException $poe) {
    exit("DBエラー: " . $poe->getMessage());
} finally {
    // DB切断
    $incomeStmt = null;
    $spendingStmt = null;
    $fixedSpendingStmt = null;
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
</head>
<body>
    <header>
        <h1>カケイボ</h1>
    </header>
    <main>
        <section id="balance-section">
            <h2>貯金残高: <span id="balance">0</span> 円</h2>
            <button onclick="location.href='AddSavings.php'" id="settings-button">編集</button>
        </section>
        <section id="monthly-summary">
            <h3 id="monthly-total-header">今月の総計: <span id="monthly-total">0</span> 円</h3>
            <label for="month-select">月を選択:</label>
            <select id="month-select">
                <option value="all">すべて</option>
                <?php
                $start = new DateTime('2024-01');
                $end = new DateTime('2025-02'); // 1ヶ月余分に進めて終了条件に使用
                for ($date = $start; $date < $end; $date->modify('+1 month')) {
                    $monthValue = $date->format('Y-m');
                    $monthText = $date->format('Y年 n月');
                    echo "<option value=\"$monthValue\">$monthText</option>";
                }
                ?>
            </select>
            <button id="select-button">決定</button>
        </section>
        <section id="history-section">
            <h3>給料履歴</h3>
            <?php
            foreach ($groupedIncomeData as $month => $data) {
                $formattedMonth = date("Y年 n月", strtotime($month . "-01"));
                echo "<div class='month-data' id='income-$month'>";
                echo "<h4>$formattedMonth</h4>";
                echo "<table>";
                echo "<thead><tr><th>日付</th><th>金額</th></tr></thead><tbody>";
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
            <h3>支出履歴</h3>
            <?php
            foreach ($groupedSpendingData as $month => $data) {
                $formattedMonth = date("Y年 n月", strtotime($month . "-01"));
                echo "<div class='month-data' id='spending-$month'>";
                echo "<h4>$formattedMonth</h4>";
                echo "<table>";
                echo "<thead><tr><th>日付</th><th>内容</th><th>金額</th></tr></thead><tbody>";
                foreach ($data as $item) {
                    $formattedDate = date("Y年 n月 j日", strtotime($item['date']));
                    echo "<tr>";
                    echo "<td>" . htmlspecialchars($formattedDate, ENT_QUOTES, 'UTF-8') . "</td>";
                    echo "<td>" . htmlspecialchars($item['buyproduct'] ?? '', ENT_QUOTES, 'UTF-8') . "</td>";
                    echo "<td>" . htmlspecialchars($item['price'] ?? '', ENT_QUOTES, 'UTF-8') . " 円</td>";
                    echo "</tr>";
                }
                echo "</tbody></table>";
                // 月ごとの支出合計を表示
                echo "<p>合計支出: " . htmlspecialchars($monthlySpendingTotals[$month], ENT_QUOTES, 'UTF-8') . " 円</p>";
                echo "</div>";
            }
            ?>
        </section>
        <button id="back-button">戻る</button>
    </main>
    <script src="./scripts/main.js"></script>
</body>
</html>
