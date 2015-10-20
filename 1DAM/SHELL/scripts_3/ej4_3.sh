#!/bin/bash

for i in * #todos los archivos del directorio
	do
	echo -n "$i: "
	echo `ls -l "$i" | cut -d" " -f1`
	# usamos "$i" entre comillas por si el archivo tiene espacios
	#en el nombre
done

exit 0
