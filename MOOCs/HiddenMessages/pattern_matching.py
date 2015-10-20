def pattern_matching(string, pattern):
	"""
	>>> pattern_matching("GATATATGCATATACTT", "ATAT")
	1 3 9
	"""

	for i in range(len(string) - len(pattern)):
		if string[i:i+len(pattern)] == pattern:
			print i,

def pattern_matching_file(file_path, pattern):
	file = open(file_path)

	starting_pos = 0

	for line in file:
		for i in range(len(line) - len(pattern)):

			if line[i: i + len(pattern)] == pattern:
				print starting_pos,
			
			starting_pos += 1