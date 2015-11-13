<!DOCTYPE html>
<html>
<head>
    <title>Formulario de subida</title>
</head>
<body>
<?php echo $error . "<br />"  ?>
<?php echo form_open_multipart('upload_controller/do_upload');?>
<input type="file" name="userfile" />
<input type="submit" value="upload" />
</body>
</html>
