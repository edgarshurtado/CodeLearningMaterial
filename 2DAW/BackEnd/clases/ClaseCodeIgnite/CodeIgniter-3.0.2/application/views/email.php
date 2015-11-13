<!DOCTYPE html>
<html>
<head>
<body>
    <form method="POST" enctype="multipart/form-data" action="<?php echo site_url('email/send') ?>">
        <input type="text" name="to"><br>
        <input type="file" name="file"><br>
        <textarea name="message" id="" cols="30" rows="10"></textarea>
        <input type="submit" name="file" ><br>
    </form>
</body>
</html>