import { WebSocketServer } from 'ws';

// ポートの定義とサーバーの作成
const port = 3000;
const wss = new WebSocketServer({ port });

wss.on('connection', (ws) => {
    console.log('クライアントが接続されました');
  
    // クライアントからのメッセージを受信したときの処理
    // メッセージが来たら、すべてのクライアントにメッセージを送信
    ws.on('message', (message) => {
      console.log('受信したメッセージ:', message);
  
      // すべてのクライアントにメッセージを送信
      wss.clients.forEach(client => {
        if (client.readyState === ws.OPEN) {
          client.send(`サーバーから: ${message}`);
        }
      });
    });
  
    // クライアントが切断したときの処理
    ws.on('close', () => {
      console.log('クライアントが切断されました');
    });
  });
  
// サーバーを起動
console.log(`WebSocket server is running on port ${port}.`);