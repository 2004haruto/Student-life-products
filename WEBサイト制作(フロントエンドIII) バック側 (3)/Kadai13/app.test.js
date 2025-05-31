import { describe, it, beforeAll, afterAll, beforeEach, expect } from "vitest";
import request from 'supertest';
import mongoose from "mongoose";
import app from "./index.js";
const mongoURI = 'mongodb://mongo:27017/Kadai13';

beforeAll(async () => {
  // MongoDBコンテナに接続
  if (mongoose.connection.readyState === 0) {
    await mongoose.connect(mongoURI)
    .then(() => {
      console.log('MongoDBに接続されました。');
    }).catch((err) => {
      console.error('MongoDB接続エラー:', err);
    });
  }
});

afterAll(async () => {
  // MongoDBから切断
  await mongoose.connection.close();
});

beforeEach(async () => {
  // テストデータをクリーンアップ
  const collections = mongoose.connection.collections;
  for (const key in collections) {
    await collections[key].deleteMany({});
  }
});

  // 正常系テスト
  describe('User API（正常系）', () => {
    it('shuld create a new products', async () => {
        const products = { name: 'tomato', quantity: 10, price: 300 };
        const response = await request(app).post('/products').send(products);
    
        expect(response.status).toBe(201);
        expect(response.body.name).toBe(products.name);
        expect(response.body.quantity).toBe(products.quantity);
        expect(response.body.price).toBe(products.price);
      });

    it('should get all products', async () => {
       const response = await request(app).get('/products');
       expect(response.status).toBe(200);
       expect(response.body).toBeInstanceOf(Array);
     });

     // 特定商品取得テスト
    it('should get a specific products by ID', async () => {
        const products = { name: 'tomato', quantity: 10, price: 300 };
        const createdProducts = await request(app).post('/products').send(products);
        const productsId = createdProducts.body._id;
        const response = await request(app).get(`/products/${productsId}`);

        expect(response.status).toBe(200);
        expect(response.body.name).toBe(products.name);
        expect(response.body.quantity).toBe(products.quantity);
        expect(response.body.price).toBe(products.price);
    });

      // 特定商品更新テスト
  it('should update a products by ID', async () => {
    const products = { name: 'tomato', quantity: 10, price: 300 };

    const createdProducts = await request(app).post('/products').send(products);
    const productsId = createdProducts.body._id;

    const updatedData = { name: 'imo', price: 50 };
    const response = await request(app).put(`/products/${productsId}`).send(updatedData);

    expect(response.status).toBe(200);
    expect(response.body.name).toBe(updatedData.name);
    expect(response.body.price).toBe(updatedData.price);

  });

  // 特定商品削除テスト
  it('should delete a products by ID', async () => {
    const products = { name: 'imo', quantity: 10, price: 300 };

    const createdProducts = await request(app).post('/products').send(products);
    const productsId = createdProducts.body._id;

    const response = await request(app).delete(`/products/${productsId}`);

    expect(response.status).toBe(200);
    expect(response.body.message).toBe('商品が削除されました');
  });
});

describe('User API（異常系）', () => {
    // 商品作成テスト（異常系）
    it('should return 400 when creating a product with missing required fields', async () => {
        const invalidProduct = { quantity: 10 ,price:300};  
        const response = await request(app).post('/products').send(invalidProduct);

        expect(response.status).toBe(400);
        expect(response.body.message).toContain('必須フィールドが不足しています');
    });

    // 商品取得テスト（IDが無効）
    it('should return 400 when getting a product with invalid ID', async () => {
        const invalidId = '123';  
        const response = await request(app).get(`/products/${invalidId}`);

        expect(response.status).toBe(400);
        expect(response.body.message).toContain('無効なIDです');
    });

    // 商品取得テスト（存在しないID）
    it('should return 404 when getting a product that does not exist', async () => {
        const nonExistentId = new mongoose.Types.ObjectId();  // 存在しないID
        const response = await request(app).get(`/products/${nonExistentId}`);

        expect(response.status).toBe(404);
        expect(response.body.message).toBe('商品が見つかりません');
    });

    // 商品更新テスト（存在しないID）
    it('should return 404 when updating a product that does not exist', async () => {
        const nonExistentId = new mongoose.Types.ObjectId();
        const updateData = { name: 'updatedName', price: 100 };
        const response = await request(app).put(`/products/${nonExistentId}`).send(updateData);

        expect(response.status).toBe(404);
        expect(response.body.message).toBe('商品が見つかりません');
    });

    // 商品更新テスト（無効な入力データ）
    it('should return 400 Bad Request when updating with invalid input data (empty fields)', async () => {
        try {
            const product = new Product({ name: 'Test Product', quantity: 10, price: 100 });
            await product.save();
            
            // 空のリクエストを送信
            const response = await request(app)
                .put(`/products/${product._id}`)
                .send({});  // 空のデータを送信
            
            expect(response.status).toBe(400);
            expect(response.body.message).toBe('更新するフィールドを指定してください');
        } catch (err) {
            console.error('エラーが発生しました:', err);
        }
    });

    // 商品削除テスト（存在しないID）
    it('should return 404 when deleting a product that does not exist', async () => {
        const nonExistentId = new mongoose.Types.ObjectId();
        const response = await request(app).delete(`/products/${nonExistentId}`);

        expect(response.status).toBe(404);
        expect(response.body.message).toBe('商品が見つかりません');
    });

    // 商品削除テスト（IDが無効）
    it('should return 400 when deleting a product with invalid ID', async () => {
        const invalidId = '123'; 
        const response = await request(app).delete(`/products/${invalidId}`);

        expect(response.status).toBe(400);
        expect(response.body.message).toContain('無効なIDです');
    });
});