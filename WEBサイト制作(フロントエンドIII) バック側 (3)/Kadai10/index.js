import express from 'express';
import jwt from 'jsonwebtoken';
import bcrypt from 'bcryptjs';
import dotenv from 'dotenv';
import mongoose from 'mongoose';
import cors from 'cors';
import User from './models/User.js'; // ユーザーモデル

// 環境変数の設定
dotenv.config();

// MongoDB接続URL
const mongoURI = 'mongodb://mongo:27017/Kadai10';

// MongoDBに接続
mongoose.connect(mongoURI)
  .then(() => {
    console.log('MongoDBに接続されました。');
  }).catch((err) => {
    console.error('MongoDB接続エラー:', err);
  });

// Expressの設定
const app = express();
const port = 3000;

// JSONのパース用ミドルウェア
app.use(express.json());

// CORS対策用のミドルウェア
app.use(cors());  // すべてのオリジンからのリクエストを許可

// ** サインアップ処理 **
app.post('/signup', async (req, res) => {

  // リクエストボディからデータ取得
  const { name, email, password } = req.body;

  try {
    // 既存アカウントの確認
    const existingUser = await User.findOne({ email });

    if (existingUser) {
      return res.status(400).json({ message: 'このメールアドレスは既に使用されています' });
    }

    // パスワードのハッシュ化
    const hashedPassword = await bcrypt.hash(password, 10);

    // 新規ユーザー作成
    const newUser = new User({ name, email, password: hashedPassword });
    await newUser.save();

    res.status(201).json({ message: 'アカウント登録が完了しました' });

  } catch (err) {
    res.status(500).json({ message: 'アカウント登録エラー' });
  }
});

// ** ログイン処理 **
app.post('/login', async (req, res) => {
  const { email, password } = req.body;

  try {
    // アカウントを検索
    const user = await User.findOne({ email });
    if (!user) {
      return res.status(401).json({ message: 'アカウントが見つかりません' });
    }

    // パスワードの検証
    const isMatch = await bcrypt.compare(password, user.password);
    if (!isMatch) {
      return res.status(401).json({ message: 'パスワードが間違っています' });
    }

    // JWTトークンを生成
    const token = jwt.sign({ userId: user._id }, process.env.JWT_SECRET, { expiresIn: '1h' });

    res.status(200).json({ token });
  } catch (err) {
    res.status(500).json({ message: 'サーバーエラー', err });
  }
});

// 認証ミドルウェア 
const auth = (req, res, next) => {
  const token = req.header('Authorization');
  if (!token ){
    return res.status(401).json({ message: 'トークンが無効です。認証が必要です。' });
  }

  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    req.user = decoded;
    next();
  } catch (error) {
      res.status(401).json({ message: 'トークンが無効です。' });
  }
};

// 認証が必要なエンドポイント
app.get('/protected', auth, (req, res) => {
  res.status(200).json({ message: '認証されたアカウントだけが見られるデータ' });
});


// プロフィール取得エンドポイント 
app.get('/profile', auth, async (req, res) => {
  try {
    const user = await User.findById(req.user.userId).select('-password');
    if (!user) {
      return res.status(404).json({ message: 'ユーザーが見つかりません' });
    }

    res.status(200).json(user);
  } catch (error) {
    res.status(500).json({ message: 'プロフィール取得エラー', error});
  }
});

// サーバー起動
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
