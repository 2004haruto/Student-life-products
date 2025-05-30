#include <WiFi.h>
#include "Ambient.h"
#include "ESP32_BME280_I2C.h"

// Wi-FiとAmbient設定
const char* ssid = "CampusIoT-WiFi";
const char* password = "0b8b413f2c0fa6aa90e085e9431abbf1fa1b2bd2db0ecf4ae9ce4b2e87da770c";
unsigned int channelId = 85052;
const char* writeKey = "7f199ac5a639dba3";

// BME280設定
const uint8_t Address = 0x76;
const uint8_t sda = 21;
const uint8_t scl = 22;
const uint32_t frequency = 30000;
ESP32_BME280_I2C bme280(Address, scl, sda, frequency);

// Wi-FiおよびAmbient設定
WiFiClient client;
Ambient ambient;

// DeepSleep時間（10秒）
const uint64_t DEEP_SLEEP_DURATION_US = 10 * 1000000; // マイクロ秒単位

// Wi-Fi接続
void connectToWiFi() {
    Serial.println("Wi-Fiに接続中...");
    WiFi.begin(ssid, password);
    unsigned long startAttemptTime = millis();

    // Wi-Fi接続待機（最大5秒）
    while (WiFi.status() != WL_CONNECTED && millis() - startAttemptTime < 5000) {
        delay(500);
        Serial.print(".");
    }

    if (WiFi.status() == WL_CONNECTED) {
        Serial.println("\nWi-Fiに接続されました");
        Serial.print("IPアドレス: ");
        Serial.println(WiFi.localIP());
    } else {
        Serial.println("\nWi-Fi接続に失敗しました。再起動します...");
        ESP.restart();
    }
}

// BME280初期化
void initBME280() {
    uint8_t t_sb = 0;    // Standby 0.5ms
    uint8_t filter = 4;  // IIR filter = 16
    uint8_t osrs_t = 2;  // OverSampling Temperature x2
    uint8_t osrs_p = 5;  // OverSampling Pressure x16
    uint8_t osrs_h = 1;  // OverSampling Humidity x1
    uint8_t Mode = 3;    // Normal mode

    bme280.ESP32_BME280_I2C_Init(t_sb, filter, osrs_t, osrs_p, osrs_h, Mode);
    Serial.println("BME280初期化完了");
}

// Ambientにデータを送信
void sendDataToAmbient(double temperature, double pressure, double humidity) {
    ambient.set(1, temperature); // 温度
    ambient.set(2, humidity);    // 湿度
    ambient.set(3, pressure);    // 気圧

    // 送信試行を3回までリトライ
    for (int i = 0; i < 3; i++) {
        if (ambient.send()) {
            Serial.println("データがAmbientに送信されました");
            return;
        } else {
            Serial.println("データ送信エラー。再試行中...");
            delay(1000);
        }
    }

    Serial.println("データ送信に失敗しました。再起動します...");
    ESP.restart();
}

// DeepSleepに移行
void enterDeepSleep() {
    Serial.println("10秒間DeepSleepに移行します...");
    esp_sleep_enable_timer_wakeup(DEEP_SLEEP_DURATION_US);
    esp_deep_sleep_start();
}

void setup() {
    Serial.begin(115200);

    // DeepSleepからの復帰確認
    esp_sleep_wakeup_cause_t wakeupReason = esp_sleep_get_wakeup_cause();
    if (wakeupReason == ESP_SLEEP_WAKEUP_TIMER) {
        Serial.println("DeepSleepから復帰しました (DEEPSLEE_RESET)");
    } else {
        Serial.println("通常起動しました");
    }

    // Wi-Fi接続
    connectToWiFi();

    // Ambient初期化
    ambient.begin(channelId, writeKey, &client);

    // BME280初期化
    initBME280();

    // センサーからデータ取得
    double temperature = 0, pressure = 0, humidity = 0;
    bme280.Read_All(&temperature, &pressure, &humidity);

    // データをシリアルモニタに出力
    Serial.printf("温度: %.2f °C, 湿度: %.2f %%, 気圧: %.2f hPa\n",
                  temperature, humidity, pressure);

    // Ambientにデータ送信
    sendDataToAmbient(temperature, pressure, humidity);

    // DeepSleepに移行
    enterDeepSleep();
}

void loop() {
    // 通常この関数は呼び出されません
}
