<?php
/**
 * 定数を定義する
 */

define( "WEB_ROOT", "http://localhost/php1" );
// define( "WEB_ROOT", "http://localhost/Project_folder" );

define( "ASSET_URL", WEB_ROOT . "/asset" );

//
// DB
//
define( "DB_HOST", "localhost" );
define( "DB_USER", "oda" );
define( "DB_PASS", "taka" );
define( "DB_NAME", "SM" );
define( "DB_CHARSET", "utf8mb4" );

// データベースに接続するための設定
$servername = "localhost";
$username = "oda";
$password = "taka";
$dbname = "SM";

// データベースに接続
$conn = mysqli_connect($servername, $username, $password, $dbname);

define( "TBL_USER", "USER" );