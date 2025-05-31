fetch('https://jsonplaceholder.typicode.com/users')
  .then((response) => response.json())
  .then((data) => {
    console.log('データ取得成功：', data);
  })
  .catch((error) => {
    console.error('データ取得失敗：', error);
  });