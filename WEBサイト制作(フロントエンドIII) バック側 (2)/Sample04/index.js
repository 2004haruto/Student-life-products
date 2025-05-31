// Expressのインポート
import express from 'express';

// Expressアプリケーションのインスタンス生成
const app = express();

// 使用するポートの指定
const port = 3000;

// URLエンコードされたデータをパースするミドルウェアを追加
app.use(express.urlencoded({ extended: true }));
// 静的ファイルを提供するミドルウェア
app.use(express.static('public'));

// ルーティング設定
app.get('/', (req, res) => {
  res.send('Hello, Express!');
});

// 新しいルーティングを追加
app.get('/about', (req, res) => {
    res.send('About Us Page');
});

// POSTリクエストのルーティング
app.post('/submit', (req, res) => {
    console.log(req.body);  // 送信されたPOSTデータをコンソールに表示
    res.send('Success!!');
});

// サーバーを起動し、指定したポートで待機
app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});