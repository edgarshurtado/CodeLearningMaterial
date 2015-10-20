#!/bin/bash

echo -n "Introduce tu primer número: "
read a

echo -n "Introduce tu segundo número: "
read b

echo -n "Introduce tu tercer número: "
read c

d=`echo "($a+$b)/$c" | bc -l` 

echo "El resultdo de ($a+$b)/$c es: $d"

exit 0
