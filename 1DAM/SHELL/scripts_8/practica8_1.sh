#!/bin/bash

function promptMenuInicial {
	echo "P) Menú de procesos"
	echo "U) Menú de usuarios"
	echo "Q) Salir"

	read option

	case $option in
		'P') menuProcesos
			;;
		'U') menuUsuarios
			;;
		'Q')
			;;
	esac
}

function menuProcesos {
	echo "1) Muestra la lista de procesos en ejecución"
	echo "2) Muestra la lista ampliada de procesos, actualizando la información cada 2 segundos"
	echo "Q) Salir"
	read option
	case $option in
		'1') `jobs`;;
		'2') `top -s 2`;;
	esac
}

function menuUsuarios {
	echo "1) Linea del usuario en /etc/passwd"
	echo "2) GID del grupo al que pertenece el usuario"
	echo -n "opcion"
	read option
	case $option in
		'1')
			user=`whoami`
			echo `cat /etc/passwd | grep $user`;;
		'2')user=`whoami`
			for gid in `cat /etc/group | grep -w $user | cut -d":" -f3`
			do
			echo $gid
			done
			;;
	esac
}

if [ $# -eq 0 ]
	then
	promptMenuInicial
fi

exit 0
