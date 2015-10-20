#!/bin/bash

if test -h $1
	then
	echo "Es un enlace simbólico"
else
	echo "No es un enlace simbólico"
fi
