<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/login.css">
    <title>ログイン画面</title>
</head>
<body>
    <main class="center">
        <form action="loginCheck.php" method="post" class="login-form" id="loginForm">
            <h1 id="headerLogin">ログイン</h1>
            <div class="LoginBox">
                <input type="text" name="id" placeholder="ID" class="input-field" required>
                <span class="error-message" id="idError">IDを入力してください。</span>
            </div>

            <div class="LoginBox">
                <input type="password" name="password" placeholder="パスワード" class="input-field" required>
                <span class="error-message" id="passwordError">パスワードを入力してください。</span>
            </div>

            <div class="LoginBox">
                <button type="submit" class="loginBtn">ログイン</button>
            </div>
        </form>

        <div class="signup-link">
            <a href="signup.php">新規登録はこちらから</a>
        </div>
    </main>

    <script src="./scripts/login.js"></script>
</body>
</html>
