<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Untitled</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="author" href="humans.txt">
        <?php
            require "model.php";
            $store_id = $_GET['store_id'];
            $conn = new ShopModel();
            $shop = $conn->getStoreById($store_id);
        ?>
    </head>
    <body>
    <form method="get" action="function_calls.php">
        <input name="store_name" type="text" value ="<?php echo $shop['store_name'] ?>">
        <input name="store_area_id" type="text" value ="<?php echo $shop['store_area_id'] ?>">
        <input name="store_address" type="text" value="<?php echo $shop['store_address'] ?>">
        <input name="store_city" type="text" value="<?php echo $shop['store_city'] ?>">
        <input name="store_phone" type="text" value="<?php echo $shop['store_phone'] ?>">
        <input name="store_email" type="text" value="<?php echo $shop['store_email'] ?>">
        <input name="store_id" type="hidden" value="<?php echo $store_id ?>">
        <input name="action" type="hidden" value="save_changes">
        <input type="submit" value="Register">
    </form>
    </body>
</html>