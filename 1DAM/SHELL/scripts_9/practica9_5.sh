#!bin/bash

if [ $1 -gt 0 ]
then
	numRestantes=$1
	numNegativos=0
	while [ $numRestantes -gt 0 ]
	do
		echo -n "Introduce un nº "
		read num
		if [ $num -lt 0 ]
			then
				numNegativos=$[$numNegativos+1]
		fi
	numRestantes=$[$numRestantes-1]
	done
fi
echo $numNegativos

