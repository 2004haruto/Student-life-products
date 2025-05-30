// ピン番号をマクロで定義
#define THER_PIN 15
#define MOTOR_PIN 13
#define LEDC_CHANNEL_1 1    // LEDC の PWM チャネル 0 から 15
#define LEDC_TIMER_8_BIT 8  // LEDC タイマーの精度 8 ビット
#define LEDC_BASE_FREQ 100  // LEDC のベース周波数 100Hz
int analogValue = 0;        // アナログ値（0~4095）
double temperature = 0;     // 温度
boolean swData;             // SW の状態を保持する変数（true->ON, false->OFF）
boolean swDataOld = true;   // 前回の SW の状態を保持する変数（初期値は false）

// 起動時に一度だけ呼び出されるメソッド
void setup() {
  Serial.begin(115200);  // シリアル通信の転送レート（bps）を設定

  // モーターチャネル設定(チャネル番号, ベース周波数, 精度ビット数)
  ledcSetup(LEDC_CHANNEL_1, LEDC_BASE_FREQ, LEDC_TIMER_8_BIT);
  // モーターのチャネルにピンを接続(ピン番号, チャネル番号)
  ledcAttachPin(MOTOR_PIN, LEDC_CHANNEL_1);
  ;
}

void getTemperature() {
  // サーミスタからアナログ値取得
  analogValue = analogRead(THER_PIN);
  temperature = ((25.0 / (2047 - 1024)) * analogValue - 25);
}

// メインループメソッド
void loop() {

  getTemperature(); 
  int motorSpeed = temperature * 2;
  // モーターを回転（チャネル番号, 回転速度）
  ledcWrite(LEDC_CHANNEL_1,motorSpeed );
  // 速度文字をシリアルモニタに表示
  Serial.printf("温度: %.2F ℃, 回転速度：%d\n",temperature,motorSpeed);

  delay(1000);  // チャタリング防止
}
