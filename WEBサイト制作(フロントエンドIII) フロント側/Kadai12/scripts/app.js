// メッセージリストの取得
const messageList = document.querySelector('#messages');

// メッセージを画面に表示する関数
function addMessage(name, text, isMyMessage = false, timestamp = '') {
  const li = document.createElement('li');
  li.classList.add('message-item');

  const messageContent = document.createElement('div');
  messageContent.classList.add('message-content');

  // 名前の部分を表示
  const messageName = document.createElement('div');
  messageName.classList.add('message-name');
  messageName.textContent = name;

  // メッセージ内容の部分を表示
  const messageText = document.createElement('div');
  messageText.classList.add('message-text');
  messageText.textContent = text;

  // タイムスタンプの作成
  const timeSpan = document.createElement('span');
  timeSpan.classList.add('timestamp');
  timeSpan.textContent = timestamp;
  timeSpan.style.display = 'block'; // タイムスタンプをブロック要素にして新しい行に表示

  // 順番を名前 -> メッセージ -> 時刻に変更
  messageContent.appendChild(messageName);
  messageContent.appendChild(messageText);
  messageContent.appendChild(timeSpan);
  li.appendChild(messageContent);

  // メッセージが自分のものなら、'sent'クラスを追加
  if (isMyMessage) {
    li.classList.add('sent');
  } else {
    li.classList.add('received');
  }

  messageList.appendChild(li);

  // メッセージリストをスクロールして最新のメッセージを表示
  messageList.scrollTop = messageList.scrollHeight;
}

// クライアントIDの初期値
let clientId = null;

// WebSocketサーバーに接続
const socket = new WebSocket('ws://localhost:3000');

// WebSocketサーバーと接続された時の処理
socket.onopen = () => {
    console.log('サーバーと接続しました');
    addMessage('サーバーと接続しました');
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
            addMessage(data.name, data.text, false, data.timestamp);
        }
    } catch (error) {
        console.error('受信メッセージのパースエラー:', error);
    }
};

// WebSocket接続が閉じられた時の処理
socket.onclose = () => {
    console.log('サーバーとの接続が閉じられました');
    addMessage('サーバーとの接続が閉じられました');
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

    const timestamp = new Date().toLocaleTimeString(); // タイムスタンプの取得

    // サーバーにメッセージ送信
    const messageData = {
        name: name,
        text: message,
        timestamp: timestamp,
    };

    socket.send(JSON.stringify(messageData));

    // 自分のメッセージを右側に表示
    addMessage(name, message, true, timestamp);
    messageInput.value = '';  // 入力フィールドクリア
});
