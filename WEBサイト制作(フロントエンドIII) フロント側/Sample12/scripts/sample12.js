// メッセージリストの取得
const messageList = document.querySelector('#messages');

// メッセージを画面に表示する関数
function addMessage(name, text, timestamp, isMyMessage = false) {
  const li = document.createElement('li');
  li.classList.add('message-item');

  // 名前部分
  const nameElement = document.createElement('div');
  nameElement.textContent = name;
  nameElement.classList.add('message-name');

  // メッセージ内容
  const textElement = document.createElement('div');
  textElement.textContent = text;
  textElement.classList.add('message-content');

  // 日付部分
  const timestampElement = document.createElement('div');
  timestampElement.textContent = timestamp;
  timestampElement.classList.add('message-timestamp');

  // 名前、メッセージ、日付をラップするコンテナ
  const messageWrapper = document.createElement('div');
  messageWrapper.classList.add('message-wrapper');
  messageWrapper.appendChild(nameElement);
  messageWrapper.appendChild(textElement);
  messageWrapper.appendChild(timestampElement);

  // 自分のメッセージなら 'sent' クラスを追加
  if (isMyMessage) {
    li.classList.add('sent');
  } else {
    li.classList.add('received');
  }

  li.appendChild(messageWrapper);
  messageList.appendChild(li);

  // メッセージリストをスクロールして最新メッセージを表示
  messageList.scrollTop = messageList.scrollHeight;
}

// クライアントIDの初期値
let clientId = null;

// WebSocketサーバーに接続
const socket = new WebSocket('ws://localhost:3000');

// WebSocketサーバーと接続された時の処理
socket.onopen = () => {
  console.log('サーバーと接続しました');
  addMessage('システム', 'サーバーと接続しました', new Date().toLocaleString());
};

// サーバーからメッセージを受信した時の処理
socket.onmessage = (event) => {
  console.log('受信したメッセージ：', event.data);

  try {
    const data = JSON.parse(event.data);

    // サーバーからIDの通知を受けた場合
    if (data.type === 'assignId') {
      clientId = data.id;
      console.log('自分のクライアントID:', clientId);
    }
    // サーバーからのメッセージであれば表示
    else if (data.id !== clientId) { // 自分が送信したメッセージでない場合
      addMessage(data.name, data.text, data.timestamp || new Date().toLocaleString());
    }
  } catch (error) {
    console.error('受信メッセージのパースエラー:', error);
  }
};

// WebSocket接続が閉じられた時の処理
socket.onclose = () => {
  console.log('サーバーとの接続が閉じられました');
  addMessage('システム', 'サーバーとの接続が閉じられました', new Date().toLocaleString());
};

// エラー発生時の処理
socket.onerror = (error) => {
  console.error('WebSocket接続中にエラーが発生しました', error);
};

// メッセージ送信ボタンのクリックイベント
document.querySelector('#sendButton').addEventListener('click', () => {
  const nameInput = document.querySelector('#nameInput');
  const messageInput = document.querySelector('#messageInput');
  const name = nameInput.value.trim();
  const message = messageInput.value.trim();

  if (name === '' || message === '') {
    alert('名前とメッセージは必須です');
    return;
  }

  // 現在の日時を取得
  const timestamp = new Date().toLocaleString();

  // サーバーにメッセージ送信
  const messageData = {
    name: name,
    text: message,
    timestamp: timestamp,
  };

  socket.send(JSON.stringify(messageData));

  // 自分のメッセージを右側に表示
  addMessage(name, message, timestamp, true);
  messageInput.value = ''; // 入力フィールドクリア
});
