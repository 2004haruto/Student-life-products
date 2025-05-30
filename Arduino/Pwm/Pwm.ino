/*
  Pwm
	Date : 2024/01/01
	Author : IE2A K.Murakami
*/

// ピン番号をマクロで定義
#define LED1_PIN 25   // 赤色LED
#define LED2_PIN A10  // 青色LED

// PWM用チャネル設定値
#define PWM_CH 0      // チャネル（0-15）
#define PWM_FREQ 5000 // 周波数
#define PWM_BIT 8     // ビット数（0-255）

void setup() {
  Serial.begin(115200);                   // シリアル通信の転送レート（bps）を設定
  pinMode(LED1_PIN, OUTPUT);              // LEDのピンを出力に設定
  ledcSetup(PWM_CH, PWM_FREQ, PWM_BIT);   // PWMチャネル設定
  ledcAttachPin(LED2_PIN, PWM_CH);        // PWMチャネルを青色LEDピンに接続
}

void loop() {
  dacWrite(LED1_PIN, 0);
  ledcWrite(PWM_CH, 0);
  Serial.println("明るさ：0%");
  delay(1000);

  dacWrite(LED1_PIN, 63);
  ledcWrite(PWM_CH, 63);
  Serial.println("明るさ：25%");
  delay(1000);

  dacWrite(LED1_PIN, 127);
  ledcWrite(PWM_CH, 127);
  Serial.println("明るさ：50%");
  delay(1000);
  
  dacWrite(LED1_PIN, 191);
  ledcWrite(PWM_CH, 191);
  Serial.println("明るさ：75%");
  delay(1000);

  dacWrite(LED1_PIN, 255);
  ledcWrite(PWM_CH, 255);
  Serial.println("明るさ：100%");
  delay(1000);
}