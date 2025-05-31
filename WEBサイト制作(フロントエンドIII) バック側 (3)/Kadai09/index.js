import express from 'express';
import mongoose from 'mongoose';
import jwt from 'jsonwebtoken';
import dotenv from 'dotenv';
import bcrypt from 'bcryptjs';
import User from './models/User.js';
import Product from './models/Product.js';

// 環境変数の設定
dotenv.config();

// Mongooseの接続URL
const mongoURI = 'mongodb://mongo:27017/Kadai09';

// Expressの設定
const app = express();
const port = 3000;

// JSONのパース用ミドルウェア
app.use(express.json());

// MongoDBに接続
mongoose.connect(mongoURI)
.then(() => {
  console.log('MongoDBに接続されました。');
}).catch((err) => {
  console.error('MongoDB接続エラー:', err);
});

// アカウント登録処理（サインアップ）
app.post('/signup', async (req, res) => {
    const { name, email, password } = req.body;
  
    try {
      // 既存アカウントの確認
      const existingUser = await User.findOne({ email });
      if(existingUser) {
        return res.status(400).json({ message: 'このメールアドレスは既に使用されています' });
      }
  
      // パスワードをハッシュ化
      const hashedPassword = await bcrypt.hash(password, 10);
  
      // 新しいアカウントを作成
      const newUser = new User({ name, email, password: hashedPassword });
      await newUser.save();
  
      res.status(201).json({ message: 'アカウント登録が完了しました' });
  
    } catch(err) {
      res.status(500).json({ message: 'アカウント登録エラー', err });
    }
});

// ログイン処理
app.post('/login', async (req, res) => {
    const { email, password } = req.body;
  
    try {
      // アカウントを検索
      const user = await User.findOne({ email });
      if(!user) {
        return res.status(401).json({ message: 'アカウントが見つかりません' });
      }
  
      // パスワードを検証
      const isMatch = await bcrypt.compare(password, user.password);
      if(!isMatch) {
        return res.status(401).json({ message: 'パスワードが間違っています' });
      }
  
      // JWTトークンを生成 (jsonwebtokenを使用)
      const token = jwt.sign({ userId: user._id }, process.env.JWT_SECRET, { expiresIn: '1h' });
  
      res.status(200).json({ token });
    } catch(err) {
      console.error(err.message);
      res.status(500).json({ message: 'サーバーエラー', err });
    }
});

// 認証ミドルウェア
const auth = (req, res, next) => {
    const token = req.header('Authorization');
    if (!token) {
      return res.status(401).json({ message: 'トークンがありません。認証が必要です。' });
    }
  
    try {
      // トークンの検証 (jsonwebtokenを使用)
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

// 商品追加用エンドポイント (POST) 認証必要
app.post('/products', auth, async (req, res) => {
    const productData = req.body;
    const product = new Product(productData);

    try {
      const savedProduct = await product.save();
      res.status(201).json(savedProduct);
    } catch (err) {
      res.status(400).json({ error: '商品追加に失敗しました' });
    }
});

// 在庫一覧取得エンドポイント (GET)
app.get('/products', async (req, res) => {
    try {
      const products = await Product.find();
      res.status(200).json(products);
    } catch (err) {
      res.status(500).json({ error: '在庫一覧取得に失敗しました' });
    }
});

// 特定商品取得エンドポイント (GET)
app.get('/products/:id', async (req, res) => {
    const productId = req.params.id;

    try {
      const product = await Product.findById(productId);
      if (!product) {
        return res.status(404).json({ message: '商品が見つかりません' });
      }
      res.status(200).json(product);
    } catch (err) {
      res.status(500).json({ message: '商品取得に失敗しました', error: err });
    }
});

// 商品情報更新エンドポイント (PUT) 認証必要
app.put('/products/:id', auth, async (req, res) => {
    const productId = req.params.id;
    const updateData = req.body;

    try {
      const updatedProduct = await Product.findByIdAndUpdate(productId, updateData, { new: true });
      if (!updatedProduct) {
        return res.status(404).json({ message: '商品が見つかりません' });
      }
      res.status(200).json(updatedProduct);
    } catch (err) {
      res.status(400).json({ message: '商品更新に失敗しました', error: err });
    }
});

// 商品削除エンドポイント (DELETE) 認証必要
app.delete('/products/:id', auth, async (req, res) => {
    const productId = req.params.id;

    try {
      const deletedProduct = await Product.findByIdAndDelete(productId);
      if (!deletedProduct) {
        return res.status(404).json({ message: '商品が見つかりません' });
      }
      res.status(200).json({ message: '商品を削除しました' });
    } catch (err) {
      res.status(500).json({ message: '商品削除に失敗しました', error: err });
    }
});

// サーバー起動
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
