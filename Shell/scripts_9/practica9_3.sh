#!/bin/bash

if [ $1 -lt $2 ]
	then
		numero=$1
		final=$2
		while [ $numero -lt $final ]
			do
				numero=$[$numero+1]
				if test $(($numero%2)) -eq 0
					then
						echo "$numero es par"
					else
						echo "$numero es inpar"
				fi
		done
				
	else
		echo "El segundo argumento debe ser menor que el primero" 
fi

exit 0
