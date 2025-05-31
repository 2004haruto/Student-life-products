import express from 'express';
import mongoose from 'mongoose';

// MongoDBの接続URL（docker-composeで設定したものを使用）
const mongoURI = 'mongodb://mongo:27017/mydatabase';

// MongoDBに接続する
mongoose.connect(mongoURI)
.then(() => {
  console.log('MongoDBに接続されました');
})
.catch((err) => {
  console.error('MongoDB接続エラー:', err);
});

// スキーマとモデルの定義
const userSchema = new mongoose.Schema({
    name: { type: String, required: true },
    email: { type: String, required: true, unique: true },
    age: { type: Number },
});
  
const User = mongoose.model('User', userSchema);

// Expressの初期設定
const app = express();
const port = 3000;
app.use(express.json());

// ユーザー作成エンドポイント（POST）
app.post('/users', async (req, res) => {
  const userData = req.body;

  // 必須フィールドのバリデーション
  if (!userData.name || !userData.email) {
    return res.status(400).json({ message: '必須フィールドが不足しています' });
  }

  const user = new User(userData);

  try {
    const savedUser = await user.save();
    res.status(201).json(savedUser);  // 作成されたユーザーを返す
  }catch(err){
    if (err.code === 11000) { 
      // MongoDBの一意制約エラーコード
      return res.status(400).json({ message: 'このメールアドレスは既に使用されています' });
    }

    if (err.name === 'ValidationError') {
      // Mongooseのスキーマバリデーションエラーの場合
      return res.status(400).json({ message: 'バリデーションエラー', error: err.message });
    }

    res.status(500).json({ message: 'ユーザー作成エラー', error: err });
  }
});

// 全ユーザー取得エンドポイント (GET)
app.get('/users', async (req, res) => {
    try {
      const users = await User.find();
      res.status(200).json(users);  // 全てのユーザーを返す
    } catch (err) {
      res.status(500).json({ message: 'ユーザー取得エラー', error: err });
    }
});

// 特定ユーザー取得エンドポイント (GET)
app.get('/users/:id', async (req, res) => {
    const userId = req.params.id;
  
    try {
      const user = await User.findById(userId);
      if (!user) {
        return res.status(404).json({ message: 'ユーザーが見つかりません' });
      }
      res.status(200).json(user);  // 特定のユーザーを返す
    } catch (err) {
      res.status(500).json({ message: 'ユーザー取得エラー', error: err });
    }
});

// ユーザー更新エンドポイント (PUT)
app.put('/users/:id', async (req, res) => {
    const userId = req.params.id;
    const updateData = req.body;
  
    try {
      const updatedUser = await User.findByIdAndUpdate(userId, updateData, { new: true });
      if (!updatedUser) {
        return res.status(404).json({ message: 'ユーザーが見つかりません' });
      }
      res.status(200).json(updatedUser);  // 更新されたユーザーを返す
    } catch (err) {
      res.status(500).json({ message: 'ユーザー更新エラー', error: err });
    }
});

// ユーザー削除エンドポイント (DELETE)
app.delete('/users/:id', async (req, res) => {
    const userId = req.params.id;
  
    try {
      const deletedUser = await User.findByIdAndDelete(userId);
      if (!deletedUser) {
        return res.status(404).json({ message: 'ユーザーが見つかりません' });
      }
      res.status(200).json({ message: 'ユーザーが削除されました' });
    } catch (err) {
      res.status(500).json({ message: 'ユーザー削除エラー', error: err });
    }
});

// サーバの起動
// app.listen(port, () => {
//     console.log(`Server is running on http://localhost:${port}`);
// });

// appをエクスポート
export default app;