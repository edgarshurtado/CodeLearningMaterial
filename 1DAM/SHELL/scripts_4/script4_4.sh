#!/bin/bash

echo "a. Secuencia pares"
echo "b. Secuencia impares"
echo "c. Cuenta atrás"

echo
echo "Escribe una opción: "
read option
echo

case $option in
	a|A)
		echo "Escribe un nº par: "
		read num
		while test $[$num%2] -ne 0
		do
			echo "Has puest un nº impar"
			echo -n "Escribe un nº par"
			read num
		done
	
		echo
		for i in `seq 2 2 $num`
		do
			echo $i
		done
		;;
	[bB]) #otra forma de que acepte min y may como parámetro
		echo "Escribe un nº impar: "
		read num
		while test $[$num%2] -eq 0
		do
			echo "Has puest un nº par"
			echo -n "Escribe un nº impar"
			read num
		done
	
		echo
		for i in `seq 1 2 $num`
		do
			echo $i
		done
		;;
	c* | ce? | c\? )
		#"c*" para c seguido de cualquier número de carácteres
		#"ce?" para ce seguido de 1 caracter cualquiera
		#"c\?" para que la opción tenga que ser c?
		echo "Escribe un nº positivo: "
		read num
		while test $[$num%2] -lt 0
		do
			echo "Has puest un nº negtivo"
			echo -n "Escribe un nº positvo"
			read num
		done
	
		echo
		for i in `seq $num -1 0`
		do
			echo $i
		done
		;;
	*) echo "Opción no válida"
		exit 1;;
esac

exit 0
