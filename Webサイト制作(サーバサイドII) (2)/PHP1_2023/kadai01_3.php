<?php
/*
 IE1A_05_正木陽斗
 kadai01_1
 2023/09/29
*/
$num = 1;
$word = '1';

// 変数の中身確認用表示
echo 'num = ',$num,'<br>';          
echo 'word = ',$word,'<br><br>';

if($num == $word) {
    echo '==で比較したとき、numとwordは等しいです。<br>';
}
else {
    echo '==で比較したとき、numとwordは等しくありません。<br>';
}

if($num === $word) {
    echo '===で比較したとき、numとwordは等しいです。<br>';
}
else {
    echo '===で比較したとき、numとwordは等しくありません。<br>';
}

?>