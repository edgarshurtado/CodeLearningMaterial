fhand=open("rosalind_dna.txt")

result=[0,0,0,0]  #A-C-G-T

for line in fhand:
	for nbase in line:
		if nbase == 'A':
			result[0]+=1
		elif nbase == 'C':
			result[1]+=1
		elif nbase == 'G':
			result[2]+=1
		elif nbase == 'T':
			result[3]+=1

print result[0], result[1], result[2], result[3],