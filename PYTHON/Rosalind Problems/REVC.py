fhand = open("dataset.txt")

result = []

for line in fhand:
	for nBase in line:
		if nBase == 'A':
			nBase = 'T'
		elif nBase == 'T':
			nBase = 'A'
		elif nBase == 'G':
			nBase = 'C'
		elif nBase == 'C':
			nBase = 'G'
		result.insert(0, nBase)

stringResult = ""
for base in result:
	stringResult += base

print stringResult