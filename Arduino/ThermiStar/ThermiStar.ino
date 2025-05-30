/*
 Thermistor
 Date : 2023/07/14
 Author : IE1A 05 H.Masaki
*/

// ピン番号をマクロで定義
#define THER_PIN 15
#define LED_PIN 4
#define SPKR_PIN 27
int analogValue = 0;     // アナログ値（0~4095）
double temperature = 0;  // 温度

// スピーカーの PWM 出力関連を定義
#define LEDC_CHANNEL_0 0      // LEDC の PWM チャネル 0 から 15
#define LEDC_TIMER_13_BIT 13  // LEDC タイマーの精度 13 ビット
#define LEDC_BASE_FREQ 5000   // LEDC のベース周波数 5000Hz

// 使用する音の周波数を定義
#define C4 261.626   // ド
#define D4 293.665   // レ
#define E4 329.628   // ミ
#define F4 349.228   // ファ
#define G4 391.995   // ソ
#define A4 440.000   // ラ
#define B4 493.883   // シ
#define C5 523.251   // ド
#define D5 587.330   // レ
#define E5 659.255   // ミ
#define F5 698.456   // ファ
#define G5 783.991   // ソ
#define A5 880.000   // ラ
#define B5 987.767   // シ
#define C6 1046.502  // ド
#define D6 1174.659  // レ
#define E6 1318.510  // ミ
#define F6 1396.913  // ファ
#define G6 1567.982  // ソ
#define NONE 0       // 無音

#define WHOLE_NOTE 1000  // 全音符(1 秒)

int i = 0;
double star[] = { C5, NONE, C5, NONE, C5, NONE, D4, C5, NONE, C5, NONE, D4, C5, NONE, C5,
                    NONE, B4, NONE, B4, NONE, B4, NONE, C4, B4, NONE, B4, NONE, C4, B4, NONE, B4, NONE };
// 起動時に一度だけ呼び出されるメソッド
void setup() {
  Serial.begin(115200);      // シリアル通信の転送レート（bps）を設定
                             // ピンの入出力設定
  pinMode(LED_PIN, OUTPUT);  // LED を出力に設定

  // スピーカー用のチャネル設定(チャネル番号, ベース周波数, 精度ビット数)
  ledcSetup(LEDC_CHANNEL_0, LEDC_BASE_FREQ, LEDC_TIMER_13_BIT);
  // チャネルにスピーカーピンを接続(ピン番号, チャネル番号)
  ledcAttachPin(SPKR_PIN, LEDC_CHANNEL_0);
  
}

void melody(double *score, int len, int note) {
  for (int i = 0; i <= len; i++) {
    ledcWriteTone(LEDC_CHANNEL_0, score[i]);
    delay(note);
  }
  ledcWriteTone(LEDC_CHANNEL_0, NONE);  //消音
}


// メインループメソッド
void loop() {
 // サーミスタからアナログ値取得
 analogValue = analogRead(THER_PIN);

 // アナログ値から温度を求める
 temperature = ((25.0 / (2047 - 1024)) * analogValue - 25);
 Serial.println(temperature);
 // 温度が 25℃以上の場合
 if (temperature >= 30) {
    digitalWrite(LED_PIN, HIGH); // 点灯
    ledcWriteTone(LEDC_CHANNEL_0, star[i]);
    delay(WHOLE_NOTE / 11);
    i++;
    if(i == 31){
      i = 0;
    }
 } else {
 digitalWrite(LED_PIN, LOW); // 消灯
 ledcWriteTone(LEDC_CHANNEL_0, NONE);  //消音
 }
 
 delay(50); // 0.1 秒待機
}