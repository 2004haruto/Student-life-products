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
        body: JSON.stringify({ email, password })
      });
  
      const data = await response.json();
  
      if (response.ok) {
        token = data.token;
        localStorage.setItem('token', token); // ローカルストレージにトークンを保存
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
let token = localStorage.getItem('token') || '';

// ログアウト処理
function logout() {
    token = '';
    localStorage.removeItem('token'); // ローカルストレージからトークンを削除
    document.querySelector('#login-form').style.display = 'block';
    document.querySelector('#user-list').style.display = 'none';
    document.querySelector('#email').value = '';
    document.querySelector('#password').value = '';
    document.querySelector('#login-message').textContent = 'ログアウトしました';
}

// ユーザー一覧取得処理
async function fetchUsers() {
    try {
      const response = await fetch(`${endPoint}/users`, {
        method: 'GET',
        headers: {
          'Authorization': token
        }
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
      } else {
        console.error('ユーザー一覧取得エラー:', data.message);
      }
    } catch (error) {
      console.error('ユーザー一覧取得エラー:', error);
    }
}

// 以下、ページロード時の処理
document.querySelector('#loginBtn').addEventListener('click', login);
document.querySelector('#logoutBtn').addEventListener('click', logout);

// ページロード時にトークンがあればユーザー一覧を表示
if (token) {
  document.querySelector('#login-form').style.display = 'none';
  document.querySelector('#user-list').style.display = 'block';
  fetchUsers();
}