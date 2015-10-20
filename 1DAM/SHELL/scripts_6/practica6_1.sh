#!/bin/bash
directorios=0
archivosReg=0
cd $1

for i in *
do
	if test -d "$i"
	then
		directorios=$[$directorios+1]
	fi

	if test -f "$i"
		then
		archivosReg=$[$archivosReg+1]
	fi
done

echo "directorios: " $directorios
echo "archivos regulares" $archivosReg

exit 0