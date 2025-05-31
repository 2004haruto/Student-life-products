import { describe, it, beforeAll, afterAll, beforeEach, expect } from "vitest";
import request from 'supertest';
import mongoose from "mongoose";
import app from "./index.js";

const mongoURI = 'mongodb://mongo:27017/Sample13_2';

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
    for(const key in collections) {
      await collections[key].deleteMany({});
    }
  });

  // 正常系テスト
describe('User API（正常系）', () => {
    // ユーザー登録テスト
    it('shuld create a new user', async () => {
        const user = { name: 'John Doe', email: 'john@example.com', age: 30 };
        const response = await request(app).post('/users').send(user);
    
        expect(response.status).toBe(201);
        expect(response.body.name).toBe(user.name);
        expect(response.body.email).toBe(user.email);
        expect(response.body.age).toBe(user.age);
      });

        // 全件ユーザー取得テスト
  it('should get all users', async () => {
    const response = await request(app).get('/users');

    expect(response.status).toBe(200);
    expect(response.body).toBeInstanceOf(Array);
  });

  // 特定ユーザー取得テスト
  it('should get a specific user by ID', async () => {
    const user = { name: 'John Smith', email: 'john_s@example.com', age: 25 };

    const createdUser = await request(app).post('/users').send(user);
    const userId = createdUser.body._id;

    const response = await request(app).get(`/users/${userId}`);

    expect(response.status).toBe(200);
    expect(response.body.name).toBe(user.name);
    expect(response.body.email).toBe(user.email);
    expect(response.body.age).toBe(user.age);
  });

    // 特定ユーザー更新テスト
    it('should update a user by ID', async () => {
        const user = { name: 'Alice', email: 'alice@example.com', age: 22 };
    
        const createdUser = await request(app).post('/users').send(user);
        const userId = createdUser.body._id;
    
        const updatedData = { name: 'Arikawa', age: 32 };
        const response = await request(app).put(`/users/${userId}`).send(updatedData);
    
        expect(response.status).toBe(200);
        expect(response.body.name).toBe(updatedData.name);
        expect(response.body.age).toBe(updatedData.age);
    
      });
    
      // 特定ユーザー削除テスト
      it('should delete a user by ID', async () => {
        const user = { name: 'Bob', email: 'bob@example.com', age: 28 };
    
        const createdUser = await request(app).post('/users').send(user);
        const userId = createdUser.body._id;
    
        const response = await request(app).delete(`/users/${userId}`);
    
        expect(response.status).toBe(200);
        expect(response.body.message).toBe('ユーザーが削除されました');
      });
});

describe('User API（異常系）', () => {
    // ユーザー作成テスト（異常系）
    it('should return 400 when creating a user with missing required fields', async () => {
        const invalidUser = { email: 'missing-name@example.com' };  // 'name'がない
    
        const response = await request(app).post('/users').send(invalidUser);
    
        expect(response.status).toBe(400);
        expect(response.body.message).toContain('必須フィールドが不足しています');
      });

        // メールアドレス重複テスト
  it('should return 400 when creating a user with duplicate email', async () => {
    const user = { name: 'Duplicate User', email: 'duplicate@example.com', age: 35 };

    // 最初のユーザー作成
    await request(app).post('/users').send(user);

    // 重複したメールアドレスで作成を試みる
    const response = await request(app).post('/users').send(user);

    expect(response.status).toBe(400);
    expect(response.body.message).toContain('このメールアドレスは既に使用されています');
  });

    // 存在しないユーザーの取得テスト
    it('should return 404 for a non-existent user', async () => {
        const nonExistentId = new mongoose.Types.ObjectId();
    
        const response = await request(app).get(`/users/${nonExistentId}`);
        expect(response.status).toBe(404);
        expect(response.body.message).toBe('ユーザーが見つかりません');
      });
      
});