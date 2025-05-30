/*
 PressurePiano
 Date : 2022/07/28
 Author : IE1A 05 H.Masaki
*/
// ピン番号をマクロで定義
#define LED_PIN 4
#define PRES_PIN 25
#define SPKR_PIN 27

// LED の PWM 出力関連を定義
#define LEDC_CHANNEL_15 15
#define LEDC_TIMER_12_BIT 12
// スピーカーの PWM 出力関連を定義
#define LEDC_CHANNEL_0 0      // LEDC の PWM チャネル 0 から 15
#define LEDC_TIMER_13_BIT 13  // LEDC タイマーの精度 13 ビット
#define LEDC_BASE_FREQ 5000   // LEDC のベース周波数 5000Hz
// LEDC のベース周波数
#define LEDC_BASE_FREQ 5000
// 使用する音の周波数を定義
#define C5 523.251     // ド
#define D5 587.330     // レ
#define E5 659.255     // ミ
#define F5 698.456     // ファ
#define G5 783.991     // ソ
#define A5 880.000     // ラ
#define B5 987.767     // シ
#define C6 1046.502    // ド
#define NONE 0         // 無音
#define HALF_NOTE 500  // 二分音符

// 起動時に一度だけ呼び出されるメソッド
void setup() {
  Serial.begin(115200);  // シリアル通信の転送レート（bps）を設定
  // LED 用のチャネル設定(チャネル番号, ベース周波数, 精度ビット数)
  ledcSetup(LEDC_CHANNEL_15, LEDC_BASE_FREQ, LEDC_TIMER_12_BIT);
  // チャネルに LED ピンを接続(ピン番号, チャネル番号)
  ledcAttachPin(LED_PIN, LEDC_CHANNEL_15);
  // スピーカー用のチャネル設定(チャネル番号, ベース周波数, 精度ビット数)
  ledcSetup(LEDC_CHANNEL_0, LEDC_BASE_FREQ, LEDC_TIMER_13_BIT);
  // チャネルにスピーカーピンを接続(ピン番号, チャネル番号)
  ledcAttachPin(SPKR_PIN, LEDC_CHANNEL_0);
}
// メインループメソッド
void loop() {
  // 圧力センサーから圧力値取得
  int pressure = analogRead(PRES_PIN);
  // 圧力値をシリアルモニタとプロッタに出力
  Serial.println(pressure);
  // 読み取った圧力値分、LED を点灯（チャネル番号, 出力値）
  ledcWrite(LEDC_CHANNEL_15, pressure);
  //圧力値が 0 の（センサーに触れていない）場合、消音する
  if (pressure == 0) {
    ledcWriteTone(LEDC_CHANNEL_0, NONE);  //消音
  } else if (pressure <= 511) {
    ledcWriteTone(LEDC_CHANNEL_0, C5);  //ド
  } else if (pressure <= 1023) {
    ledcWriteTone(LEDC_CHANNEL_0, D5);  //レ
  } else if (pressure <= 1535) {
    ledcWriteTone(LEDC_CHANNEL_0, E5);  //ミ
  } else if (pressure <= 2047) {
    ledcWriteTone(LEDC_CHANNEL_0, F5);  //ファ
  } else if (pressure <= 2559) {
    ledcWriteTone(LEDC_CHANNEL_0, G5);  //ソ
  } else if (pressure <= 3071) {
    ledcWriteTone(LEDC_CHANNEL_0, A5);  //ラ
  } else if (pressure <= 3583) {
    ledcWriteTone(LEDC_CHANNEL_0, B5);  //シ
  } else if (pressure <= 4095) {
    ledcWriteTone(LEDC_CHANNEL_0, C6);  //ド
  }
  delay(HALF_NOTE);
  delay(100);  // 0.1 秒待機
}