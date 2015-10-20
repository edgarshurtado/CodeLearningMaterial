#!/bin/bash
function numberOfLines {
	lines=`cat $1 | wc -l`
	return $lines
}

if test $# -eq 2
	then
	numberOfLines $1
	file1=$?
	numberOfLines $2
	file2=$?

	if test $file1 -eq $file2
		then
		echo "$1 y $2 Son iguales en longitud con $file1 lineas"
	else
		if test $file1 -gt $file2
			then
			echo "$1 es mayor con $file1 lineas"
			echo "$2 es menor con $file2 lineas"
		else
			echo "$2 es mayor con $file2 lineas"
			echo "$1 es menor con $file1 lineas"
		fi
	fi

else
	echo "Nº de argumentos incorrecto"
fi

exit 0
