const apiUrl = 'http://localhost:3000';

// ログイン処理
async function login() {
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  try {
    const response = await fetch(`${apiUrl}/login`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include',
      body: JSON.stringify({ email, password })
    });

    const data = await response.json();
    const loginMessage = document.getElementById('login-message');

    if (response.ok) {
      loginMessage.textContent = 'ログイン成功';
      document.getElementById('login-form').style.display = 'none';
      document.getElementById('post-form').style.display = 'block';
    } else {
      loginMessage.textContent = data.message;
    }
  } catch (error) {
    console.error('ログインエラー:', error);
  }
}

// 投稿作成処理
async function createPost() {
  const title = document.getElementById('title').value;
  const content = document.getElementById('content').value;

  try {
    const response = await fetch(`${apiUrl}/posts`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include', // クッキーを送信
      body: JSON.stringify({ title, content })
    });

    if (response.ok) {
      alert('投稿が作成されました');
      loadPosts();
    } else {
      alert('投稿の作成に失敗しました');
    }
  } catch (error) {
    console.error('投稿作成エラー:', error);
  }
}

// 投稿一覧の読み込み
async function loadPosts() {
  try {
    const response = await fetch(`${apiUrl}/posts`, { method: 'GET', credentials: 'include' });
    const posts = await response.json();
    const postsList = document.getElementById('posts');
    postsList.innerHTML = '';

    posts.forEach(post => {
      const li = document.createElement('li');
      li.innerHTML = `<h3>${post.title}</h3><p>${post.content}</p>`;
      postsList.appendChild(li);
    });
  } catch (error) {
    console.error('投稿取得エラー:', error);
  }
}

// ページロード時に投稿一覧を読み込む
window.onload = loadPosts;