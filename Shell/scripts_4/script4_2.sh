#!/bin/bash

echo "1. Listar archivos."
echo "2. Mostrar el directorio de trabajo"
echo "3. Crear directorio"
echo "4. Salir"

echo
echo -n "Escribe una opción: "
read option
echo

until test $option -eq 4
do
	case $option in
	1)ls -l;;

	2)pwd;;

	3)read newdir;
	mkdir $newdir;;

	4) exit 0;;

	*)echo "Opción no válida."
	
	esac

	echo -n "Escribe una opción: "
	read option
done
