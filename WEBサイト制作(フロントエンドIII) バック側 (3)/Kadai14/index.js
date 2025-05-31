import express from 'express';
import multer from 'multer';
import path from 'path';
import cors from 'cors';
import fs from 'fs';

const app = express();
const port = 3000;

// データベース的な役割を果たす配列
let profiles = [];

// アップロード先ディレクトリ作成（存在しない場合）
const uploadDir = 'uploads';
if (!fs.existsSync(uploadDir)) {
  fs.mkdirSync(uploadDir, { recursive: true });
}

// multer設定
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, uploadDir);
  },
  filename: (req, file, cb) => {
    const uniqueSuffix = Date.now() + '-' + Math.round(Math.random() * 1e9);
    cb(null, uniqueSuffix + path.extname(file.originalname));
  },
});

const upload = multer({
  storage,
  limits: { fileSize: 5 * 1024 * 1024 },
  fileFilter: (req, file, cb) => {
    const fileTypes = /jpeg|jpg|png/;
    const extname = fileTypes.test(path.extname(file.originalname).toLowerCase());
    const mimetype = fileTypes.test(file.mimetype);
    if (extname && mimetype) {
      return cb(null, true);
    }
    cb(new Error('対応している形式は .jpeg, .jpg, .png のみです'));
  },
});

// ミドルウェア
app.use(cors());
app.use(express.json());
app.use('/uploads', express.static(uploadDir));

// プロフィール登録
app.post('/profiles', upload.single('profileImage'), (req, res) => {
  try {
    const { name, email } = req.body;
    const file = req.file;

    if (!name || !email || !file) {
      return res.status(400).json({ message: '全てのフィールドを入力してください' });
    }

    const profile = {
      id: Date.now().toString(),
      name,
      email,
      profileImage: `${req.protocol}://${req.get('host')}/uploads/${file.filename}`,
    };

    profiles.push(profile);
    res.status(201).json({ message: 'プロフィールが作成されました', profile });
  } catch (error) {
    console.error('エラー:', error);
    res.status(500).json({ message: 'サーバーエラーが発生しました', error: error.message });
  }
});

// 全プロフィール取得
app.get('/profiles', (req, res) => {
  try {
    res.status(200).json({ message: 'プロフィール一覧', profiles });
  } catch (error) {
    console.error('エラー:', error);
    res.status(500).json({ message: 'サーバーエラーが発生しました', error: error.message });
  }
});

// プロフィール削除
app.delete('/profiles/:id', (req, res) => {
  try {
    const { id } = req.params;
    const index = profiles.findIndex((profile) => profile.id === id);

    if (index === -1) {
      return res.status(404).json({ message: '指定されたIDのプロフィールが見つかりません' });
    }

    const [deletedProfile] = profiles.splice(index, 1);

    // アップロードされた画像を削除
    const imagePath = path.join(uploadDir, path.basename(deletedProfile.profileImage));
    if (fs.existsSync(imagePath)) {
      fs.unlinkSync(imagePath);
    }

    res.status(200).json({ message: 'プロフィールが削除されました', profile: deletedProfile });
  } catch (error) {
    console.error('エラー:', error);
    res.status(500).json({ message: 'サーバーエラーが発生しました', error: error.message });
  }
});

// サーバー起動
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
