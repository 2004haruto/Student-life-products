const endPoint = 'http://localhost:3000';

const postData = async (data) => {
  try{
    // fetch処理
    const response = await fetch(`${endPoint}/signup`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });

    console.log(response);

    // エラーチェック
    if(!response.ok){
      const errorData = await response.json(); // サーバーからのエラーメッセージを取得
      throw new Error(errorData.message || 'サインアップに失敗しました');
    }

    const result = await response.json();
    console.log('成功:', result);
  }catch(err){
    console.error(err);
    document.querySelector('#message').innerHTML = err;
  }
}

// 送信フォームサブミットイベント
document.querySelector('#signUpForm').addEventListener('submit', (event) => {
  event.preventDefault();
  const formData = new FormData(event.target);
  const data = Object.fromEntries(formData.entries());
  postData(data);
});