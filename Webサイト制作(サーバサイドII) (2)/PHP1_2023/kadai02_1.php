<?php
/*
 IE1A_05_正木陽斗
 kadai01_1
 2023/09/29
*/
$fruits = ['りんご','バナナ','苺','ぶどう','キウイ'];
$fruits[5]='パイナップル';
echo '配列fruitsの3番目の値は[',$fruits[2],']です。';
echo '<pre>';
print_r($fruits);
echo '</pre>';
echo '配列1番目を上書き';
$fruits[0] = 'スイカ';
echo '<pre>';
print_r($fruits);
echo '</pre>';
?>