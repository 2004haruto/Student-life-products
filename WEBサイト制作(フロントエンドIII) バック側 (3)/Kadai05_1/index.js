//Expressをインポート
import express from 'express';

//インスタンス生成
const app = express();
//使用するポートの宣言
const port = 3000;

// /greet ルート
app.get('/greet', (req, res) => {
  const name = req.query.name;
  if (!name) {
    return res.send("Error: No name provided.");
  }
  res.send(`Hello, ${name}!`);
});

// /square ルート
app.get('/square', (req, res) => {
  const number = parseInt(req.query.number, 10);
  if (isNaN(number)) {
    return res.send("Error: Invalid number provided.");
  }
  res.send(`${number * number}`);
});

//サーバ起動
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
