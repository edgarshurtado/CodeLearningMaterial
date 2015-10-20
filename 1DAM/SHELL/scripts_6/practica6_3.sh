#!bin/bash
maxLineas=0
for archivo in *
do
	numLineas=`cat "$archivo" | wc -l` 
	if test $numLineas -ge $maxLineas
		then
		archMaxLineas="$archivo"
		maxLineas=$numLineas
	fi
done

echo $archMaxLineas