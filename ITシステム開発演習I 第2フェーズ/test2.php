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

// ログインしているユーザーのIDを取得
$user_id = isset($_SESSION['user_id']) ? $_SESSION['user_id'] : null;

// データベースからデータを取得
try {
    $db = getDbConnection();
    $sql = "SELECT PNumber, PRODUCT, PRICE, link, VISIBLE FROM wish_list WHERE USER_ID = :user_id";
    $stmt = $db->prepare($sql);
    $stmt->bindParam(':user_id', $user_id, PDO::PARAM_STR);
    $stmt->execute();
    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch (PDOException $e) {
    exit("データベースエラー: " . $e->getMessage());
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欲しい物リスト</title>
    <link rel="stylesheet" type="text/css" href="./styles/hosiimono.css">
</head>
<body>

<h1>欲しい物リスト</h1>
<table>
    <tr>
        <th>商品名</th>
        <th>金額</th>
        <th>リンク</th>
        <th>ステータス</th>
        <th>支出に追加</th>
        <th>削除</th>
    </tr>
    <?php
    if ($result) {
        foreach ($result as $row) {
            $product = isset($row['PRODUCT']) ? htmlspecialchars($row['PRODUCT']) : '';
            $price = isset($row['PRICE']) ? htmlspecialchars($row['PRICE']) : '';
            $link = isset($row['link']) ? htmlspecialchars($row['link']) : '';
            $VISIBLE = isset($row['VISIBLE']) ? htmlspecialchars($row['VISIBLE']) : '';
            
            $status_text = $VISIBLE == 1 ? "購入済み" : "未購入";
            echo "<tr>
                <td><input type='text' value='".$product."' readonly></td>
                <td><input type='number' value='".$price."' readonly></td>
                <td><a href='" . $link . "'>" . $link . "</a></td>
                <td><button class='status-button' data-id='".$row['PNumber']."'>" . $status_text . "</button></td>
                <td><a href='AddSavings.php?id=" . $row['PNumber'] . "'>支出に追加</a></td>
                <td><button class='delete-button' onclick='deleteItem(".$row['PNumber'].")'>削除</button></td>
            </tr>";
        }
    } else {
        echo "<tr><td colspan='6'>データがありません</td></tr>";
    }
    ?>
</table>

<div>
    <button onclick="location.href='team_friends.php'">ホーム</button>
    <button onclick="location.href='test4.php'">追加</button>
</div>

<script>
    function deleteItem(id) {
        if (confirm("本当に削除しますか？")) {
            window.location.href = "delete_item.php?id=" + id;
        }
    }

    document.querySelectorAll('.status-button').forEach(button => {
        button.addEventListener('click', function() {
            const id = this.dataset.id;
            fetch('update_status.php', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'id=' + id
            })
            .then(response => response.text())
            .then(data => {
                if (data === 'success') {
                    const newStatus = this.textContent === '購入済み' ? '未購入' : '購入済み';
                    this.textContent = newStatus;
                } else {
                    alert('ステータスの更新に失敗しました: ' + data);
                }
            })
            .catch(error => {
                alert('ステータスの更新中にエラーが発生しました: ' + error);
            });
        });
    });
</script>

</body>
</html>
