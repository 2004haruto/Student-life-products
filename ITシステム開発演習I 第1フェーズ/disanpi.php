<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登録内容の確認</title>
    <link rel="stylesheet" href="./styles/disanpi.css">
</head>
<body>
    <h1>登録内容の表示</h1>
    <table>
        <thead>
            <tr>
                <th>登録日</th>
                <th>安否状態</th>
                <th>詳細メッセージ</th>
            </tr>
        </thead>
        <tbody>
        <?php
            $ok = "";
            $dsn = 'mysql:dbname=COS;host=localhost';
            $user = 'muser';
            $password = 'mmm';

            $status = filter_input(INPUT_POST,"status"); // 安否状態
            $comno = filter_input(INPUT_POST,"comno"); // 社員番号
            $comment = filter_input(INPUT_POST,"message"); // 詳細メッセージ
            
            $Msg = ""; // メッセージの格納用変数

            if(!$status) {
                $Msg .= "安否状態をどちらか必ず選択してください<br>";
            }

            if(!$comno) {
                $Msg .= "社員番号がないと登録できません<br>";
            }

            if($Msg == "") {
                try {
                    // DBへ接続
                    $db = new PDO($dsn, $user, $password);
                    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
                    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                    $db->setAttribute(PDO::ATTR_AUTOCOMMIT, false);

                    // トランザクション開始
                    $db->beginTransaction();

                    // データベース内に社員番号が存在するか確認
                    $check_sql = "SELECT COUNT(*) FROM staff WHERE id = :comno";
                    $check_stmt = $db->prepare($check_sql);
                    $check_stmt->bindParam(':comno', $comno, PDO::PARAM_INT);
                    $check_stmt->execute();
                    $result = $check_stmt->fetchColumn();

                    if ($result == 0) {
                        $Msg .= "指定された社員番号は存在しません<br>";
                    } else {
                        $sql = "UPDATE staff
                                SET filter = :status, comment = :comment, date = CURRENT_TIMESTAMP
                                WHERE id = $comno";

                        $stmt = $db->prepare($sql);
                        $stmt->bindParam(':comment', $comment, PDO::PARAM_STR);
                        $stmt->bindParam(':status', $status, PDO::PARAM_INT);
                        
                        // SQL文を実行
                        $stmt->execute();
                        // 登録成功メッセージ
                        $ok .= "この内容で登録しました<br>";
                        // トランザクション確定
                        $db->commit();
                    }
                } catch(PDOException $poe) {
                    $db->rollBack();
                    echo "DB接続エラー".$poe->getMessage();
                } finally {
                    //DB切断
                    $stmt = null;
                    $db = null;
                }
            }
            // 登録処理ここまで
            echo $Msg;
            // 登録内容表示
            if($Msg == "") {
                echo "<tr>";
                if($status == 1) {
                    $anpi = "無事";
                } elseif($status == 2) {
                    $anpi = "被害あり";
                }
                echo "<td>" . date("Y-m-d H:i:s") . "</td>";
                echo "<td>$anpi</td>";
                echo "<td>$comment</td>";
                echo "</tr>";
                echo $ok;
            }
        ?>
        </tbody>
    </table>
    <a href="Safety indication.php">一覧画面</a>
    <a href="Reanpi.php">戻る</a>
</body>
</html>
