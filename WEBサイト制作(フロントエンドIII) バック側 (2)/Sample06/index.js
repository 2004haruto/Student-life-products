import express from 'express';

const app = express();
const port = 3000;

// 仮のデータベース
let items = [
    { id: 1, name: 'りんご' },
    { id: 2, name: 'バナナ' },
];

// URLエンコーデッドミドルウェア
app.use(express.urlencoded({extended: true}));

// JSONボディのパース用ミドルウェア
app.use(express.json());

// ルーティング
// すべてのアイテムを取得するエンドポイント
app.get('/items', (req, res) => {
    res.json(items);
});

// 特定のアイテムを取得するエンドポイント
app.get('/items/:id', (req, res) => {
    const id = req.params.id;
    const item = items.find(item => item.id === parseInt(id, 10));
    
    // アイテムが見つかればJSONで返す
    // 見つからなければ404ステータスコードでエラーを返す
    if (item) {
      res.json(item);
    } else {
      res.status(404).json({ message: 'Item not found' });
    }
});

// 新しいアイテムを作成するエンドポイント
app.post('/items', (req, res) => {
	// 現在の最大IDを取得し、その値に1を足す
    const newId = items.length > 0 ? Math.max(...items.map(item => item.id)) + 1 : 1;
  
    const newItem = {
        id: newId,
        name: req.body.name,
    };
    items.push(newItem);
    res.status(201).json(newItem);
});

// 特定のアイテムを更新するエンドポイント
app.put('/items/:id', (req, res) => {
    const id = req.params.id;
    const item = items.find(item => item.id === parseInt(id, 10));
  
    if (item) {
      item.name = req.body.name;
      res.json(item);
    } else {
      res.status(404).json({ message: 'Item not found' });
    }
});

// 特定のアイテムを削除するエンドポイント
app.delete('/items/:id', (req, res) => {
    const id = req.params.id;
    const index = items.findIndex(item => item.id === parseInt(id, 10));
  
    if (index !== -1) {
      const deletedItem = items.splice(index, 1);
      res.json(deletedItem);
    } else {
      res.status(404).json({ message: 'Item not found' });
    }
});

// サーバーの起動
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});