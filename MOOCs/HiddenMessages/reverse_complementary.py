def reverse_complementary(string):
	complementary_nucleotides = {'A': 'T', 'T': 'A', 'C': 'G', 'G': 'C'}
	complementary_string = ""

	string = string.strip().upper()

	for nucleotide in string:
		complementary_string += complementary_nucleotides[nucleotide]

	reverse_complementary = complementary_string[::-1]
	return reverse_complementary