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

try {
    $db = getDbConnection();
    $stmt = $db->query("SELECT * FROM WISH_LIST");
    $wish_list = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch (PDOException $e) {
    echo "データベースエラー: " . $e->getMessage();
}
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欲しいものリスト編集</title>
    <link rel="stylesheet" href="./styles/team_friends.css">
</head>
<body>
<h2>欲しいものリスト編集</h2>
<form method="post" action="update_wish.php">
    <table>
        <thead>
        <tr>
            <th>商品名</th>
            <th>金額</th>
            <th>商品リンク</th>
            <th>ステータス</th>
            <th>削除</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($wish_list as $item): ?>
            <tr>
                <td><input type="text" name="product[]" value="<?= htmlspecialchars($item['PRODUCT'] ?? '', ENT_QUOTES, 'UTF-8'); ?>"></td>
                <td><input type="number" name="price[]" value="<?= htmlspecialchars($item['PRICE'] ?? '', ENT_QUOTES, 'UTF-8'); ?>"></td>
                <td><input type="text" name="link[]" value="<?= htmlspecialchars($item['LINK'] ?? '', ENT_QUOTES, 'UTF-8'); ?>"></td>
                <td>
                    <select name="status[]">
                        <option value="0" <?= $item['VISIBLE'] == 0 ? 'selected' : ''; ?>>未購入</option>
                        <option value="1" <?= $item['VISIBLE'] == 1 ? 'selected' : ''; ?>>購入済み</option>
                    </select>
                </td>
                <td><button type="button" class="delete-btn" data-id="<?= $item['ID']; ?>">削除</button></td>
            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
    <button type="submit">保存</button>
</form>
<footer></footer>
<script>
    document.querySelectorAll('.delete-btn').forEach(function(button) {
        button.addEventListener('click', function() {
            // 削除ボタンがクリックされた行を削除する
            var id = this.dataset.id;
            this.closest('tr').remove();
            // データベースからも削除
            fetch('delete_wish.php', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'id=' + encodeURIComponent(id),
            }).then(response => {
                if (!response.ok) {
                    throw new Error('削除に失敗しました');
                }
                return response.text();
            }).catch(error => {
                alert(error.message);
            });
        });
    });
</script>
</body>
</html>
