import express from 'express';

const app = express();
const port = 3000;

// ユーザー管理用の配列
let users = [
  { id: 1, name: 'Arikawa', email: 'arikawa@example.com', age: 32 },
  { id: 2, name: 'Yamada', email: 'yamada@example.com', age: 25 },
];

// JSONボディのパース用ミドルウェア
app.use(express.json());

// 1. 全ユーザーの取得
app.get('/users', (req, res) => {
  res.status(200).json(users);
});

// 2. 特定のユーザー情報の取得
app.get('/users/:id', (req, res) => {
  const id = req.params.id;
  const user = users.find(user => user.id === parseInt(id, 10));
  
  if (user) {
    res.status(200).json(user);
  } else {
    res.status(404).json({ message: 'ユーザーが見つかりません' });
  }
});

// 3. ユーザーの追加
app.post('/users', (req, res) => {
  const { name, email, age } = req.body;
  const newId = users.length > 0 ? Math.max(...users.map(user => user.id)) + 1 : 1;

  const newUser = { id: newId, name, email, age };
  users.push(newUser);
  res.status(201).json(newUser);
});

// 4. ユーザー情報の更新
app.put('/users/:id', (req, res) => {
    const id = req.params.id;
    const user = users.find(user => user.id === parseInt(id, 10));
    
  if (user) {
    const { name, email, age } = req.body;
    user.name = name ?? user.name;
    user.email = email ?? user.email;
    user.age = age ?? user.age;
    res.status(200).json(user);
  } else {
    res.status(404).json({ message: 'ユーザーが見つかりません' });
  }
});

// 5. ユーザー情報の削除
app.delete('/users/:id', (req, res) => {
    const id = req.params.id;
    const index = users.findIndex(user => user.id === parseInt(id, 10));
  
  if (index !== -1) {
    users.splice(index, 1);
    res.status(200).json({ message: 'ユーザーが削除されました' });
  } else {
    res.status(404).json({ message: 'ユーザーが見つかりません' });
  }
});

// サーバーの起動
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
