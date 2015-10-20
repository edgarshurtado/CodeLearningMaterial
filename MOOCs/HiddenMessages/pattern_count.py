def pattern_count(text, pattern):
	"""
	Count the ocurrences of pattern in text. It counts
	the overlaping ocurrences too.
	"""
	count = 0
	#Need to do len(pattern) - 1 to include the last 
	#nucelotide of the sequence
	for i in range(0,len(text) - (len(pattern) - 1)):
		if text[i:(i + len(pattern))] == pattern:
			count += 1

	return count

def extract_patterns(text, k):
	patterns = set()

	for i in range(len(text) - k):
		patt = text[i: i + k]
		patterns.add(patt)

	return patterns

def frequent_words(text, k):
	max_patterns = []
	max_count = 0

	patterns = extract_patterns(text, k)

	for pattern in patterns:
		count = pattern_count(text, pattern)
		if count > max_count:
			max_count = count
			max_patterns = []
			max_patterns.append(pattern)
		elif count == max_count:
			max_patterns.append(pattern)

	print max_count
	return max_patterns

def print_patterns(patterns_set):
	for pattern in patterns_set:
		print pattern,


