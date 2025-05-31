//必要なモジュールインポート
import express from 'express';
import dayjs from 'dayjs';

//インスタンス生成
const app = express();
//使用するポート宣言
const port = 3000;

// カスタムミドルウェアの作成
const requestTimeLogger = (req, res, next) => {
  // dayjsを使って現在の時刻を取得し、フォーマット
  const currentTime = dayjs().format('YYYY-MM-DD HH:mm:ss');
  console.log(`[${currentTime}] ${req.method} request to ${req.url}`);
  next();  // 次のミドルウェアまたはルートハンドラーに制御を渡す
};

// アプリケーション全体にカスタムミドルウェアを適用
// app.use(requestTimeLogger);

// ルートハンドラー
app.get('/', (req, res) => {
  res.send('Hello, World!');
});

// app.get('/about', (req, res) => {
//   res.send('About Page');
// });

// '/about'ルートにのみカスタムミドルウェアを適用
app.get('/about',requestTimeLogger , (req, res) => {
    res.send('About Page');
});

//サーバー起動
app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});