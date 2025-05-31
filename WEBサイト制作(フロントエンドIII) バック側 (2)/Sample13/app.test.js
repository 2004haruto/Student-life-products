import { describe, it, expect } from 'vitest'; // テスト構文をインポート
import request from 'supertest'; // Supertestをインポート
import app from './app.js'; // テスト対象のアプリケーションをインポート

describe('GET /health', () => {
  it('should return status OK', async () => {
    const response = await request(app).get('/health'); // GETリクエストを送信
    expect(response.status).toBe(200); // ステータスコードが200であることを確認
    expect(response.body).toEqual({ status: 'ok' }); // レスポンス内容を検証
  });
});