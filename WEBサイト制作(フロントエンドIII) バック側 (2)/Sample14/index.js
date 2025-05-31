import express from 'express';
import multer from 'multer';
import path from 'path';
import cors from 'cors';

const app = express();
const port = 3000;

// multerの設定
const storage = multer.diskStorage({
    destination: (req, file, cb) => {
      cb(null, 'uploads/'); // アップロード先ディレクトリ指定
    },
    filename: (req, file, cb) => {
      if(!file){
        return cb(new Error('ファイルが指定されていません'));
      }
      const uniqueSuffix = Date.now() + '-' + Math.round(Math.random() * 1E9);
      cb(null, uniqueSuffix + path.extname(file.originalname)); // ユニークなファイル名
    }
  });
  
  const upload = multer({
    storage,
    limits: { fileSize: 5 * 1024 * 1024 }, // 最大5MBのファイル
    fileFilter: (req, file, cb) => {
      const fileTypes = /jpeg|jpg|png/;
      const extname = fileTypes.test(path.extname(file.originalname).toLowerCase());
      const mimetype = fileTypes.test(file.mimetype);
      if (extname && mimetype) {
        return cb(null, true);
      }
      cb(new Error('Only .jpeg, .jpg, and .png formats are allowed!'));
    }
  });

  // 静的ファイルの公開
app.use('/uploads', express.static('uploads'));
app.use(cors());

app.post('/upload', upload.single('file'), (req, res) => {
    try{
      const metadata = JSON.parse(req.body.metadata); // JSONデータをパース
      const file = req.file;
      const fileUrl = `${req.protocol}://${req.get('host')}/uploads/${req.file.filename}`;
  
      // 必要に応じて処理を行う
      console.log('アップロードされたファイル：', file);
      console.log('メタデータ：', metadata);
  
      res.status(201).json({
        message: 'ファイルとデータが正常にアップロードされました',
        file,
        metadata,
        fileUrl
      });
    }catch(error){
      console.error('エラー：', error);
      res.status(400).json({ message: 'アップロードに失敗しました', error: error.message });
    }
  });

  app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
  });