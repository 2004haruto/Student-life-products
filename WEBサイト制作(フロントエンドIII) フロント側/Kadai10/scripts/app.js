const endPoint = 'http://localhost:3000'; // サーバーのURL

// ユーザー登録（サインアップ）
async function signup() {
  const name = document.querySelector('#signup-name').value;
  const email = document.querySelector('#signup-email').value;
  const password = document.querySelector('#signup-password').value;

  try {
    const response = await fetch(`${endPoint}/signup`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name, email, password }),
    });

    const data = await response.json();
    if (response.ok) {
      alert('登録が成功しました。ログインしてください。');
      showLogin(); // ログイン画面を表示
    } else {
      alert(data.message || '登録に失敗しました。');
    }
  } catch (error) {
    console.error('登録エラー:', error);
    alert('エラーが発生しました。');
  }
}

// ログイン
async function login() {
  const email = document.querySelector('#login-email').value;
  const password = document.querySelector('#login-password').value;

  try {
    const response = await fetch(`${endPoint}/login`, {
      method: 'POST',
      headers: { 
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ email, password }),
    });

    const data = await response.json();

    if (response.ok) {
      token = data.token;
      localStorage.setItem('token', token); // ローカルストレージにトークンを保存
      document.querySelector('#login-message').textContent = 'ログインに成功しました';
      showProfile(); // プロフィール画面を表示
      fetchProfile(token); // プロフィールデータを取得
    } else {
      document.querySelector('#login-message').textContent = data.message || 'ログインに失敗しました。';
    }
  } catch (error) {
    console.error('ログインエラー:', error);
    document.querySelector('#login-message').textContent = 'エラーが発生しました。';
  }
}

// ローカルストレージからトークンを取得
let token = localStorage.getItem('token') || '';

// ログアウト
function logout() {
  token = '';
  localStorage.removeItem('token'); // ローカルストレージからトークンを削除
  showLogin(); // ログイン画面を表示
  document.querySelector('#profile').style.display = 'none';
  document.querySelector('#profile-info').textContent = ''; // プロフィール情報をクリア
  document.querySelector('#login-message').textContent = ''; // ログインメッセージをクリア
}


// プロフィール情報を取得
async function fetchProfile(token) {
  try {
    const response = await fetch(`${endPoint}/profile`, {
      headers: { Authorization: token },
    });

    const data = await response.json();
    if (response.ok) {
      document.querySelector('#profile-info').textContent = `名前: ${data.name}, メール: ${data.email}`;
    } else {
      alert(data.message || 'プロフィール取得に失敗しました。');
      showLogin(); // トークンが無効な場合はログイン画面に戻す
    }
  } catch (error) {
    console.error('プロフィール取得エラー:', error);
    alert('エラーが発生しました。');
  }
}

// 表示切り替え
function showSignup() {
  document.querySelector('#signup-form').style.display = 'block';
}

function showLogin() {
  document.querySelector('#login-form').style.display = 'block';
}

function showProfile() {
  document.querySelector('#profile').style.display = 'block';
}

// 初期化処理
document.addEventListener('DOMContentLoaded', () => {
  const token = localStorage.getItem('token');
  if (token) {
    showProfile(); // トークンがある場合、プロフィール画面へ
    fetchProfile(`Bearer ${token}`); // トークンを使ってプロフィールを取得
  } else {
    showLogin(); // トークンがない場合はログイン画面を表示
  }
});

// イベントリスナーの登録
document.querySelector('#signupBtn').addEventListener('click', signup);
document.querySelector('#loginBtn').addEventListener('click', login);
document.querySelector('#logoutBtn').addEventListener('click', logout);
