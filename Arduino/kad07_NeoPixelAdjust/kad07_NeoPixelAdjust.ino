#include <Adafruit_NeoPixel.h>
#ifdef __AVR__
 #include <avr/power.h> // Required for 16 MHz Adafruit Trinket
#endif

#define LED_PIN   16
#define LED_COUNT 60
#define BRIGHTNESS_PIN 34 // ボリュームのピン
#define BUTTON_PIN 22      // スイッチのピン

Adafruit_NeoPixel strip(LED_COUNT, LED_PIN, NEO_GRB + NEO_KHZ800);

int brightness = 50; // 初期の明るさ（20%）
bool buttonPressed = false;

void setup() {
  #if defined(__AVR_ATtiny85__) && (F_CPU == 16000000)
    clock_prescale_set(clock_div_1);
  #endif

  pinMode(BRIGHTNESS_PIN, INPUT);
  pinMode(BUTTON_PIN, INPUT_PULLUP);

  Serial.begin(115200); // シリアル通信を開始

  strip.begin();
  strip.show();
  strip.setBrightness(brightness);
}

void loop() {
  // 既存のアニメーション関数を呼び出す
  colorWipe(strip.Color(255,   0,   0), 50);
  colorWipe(strip.Color(  0, 255,   0), 50);
  colorWipe(strip.Color(  0,   0, 255), 50);
  theaterChase(strip.Color(127, 127, 127), 50);
  theaterChase(strip.Color(127,   0,   0), 50);
  theaterChase(strip.Color(  0,   0, 127), 50);
  rainbow(10);
  theaterChaseRainbow(50);
}

void checkButtonAndAdjustBrightness() {
  // ボリュームの値を読み取る
  int potValue = analogRead(BRIGHTNESS_PIN);
  // 0-1023の範囲を0-255の範囲にマッピング
  int newBrightness = map(potValue, 0, 1023, 0, 255);

  // 現在のアナログ値と輝度をシリアルモニターに表示
  Serial.print("アナログ値: ");
  Serial.print(potValue);
  Serial.print(" -> 輝度: ");
  Serial.println(newBrightness);

  // スイッチが押されたら明るさを更新
  if (digitalRead(BUTTON_PIN) == LOW) {
    if (!buttonPressed) {
      brightness = newBrightness;
      strip.setBrightness(brightness);
      strip.show();
      Serial.println("Brightness updated");
      buttonPressed = true;
    }
  } else {
    buttonPressed = false;
  }
}

void colorWipe(uint32_t color, int wait) {
  for(int i=0; i<strip.numPixels(); i++) {
    strip.setPixelColor(i, color);
    strip.show();
    delay(wait);
    checkButtonAndAdjustBrightness(); // ボタンの状態をチェック
  }
}

void theaterChase(uint32_t color, int wait) {
  for(int a=0; a<10; a++) {
    for(int b=0; b<3; b++) {
      strip.clear();
      for(int c=b; c<strip.numPixels(); c+=3) {
        strip.setPixelColor(c, color);
      }
      strip.show();
      delay(wait);
      checkButtonAndAdjustBrightness(); // ボタンの状態をチェック
    }
  }
}

void rainbow(int wait) {
  for(long firstPixelHue = 0; firstPixelHue < 5*65536; firstPixelHue += 256) {
    for(int i=0; i<strip.numPixels(); i++) {
      int pixelHue = firstPixelHue + (i * 65536L / strip.numPixels());
      strip.setPixelColor(i, strip.gamma32(strip.ColorHSV(pixelHue)));
    }
    strip.show();
    delay(wait);
    checkButtonAndAdjustBrightness(); // ボタンの状態をチェック
  }
}

void theaterChaseRainbow(int wait) {
  int firstPixelHue = 0;
  for(int a=0; a<30; a++) {
    for(int b=0; b<3; b++) {
      strip.clear();
      for(int c=b; c<strip.numPixels(); c+=3) {
        int hue = firstPixelHue + c * 65536L / strip.numPixels();
        strip.setPixelColor(c, strip.gamma32(strip.ColorHSV(hue)));
      }
      strip.show();
      delay(wait);
      checkButtonAndAdjustBrightness(); // ボタンの状態をチェック
      firstPixelHue += 65536 / 90;
    }
  }
}