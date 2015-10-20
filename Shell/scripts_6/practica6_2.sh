#!bin/bash
if [ `find "$1" -prune -empty -type d` ]
then
	echo "Con archivos"
else
	echo "Sin archivos"
fi