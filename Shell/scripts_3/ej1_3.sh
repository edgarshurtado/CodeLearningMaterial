#!/bin/bash

if test $# = 1
then
	if test -g $1
	then
		echo "set-group-ID"
	fi

	if test -k $1
	then
		echo "Permiso sticky bit"
	fi

	if test -u
	then
		echo "set-user-ID"
	fi

else
	echo "Nº de argumentos incorrectos"
fi

exit 0
