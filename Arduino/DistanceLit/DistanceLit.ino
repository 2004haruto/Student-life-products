/*
  DistanceLit
  Date : 2023/06/16
  Author : IE1A 05 H.Masaki
 */

// ピン番号をマクロで定義
#define TRIG_PIN 16  // トリガー（送信）
#define ECHO_PIN 17  // エコー（受信）

int LED_PIN = 25;

double duration = 0;  // 受信した時間
double distance = 0;  // 物との距離
// 起動時に一度だけ呼び出されるメソッド
void setup() {
  Serial.begin(115200);  // シリアル通信の転送レート（bps）を設定

  // ピンの入出力設定
  pinMode(TRIG_PIN, OUTPUT);  // トリガーを出力に設定
  pinMode(ECHO_PIN, INPUT);   // エコーを入力に設定
  pinMode(LED_PIN, OUTPUT);

  // トリガーを LOW に落としておく
  digitalWrite(TRIG_PIN, LOW);
  delay(10);  // 落ちきるまで少し待機
}
// 超音波送信メソッド
void sendTrigger() {
  digitalWrite(TRIG_PIN, HIGH);  // トリガーに HIGH を出力し、超音波を出す
  delayMicroseconds(10);         // 一瞬だけ待機
  digitalWrite(TRIG_PIN, LOW);   // トリガーに LOW を出力し、超音波を止める
}
// メインループメソッド
void loop() {
  sendTrigger();                       // 超音波送信
  duration = pulseIn(ECHO_PIN, HIGH);  // エコーから受信した時間(マイクロ秒)を取得

  // 受信した時間が受け取れている（0 より大きい）場合
  if (duration > 0) {
    duration /= 2;  // 往復の時間を片道（半分）に変換
    // 音速を 340m/s として受信した時間から距離（cm）に変換
    distance = duration * 340;
    distance /= 10000;

    // 
    if (distance <= 30) {
      digitalWrite(LED_PIN, HIGH);
    } else {
      digitalWrite(LED_PIN, LOW);
    }
    // 求めた距離をシリアルモニタに出力
    Serial.printf("距離:%.2lF cm\n", distance);
  }


  delay(1000);  // 1 秒待機
}
