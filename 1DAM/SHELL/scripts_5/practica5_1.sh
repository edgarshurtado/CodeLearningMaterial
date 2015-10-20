#!/bin/bash

function menu {
	echo "1. Sumar"
	echo "2. Restar"
	echo "3. Multiplicar"
	echo "4. Dividir"
	echo "5. Salir"

	echo

	echo -n "Escribe una opción "
	read opcion

	return $opcion
}

function suma {
	echo "Introduce 2 numeros "
	read num1
	read num2
	local suma=$[$num1+$num2]
	echo "El resultado es: "$suma
}

function resta {
	echo "Introduce 2 numeros "
	read num1
	read num2
	local resta=$[$num1-$num2]
	echo "El resultado es: " $resta
}

function multiplicar {
	echo "Introduce 2 numeros "
	read num1
	read num2
	local mult=$[$num1*$num2]
	echo "El resultado es: " $mult
}

function dividir {
	echo "Introduce 2 numeros "
	read num1
	read num2
	local div=$[$num1/$num2]
	echo "El resultado es: " $div
}
repetir=true;
while $repetir
	do
	menu
	case $? in
		1) suma;;
		2) resta;;
		3) multiplicar;;
		4) dividir;;
		5) repetir=false;;
		*) echo "Opción incorrecta";
			exit 1;;
	esac
	echo
done
exit 0