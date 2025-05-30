/*
	Switch
	Date : 2024/01/01
	Author : IE2A K.Murakami
*/

//ピン番号をマクロで定義
#define LED1_PIN 17  // 赤色LED
#define SW_PIN 22    // タクトスイッチ

// SWの状態を保持する変数
int swData;

void setup() {
  Serial.begin(115200);       // シリアル通信の転送レート（bps）を設定
  pinMode(LED1_PIN, OUTPUT);  // LEDのピンを出力に設定
  pinMode(SW_PIN, INPUT);     // SWITCHのピンを入力に設定
}

void loop() {
  // SWの入力を読み取る（ON->HIGH, OFF->LOW）
  swData = digitalRead(SW_PIN);

  // スイッチが押されている場合
  if (swData == HIGH) {
    digitalWrite(LED1_PIN, HIGH);  // LEDにHIGHを出力し点灯する
    Serial.println("点灯"); 
  } else {
    digitalWrite(LED1_PIN, LOW);  // LEDにLOWを出力し消灯する
    Serial.println("消灯");
  }

  delay(10);  // チャタリング防止
  /*
	  アドバイス！
	  スイッチを押した時に生じる接点の反発により、電圧が高速でHIGH・LOWを繰り返す現象をチャタリングという。
	  プログラムが高速で動作していることにより、チャタリングが起きた際にスイッチが誤動作する可能性がある。
	  それを防止するにはメインルーチンの最後に【10ミリ秒以上の待機があれば良い】為、上記のコードを記述する必要がある。
	*/
}