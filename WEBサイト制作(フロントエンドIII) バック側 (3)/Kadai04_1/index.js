// Expressのインポート
import express from 'express';

// Expressアプリケーションのインスタンス生成
const app = express();

// 使用するポートの指定
const port = 3000;

// ルートハンドラーの設定
app.get('/', (req, res) => {
    res.send('Welcome to My Express App!');
});

app.get('/about', (req, res) => {
    res.send('This is About page');
});

app.get('/contact', (req, res) => {
    res.send('Contact us at contact@example.com');
});

// サーバーを起動
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});