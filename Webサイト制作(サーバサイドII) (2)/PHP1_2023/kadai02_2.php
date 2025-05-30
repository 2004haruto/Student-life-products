<?php
/*
 IE1A_05_正木陽斗
 kadai01_1
 2023/09/29
*/
$fruits = ['りんご','バナナ','苺','ぶどう','キウイ'];
$vegetable = ['キャベツ','人参','ピーマン','茄子','かぼちゃ'];
echo '<pre>';
var_dump($fruits);
echo '</pre>';
echo '<pre>';
var_dump($vegetable);
echo '</pre>';
echo '<pre>';
$food = array($fruits,$vegetable);
var_dump($food);
echo '</pre>';
echo '$food2行3列目は、',$food[1][2],'です。';
?>