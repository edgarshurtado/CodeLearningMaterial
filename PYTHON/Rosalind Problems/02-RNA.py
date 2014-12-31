fhand=open("rosalind_rna.txt")

result=""

for line in fhand:
	for nBase in line:
		if nBase == 'T':
			nBase = 'U'
		result+=nBase

print result

