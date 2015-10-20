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


def computing_frequencies(text, k):
	frequency_array = []
	
	for i in range(4**k):
		frequency_array.append(0)

	for i in range(len(text) - (k - 1)):
		pattern = text[i:(i+k)]
		pattern_index = pattern_to_number(pattern)

		frequency_array[pattern_index] += 1

	return frequency_array


