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
const int redLedPin = 2; // 赤色LEDを接続するGPIOピン番号（例: GPIO2）
const int blueLedPin = 4; // 青色LEDを接続するGPIOピン番号（例: GPIO4）
const int buttonPin = 22;  // タクトスイッチを接続するGPIOピン番号（例: GPIO0）

WiFiClient espClient;
PubSubClient client(espClient);

// 青色LEDの状態を管理
bool blueLedState = false;

// ボタンの押下状態を管理
bool buttonPressed = false;
unsigned long lastDebounceTime = 0;  // 最後にボタンが押された時間
unsigned long debounceDelay = 50;    // デバウンスの遅延（ミリ秒）

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
            digitalWrite(redLedPin, HIGH); // 赤色LED点灯
            Serial.println("赤色LED点灯");
        } else if (message == "off") {
            digitalWrite(redLedPin, LOW); // 赤色LED消灯
            Serial.println("赤色LED消灯");
        } else if (message == "change") {
            // "change" メッセージを受け取ったら青色LEDの状態を切り替える
            blueLedState = !blueLedState; // LEDの状態を反転
            digitalWrite(blueLedPin, blueLedState ? HIGH : LOW); // 青色LEDの状態を変更
            Serial.println(blueLedState ? "青色LED点灯" : "青色LED消灯");
        } else {
            Serial.println("不明なメッセージ");
        }
    } else {
        Serial.println("無視されたトピックからのメッセージです");
    }
}

void setup() {
    // シリアルモニタを開始
    Serial.begin(115200);

    // LEDピンを出力モードに設定
    pinMode(redLedPin, OUTPUT);
    pinMode(blueLedPin, OUTPUT);
    pinMode(buttonPin, INPUT_PULLUP);  // 内部プルアップ抵抗を有効にしてボタンを設定
    digitalWrite(redLedPin, LOW); // 初期状態で赤色LED消灯
    digitalWrite(blueLedPin, LOW); // 初期状態で青色LED消灯

    // Wi-Fi接続
    connectToWiFi();

    // MQTT接続
    connectToMQTT();
}

void loop() {
    // ボタン状態を読み込む
    int buttonState = digitalRead(buttonPin);

    // デバウンス処理
    if (buttonState == LOW) {
        // ボタンが押されている状態
        if (!buttonPressed && (millis() - lastDebounceTime) > debounceDelay) {
            buttonPressed = true;
            lastDebounceTime = millis(); // 最後に押された時間を記録
            client.publish(topic, "change"); // "change"メッセージをパブリッシュ
            Serial.println("changeメッセージを送信しました");
        }
    } else {
        buttonPressed = false;
    }

    // ボタンが押されたかの状態をデバッグ表示
    // if (buttonState == LOW) {
    //     Serial.println("ボタンが押されていません");
    // } else {
    //     Serial.println("ボタンが押されています");
    // }

    // MQTTクライアントのループ処理
    if (!client.connected()) {
        connectToMQTT(); // 接続が切れた場合に再接続
    }
    client.loop();
}
