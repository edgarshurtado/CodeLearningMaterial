<?php
    require "model.php";
    $action= $_GET['action'];
    $conn = new ShopModel();

    switch ($action) {
        case 'register':
            $conn->register();
            break;

        case 'delete':
            $id = $_GET['store_id'];
            $conn->delete($id);
            break;
        case 'edit':
            $id = $_GET['store_id'];
            header("location: edit_form.php?store_id=".$id);
            break;
        case 'save_changes':
            $arrayShop = array(
               $_GET['store_name'],
               $_GET['store_area_id'],
               $_GET['store_address'],
               $_GET['store_city'],
               $_GET['store_phone'],
               $_GET['store_email'],
               $_GET['store_id']
                 );
            $conn->updateShop($arrayShop);
            break;
        default:
            # code...
            break;
    }

?>