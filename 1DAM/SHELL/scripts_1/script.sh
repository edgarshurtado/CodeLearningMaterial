#!/bin/bash

echo -n "Fecha y hora: "
date

echo -n "Usuarios activos: "
who | wc -l 

echo -e "Directorio actual: \c"
pwd
