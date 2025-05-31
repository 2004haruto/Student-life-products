import express from 'express';

const app = express();
app.use(express.json());

// サンプルエンドポイント
app.get('/health', (req, res) => {
  res.status(200).json({ status: 'ok' });
});

export default app;