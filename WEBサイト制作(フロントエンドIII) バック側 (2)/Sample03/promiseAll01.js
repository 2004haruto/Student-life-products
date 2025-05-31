// 複数のAPIからデータを取得する非同期関数
async function fetchMultipleData() {
    try {
      // 並行してAPIリクエストを行う
      const [postsResponse, usersResponse] = await Promise.all([
        fetch('https://jsonplaceholder.typicode.com/posts/1'),
        fetch('https://jsonplaceholder.typicode.com/users/1')
      ]);
  
      // エラーチェック
      if (!postsResponse.ok) throw new Error('Postデータの取得に失敗しました');
      if (!usersResponse.ok) throw new Error('Userデータの取得に失敗しました');
  
      // データをJSON形式に変換
      const posts = await postsResponse.json();
      const users = await usersResponse.json();
  
      // データ表示
      console.log('取得したPostデータ:', posts);
      console.log('取得したUserデータ:', users);
  
    } catch (error) {
      // エラーハンドリング
      console.error('エラーが発生しました:', error);
    }
  }
  
  // 関数を実行
  fetchMultipleData();