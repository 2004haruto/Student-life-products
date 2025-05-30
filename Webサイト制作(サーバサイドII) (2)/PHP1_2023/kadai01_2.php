<?php
/*
 IE1A_05_正木陽斗
 kadai01_1
 2023/09/29
*/
    $word = 'ECC太郎';

    echo 'こんにちは。 {$word} さん！';
    echo '<br>';        //比較の分かり易さため、改行は分けて記述
    echo "こんにちは。 {$word} さん！";
    echo '<br>';

    $quote1 = 'シングルコーテーション\tで囲んだ文字列';   //　\tはタブ
    $quote2 = "ダブルコーテーション\tで囲んだ文字列";

    echo $quote1;
    echo '<br>';
    echo $quote2;

?>