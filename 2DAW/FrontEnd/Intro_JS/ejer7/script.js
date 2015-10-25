var numero = prompt("Escribe un número para obtener su factorial");

var factorial = 1;
for (var i = numero; i > 0; i--){
	factorial *= i;	
}

alert(factorial);