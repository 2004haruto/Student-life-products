//Promiseオブジェクトの作成
const myPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
      const success = false; // trueにすると成功、falseにすると失敗
      if (success) {
        resolve('データの取得に成功しました！');
      } else {
        reject('エラーが発生しました...');
      }
    }, 2000);
  });
  
  //myPromiseの呼び出し
  myPromise
    .then((message) => {
      console.log('成功:', message);
    })
    .catch((error) => {
      console.error('失敗:', error);
    });