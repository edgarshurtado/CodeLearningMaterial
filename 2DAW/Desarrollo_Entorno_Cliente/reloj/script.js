function getTime(){
	var date = new Date();

	return date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
}

var prueba = document.getElementById("reloj").innerHTML;
alert(prueba);