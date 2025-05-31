// readlineモジュールのインポート
import readline from 'readline';

// readlineインターフェースの作成
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// ユーザーに入力を求めるプロンプトを表示
rl.question('名前を入力してください: ', (name) => {
  console.log(`こんにちは、${name}さん！`);

  // インターフェースを閉じる
  rl.close();
});