#include <Adafruit_NeoPixel.h>
#include "BLEDevice.h"
#include "BLEServer.h"
#include "BLEUtils.h"
#include "BLE2902.h"

// BLE設定
const char *bleName = "IE2B06";  
#define SERVICE_UUID "15d738e4-ed6e-11ed-a05b-0242ac120003"
#define CHARACTERISTIC_UUID_RX "06015e54-ed6e-11ed-a05b-0242ac120003"
#define CHARACTERISTIC_UUID_TX "0e8b42ba-ed6e-11ed-a05b-0242ac120003"
BLECharacteristic *pCharacteristic;

// NeoPixel設定
#define LED_PIN    16   // NeoPixelのデータピン
#define LED_COUNT  5    // 使用するLEDの数
Adafruit_NeoPixel strip(LED_COUNT, LED_PIN, NEO_GRB + NEO_KHZ800);
int brightness = 50;    // 輝度設定

String receivedText = "";     // 受信したテキストを保存
unsigned long lastMessageTime = 0;  // 最後のメッセージ受信時刻

void setup() {
  Serial.begin(115200);
  setupBLE();
  strip.begin();
  strip.setBrightness(brightness);
  strip.show(); // すべてのLEDを消灯
}

void loop() {
  // メッセージを受信してから1秒以上経過した場合に、内容に応じてLEDを更新
  if (receivedText.length() > 0 && millis() - lastMessageTime > 1000) {
    Serial.print("Received message: ");
    Serial.println(receivedText);
    
    if (receivedText == "red") {
      setStripColor(255, 0, 0); // 赤色に設定
    } else if (receivedText == "green") {
      setStripColor(0, 255, 0); // 緑色に設定
    } else if (receivedText == "blue") {
      setStripColor(0, 0, 255); // 青色に設定
    } else {
      setStripColor(0, 0, 0);   // 無効なメッセージは消灯
    }

    // BLE通知
    pCharacteristic->setValue(receivedText.c_str());
    pCharacteristic->notify();
    receivedText = "";
  }
}

// 指定した色にLED全体を点灯させる関数
void setStripColor(uint8_t r, uint8_t g, uint8_t b) {
  for (int i = 0; i < strip.numPixels(); i++) {
    strip.setPixelColor(i, strip.Color(r, g, b));
  }
  strip.show();
}

// BLEサーバーのコールバック
class MyServerCallbacks : public BLEServerCallbacks {
  void onConnect(BLEServer *pServer) {
    Serial.println("Connected");
  }
  void onDisconnect(BLEServer *pServer) {
    Serial.println("Disconnected");
  }
};

// BLEキャラクタリスティックのコールバック
class MyCharacteristicCallbacks : public BLECharacteristicCallbacks {
  void onWrite(BLECharacteristic *pCharacteristic) {
    std::string value = pCharacteristic->getValue();
    receivedText = String(value.c_str());
    lastMessageTime = millis();
    Serial.print("Received: ");
    Serial.println(receivedText);
  }
};

// BLE初期化
void setupBLE() {
  BLEDevice::init(bleName);
  BLEServer *pServer = BLEDevice::createServer();
  pServer->setCallbacks(new MyServerCallbacks());

  BLEService *pService = pServer->createService(SERVICE_UUID);
  pCharacteristic = pService->createCharacteristic(CHARACTERISTIC_UUID_TX, BLECharacteristic::PROPERTY_NOTIFY);
  pCharacteristic->addDescriptor(new BLE2902());

  BLECharacteristic *pCharacteristicRX = pService->createCharacteristic(CHARACTERISTIC_UUID_RX, BLECharacteristic::PROPERTY_WRITE);
  pCharacteristicRX->setCallbacks(new MyCharacteristicCallbacks());

  pService->start();
  pServer->getAdvertising()->start();
  Serial.println("Waiting for a client connection...");
}
