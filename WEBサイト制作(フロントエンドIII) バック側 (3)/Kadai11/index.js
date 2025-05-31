import express from 'express';
import jwt from 'jsonwebtoken';
import bcrypt from 'bcryptjs';
import mongoose from 'mongoose';
import cors from 'cors';
import cookieParser from 'cookie-parser';
import dotenv from 'dotenv';
import xss from 'xss';

dotenv.config();
const app = express();
const port = 3000;

// ミドルウェアの設定
app.use(cors({
  origin: 'http://localhost:5500', // フロントエンドのURLを指定
  credentials: true // クッキーを送信するために必要
}));
app.use(express.json());
app.use(cookieParser());

// MongoDBに接続
mongoose.connect('mongodb://mongo:27017/Kadai11')
  .then(() => console.log('MongoDBに接続されました'))
  .catch((err) => console.error('MongoDB接続エラー:', err));

// ユーザーモデル
const userSchema = new mongoose.Schema({
  name: String,
  email: String,
  password: String,
});
const User = mongoose.model('User', userSchema);

// 投稿モデル
const postSchema = new mongoose.Schema({
  title: String,
  content: String,
  author: String, // ユーザー名
});
const Post = mongoose.model('Post', postSchema);

// JWTシークレットキー
const JWT_SECRET = 'SId8BBWo9MhfzbwYXVD4gsiUNeSx95FH';

// サインアップエンドポイント
app.post('/signup', async (req, res) => {
  // const { name, email, password } = req.body;

  // ユーザー入力をサニタイズ
  const name = xss(req.body.name);
  const email = xss(req.body.email);
  const password = req.body.password; // パスワードはそのままでOK

  try {
    const existingUser = await User.findOne({ email });
    if (existingUser) {
      return res.status(400).json({ message: 'このメールアドレスは既に使用されています' });
    }

    const hashedPassword = await bcrypt.hash(password, 10);
    const newUser = new User({ name, email, password: hashedPassword });
    await newUser.save();

    res.status(201).json({ message: 'アカウント登録が完了しました' });
  } catch (err) {
    res.status(500).json({ message: 'サーバーエラー', error: err });
  }
});

// ログインエンドポイント
app.post('/login', async (req, res) => {
  // const { email, password } = req.body;

  // 入力をサニタイズ
  const email = xss(req.body.email);
  const password = req.body.password; // パスワードはそのままでOK

  try {
    const user = await User.findOne({ email });
    if (!user || !(await bcrypt.compare(password, user.password))) {
      return res.status(401).json({ message: 'メールアドレスまたはパスワードが間違っています' });
    }

    const token = jwt.sign({ userId: user._id }, JWT_SECRET, { expiresIn: '1h' });
    console.log(token);
    // クッキーにトークンを設定
    res.cookie('token', token, {
      httpOnly: true,
      secure: process.env.NODE_ENV === 'production', // 本番環境ではSecureを有効にする
      sameSite: 'Strict',
      maxAge: 3600000
    });

    res.status(200).json({ message: 'ログイン成功' });
  } catch (err) {
    res.status(500).json({ message: 'サーバーエラー', error: err });
  }
});

// 認証ミドルウェア
const auth = (req, res, next) => {
  const token = req.cookies.token; // クッキーからトークンを取得
  if (!token) return res.status(401).json({ message: '認証が必要です' });

  try {
    req.user = jwt.verify(token, JWT_SECRET);
    next();
  } catch (err) {
    res.status(401).json({ message: 'トークンが無効です' });
  }
};

// 投稿作成エンドポイント
app.post('/posts', auth, async (req, res) => {
  // const { title, content } = req.body;

  const title = xss(req.body.title);
  const content = xss(req.body.content);

  const author = req.user.userId;

  try {
    const newPost = new Post({ title, content, author });
    await newPost.save();
    res.status(201).json({ message: '投稿が作成されました' });
  } catch (err) {
    res.status(500).json({ message: '投稿の作成中にエラーが発生しました', error: err });
  }
});

// 投稿取得エンドポイント
app.get('/posts', async (req, res) => {
  try {
    const posts = await Post.find({});
    res.status(200).json(posts);
  } catch (err) {
    res.status(500).json({ message: '投稿の取得中にエラーが発生しました', error: err });
  }
});

// サーバーの起動
app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});