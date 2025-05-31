// asyncキーワードを使って非同期関数を定義
async function fetchData() {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/users'); // Promiseが解決されるのを待つ
      const data = await response.json(); // レスポンスをJSON形式に変換するPromiseを待つ
      console.log('データ取得成功:', data);
    } catch (error) {
      console.error('エラーが発生しました:', error);
    }
  }
  
  // 関数を実行
  fetchData();