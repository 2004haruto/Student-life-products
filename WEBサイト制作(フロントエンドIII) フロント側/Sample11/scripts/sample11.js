// ログイン処理

const endPoint = 'http://localhost:3000';

async function login() {
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;
  
    try {
      const response = await fetch(`${endPoint}/login`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        credentials: 'include', // クッキーの送信を許可
        body: JSON.stringify({ email, password })
      });
  
      const data = await response.json();
  
      if (response.ok) {
        //token = data.token;
        //localStorage.setItem('token', token); // ローカルストレージにトークンを保存
        document.querySelector('#login-message').textContent = 'ログインに成功しました';
        document.querySelector('#login-form').style.display = 'none';
        document.querySelector('#user-list').style.display = 'block';
        fetchUsers(); // ログイン成功後にユーザー一覧を取得
      } else {
        document.getElementById('login-message').textContent = data.message;
      }
    } catch (error) {
      console.error('ログインエラー:', error);
    }
}

// ローカルストレージからトークンを取得
//let token = localStorage.getItem('token') || '';

// ログアウト処理
async function logout() {

  try {
    const response = await fetch(`${API_URL}/logout`, {
      method: 'POST',
      credentials: 'include' // クッキーを送信
    });

    if (response.ok) {
      // ログインフォームを表示し、ユーザー一覧を非表示
      document.getElementById('login-form').style.display = 'block';
      document.getElementById('user-list').style.display = 'none';
      document.getElementById('users').innerHTML = ''; // ユーザー一覧をクリア
      document.getElementById('login-message').textContent = 'ログアウトしました';
    }
  } catch (error) {
    console.error('ログアウトエラー:', error);
  }
}

// ユーザー一覧取得処理
async function fetchUsers() {
    try {
      const response = await fetch(`${endPoint}/users`, {
        method: 'GET',
        // headers: {
        //   'Authorization': token
        // }
        credentials: 'include' // クッキーを含めてリクエスト
      });
  
      if (response.status === 401) {
        // トークンの有効期限が切れている場合、ログイン画面に戻す
        alert('セッションが切れました。再度ログインしてください。');
        logout();
        return;
      }
  
      const data = await response.json();
  
      if (response.ok) {
        const usersList = document.getElementById('users');
        usersList.innerHTML = ''; // 既存のリストをクリア
  
        // ユーザー一覧を表示
        data.forEach(user => {
          const listItem = document.createElement('li');
          listItem.textContent = `名前: ${user.name}, メール: ${user.email}`;
          usersList.appendChild(listItem);
        });
        
      } else if (response.status === 401) {
        console.log('未認証のため、ユーザー一覧は取得できません。');
        // ログインフォームを表示
        document.getElementById('login-form').style.display = 'block';
        document.getElementById('user-list').style.display = 'none';      }
    } catch (error) {
      console.error('ユーザー一覧取得エラー:', error);
    }
}

// 以下、ページロード時の処理
document.querySelector('#loginBtn').addEventListener('click', login);
document.querySelector('#logoutBtn').addEventListener('click', logout);

// ページロード時にトークンがあればユーザー一覧を表示
// if (token) {
//   document.querySelector('#login-form').style.display = 'none';
//   document.querySelector('#user-list').style.display = 'block';
//   fetchUsers();
// }

// ページロード時にログイン状態をチェック
window.addEventListener('load', () => {
  fetchUsers(); // 認証があればユーザー一覧を表示し、なければログイン画面のみ表示
});