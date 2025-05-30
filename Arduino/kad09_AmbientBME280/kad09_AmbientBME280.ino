#include <WiFi.h>
#include "Ambient.h"
#include "ESP32_BME280_I2C.h"

// WiFiとAmbient設定
const char* ssid = "CampusIoT-WiFi";
const char* password = "0b8b413f2c0fa6aa90e085e9431abbf1fa1b2bd2db0ecf4ae9ce4b2e87da770c";
unsigned int channelId = 85052;
const char* writeKey = "7f199ac5a639dba3";

// BME280設定
const uint8_t Address = 0x76;
const uint8_t sda = 21;
const uint8_t scl = 22;
const uint32_t frequency = 30000;
ESP32_BME280_I2C bme280i2c(Address, scl, sda, frequency);

// WiFiおよびAmbient設定
WiFiClient client;
Ambient ambient;

void setup() {
    Serial.begin(115200);
    
    // WiFi接続
    WiFi.begin(ssid, password);
    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
    }
    Serial.println("WiFi connected");
    Serial.print("IP address: ");
    Serial.println(WiFi.localIP());
    
    // Ambientの初期化
    ambient.begin(channelId, writeKey, &client);
    
    // BME280の初期化
    uint8_t t_sb = 0;    // stanby 0.5ms
    uint8_t filter = 4;  // IIR filter = 16
    uint8_t osrs_t = 2;  // OverSampling Temperature x2
    uint8_t osrs_p = 5;  // OverSampling Pressure x16
    uint8_t osrs_h = 1;  // OverSampling Humidity x1
    uint8_t Mode = 3;    // Normal mode
    bme280i2c.ESP32_BME280_I2C_Init(t_sb, filter, osrs_t, osrs_p, osrs_h, Mode);
    delay(1000);
}

void loop() {
    double temperature, pressure, humidity;
    
    // BME280からデータ取得
    bme280i2c.Read_All(&temperature, &pressure, &humidity);
    
    // 取得したデータをAmbientのデータフィールドにセット
    ambient.set(1, temperature);  // チャート名「温度」
    ambient.set(2, humidity);     // チャート名「湿度」
    ambient.set(3, pressure);     // チャート名「気圧」
    
    // データを一度に送信
    if (ambient.send()) {
        Serial.println("Data sent to Ambient successfully");
    } else {
        Serial.println("Error sending data to Ambient");
    }
    
    delay(5000);  // 5秒間隔で送信
}
