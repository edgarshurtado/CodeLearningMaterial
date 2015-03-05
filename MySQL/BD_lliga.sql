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