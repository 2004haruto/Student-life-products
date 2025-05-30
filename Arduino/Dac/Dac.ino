/*
  Dac
	Date : 2024/01/01
	Author : IE2A K.Murakami
*/

// ピン番号をマクロで定義
#define LED1_PIN 25  // 赤色LED

void setup() {
  Serial.begin(115200);       // シリアル通信の転送レート（bps）を設定
  pinMode(LED1_PIN, OUTPUT);  // LEDのピンを出力に設定
}

void loop() {
  dacWrite(LED1_PIN, 0);
  Serial.println("明るさ：0%");
  delay(1000);

  dacWrite(LED1_PIN, 63);
  Serial.println("明るさ：25%");
  delay(1000);

  dacWrite(LED1_PIN, 127);
  Serial.println("明るさ：50%");
  delay(1000);
  
  dacWrite(LED1_PIN, 191);
  Serial.println("明るさ：75%");
  delay(1000);

  dacWrite(LED1_PIN, 255);
  Serial.println("明るさ：100%");
  delay(1000);
}