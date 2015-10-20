#!/bin/bash

if test -d $1
	then
	echo "El archivo es un directorio"
elif test -f $1
	then
	echo "Es un archivo regular"
	if test -x $1
		then
		echo "Tiene permisos de ejecución"
	else
		echo "No tiene permisos de ejecución"
	fi
else
	echo "El archivo no existe"
fi


exit 0
