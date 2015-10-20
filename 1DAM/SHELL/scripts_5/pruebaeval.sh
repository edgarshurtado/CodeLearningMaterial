#!/bin/bash

read ruta
echo $ruta
test -d "$ruta" && echo yes || echo no