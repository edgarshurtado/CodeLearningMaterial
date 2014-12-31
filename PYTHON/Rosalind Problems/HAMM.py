fhand = open("rosalind_hamm.txt")

#Setting the strings and the counter
strings = []
for line in fhand:
	strings.append(line)
mutations = 0

#Counting the numbers of mutations
for i in range(len(strings[0])-1):
	if strings[0][i] != strings[1][i]:
		mutations += 1

print mutations