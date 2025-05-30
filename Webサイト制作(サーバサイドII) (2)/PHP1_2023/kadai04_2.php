<?php
$_POST["department"];

// TODO：kadai03_resource.phpファイル読み込み
require_once "./kadai03_resource.php";

$departments = $school["departments"];

// TODO：kadai04_utils.phpファイル読み込み

// TODO：課題４－１から受け取ったデータを連想配列に格納。（連想配列の値を加工）
$department = filter_input(INPUT_POST,"department",FILTER_VALIDATE_INT);
$course = filter_input(INPUT_POST,"course",FILTER_VALIDATE_INT);
$name = filter_input(INPUT_POST,"name",FILTER_SANITIZE_FULL_SPECIAL_CHARS);
$kana = filter_input(INPUT_POST,"kana",FILTER_SANITIZE_FULL_SPECIAL_CHARS);
$note = filter_input(INPUT_POST,"note",FILTER_SANITIZE_FULL_SPECIAL_CHARS);

$name = trim(mb_convert_kana($name,"sKV","UTF-8"));
$kana = trim(mb_convert_kana($kana,"sKV","UTF-8"));
$note = trim(mb_convert_kana($note,"sKV","UTF-8"));



if(empty($name)){
    $name = "名前が入力されていません";
}

if(empty($kana)){
    $kana = "フリガナが入力されていません";
}


$dMessage = "学科の選択が間違っています";
$cMessage = "コースの選択が間違っています";

foreach($departments as $d){
    if($d["id"] === $department){
        $dMessage = $d["name"];
        foreach($d["courses"] as $c){
            if($c["id"] === $course){
                $cMessage = $c["name"];
            }
        }
    }
}

?>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>php1 - kadai04_2</title>
    <!-- TODO:bootstrapCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 備考の幅調整：個別設定 -->
    <style>
        p.note-height {
            height: 85%;
        }
    </style>

</head>

<body>
    <!-- ▼▼コンテンツ全体▼▼---------------------------------- -->
    <div class="w-100">

        <!-- ▼▼ヘッダー▼▼--------------------------------- -->
        <header class="bg-info">
            <div class="text-light ms-5 pt-5 pb-3">
                <h1 class="h6">サーバーサイドスクリプト演習１</h1>
                <h2 class="pt-3">form送信（POST）の結果画面</h2>
            </div><!--/.container-->
        </header>
        <!-- ▲▲ヘッダー▲▲--------------------------------- -->

        <!-- ▼▼メイン▼▼----------------------------------- -->
        <main>
            <!-- TODO：各データ表示（phpで処理した連想配列の値を表示すること） -->
            <!-- TODO:前回の課題３は変数でOK。今回の課題４は連想配列が必須 -->
            <div class="form-control">

                <div class="p-5 row">
                    <div class="col-md-5">
                        <div class="row">

                            <!-- 学科表示 -->
                            <div class="col">
                                <label class="form-label" for="department">学科</label>
                                <p class="form-control form-control-lg border-info"><?= $dMessage?></p>
                            </div>

                            <!-- コース表示 -->
                            <div class="col">
                                <label class="form-label" for="course">コース</label>
                                <p class="form-control form-control-lg border-info"><?= $cMessage?></p>
                            </div>
                        </div>

                        <div class="col">
                            <label class="form-label" for="name">名前</label>
                            <p class="form-control form-control-lg border-info"><?= $name ?></p>
                        </div>

                        <div class="col">
                            <label class="form-label" for="kana">フリガナ</label>
                            <p class="form-control form-control-lg border-info"><?= $kana ?></p>
                        </div>
                    </div>


                    <div class="col mh-100">
                        <label class="form-label" for="note">備考</label>
                        <p class="form-control form-control-lg border-info note-height"><?=nl2br("$note \n"); ?></p>
                    </div>
                </div>

                <div class="p-5 d-grid gap-2 d-md-flex justify-content-md-end">
                    <!-- TODO：入力画面に戻る処理 -->
                    <a class="btn btn-secondary btn-lg me-md-5" href="kadai04_1.php">戻る</a>
                    <!-- ここは今回の課題では指定なしなので、そのままでOK -->
                    <a class="btn btn-danger btn-lg" href="#">送信</a>
                </div>


            </div><!--/.container-->
        </main>
        <!-- ▲▲メイン▲▲------------------------------------ -->

    </div>
    <!-- ▲▲コンテンツ全体▲▲---------------------------------- -->
</body>

</html>