import app from './index.js';

const port = 3000;

// サーバーの起動
app.listen(port, () => {
  console.log(`サーバーがポート${port}で起動しています`);
});