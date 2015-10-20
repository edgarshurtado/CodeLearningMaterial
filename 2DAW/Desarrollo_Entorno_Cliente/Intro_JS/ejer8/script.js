function esPar(numero){
	return numero % 2 === 0;
}

var userNumb = parseInt(prompt("Introduce un numero"), 10);

if(esPar(userNumb)){
	alert("Es par");
} else {
	alert("Es impar");
}