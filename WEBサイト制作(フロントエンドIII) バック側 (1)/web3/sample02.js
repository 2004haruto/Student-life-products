// sample02.js

// ユーザーに挨拶をする関数を定義
function greet(name){
    const greetingMessage = `こんにちは、${name}さん！`;
    console.log(greetingMessage);
  }
  
  // アロー演算子を使う場合
  const greet2 = (name) => {
    const greetingMessage = `こんにちは、${name}さん！`;
    console.log(greetingMessage);
  }
  
  // 名前の入力を受け取り、挨拶を表示する
  const userName = '有川';
  greet(userName);
  greet2(userName);