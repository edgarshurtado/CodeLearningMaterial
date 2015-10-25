<form action="2.php" method="POST">
    <input type="text" name="edad" value="" required/>
    Hombre
    <input type="radio" name="sexo" value="male" />
    Mujer
    <input type="radio" name="sexo" value="male" />
    <br />
    <input type="checkbox" name="Extras[]" value="Garaje">Garaje</input> <br />
    <input type="checkbox" name="Extras[]" value="Jardín">Jardín</input><br />
    <input type="checkbox" name="Extras[]" value="Piscina">Piscina</input><br />
    <input type="submit" name="button" value="Send" />
</form>