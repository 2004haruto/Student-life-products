// フォーム要素とプロフィールリスト要素の取得
const profileForm = document.getElementById('profileForm');
const profilesList = document.getElementById('profilesList');

// プロフィール登録処理
profileForm.addEventListener('submit', async (event) => {
  event.preventDefault(); // デフォルトのフォーム送信を無効化

  const formData = new FormData(profileForm); // フォームデータを取得

  try {
    const response = await fetch('http://localhost:3000/profiles', {
      method: 'POST',
      body: formData,
    });

    if (!response.ok) {
      throw new Error('プロフィール登録に失敗しました');
    }

    const result = await response.json();
    alert('プロフィールを登録しました！');
    fetchProfiles(); // プロフィール一覧を再取得
  } catch (error) {
    console.error('エラー:', error);
    alert('エラー: ' + error.message);
  }
});

// プロフィール一覧取得処理
async function fetchProfiles() {
  try {
    const response = await fetch('http://localhost:3000/profiles');
    if (!response.ok) {
      throw new Error('プロフィール一覧の取得に失敗しました');
    }

    const data = await response.json();
    console.log(data); // ここでデータの内容を確認

    profilesList.innerHTML = ''; // リストをクリア

    // もしdataがオブジェクト形式でprofilesというキーに配列が入っている場合
    const profiles = data.profiles || []; // プロフィールが含まれる配列を取得

    profiles.forEach((profile) => {
      const li = document.createElement('li');

      li.innerHTML = `
        <img src="${profile.profileImage}" alt="プロフィール画像" style="width: 100px;">
        <span>${profile.name} (${profile.email})</span>
        <button onclick="deleteProfile('${profile.id}')">削除</button>
      `;

      profilesList.appendChild(li);
    });
  } catch (error) {
    console.error('エラー:', error);
    alert('エラー: プロフィール一覧を取得できません');
  }
}

// プロフィール削除処理
async function deleteProfile(id) {
  try {
    const response = await fetch(`http://localhost:3000/profiles/${id}`, {
      method: 'DELETE',
    });

    if (!response.ok) {
      throw new Error('プロフィール削除に失敗しました');
    }

    alert('プロフィールを削除しました！');
    fetchProfiles(); // プロフィール一覧を再取得
  } catch (error) {
    console.error('エラー:', error);
    alert('エラー: ' + error.message);
  }
}

// ページ読み込み時にプロフィール一覧を取得
fetchProfiles();
