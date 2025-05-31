<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./styles/login.css">
    <title>災害管理</title>
</head>

<h1>災害時連絡掲示板</h1>
  <body>
    <div class="login-wrapper" id="login">
      <div class="container">
          <div class="login">
              <div class="login-wrapper-title">
                  <h2>ログイン</h2>
              </div>
                  <div class="form-group">
                    <form action="login result.php" method="POST">
                            <p>社員番号</p>
                            <input type="id" name="id" required>
                        </div>
                        <div class="form-group">
                            <p>パスワード</p>
                            <input type="password" name="password" required>
                        </div>
                        <div class="newuser"><a href="saigai.html">新規ユーザー作成</a></div>
                        <button type="submit" class="btn btn-submit">ログイン</button>
                  </form>
            </div>
        </div>
    </div>
  </body>
</html>
