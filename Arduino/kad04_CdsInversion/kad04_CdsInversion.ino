/*
  Cds
  Date : 2024/10/23
  Author : IE2B H.Masaki
*/

// ピン番号をマクロで定義
#define CDS_PIN A7  // CDSセル
#define LED1_PIN 25 // 赤色LED
#define LED2_PIN A10 // 青色LED
#define SW_PIN 22    // タクトスイッチ

// PWM用チャネル設定値
#define PWM_CH 0      // チャネル（0-15）
#define PWM_FREQ 5000 // 周波数
#define PWM_BIT 8     // ビット数（0-255）

bool inverted = false;            // 明るさ反転の状態
bool lastSwitchState = HIGH;      // 最後のスイッチの状態を保存

void setup() {
  Serial.begin(115200);           // シリアル通信の転送レート（bps）を設定
  pinMode(CDS_PIN, INPUT);        // CDSのピンを入力に設定
  pinMode(LED1_PIN, OUTPUT);      // 赤色LEDのピンを出力に設定
  pinMode(SW_PIN, INPUT_PULLUP);  // スイッチのピンをプルアップ付きで入力に設定
  ledcSetup(PWM_CH, PWM_FREQ, PWM_BIT); // PWMチャネルの設定
  ledcAttachPin(LED2_PIN, PWM_CH); // 青色LEDにPWMを割り当て
}

void loop() {
  checkSwitch();                  // スイッチの状態をチェック

  // CDSセルからアナログ値を読み取る
  int cdsValue = analogRead(CDS_PIN);
  Serial.printf("アナログ値：%d\n", cdsValue);

  // 明るさを0-255にスケーリング
  int brightness = map(cdsValue, 0, 4095, 0, 255);

  // 反転した状態に応じてLEDの明るさを設定
  if (inverted) {
    // 反転状態: 青色LEDが明るく、赤色LEDが暗く
    ledcWrite(PWM_CH, brightness);          // 青色LEDにPWM出力
    dacWrite(LED1_PIN, 255 - brightness);   // 赤色LEDにDAC出力
  } else {
    // 初期状態: 赤色LEDが明るく、青色LEDが暗く
    ledcWrite(PWM_CH, 255 - brightness);    // 青色LEDにPWM出力
    dacWrite(LED1_PIN, brightness);          // 赤色LEDにDAC出力
  }

  delay(10); // 10ミリ秒ごとに変更
}

// スイッチの状態をチェックする関数
void checkSwitch() {
  bool currentSwitchState = digitalRead(SW_PIN); // 現在のスイッチの状態を読み取る

  // スイッチが押されたときに状態を切り替える
  if (lastSwitchState == HIGH && currentSwitchState == LOW) {
    inverted = !inverted; // 明るさの反転
    Serial.println("明るさの反転"); // 状態が反転したことを表示
  }

  lastSwitchState = currentSwitchState; // 現在の状態を保存
}
