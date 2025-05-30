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

void setup() {
  Serial.begin(115200); // シリアル通信の転送レート（bps）を設定
  pinMode(LED1_PIN, OUTPUT); // LEDのピンを出力に設定
}

void loop() {
  digitalWrite(LED1_PIN, HIGH);  // LEDにHIGHを出力し点灯する
  Serial.println("点灯");   // シリアルモニタに出力 
  delay(1000);    // 1秒待機
  
  digitalWrite(LED1_PIN, LOW);   // LEDにLOWを出力し消灯する
  Serial.println("消灯");   //　シリアルモニタに出力
  delay(1000);    // 1秒待機
}
