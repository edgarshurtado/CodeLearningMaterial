#!/bin/bash
if [ $1 -eq $2 ] && [ $2 -eq $3 ]
	then
		echo "Todos son iguales"
	else if [ $1 -ne $2 ] && [ $2 -ne $3 ] && [ $1 -ne $3 ]
		then
			echo "Todos son distintos"
	else
		echo "2 son iguales"
	fi
fi

exit 0
