
sequence = [1, 1] #The first 2 elements in every fiboniacci secuence

#Taking the data
fhand = open("dataset.txt")
for line in fhand:
	line = line.split()
	nGenerations = int(line[0])
	k = int(line[1])

#Program logic
index = 1 #Starts in index 1 because of the 2 numbers that are in the secuence already
while (len(sequence) < nGenerations):
	sequence.append( sequence[index] + (sequence[index-1] * k))
	index += 1

print sequence