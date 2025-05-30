<?php
/*
 IE1A_05_正木陽斗
 kadai01_1
 2023/09/29
*/

$fruits = [
    'apple' => 220,
    'banana' => 110,
    'strawberry' => 490,
    'grape' => 550,
    'kiwi' => 160,
];
echo '<pre>';
var_dump($fruits);
echo '</pre>';
$vegetable = [
    'cabbage' => 130,
    'carrot' => 80,
    'greenPepper' =>120,
    'eggplant' => 160,
    'pumpkin' => 240,
];
$foods = [
    'fruits' => $fruits,
    'vegetable' => $vegetable
];
echo 'foodの内容を表示';
echo '<pre>';
var_dump($foods);
echo '</pre>';
echo '[第3段階]配列$fruitsの中身をforeachで順番に表示します。';
echo '<br>';
foreach($fruits as $key => $value){
    echo $key,':', $fruits[$key],'円','<br>';
};
echo '【第4段階】配列$foodの中身をforeachで種別ごとに、順番に表示します。','<br>';
foreach($foods as $key => $value){
    echo '種別:', $key,'<br>';
    foreach($value as $key => $value){
        echo '商品名:',$key,'/価格:',$value,'円','<br>';
    };
    echo'-------------------------------------','<br>';
};
?>