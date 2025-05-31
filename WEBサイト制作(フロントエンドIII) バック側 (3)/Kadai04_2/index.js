// Expressのインポート
import express from 'express';

// Expressアプリケーションのインスタンス生成
const app = express();

// 静的ファイルを提供するミドルウェア
app.use(express.static('public'));

// 使用するポートの指定
const port = 3000;

// サーバーを起動
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
