#!/bin/bash
anyoActual=`date | cut -d' ' -f6`
echo "Introduce un año"
read anyoIntroducido
echo $anyoActual $anyoIntroducido

if test $anyoIntroducido -gt $anyoActual
then
	resultado=$[$anyoIntroducido-$anyoActual]
	echo "Faltan $resultado años"
else
	resultado=$[$anyoActual-$anyoIntroducido]
	echo "Han pasado $resultado años"
fi

exit 0
