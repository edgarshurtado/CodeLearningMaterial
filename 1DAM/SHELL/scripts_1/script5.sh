#!/bin/bash

echo -n "Introduce el primer nº: "
read a

echo -n "Introduce el segundo nº: "
read b

if test $a -gt $b  #ó bien:		if [$a -gt $b]
then
	echo "$a > $b"
	echo $(($a-$b))
elif test $b -gt $a #ó bien: 	elif [$b -gt $a]
then
	echo "$b > $a"
	echo $(($b-$a)) 
else
	echo "Los números son iguales"

fi



