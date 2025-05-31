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
const productSchema = new mongoose.Schema({
    name: { type: String, required: true },
    price: { type: Number, required: true },
    stock: { type: Number, required: true }
  });
  
const Product = mongoose.model('Product', productSchema);
  
// Expressの初期設定
const app = express();
const port = 3000;
app.use(express.json());

// 商品追加用エンドポイント (POST)
app.post('/products', async (req, res) => {
    const productData = req.body;
    const product = new Product(productData);

    try {
      const savedProduct = await product.save();
      res.status(201).json(savedProduct);
    } catch (err) {
      res.status(400).json({ error: '商品追加に失敗しました' });
    }
});
  
//  在庫一覧取得エンドポイント (GET)
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
      res.status(500).json({ message: '商品取得に失敗しました' ,error: err});
    }
});

// 商品情報更新エンドポイント (PUT)
app.put('/products/:id', async (req, res) => {
    const productId = req.params.id;
    const updateData = req.body

    try {
      const updatedProduct = await Product.findByIdAndUpdate(productId, updateData, { new: true });
      if (!updatedProduct) {
        return res.status(404).json({ message: '商品が見つかりません' });
      }
      res.status(200).json(updatedProduct);
    } catch (err) {
      res.status(400).json({ message: '商品更新に失敗しました',error: err });
    }
});
  
// 商品削除エンドポイント (DELETE)
app.delete('/products/:id', async (req, res) => {
    const productId = req.params.id;

    try {
      const deletedProduct = await Product.findByIdAndDelete(productId);
      if (!deletedProduct) {
        return res.status(404).json({ message: '商品が見つかりません' });
      }
      res.status(200).json({ message: '商品を削除しました' });
    } catch (err) {
      res.status(500).json({ message: '商品削除に失敗しました',error :err });
    }
});
  
// サーバの起動
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
  