import express from 'express';
import mongoose from 'mongoose';

// MongoDBの接続URL
const mongoURI = 'mongodb://mongo:27017/Kadai13';

// MongoDBに接続
mongoose.connect(mongoURI)
  .then(() => console.log('MongoDBに接続されました'))
  .catch((err) => console.error('MongoDB接続エラー:', err));

// 商品スキーマとモデル
const productSchema = new mongoose.Schema({
  name: { type: String, required: true },
  quantity: { type: Number, required: true, min: 0 },
  price: { type: Number, required: true, min: 0 }
});

const Product = mongoose.model('Product', productSchema);

// Expressアプリの設定
const app = express();
app.use(express.json());

// 商品の作成エンドポイント（POST）
app.post('/products', async (req, res) => {
  try {
    const product = new Product(req.body);
    const savedProduct = await product.save();
    res.status(201).json(savedProduct);
  } catch (err) {
    res.status(400).json({ message: '商品の作成に失敗しました', error: err });
  }
});

// 商品の全件取得エンドポイント（GET）
app.get('/products', async (req, res) => {
  try {
    const products = await Product.find();
    res.status(200).json(products);
  } catch (err) {
    res.status(500).json({ message: '商品の取得に失敗しました', error: err });
  }
});

// 特定商品の取得エンドポイント（GET）
app.get('/products/:id', async (req, res) => {
  try {
    const product = await Product.findById(req.params.id);
    if (!product) {
      return res.status(404).json({ message: '商品が見つかりません' });
    }
    res.status(200).json(product);
  } catch (err) {
    res.status(500).json({ message: '商品の取得に失敗しました', error: err });
  }
});

// 商品の更新エンドポイント（PUT）
app.put('/products/:id', async (req, res) => {
  try {
    const updatedProduct = await Product.findByIdAndUpdate(req.params.id, req.body, { new: true });
    if (!updatedProduct) {
      return res.status(404).json({ message: '商品が見つかりません' });
    }
    res.status(200).json(updatedProduct);
  } catch (err) {
    res.status(400).json({ message: '商品の更新に失敗しました', error: err });
  }
});

// 商品の削除エンドポイント（DELETE）
app.delete('/products/:id', async (req, res) => {
  try {
    const deletedProduct = await Product.findByIdAndDelete(req.params.id);
    if (!deletedProduct) {
      return res.status(404).json({ message: '商品が見つかりません' });
    }
    res.status(200).json({ message: '商品が削除されました' });
  } catch (err) {
    res.status(500).json({ message: '商品の削除に失敗しました', error: err });
  }
});

export default app;