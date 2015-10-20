#!/bin/bash

if test $# = 1
	then
	du $1 | cut -f1
else
	echo "Has de introducir un nombre como argumento"
fi
