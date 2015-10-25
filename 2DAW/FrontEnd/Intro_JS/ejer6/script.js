function dniValido(numero, letra){
	if(numero < 0 || numero > 999999999){
		alert("Número inválido");
		return false;
	} else{
		return letraValida();
	}

	function letraValida(){
		var dicLetras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
						'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
						'C', 'K', 'E', 'T'];

		if(dicLetras[numero % 23] === letra){
			return true;
		} else {
			return false;
		}
	}
}

var dniNumber = parseInt(prompt("Introduce el nº de tu DNI"));
var dniLeter = prompt("Introduce la letra de tu DNI").toUpperCase();

if(dniValido(dniNumber, dniLeter)){
	alert("\xC9s Valido");
} else {
	alert("No es válido");
}