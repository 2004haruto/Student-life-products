document.getElementById('uploadForm').addEventListener('submit', async (event) => {
    event.preventDefault();
  
    const formData = new FormData();
    const fileInput = document.querySelector('#fileInput');
    const title = document.querySelector('#title').value;
    const description = document.querySelector('#description').value;
    const jsonInput = { title, description };
  
    formData.append('file', fileInput.files[0]); // ファイルを追加
    formData.append('metadata', JSON.stringify(jsonInput)); // JSONデータを追加
  
    try {
      const response = await fetch('http://localhost:3000/upload', {
        method: 'POST',
        body: formData
      });
  
      const result = await response.json();
      console.log(result);
      document.querySelector('#message').textContent = result.message;
      const img = document.createElement('img');
      img.src = result.fileUrl;
      document.querySelector('#imgArea').append(img);
    } catch (error) {
      console.error('エラー:', error);
      document.querySelector('#message').textContent = '送信に失敗しました。';
    }
  });