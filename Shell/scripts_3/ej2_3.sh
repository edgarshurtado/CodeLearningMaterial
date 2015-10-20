#!/bin/bash


for argumento in $*
do
	if test `expr $argumento % 2` = 0
	then
		echo "$argumento es par"
	else
		echo "$argumento es inpar"	
	fi

done


