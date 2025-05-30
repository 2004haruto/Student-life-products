/*
  SpeakerVolumeControl
  Date : 2024/10/23
  Author : IE2B H.Masaki
*/

#define LEDC_CHANNEL_0     0      // LEDCのチャンネル設定（0から開始）
#define LEDC_TIMER_13_BIT  13     // LEDCタイマーの精度を13ビットに設定
#define LEDC_BASE_FREQ     5000   // LEDCの基本周波数を5000Hzに設定

// ピンの設定
#define BUZZER_OUT 13      // ブザー出力ピン
#define SW_PIN 22          // スイッチピン
#define VOL_PIN 34         // ボリューム（アナログ）入力ピン
#define RED_LED_PIN 25     // 赤色LEDピン
#define BLUE_LED_PIN 26    // 青色LEDピン

const int DEBOUNCE_DELAY = 50;  // デバウンスの遅延時間（50ms）

volatile bool muted = false;     // ミュート状態を記録
volatile bool switchPressed = false;  // スイッチが押された状態を記録
unsigned long lastDebounceTime = 0;   // 最後にスイッチが押された時間を記録

// 割り込み
void IRAM_ATTR handleSwitchPress() {
  unsigned long currentTime = millis();
  if (currentTime - lastDebounceTime > DEBOUNCE_DELAY) {
    switchPressed = true;  // スイッチが押されたことを記録
    lastDebounceTime = currentTime;  // デバウンス時間を更新
  }
}

//=====================================================================
// setup
//=====================================================================
void setup() {
  Serial.begin(115200);  // シリアル通信を初期化
  ledcSetup(LEDC_CHANNEL_0, LEDC_BASE_FREQ, LEDC_TIMER_13_BIT);  // LEDC設定
  ledcAttachPin(BUZZER_OUT, LEDC_CHANNEL_0);  // ブザーをLEDCに接続

  pinMode(SW_PIN, INPUT_PULLUP);  // スイッチのピンをプルアップ付きで入力に設定
  pinMode(RED_LED_PIN, OUTPUT);   // 赤色LEDを出力に設定
  pinMode(BLUE_LED_PIN, OUTPUT);  // 青色LEDを出力に設定
  attachInterrupt(digitalPinToInterrupt(SW_PIN), handleSwitchPress, FALLING);  // 割り込み設定

  // 初期状態：ミュートOFF、赤色LED点灯
  digitalWrite(RED_LED_PIN, HIGH);  // 赤色LEDをON
  digitalWrite(BLUE_LED_PIN, LOW);  // 青色LEDをOFF
}

//=====================================================================
// メインループ
//=====================================================================
void loop() {
  // ボリュームのアナログ値を取得
  int volumeValue = analogRead(VOL_PIN);  // ボリュームの値を読み取る 
  int frequency = volumeValue * 3;  // アナログ値を3倍して周波数とする

  // スイッチが押されたらミュートの状態を切り替える
  if (switchPressed) {
    muted = !muted;  // ミュート状態を反転
    switchPressed = false;  // スイッチの状態をリセット

    // LEDの状態を切り替え
    if (muted) {
      digitalWrite(RED_LED_PIN, LOW);  // 赤色LEDをOFF
      digitalWrite(BLUE_LED_PIN, HIGH);  // 青色LEDをON
      Serial.println("消音モード");
    } else {
      digitalWrite(RED_LED_PIN, HIGH);  // 赤色LEDをON
      digitalWrite(BLUE_LED_PIN, LOW);  // 青色LEDをOFF
      Serial.println("音量モード");
    }
  }

  // ミュートされていない場合は音を鳴らす
  if (!muted) {
    ledcWriteTone(LEDC_CHANNEL_0, frequency);  // 周波数に基づいた音を出す
    Serial.print("アナログ値: ");
    Serial.print(volumeValue);
    Serial.print(" -> 周波数: ");
    Serial.print(frequency);
    Serial.println(" Hz"); 
  } else {
    ledcWriteTone(LEDC_CHANNEL_0, 0);  // ミュート中は無音
  }

  delay(100);  
}
