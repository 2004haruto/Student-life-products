<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>安否登録</title>
    <link rel="stylesheet" href="./styles/Reanpi.css">
    
</head>
<body>
    <main>
        <h1>災害時連絡掲示板</h1>

        <form action="disanpi.php" method="post">
            <div class="wrapper">
                <h2>あなたの安否状態を登録してください</h2>
                <!-- 安否登録(無事 or 被害あり) -->
                <div>
                    <input name="status" type="radio" id="ok"  value="1" />
                    <label for="ok" class="status">無事</label>
                    <input name="status" type="radio" id="no" value="2" />
                    <label for="no" class="status">被害あり</label>
                </div>
                <br>
                <br>
                <!-- ないとどこに登録するかわからなくなりそう -->
                <h4>社員番号入力</h4>
                <input type="number" name="comno" > 

                <h4>詳細入力(自由)</h4>
                <!-- メッセージ -->
                <div class="msg">
                    <label for="message"></label>
                    <textarea rows="10" cols="60" id="message" name="message"></textarea>
                    <br>
                </div>
            </div>
            
            <!-- 入力内容を登録 -->
            <input type="submit" value="登録" class="okbtn">
        </form>

         <!-- 戻るボタン -->
         <form action="Safety indication.php" method="get">
            <input type="submit" value="戻る" class="backbtn">
        </form>
    </main>  
</body>
</html>
