<?php
     $num = $_POST['numero'];
     
     echo '<table border="1">';
     for($i = 0; $i <= 10; $i++){
        echo "<tr>";
         echo "<td>$num x $i</td>";
         echo "<td>".$num * $i."</td>";
        echo "</tr>";
     }
     echo "</table>";
?>
