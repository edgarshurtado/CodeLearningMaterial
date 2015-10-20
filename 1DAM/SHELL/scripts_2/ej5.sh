#!/bin/bash

if test $# = 1
then
	if test ! -f $1	
	then
		touch $1
		echo "Archivo $1 creado"
	else
		echo "El archivo existe"
	fi
fi
echo
echo "------Entrada en bulce-----"
echo
echo -n "Escribe el nombre de un archivo: "
read archivo

until test -f $archivo
do
	echo "$archivo no existe"
	echo -n "Escribe el nombre de un archivo: "
	read archivo
done
