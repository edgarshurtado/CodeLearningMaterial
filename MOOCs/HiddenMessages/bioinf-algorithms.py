from frequency_array import *

def clump_finding(Genome, k, t, L):
	frequent_patterns = set()
	clump = []

	for i in range(4**k):
		clump.append(0)

	for i in range (len(Genome) - L):
		text = Genome[i:i+L]
		frequency_array = computing_frequencies(text, k)

		for j in range(4**k):
			if frequency_array[j] >= t:
				clump[j] = 1

	for i in range(4**k):
		if clump[i] == 1:
			pattern = number_to_pattern(i, k)
			frequent_patterns.add(pattern)

	return frequent_patterns

def clump_improved(Genome, k, t, L):
	frequent_patterns = set()
	clump = []

	for i in range(4**k):
		clump.append(0)

	text = Genome[0:L]
	frequency_array = computing_frequencies(text, k)
	for i in range(4**k):
		if frequency_array[i] >= t:
			clump[i] = 0

	for i in range( 1, len(Genome) - L):
		first_pattern = Genome[i - 1: i + k - 1]
		first_pattern_index = pattern_to_number(first_pattern)
		frequency_array[first_pattern_index] -= 1

		last_pattern = Genome[i + L - k : i + L]
		last_pattern_index = pattern_to_number(last_pattern)
		frequency_array[last_pattern_index] += 1

		if frequency_array[last_pattern_index] >= t:
			clump[last_pattern_index] = 1

	for i in range(4**k):
		if clump[i] == 1:
			pattern = number_to_pattern(i, k)
			frequent_patterns.add(pattern)

	return frequent_patterns

