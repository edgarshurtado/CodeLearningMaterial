#!/bin/bash

function comprobarFichero {
	echo -n "Dime el nombre de un fichero: "
	read local fichero
	if test -s $fichero
		then
		echo "El archivo existe"
	else
		echo "El archivo no existe"
	fi
}

function actualizarHora {
	ls -l
	echo -n "Dime el nombre del fichero a actualizar: "
	read fichero
	if test -f $fichero
		then
		touch $fichero
	else
		echo "El archivo no existe"
	fi
}

function crearArchivo {
	echo -n "Dime el nombre del archivo a crear: "
	read fichero
	if test ! -f $fichero
		then
		touch $fichero
		echo "Archivo creado"
	else
		echo "El archivo ya existe"
	fi
}

function menuPrincipal {
	while true
	do
		echo "MENU DE OPCIONES"
		echo
		echo "1) Ficheros"
		echo "2) Directorios"
		echo "*) Salir"
	done
}

function ficheros {
	while true
	do 
		echo "MENU FICHEROS"
		echo
		echo "1) Comprueba si existe un fichero"
		echo "2) Actualiza hora y fecha de un fichero"
		echo "3) Crea un fichero"
		echo "4) Vuelve al menú principal"
		echo "*) Salir"
		echo
		echo -n "Introduce tu opcion: "
		read opcion
		case $opcion in
			1)comprobarFichero;;
			2)actualizarHora;;
			3)crearArchivo;;
			4) break;;
			*) exit 0;;
		esac
	done
}

function menuDirectorios {
	echo "MENU DIRECTORIOS"
	echo
	echo "1) Comprueba si existe un directorio"
	echo "2) Crea un directorio"
	echo "3) Vuelve al menú principal"
	echo
	echo -n "Introduce tu opción: "
	read opcion
	case $opcion in
		1);;
		2);;
		3);;
		*) echo "Opción incorrecta";;
	esac		
		
}

function comprobarDirectorio {
	cd
	echo "Nombre del directorio: "
	read directorio
	eval "directorio=$directorio"
	echo $directorio	
	if test -d $directorio
		then
			echo "El directorio existe"
		else
			echo "El directorio no existe"
	fi
}

function crearDirectorio {
	echo -n "Nombre del directorio"
	read directorio
	eval directorio=$directorio
	mkdir $directorio
}

comprobarDirectorio
