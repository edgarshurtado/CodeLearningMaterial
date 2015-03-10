#7 Mostra el següents sous: El més car, el més barat i la mitjana
SELECT MAX(sou), MIN(sou), AVG(sou)
	FROM jugadors;
	
#8 Incrementa un 5% els pressupostos de tots els equips.
UPDATE equips
	SET pressupost = pressupost * 1.05;

#9 Mostra la quiniela de la primera jornada (equip casa, equip fora, 1x2). Harás de buscar un select condicional. Busca en internet.
DESCRIBE partits;
SELECT equipc, equipf, IF(golsc > golsf, 'x', '') AS `Equip casa`, IF (golsc < golsf, 'x', '') AS `Equip fora`, IF(golsc = golsf, 'x', '') AS `1x2`
	FROM partits
	WHERE jornada = 1;
	
#10. Mostra les quinieles de tota la competició
SELECT equipc, equipf, jornada, IF(golsc > golsf, 'x', '') AS `Equip casa`, IF (golsc < golsf, 'x', '') AS `Equip fora`, IF(golsc = golsf, 'x', '') AS `1x2`
	FROM partits
	ORDER BY jornada;
	
#11 Gols marcats pel pitxitxi
SELECT jugadors.nom AS `pitxitxi`, golejadors.equip, golejadors.dorsal, MAX(gols) AS `gols`
	FROM golejadors, jugadors
	WHERE golejadors.dorsal = jugadors.dorsal AND golejadors.equip = jugadors.equip;
	
#EXERCICIS GROUP BY
#1 Mostra de cada equip: el codi, sou màxim, mínim, la suma de tots els sous, quants jugadors hi ha, de quants jugadors es coneix el sou, la mitjana de sous entre els que sabem el sou i la mitjana de sous entre tots el jugadors.
DESCRIBE jugadors;
SELECT count(*) 
	FROM jugadors;
	
SELECT count(*)
	FROM jugadors
	WHERE sou IS NULL;
SELECT equip, MAX(sou), MIN(sou), SUM(sou), COUNT(dorsal) AS `jugadors`, COUNT(sou), AVG(sou) AS `Mitja sou`, SUM(sou)/COUNT(*) AS `Mitja total`
	FROM jugadors
	GROUP BY equip;
	
#2. Mostra quants jugadors té cada equip en cada posició.
DESCRIBE jugadors;
SELECT equip, lloc, count(*)
	FROM jugadors
	GROUP BY equip, lloc;
	
#3 Gols marcats en total en cada jornada
SELECT jornada, sum(golsc+golsf) AS `gols`
	FROM `partits`
	GROUP BY jornada
	HAVING gols IS NOT NULL;
	
#4 Mitja de gols per partit en cada jornada
DESCRIBE partits;
SELECT count(*)
	FROM partits
	WHERE jornada = 1;
SELECT jornada, count(*) AS `partits`, SUM(golsc + golsf)/COUNT(*) AS `Mitja gols`
	FROM `partits`
	GROUP BY jornada
	HAVING `Mitja gols` IS NOT NULL;
	
#5 Gols marcats pel pitxitxi de cada equip
DESCRIBE golejadors;
SELECT golejadors.equip, jugadors.nom, MAX(golejadors.gols)
	FROM golejadors, jugadors
	WHERE golejadors.equip + golejadors.dorsal = jugadors.equip + jugadors.dorsal
	GROUP BY equip;
	
#6 Gols marcats per cada equip en casa
DESCRIBE partits;
SELECT equipc, sum(golsc)
	FROM partits
	GROUP BY equipc;
	
#7 Gols que ha rebut en total cada equip com a visitant
SELECT equipf AS equip, sum(golsc) AS `goles encajados como vis.`
	FROM partits
	GROUP BY equipf;
	
#8 Quants partits han guanyat cada equip jugant en casa
SELECT equipc AS `equip`, count(*) AS `partits guanyats`
	FROM `partits`
	WHERE golsc > golsf
	GROUP BY equipc;
	
#9 Comprova si hi ha algun nom de jugador repetit. És a dir: cal mostrar el nom del jugador i quantes voltes apareix però només per a aquells jugadors que tinguen el nom repetit.
SELECT nom, count(*)
	FROM jugadors
	GROUP BY nom
	HAVING count(*) > 1;
	
#10 Volem saber la mitja de possessió del baló de cada equip jugant a casa. Ordenat de major a menor possessió. La mitja ha d'eixir sense decimals.
DESCRIBE partits;
SELECT equipc, ROUND(AVG(possessioc))
	FROM partits
	GROUP BY equipc;
	
#11 Mitjana de gols marcats en cada jornada i la data de la jornada (un decimal).
DESCRIBE jornades;
SELECT jornades.num AS `jornada`, ROUND(AVG(partits.golsc + partits.golsf), 1) AS `Mitja gols`
	FROM jornades, `partits`
	GROUP BY jornades.num;
	
#12 Jornades en les quals s'han marcat més de 35 gols.
DESCRIBE partits;
SELECT jornada, SUM(golsc+golsf) AS `gols`
	FROM partits
	GROUP BY jornada
	HAVING `gols` > 35;