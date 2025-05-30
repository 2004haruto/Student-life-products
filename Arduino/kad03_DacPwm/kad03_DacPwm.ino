/*
  Pwm
  Date : 2024/10/09
  Author : IE2B H.Masaki
*/

// ピン番号をマクロで定義
#define LED1_PIN 25   // 赤色LED
#define LED2_PIN A10  // 青色LED
#define SW_PIN 22     // タクトスイッチ

// PWM用チャネル設定値
#define PWM_CH 0      // チャネル（0-15）
#define PWM_FREQ 5000 // 周波数
#define PWM_BIT 8     // ビット数（0-255）

// 明るさ制御用の変数
int brightness = 0;      // 初期の明るさ
int increment = 1;       // 明るさの増減量（1単位）
bool increasing = true;  // 明るさが増加中かどうかを記録
bool lastSwitchState = LOW; // 最後のスイッチの状態を保存

void setup() {
  Serial.begin(115200);                  // シリアル通信の転送レートを設定
  pinMode(LED1_PIN, OUTPUT);             // 赤色LEDのピンを出力に設定
  pinMode(SW_PIN, INPUT_PULLUP);         // スイッチのピンをプルアップ付きで入力に設定
  ledcSetup(PWM_CH, PWM_FREQ, PWM_BIT);  // PWMチャネルの設定
  ledcAttachPin(LED2_PIN, PWM_CH);  
}

// 明るさをセットする関数
void setBrightness(int level) {
  dacWrite(LED1_PIN, level);         // 赤色LEDにDAC出力
  ledcWrite(PWM_CH, level);          // 青色LEDにPWM出力
  Serial.printf("デューティー値:%d\n", level);  // シリアルモニタに明るさを出力
}

// スイッチの状態をチェックして増減を切り替える関数
void checkSwitch() {
  bool currentSwitchState = digitalRead(SW_PIN); // 現在のスイッチの状態を読み取る
  static const unsigned long debounceDelay = 50; // デバウンスの遅延時間（ミリ秒）

  // スイッチが押されている状態から離された状態に変わったとき
  if (lastSwitchState == HIGH && currentSwitchState == LOW) {
    increasing = !increasing;  // 増加・減少を切り替え
    Serial.println("増減切り替え");  // 「増減切り替え」を表示
  }

  lastSwitchState = currentSwitchState; // 現在の状態を保存
}

// 明るさを更新する関数
void updateBrightness() {
  if (increasing) {
    brightness += increment;  // 明るさを増加
    if (brightness > 255) {   // 明るさが最大値を超えないように制御
      brightness = 255;
    }
  } else {
    brightness -= increment;  // 明るさを減少
    if (brightness < 0) {     // 明るさが最小値を下回らないように制御
      brightness = 0;
    }
  }

  setBrightness(brightness);  // 更新した明るさを設定
}

void loop() {
  checkSwitch();      // スイッチの状態をチェック
  updateBrightness(); // 明るさを更新
  delay(10);          // 10ミリ秒ごとに明るさを変化させる
}
