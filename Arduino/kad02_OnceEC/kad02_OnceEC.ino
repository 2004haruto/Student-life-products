/*
	Switch
	Date : 2024/10/02
	Author : IE2B H.Masaki
*/

//ピン番号をマクロで定義
#define LED1_PIN 17  // 赤色LED
#define SW_PIN 22    // タクトスイッチ

//各時間を変数にする
int dot = 200;   // 「・」の点灯時間（200ミリ秒）
int dash = 600;  // 「ー」の点灯時間（600ミリ秒）
int off = 100;   // 消灯時間（100ミリ秒）
int signalPause = 1000;  // SOS信号の間隔（1秒）

// モールス符号の定義
int eSignal[] = {dot};  // E = 「・」1つ
int cSignal[] = {dash, dot, dash, dot};  // C = 「・」2つ,「ー」2つ

// 配列の長さを計算
int eLength = sizeof(eSignal) / sizeof(eSignal[0]);
int cLength = sizeof(cSignal) / sizeof(cSignal[0]);

// SWの状態を保持する変数
int swData;

bool hasTransmitted = false;  // 信号が送信されたかどうかを管理するフラグ

void setup() {
  Serial.begin(115200);       // シリアル通信の転送レート（bps）を設定
  pinMode(LED1_PIN, OUTPUT);  // LEDのピンを出力に設定
  pinMode(SW_PIN, INPUT);     // SWITCHのピンを入力に設定
}

// 信号を送信する関数
void transmitMorse(int signal[], int length) {
  for (int i = 0; i < length; i++) {
    digitalWrite(LED1_PIN, HIGH);  // LEDを点灯
    delay(signal[i]);              // 「・」または「ー」の点灯時間
    digitalWrite(LED1_PIN, LOW);   // LEDを消灯
    delay(off);            // 消灯時間
  }
}

void loop() {
  int swData = digitalRead(SW_PIN);  // スイッチの状態を読み取る

  // スイッチが押され、まだ信号が送信されていない場合
  if (swData == HIGH && !hasTransmitted) {
    // E信号を送信
    transmitMorse(eSignal, eLength);
    // C信号を送信
    transmitMorse(cSignal, cLength);
    // C信号を送信
    transmitMorse(cSignal, cLength);

    hasTransmitted = true;  // 信号が送信されたことを記録

  } else if (swData == LOW) {
    hasTransmitted = false;  // スイッチが離されたら、再度押せるようにフラグをリセット
  }

  delay(10);  // チャタリング防止のための待機時間
  /*
	  アドバイス！
	  スイッチを押した時に生じる接点の反発により、電圧が高速でHIGH・LOWを繰り返す現象をチャタリングという。
	  プログラムが高速で動作していることにより、チャタリングが起きた際にスイッチが誤動作する可能性がある。
	  それを防止するにはメインルーチンの最後に【10ミリ秒以上の待機があれば良い】為、上記のコードを記述する必要がある。
	*/
}