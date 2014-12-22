
fhand = open("dataset.txt")
currentSecuenceComp=[0, 0, 0, 0]

for line in fhand:
	for nBase in line:
		if nBase == 'A':
			currentSecuenceComp[0] += 1
		elif nBase == 'T':
			currentSecuenceComp[1] += 1
		elif nBase == 'G':
			currentSecuenceComp[2] += 1
		elif nBase == 'C':
			currentSecuenceComp[3] += 1

print currentSecuenceComp

totalGC = currentSecuenceComp[2] + currentSecuenceComp[3]
totalBases = totalGC + currentSecuenceComp[0] + currentSecuenceComp[1]
currentSecuenceGC_Comp = (float(totalGC)/totalBases) * 100

print currentSecuenceGC_Comp