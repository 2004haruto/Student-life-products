// 複数のAPIからデータを取得する非同期関数
async function fetchMultipleData() {
    try {
      // 並行してAPIリクエストを行う
      const [postsResponse, usersResponse, commentsResponse] = await Promise.all([
        fetch('https://jsonplaceholder.typicode.com/posts'),
        fetch('https://jsonplaceholder.typicode.com/users'),
        fetch('https://jsonplaceholder.typicode.com/comments')
      ]);
  
      // エラーチェック
      if (!postsResponse.ok) throw new Error('Postデータの取得に失敗しました');
      if (!usersResponse.ok) throw new Error('Userデータの取得に失敗しました');
      if (!commentsResponse.ok) throw new Error('Commentデータの取得に失敗しました');
  
      // データをJSON形式に変換
      const posts = await postsResponse.json();
      const users = await usersResponse.json();
      const comments = await commentsResponse.json();
  
      // データ表示
      console.log('取得したPostデータ:', posts.slice(0, 5));
      console.log('取得したUserデータ:', users.slice(0, 5));
      console.log('取得したCommentデータ:', comments.slice(0, 5));
        
    } catch (error) {
      // エラーハンドリング
      console.error('エラーが発生しました:', error);
    }
  }
  
  // 関数を実行
  fetchMultipleData();