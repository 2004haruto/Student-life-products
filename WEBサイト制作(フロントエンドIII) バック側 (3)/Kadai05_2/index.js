//必要なモジュールインポート
import express from 'express';
import dayjs from 'dayjs';

//インスタンス生成
const app = express();
//使用するポート宣言
const port = 3000;

const users = [
  { id: 1, name: 'Alice', age: 25 },
  { id: 2, name: 'Bob', age: 30 },
  { id: 3, name: 'Charlie', age: 35 }
];

// カスタムミドルウェア: リクエストが来た時間をログ出力
const logRequestTime = (req, res, next) => {
  console.log(`Request received at: ${dayjs().format('YYYY-MM-DD HH:mm:ss')}`);
  next();
};

// 全ルートでlogRequestTimeミドルウェアを適用
app.use(logRequestTime);

// /users/:id ルート
app.get('/users/:id', (req, res) => {
  const userId = parseInt(req.params.id, 10);
  const user = users.find(u => u.id === userId);
  if (!user) {
    return res.send("User not found.");
  }
  res.send(`User: ${user.name}, Age: ${user.age}`);
});

// /users ルート
app.get('/users', (req, res) => {
  const minAge = parseInt(req.query.age, 10);
  if (isNaN(minAge)) {
    return res.send("Error: Invalid age provided.");
  }
  const filteredUsers = users.filter(u => u.age >= minAge);
  res.send(filteredUsers.map(user => `User: ${user.name}, Age: ${user.age}`).join(', '));
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
