import { WebSocketServer } from 'ws';

// ポートの定義とサーバーの作成
const port = 3000;
const wss = new WebSocketServer({ port });

// クライアントIDを管理するカウンター
let clientIdCounter = 1;

wss.on('connection', (ws) => {
    console.log('クライアントが接続されました');
  
    // 新しいクライアントに一意のIDを割り当て
    ws.clientId = clientIdCounter++;
  
    // 接続時にクライアントIDを送信
    ws.send(JSON.stringify({ type: 'assignId', id: ws.clientId }));
  
    // クライアントからのメッセージを受信したときの処理
    ws.on('message', (message) => {
      console.log('受信したメッセージ:', message);
  
      try {
        const parsedMessage = JSON.parse(message);

        // 受信したメッセージをすべてのクライアントに送信
        wss.clients.forEach(client => {
          if (client.readyState === ws.OPEN && client !== ws) {
            const messageToSend = {
              id: ws.clientId,
              name: parsedMessage.name || '匿名',  // 名前が未指定なら「匿名」
              text: parsedMessage.text,
              timestamp: new Date().toLocaleString(),  // 現在の日時をタイムスタンプとして使用
            };

            client.send(JSON.stringify(messageToSend));
          }
        });
      } catch (error) {
        console.error('メッセージのパースエラー:', error);
      }
    });
  
    // クライアントが切断したときの処理
    ws.on('close', () => {
      console.log(`クライアントID ${ws.clientId} が切断されました`);
    });
  
    // エラーが発生した時の処理
    ws.on('error', (error) => {
      console.error(`クライアントID ${ws.clientId} でエラーが発生しました:`, error);
    });
});
  
// サーバーを起動
console.log(`WebSocket server is running on port ${port}.`);
