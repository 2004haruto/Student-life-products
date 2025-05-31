<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/signup.css">
    <title>新規登録画面</title>
</head>
<body>
    <header>
    </header>

    <main> 
        <h1 class="center">新規登録</h1>

        <form action="signupcheck.php" method="POST">
            <div class="SignUpBox">
                <input type="text" name="id" id="id" placeholder="ID">
            </div>

            <div class="SignUpBox">
                <input type="text" name="name" placeholder="名前">
            </div>

            <div class="SignUpBox">
                <input type="text" name="mail" id="mail" placeholder="メールアドレス">
            </div>

            <div class="SignUpBox">
                <input type="password" name="password" id="passBtn" placeholder="パスワード">
            </div>

            <div class="SignUpBox">
                <input type="password" name="password-check" id="passBtn-check" placeholder="パスワード(確認)">
                <button type="submit" class="tourokuBtn">登録</button>
            </div>

            <div>
                <a href="login.php" class="comeBack">＜戻る</a>
            </div>
        </form>
    </main>

    <script src="./scripts/signup.js"></script>
</body>
</html>
