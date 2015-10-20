#!/bin/bash

if test $# != 2
	then
	echo "Nº de argumentos incorrecto"
	exit 1
fi

if test $1 = $2
	then
	echo "$1 y $2 son iguales"
else
	echo "$1 y $2 son distintos"
fi

exit 0