import app from './index.js';

// サーバー起動
const port = 3000;
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});