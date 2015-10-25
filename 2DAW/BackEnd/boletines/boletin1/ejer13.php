<?php
	$block = "*";

	$nRows = 5;
	$currentRow = 1;
	while($nRows >= $currentRow){
		$counter = 0;
		while($counter < $currentRow){
			echo $block;
			$counter++;
		}
		echo "<br />";
		$currentRow++;
	}
?>