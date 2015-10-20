#!/bin/bash

if test $# -eq 1
	then
	touch $1
	echo -n "Introduce un nuevo nombre para el archivo "
	read nombre
	mv $1 $nombre
else
	echo "Has introducido un nº incorrecto de argumentos"
	exit 1
fi

exit 0
