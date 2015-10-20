#!/bin/bash
links=0

for i in `ls`
	do
	if test -L $i
		then
		echo "$i es un enlace simbólico"
		links=$(($links+1))
	else
		echo "$i no es un enlace simbólico"
	fi 
done

echo "Nº total de enlaces simbólicos: $links"
