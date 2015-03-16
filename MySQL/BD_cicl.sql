##4.2.2
#a1 Obteniu quants ciclistes hi ha
SELECT count(*)
	FROM ciclistes;

#a2 Mostra l'edat mitjana dels ciclistes
DESCRIBE ciclistes;
SELECT AVG(edat)
	FROM ciclistes;
	
#a3 Obteniu l'altura mínima y máxima dels ports de muntanya
DESCRIBE ports;
SELECT MIN(altura), MAX(altura)
	FROM ports;

#a4 Calcula quants kilòmetres té en total la volta ciclista
DESCRIBE etapes;
SELECT SUM(kms)
	FROM etapes;
	
##4.3.7 Flata de dades (valors NULL)
#b1 Obteniu aquells ports que no tenen assignada categoria
DESCRIBE ports;
SELECT nom
	FROM ports
	WHERE categoria IS NULL;

##4.4.2 CLAUSULA SELECT
#a1 Selecciona tota la informació dels ports
SELECT * FROM ports;

#a2 Selecciona el nom del port, l'altura en kilòmetres (está guardada en metres) i, al costat, que aparega la paraula "Km"

SELECT nom, (altura/1000), "kms" AS altura_kms
	FROM ports;
	
### 4.4.4 RESULTATS DE CONSULTES
#b1 Crea la taula etapes_ciutat que continga el número d'etapa i la ciutat d'aquelles etapes que comencen i cabaen en la mateixa ciutat.
DESCRIBE etapes;
CREATE TABLE etapes_ciutat
	SELECT numero, eixida
		FROM etapes
		WHERE eixida = arribada;
		
#b2 Crea la taula premis que continga el nom del color del mallot i el premi. Els noms de les columnes han de ser "Color del mallot" i "Valor del premi"
DESCRIBE mallots;
CREATE TABLE premis(
	`Color del mallot` VARCHAR(20),
	`Valor del premi` INT(10),
	PRIMARY KEY (`Color del mallot`, `Valor del premi`)
);

INSERT INTO premis
	SELECT color, premi
	FROM mallots;
	
## 4.4.10 (Clàusula GROUP BY)
#c1 Calcula de cada equip l'edat mitjana, màxima, mínima i quants corredors té
DESCRIBE ciclistes;
SELECT equip, round(AVG(edat),2) AS `mitja	`, MAX(edat), MIN(edat), count(*)
	FROM ciclistes
	GROUP BY equip;
	
#c2 Calcula quantes etapes ha guanyat cada corredor, ordenat primer per qui ha guanyat més etapes.
DESCRIBE etapes;
DESCRIBE ciclistes;
SELECT ciclistes.nom, count(*) AS `etapas_ganadas`
	FROM etapes, ciclistes
	WHERE ciclistes.dorsal = etapes.`ciclista`
	GROUP BY etapes.ciclista
	ORDER BY `etapas_ganadas` DESC;
	
#c3 Calcula, de cada categoria de port: l'altura máxima, minima i mitjana; la pendent máxima, mínima i mitjana; quants ports hi ha

DESCRIBE ports;
SELECT categoria, MAX(altura), MIN(altura), AVG(altura), MAX(pendent), MIN(pendent), AVG(pendent), count(*)
	FROM ports
	GROUP BY categoria;
	
#c4 Calcula quantes voltes ha portat un corredor cada mallot
DESCRIBE portar;
SELECT ciclista, mallot, count(*)
	FROM portar
	GROUP BY ciclista, mallot;

#c5 Quants corredors hi ha de cada edat en cada equip?
DESCRIBE ciclistes;
SELECT edat, `equip`, count(*)
	FROM ciclistes
	GROUP BY edat, equip;
	
## 4.4.11 (Clàusula HAVING)
#d1 Calcula de cada equip amb més de 3 corredors: l'edat mitjana, máxima i quants corredors té
