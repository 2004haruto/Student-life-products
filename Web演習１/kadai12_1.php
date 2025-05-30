<?php
  //echo 'Hello, world!!';
  var_dump($_POST);
  $postData = [];
  $postData["uname"] = filter_input(INPUT_POST, "uname");
  $postData["ruby"] = filter_input(INPUT_POST, "ruby");
  $postData["mail"] = filter_input(INPUT_POST, "mail");
  $postData["password"] = filter_input(INPUT_POST, "password");
  $postData["confirmPassword"] = filter_input(INPUT_POST, "confirmPassword");
  $postData["tel"] = filter_input(INPUT_POST, "tel");
  $postData["postal"] = filter_input(INPUT_POST, "postal");
  $postData["address"] = filter_input(INPUT_POST, "address");
  $postData["checkDM"] = filter_input(INPUT_POST, "checkDM");

	//内容確認
	var_dump($postData);
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ECC Pizza | お届け先情報確認</title>
</head>
<body>
    <h1>内容確認</h1>
    <p>
        <?php echo $postData["uname"]; ?>
    </p>
    <p>
        <?= $postData["ruby"] ?>
    </p>
    <p>
        <?= $postData["mail"] ?>
    </p>
    <p>
        <?= $postData["password"] ?>
    </p>
    <p>
        <?= $postData["confirmPassword"] ?>
    </p>
    <p>
        <?= $postData["tel"] ?>
    </p>
    <p>
        <?= $postData["postal"] ?>
    </p>
    <p>
        <?= $postData["address"] ?>
    </p>
    <p>
        <?= $postData["checkDM"] ?>
    </p>
</body>
</html>