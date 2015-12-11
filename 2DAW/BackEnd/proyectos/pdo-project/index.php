<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>PDO CRUD Shop</title>
</head>
<body>
    <?php
    require 'model.php';



    $conn = new ShopModel();
    $data = $conn->retrieveAll();
    ?>

    <button ><a href="reg_form.php">Nuevo Registro</a></button>

    <table border="1">
        <thead>
            <th>Nombre Tienda</th>
            <th>Zona</th>
            <th>Dirección</th>
            <th>Ciudad</th>
            <th>Teléfono</th>
            <th>Email</th>
            <th>Opciones</th>
        </thead>
        <tbody>
        <tr>
            <?php
            foreach ($data as $shop) {
                echo "<tr>";
                echo "<td>".$shop['store_name']."</td>";
                echo "<td>".$shop['area']."</td>";
                echo "<td>".$shop['store_address']."</td>";
                echo "<td>".$shop['store_city']."</td>";
                echo "<td>".$shop['store_phone']."</td>";
                echo "<td>".$shop['store_email']."</td>";
                echo "<td>
                <button onclick='location.href=\"function_calls.php?action=delete&store_id=". $shop['store_id'] ."\"'>
                Delete
                </button>
                <button onclick='location.href=\"function_calls.php?action=edit&store_id=". $shop['store_id'] ."\"'>
                Edit
                </button></td>";
                echo "</tr>";
            }
            ?>
        </tr>
        </tbody>
        <tfoot>
            <tr><td colspan="7"><?php echo count($data); ?></td></tr>
        </tfoot>
    </table>
</body>
</html>