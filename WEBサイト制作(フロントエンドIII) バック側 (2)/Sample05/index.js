//Expressをインポート
import express from 'express';

//インスタンス生成
const app = express();
//使用するポートの宣言
const port = 3000;

// パラメータ付きルートの定義
app.get('/users/:id', (req, res) => {
  // req.paramsを使用してパスパラメータを取得
  const userId = req.params.id;
  console.log(`User ID is: ${userId}`);  
  res.send(`User ID is: ${userId}`);
});

// クエリパラメータを処理するルート
app.get('/search', (req, res) => {
    const searchQuery = req.query.q;  // クエリパラメータ 'q' を取得
    console.log(`You searched for: ${searchQuery}`);
    res.send(`You searched for: ${searchQuery}`);
});

//サーバ起動
app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});