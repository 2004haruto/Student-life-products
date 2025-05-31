// 成功する関数 (APIからデータを取得)
const fetchPosts = () => fetch('https://jsonplaceholder.typicode.com/posts');
const fetchUsers = () => fetch('https://jsonplaceholder.typicode.com/users');
const fetchComments = () => fetch('https://jsonplaceholder.typicode.com/comments');

// 失敗する関数 
const fetchData4 = () => new Promise((resolve, reject) => {
  setTimeout(() => {
    reject('データ4の取得に失敗'); // 失敗をシミュレート
  }, 2000);
});

// Promise.allSettledを使ってすべての結果を取得
async function fetchAllData() {
  const results = await Promise.allSettled([
    fetchPosts(),
    fetchUsers(),
    fetchComments(),
    fetchData4() // ここは関数を呼び出す必要がある
  ]);

  // fulfilled の結果だけ JSON に変換
  const jsonPromises = results.map(async (result, index) => {
    if (result.status === 'fulfilled') {
      try {
        const data = await result.value.json(); // レスポンスをJSONに変換
        console.log(`API ${index + 1}のデータ取得成功:`, data.slice(0, 5)); // データの一部を表示
      } catch (jsonError) {
        console.error(`API ${index + 1}のJSON変換に失敗しました:`, jsonError);
      }
    } else {
      console.error(`API ${index + 1}のデータ取得失敗:`, result.reason);
    }
  });

  await Promise.all(jsonPromises); // JSON変換の処理がすべて完了するのを待つ  
}

// 関数を実行
fetchAllData();
