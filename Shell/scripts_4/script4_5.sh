#!/bin/bash

month=`date | cut -d" " -f2`
day=`date | cut -d" " -f3`


case $month in 
	ene)days=0;;
	feb)days=31;;
	mar)days=59;;
	abr)days=90;;
	may)days=120;;
	jun)days=151;;
	jul)days=181;;
	ago)days=212;;
	sep)days=243;;
	oct)days=273;;
	nov)days=304;;
	dic)days=334;;
esac

days=$[$days+$day]

echo $days
