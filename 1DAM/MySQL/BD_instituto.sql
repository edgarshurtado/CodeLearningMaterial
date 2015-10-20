#Crea BD instituto
CREATE DATABASE instituto;
USE instituto;

#Crea la tabla alumnos = codigo + nombre + estudios
CREATE TABLE alumnos (
	codi INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20),
	estudis VARCHAR(3)
);

#Introduce 9 alumnos: 3 de PQP, 3 de ESO y 3 de DAM
INSERT INTO alumnos (nombre, estudis) VALUES ("Edgar", "DAM");
INSERT INTO alumnos (nombre, estudis) VALUES ("Angel", "ESO");
INSERT INTO alumnos (nombre, estudis) VALUES ("Adriana", "PQP");
INSERT INTO alumnos (nombre, estudis) VALUES ("Igor", "ESO");  
INSERT INTO alumnos (nombre, estudis) VALUES ("Diego", "DAM");
INSERT INTO alumnos (nombre, estudis) VALUES ("Carlos", "PQP");
INSERT INTO alumnos (nombre, estudis) VALUES ("Bernat", "DAM");
INSERT INTO alumnos (nombre, estudis) VALUES ("Marc", "ESO");
INSERT INTO alumnos (nombre, estudis) VALUES ("Isidro", "PQP");

# A partir de la tabla alumnos crea la tabla a_dam con (codi y nombre) de DAM
CREATE TABLE dam
	SELECT * 
		FROM alumnos
		WHERE estudis = "DAM";
# Igual pero con los de la eso
DROP TABLE eso;
CREATE TABLE eso (
	codi INT PRIMARY KEY,
	nombre VARCHAR(20),
	estudis VARCHAR(3)
);
INSERT INTO eso
	SELECT *
		FROM alumnos
		WHERE estudis = "ESO";


#3 alumnos d'eso.
INSERT INTO eso (codi, nombre) VALUES (10, "Adrianorbe");
INSERT INTO eso (codi, nombre) VALUES (11, "Chismoll");
INSERT INTO eso (codi, nombre) VALUES (12, "Botija");

#Borrar datos de alumnos
DELETE FROM alumnos;
	