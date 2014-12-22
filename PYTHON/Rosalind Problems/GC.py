"""
Computing GC Content

Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).

Return: The ID of the string having the highest GC-content, followed by the
GC-content of that string. Rosalind allows for a default error of 0.001 in 
all decimal answers unless otherwise stated; please see the note on absolute 
error below."""

def GC_CompMath(listComposition):
	#Computes the % of GC in the string
	totalGC = listComposition[2] + listComposition[3]
	totalBases = totalGC + listComposition[0] + listComposition[1]
	currentSecuenceGC_Comp = (float(totalGC)/totalBases) * 100
	return currentSecuenceGC_Comp

#Inicialicing the needed variables. These negative values haven't got biological meaning
highestName = "default" 
highestGC_Comp = -1

currentSecuenceName = "default"
currentSecuenceComp = [-1, -1, -1, -1]

fhand = open("dataset.txt")
for line in fhand:
	if line.startswith(">"):
		#Checking if the previous secuence has a higher GC composition
		currentSecuenceGC_Comp = GC_CompMath(currentSecuenceComp)

		if currentSecuenceGC_Comp > highestGC_Comp:
			highestName = currentSecuenceName
			highestGC_Comp = currentSecuenceGC_Comp

		#Reseting current secuence variables
		currentSecuenceName = line[1:]
		currentSecuenceComp = [0, 0, 0, 0]

	else:
		#Count of bases
		for nBase in line:
			if nBase == 'A':
				currentSecuenceComp[0] += 1
			elif nBase == 'T':
				currentSecuenceComp[1] += 1
			elif nBase == 'G':
				currentSecuenceComp[2] += 1
			elif nBase == 'C':
				currentSecuenceComp[3] += 1

#Check for the last secuence (because there's no ">" at the end of the last line)
currentSecuenceGC_Comp = GC_CompMath(currentSecuenceComp)

if currentSecuenceGC_Comp > highestGC_Comp:
	highestName = currentSecuenceName
	highestGC_Comp = currentSecuenceGC_Comp

print highestName, highestGC_Comp
