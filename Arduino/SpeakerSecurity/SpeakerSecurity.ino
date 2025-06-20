/*
 SpeakerSecurity
 Date : 2023/06/23
 Author : IE1A 05 H.Masaki
*/

// ピン番号をマクロで定義
#define SW_PIN 14
#define SPKR_PIN 27
#define TRIG_PIN 16  // トリガー（送信）
#define ECHO_PIN 17  // エコー（受信）

double duration = 0;  // 受信した時間
double distance = 0;  // 物との距離

// 超音波送信メソッド
void sendTrigger() {
  digitalWrite(TRIG_PIN, HIGH);  // トリガーに HIGH を出力し、超音波を出す
  delayMicroseconds(10);         // 一瞬だけ待機
  digitalWrite(TRIG_PIN, LOW);   // トリガーに LOW を出力し、超音波を止める
}



// スピーカーの PWM 出力関連を定義
#define LEDC_CHANNEL_0 0      // LEDC の PWM チャネル 0 から 15
#define LEDC_TIMER_13_BIT 13  // LEDC タイマーの精度 13 ビット
#define LEDC_BASE_FREQ 5000   // LEDC のベース周波数 5000Hz

// 使用する音の周波数を定義
#define C4 261.626   // ド
#define D4 293.665   // レ
#define E4 329.628   // ミ
#define F4 349.228   // ファ
#define G4 391.995   // ソ
#define A4 440.000   // ラ
#define B4 493.883   // シ
#define C5 523.251   // ド
#define D5 587.330   // レ
#define E5 659.255   // ミ
#define F5 698.456   // ファ
#define G5 783.991   // ソ
#define A5 880.000   // ラ
#define B5 987.767   // シ
#define C6 1046.502  // ド
#define D6 1174.659  // レ
#define E6 1318.510  // ミ
#define F6 1396.913  // ファ
#define G6 1567.982  // ソ
#define NONE 0       // 無音

#define WHOLE_NOTE 1000  // 全音符(1 秒)

// ミス楽譜
double miss[] = { B4, F5, NONE, F5, F5, E5, NONE, D5, C5, NONE };

boolean swData;            // SW の状態を保持する変数（true->ON, false->OFF）
boolean swDataOld = true;  // 前回の SW の状態を保持する変数（初期値は false）

// 起動時に一度だけ呼び出されるメソッド
void setup() {
  Serial.begin(115200);  // シリアル通信の転送レート（bps）を設定
  // ピンの入出力設定
  pinMode(SW_PIN, INPUT);  // スイッチを入力に設定
  pinMode(TRIG_PIN,OUTPUT);
  pinMode(ECHO_PIN,INPUT);
  // トリガーを LOW に落としておく
  digitalWrite(TRIG_PIN, LOW);
  delay(10);  // 落ちきるまで少し待機

  // スピーカー用のチャネル設定(チャネル番号, ベース周波数, 精度ビット数)
  ledcSetup(LEDC_CHANNEL_0, LEDC_BASE_FREQ, LEDC_TIMER_13_BIT);
  // チャネルにスピーカーピンを接続(ピン番号, チャネル番号)
  ledcAttachPin(SPKR_PIN, LEDC_CHANNEL_0);
  // マリオテーマ楽譜
  double mario[] = { E5, E5, NONE, E5, NONE, C5, E5, NONE, G5, NONE, NONE, NONE, G4 };
  // setup 完了後、マリオのテーマを奏でる(八分音符)
  melody(mario, sizeof(mario) / sizeof(double), WHOLE_NOTE / 8);
  Serial.println("プログラム開始");
}
// 演奏メソッド（楽譜配列, 楽譜の要素数, 音符の長さ）
void melody(double *score, int len, int note) {
  for (int i = 0; i <= len; i++) {
    ledcWriteTone(LEDC_CHANNEL_0, score[i]);
    delay(note);
  }

  ledcWriteTone(LEDC_CHANNEL_0, NONE);  //消音
}

bool A = true;
// メインループメソッド
void loop() {
  swData = digitalRead(SW_PIN);

  sendTrigger();                       // 超音波送信
  duration = pulseIn(ECHO_PIN, HIGH);  // エコーから受信した時間(マイクロ秒)を取得
  // 音速を 340m/s として受信した時間から距離（cm）に変換
  distance = duration * 340 * 100 / 1000000;

  //5cm以内の時
  if (distance <= 5) {
    A = true;
  }

  //swを押したとき
  if (swData != swDataOld) {
    if (swData) {
      A = false;
    }
  }

  Serial.println(A);
  if (A) {
    melody(miss, sizeof(miss) / sizeof(double), WHOLE_NOTE / 8);
  } else {
    ledcWriteTone(LEDC_CHANNEL_0, NONE);  //消音
  }
  // 次回の為に現在の SW の状態を保存する
  swDataOld = swData;  //一時保存
  delay(10);           // チャタリング防止
}
