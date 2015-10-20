def skew(genome):
	"""
	Generates the skew diagram for the given genome
	"""
	g_minus_c_content = 0
	skew_diagram = [0]

	for base in genome:
		if base == "C":
			g_minus_c_content -= 1
			
		elif base == "G":
			g_minus_c_content += 1

		skew_diagram.append(g_minus_c_content)

	return skew_diagram

def min_skew(genome):
	"""
	--> list
	Returns the postions of the genome where the
	skew diagram has the lowest value
	"""
	skew_diagram = skew(genome)
	min_skew_pos = []
	min_skew_value = 0

	for i in range(len(skew_diagram)):
		if skew_diagram[i] < min_skew_value:
			min_skew_value = skew_diagram[i]
			min_skew_pos = []
			min_skew_pos.append(i)
		elif skew_diagram[i] == min_skew_value:
			min_skew_pos.append(i)

	for position in min_skew_pos:
		print position,

