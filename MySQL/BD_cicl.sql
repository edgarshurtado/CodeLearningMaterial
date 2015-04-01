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

DESCRIBE ciclistes;
SELECT ROUND(AVG(edat), 1), max(edat), count(*)
	FROM ciclistes
	GROUP BY equip
	HAVING count(*) >= 3;
	
#d2) Calcula quantes etapes ha guanyat cada corredor, ordenat primer per qui ha guanyat més etapes. Només es mostrarán els corredors que hagen guanyat más d'1 etapa.
DESCRIBE etapes;
SELECT ciclista, count(*)
	FROM etapes
	GROUP BY ciclista
	HAVING count(*) > 1;
	
#d3) Mostra les categories de ports on l'altura màxima siga igual a la mínima.
DESCRIBE ports;
SELECT nom, categoria, max(altura), min(altura) 
	FROM ports
	GROUP BY categoria
	HAVING max(altura) = min(altura);
	
#d4)Dorsals que han guanyat més d'un port en una mateixa etapa.
DESCRIBE ports;

SELECT ciclista, etapa, count(*)
	FROM ports
	GROUP BY ciclista, etapa
	HAVING count(*) > 1;
	
#4.4.12(Condicions de recerca)
#E1) Mostra l'etapa i els km de les etapes entre 50 i 100 kms
DESCRIBE etapes;
SELECT numero, kms
	FROM etapes
	WHERE kms > 50 AND kms < 100;
	
#E2) Mostra l'etapa i els km de les altres etapes (<50 i > 100)
SELECT numero, kms
	FROM etapes
	WHERE kms < 50 OR kms > 100;
	
#E3) Obtín el nom dels cilistes que comencen per 'Al'
DESCRIBE ciclistes;
SELECT nom
	FROM ciclistes
	WHERE nom LIKE 'Al%';

#E4) Noms d'equips que contiguen 'tiac'
DESCRIBE equips;

SELECT nom
	FROM equips
	WHERE nom LIKE '%tiac%';
	
#E5) Noms de ciutats d'arribada que continguen 'Naran', que tinguen altra lletra al costat, després una 'o' i després més coses.
DESCRIBE etapes;
SELECT arribada
	FROM etapes
	WHERE arribada LIKE '%naran_o%';

#E6) Noms de ciclistes que continguen 'Induráin' peró que no siguen 'Miguel'.
DESCRIBE ciclistes;
SELECT nom
	FROM ciclistes
	WHERE nom LIKE '%induráin%' AND nom NOT LIKE '%miguel%';

#4.4.13 (Condicions de recerca compostes: AND, OR i NOT)
#F1) Selecciona els ports que estiguen entre 1500 i 2000 metres. A més, haurán de complir que no siguen de la categoria 'E' o que tinguen una pendent major que 5.
DESCRIBE ports;

SELECT nom, altura, categoria, pendent
	FROM ports
	WHERE altura > 1500 AND altura < 2000 AND (categoria != 'E' OR pendent > 5);
	
#F2) Ciclistes que comencen per 'Al', 'An' o 'Ar' que tinguen entre 25 i 30 anys.
DESCRIBE ciclistes;

SELECT nom, edat
	FROM ciclistes
	WHERE (nom LIKE 'Al%' OR nom LIKE 'an%' OR nom LIKE 'Ar%') AND edat >= 25 AND edat <= 30;
	
#G1) Ordena els ciclistes pel nom de l'equip. Dins de cada equip, primer eixiran els més vells i després els més joves. Si diversos ciclistes del mateix equip tenen la mateixa edat, deuran aparéixer ordenats pel nom del ciclista

DESCRIBE ciclistes;
SELECT equip, nom, edat
	FROM ciclistes
	ORDER BY equip, edat DESC;
	
#H1) Selecciona els dorsals dels corredors de Banesto i també els que han guanyat alguna etapa.

SELECT dorsal
	FROM ciclistes
	WHERE equip='Banesto'

UNION	

SELECT ciclista
	FROM etapes;
	



	