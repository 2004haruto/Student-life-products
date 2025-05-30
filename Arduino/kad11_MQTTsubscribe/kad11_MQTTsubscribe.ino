#include <WiFi.h>
#include <PubSubClient.h>

// Wi-Fi情報
const char* ssid = "CampusIoT-WiFi"; // Wi-Fi名
const char* password = "0b8b413f2c0fa6aa90e085e9431abbf1fa1b2bd2db0ecf4ae9ce4b2e87da770c"; // Wi-Fiパスワード

// MQTT情報
const char* mqtt_broker = "broker.emqx.io";
const char* topic = "ie2b/led"; // クラス名と指定されたトピック
const char* mqtt_username = "emqx";
const char* mqtt_password = "public";
const int mqtt_port = 1883;

// LEDピン設定
const int ledPin = 2; // 赤色LEDを接続するGPIOピン番号（例: GPIO2）

WiFiClient espClient;
PubSubClient client(espClient);

void connectToWiFi() {
    Serial.print("Wi-Fi接続中: ");
    WiFi.begin(ssid, password);
    while (WiFi.status() != WL_CONNECTED) {
        Serial.print(".");
        delay(1000);
    }
    Serial.println("\nWi-Fiに接続されました");
    Serial.print("IPアドレス: ");
    Serial.println(WiFi.localIP());
}

void connectToMQTT() {
    client.setServer(mqtt_broker, mqtt_port);
    client.setCallback(callback);

    while (!client.connected()) {
        String client_id = "esp32-client-";
        client_id += String(WiFi.macAddress());
        Serial.printf("クライアント %s がMQTTブローカーに接続中...\n", client_id.c_str());
        if (client.connect(client_id.c_str(), mqtt_username, mqtt_password)) {
            Serial.println("MQTTブローカーに接続しました");

            // トピックを購読
            client.subscribe(topic);
            Serial.printf("トピック '%s' を購読しました\n", topic);

            // 初回メッセージをパブリッシュ
            client.publish(topic, "Hi, I’m IE2B06 ^^");
            Serial.println("接続メッセージを送信しました");
        } else {
            Serial.print("接続失敗、ステータスコード: ");
            Serial.println(client.state());
            Serial.println("2秒後に再接続を試みます...");
            delay(2000);
        }
    }
}

void setup() {
    // シリアルモニタを開始
    Serial.begin(115200);

    // LEDピンを出力モードに設定
    pinMode(ledPin, OUTPUT);
    digitalWrite(ledPin, LOW); // 初期状態でLEDを消灯

    // Wi-Fi接続
    connectToWiFi();

    // MQTT接続
    connectToMQTT();
}

void callback(char* receivedTopic, byte* payload, unsigned int length) {
    Serial.printf("Message arrived in topic: %s\n", receivedTopic);
    Serial.print("Message: ");

    String message;
    for (int i = 0; i < length; i++) {
        Serial.print((char)payload[i]);
        message += (char)payload[i];
    }
    Serial.println();

    // メッセージに応じてLEDを制御
    if (String(receivedTopic) == topic) {
        if (message == "on") {
            digitalWrite(ledPin, HIGH); // LED点灯
            Serial.println("赤色LED点灯");
        } else if (message == "off") {
            digitalWrite(ledPin, LOW); // LED消灯
            Serial.println("赤色LED消灯");
        } else {
            Serial.println("不明なメッセージ");
        }
    } else {
        Serial.println("無視されたトピックからのメッセージです");
    }
}

void loop() {
    // MQTTクライアントのループ処理
    if (!client.connected()) {
        connectToMQTT(); // 接続が切れた場合に再接続
    }
    client.loop();
}
