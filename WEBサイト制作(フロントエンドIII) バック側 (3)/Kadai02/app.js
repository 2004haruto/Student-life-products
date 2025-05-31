// readlineモジュール,showCurrentDate, addDaysToDate: dateOperations.jsからのインポート
import readline from 'readline';
import { showCurrentDate, addDaysToDate } from './dateOperations.js';

// readlineインターフェースの作成
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// 処理を選択
function mainMenu() {
    console.log("処理を選択:");
    console.log("1: 現在の日付を表示");
    console.log("2: 現在の日付に日数を追加");
    console.log("3: 終了");

    // 選択肢を入力
    rl.question('選択肢を入力してください> ', (choice) => {
        switch (choice) {
            // 1の時、現在の日付を表示
            case '1':
                showCurrentDate();
                mainMenu(); // 続けて次の入力を受け付ける
                break;
            // 2の時、現在の日付に日数を追加
            case '2':
                rl.question('加算する日付を入力: ', (days) => {
                    addDaysToDate(parseInt(days));
                    mainMenu(); // 続けて次の入力を受け付ける
                });
                break;
            // 3の時、終了
            case '3':
                console.log("終了します");
                rl.close();
                break;
            //1,2,3以外の選択肢の時
            default :
                console.log('正しい値を入力してください');
                mainMenu(); // 続けて次の入力を受け付ける
                break;
        }
    });
}

// メインメニューを呼び出す
mainMenu();
