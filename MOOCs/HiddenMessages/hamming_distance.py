from reverse_complementary import reverse_complementary

def pattern_to_number(pattern):
	"""
	>>> pattern_to_number("TGA")
	56
	"""
	n_bases = ["A", "C", "G", "T"]
	number = 0
	for position in range(len(pattern)):
		nb = pattern[position]
		exponent = len(pattern) - position -1
		number += n_bases.index(nb) * (4 ** exponent)

	return number

def number_to_pattern(number, k):
	"""
	Takes a number and returns the pattern of length k that takes
	the position "number" in a sorted list of patterns of length k
	"""
	n_bases = ["A", "C", "G", "T"]
	pattern = ""
	for i in range(k-1, -1, -1):
		base_index = number / (4**i)
		pattern += n_bases[base_index]
		number -= base_index * 4**i

	return pattern

def hamming_distance(string1, string2):
	assert len(string1) == len(string2), "The strings have to had the same length"

	missmatches = 0

	for i in range(len(string1)):
		if string1[i] != string2[i]:
			missmatches += 1

	return missmatches

def approximate_pattern_matching(string, pattern, d):

	matches = []

	for i in range(len(string) - (len(pattern) - 1)):
		substring = string[i:i+len(pattern)]
		if hamming_distance(substring, pattern) <= d:
			matches.append(i)

	return matches

def pattern_count(text, pattern, d):
	"""
	Count the ocurrences of pattern in text if the difference isn't 
	greater than d missmatches. It counts
	the overlaping ocurrences too.
	"""
	count = 0
	#Need to do len(pattern) - 1 to include the last 
	#nucelotide of the sequence
	for i in range(0,len(text) - (len(pattern) - 1)):
		substring = text[i:(i + len(pattern))]
		if  hamming_distance(substring, pattern) < d:
			count += 1

	return count

def computing_freq(genome, k, d=0):
	"""
	--> list
	Returns the frequency array of k-mers in the genome with missmatches
	up to d. d is 0 by default
	"""
	freq_array = []

	for i in range(4**k):
		freq_array.append(0)

	for i in range(len(genome) - (k - 1)):
		pattern = genome[i : i + k]
		pattern_i = pattern_to_number(pattern)
		
		if d == 0:
			freq_array[pattern_i] += 1
		else:
			for j in range(4**k):
				q_sequence = number_to_pattern(j, k)
				hd = hamming_distance(pattern, q_sequence)
				if hd <= d:
					freq_array[j] += 1

	return freq_array 


def frequent_words_mistmaches(genome, k, d):
	"""
	--> list
	Returns a list with the most frequent k-mers with
	mismatches up to d

	>> frequent_words_mistmaches(
		"ACGTTGCATGTCGCATGATGCATGAGAGCT", 4, 1)
	["GATG","ATGC","ATGT"]
	"""
	frequent_words = []
	fq_array = computing_freq(genome, k, d)
	max_fq = max(fq_array)

	for i in range(len(fq_array)):
		if fq_array[i] == max_fq:
			frequent_word = number_to_pattern(i, k)
			frequent_words.append(frequent_word)

	return frequent_words


def fwm_reverse(genome, k, d):
	"""
	Returns a list with the most frequent k-mers and its
	reverses with mismatches up to d

	>>> fwm_reverse("ACGTTGCATGTCGCATGATGCATGAGAGCT", 4, 1)
	[set(['ATGT', 'ACAT'])]
	"""
	frequent_words = []
	fq_array = computing_freq(genome, k, d)
	max_fq = -1

	for i in range(len(fq_array)):
		reverse = reverse_complementary(
			number_to_pattern(i, k)
		)
		r_number = pattern_to_number(reverse)

		if fq_array[i]+fq_array[r_number] > max_fq and i < r_number:
			frequent_words = []
			frequent_word = set([number_to_pattern(i, k), reverse])
			frequent_words.append(frequent_word)
			max_fq = fq_array[i]+fq_array[r_number]
		elif fq_array[i]+fq_array[r_number] == max_fq and i < r_number:
			frequent_word = set([number_to_pattern(i, k), reverse])
			frequent_words.append(frequent_word)

	return frequent_words
