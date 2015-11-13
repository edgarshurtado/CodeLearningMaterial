<!DOCTYPE html>
<html>
<head>
    <title>Formulario de subida</title>
</head>
<body>
<h1>Success!</h1>
<ul>
    <?php
foreach($upload_data as $key => $value)
{
    echo "<li> $key: $value:  </li>";
}
    ?>
</ul>
<br />
<?php
    echo anchor('upload', 'transferir otro fichero');
?>
</form>
</body>
</html>
