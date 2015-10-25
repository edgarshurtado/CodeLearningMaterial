<?php
	$numero1 = $_POST['a'];
	$numero2 = $_POST['b'];

	$suma = $numero1 + $numero2;
	$producto = $numero1 * $numero2;

	if($suma > $producto){
		echo "La suma es mayor que el producto";
	}else if($suma < $producto){
		echo "El producto es mayor que la suma";
	}else {
		echo "Producto y suma son iguales";
	}
?>