/*
	Blink
	Date : 2024/10/02
	Author : IE2B H.Masaki
*/

//ピン番号をマクロで定義
#define LED1_PIN 17 // 赤色LED
/*
	アドバイス！
	マクロとは、プログラム内の文字列をあらかじめ定義した規則に従って置き換えられる機能のこと。#define 修飾子でマクロ化ができ、主にピン番号を定義するのに使用する。
	変数や定数とは違いデータ型を持たず、コンパイル前に置き換えられるので値を保持することは出来ないが、その分メモリ領域を割かずに別の文字列として扱うことができ、可読性が向上する。
	コード全てを置き換えてしまうので、他の命令文と重複しないよう命名すること。
*/

int dot = 200;   // 「・」の点灯時間（200ミリ秒）
int dash = 600;  // 「ー」の点灯時間（600ミリ秒）
int off = 100;   // 消灯時間（100ミリ秒）
int signalPause = 1000;  // SOS信号の間隔（1秒）

// モールス符号の定義
int sSignal[] = {dot, dot, dot};  // S = 「・」3つ
int oSignal[] = {dash, dash, dash};  // O = 「ー」3つ

// 配列の長さを計算
int sLength = sizeof(sSignal) / sizeof(sSignal[0]);
int oLength = sizeof(oSignal) / sizeof(oSignal[0]);

// 信号を送信する関数
void transmitMorse(int signal[], int length) {
  for (int i = 0; i < length; i++) {
    digitalWrite(LED1_PIN, HIGH);  // LEDを点灯
    delay(signal[i]);              // 「・」または「ー」の点灯時間
    digitalWrite(LED1_PIN, LOW);   // LEDを消灯
    delay(off);            // 消灯時間
  }
}

void setup() {
  pinMode(LED1_PIN, OUTPUT);  // LEDピンを出力に設定
}

void loop() {
  // S信号を送信
  transmitMorse(sSignal, sLength);
  delay(off);
  // O信号を送信
  transmitMorse(oSignal, oLength);
  delay(off);
  // S信号を送信
  transmitMorse(sSignal, sLength);
  delay(off);
  
  delay(signalPause);

}