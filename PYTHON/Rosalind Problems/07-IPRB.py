def iprb(k, m, n):
	"""Computes the probability of getting a dominant phenotype
	from matching 2 randomly selected individuals of a population
	given the number of dominant homozygous individuals (k), heterozygous
	individuals (m) and recesive homozygous individuals (n) """
	
	dominantAlleles = 2.0*k + m
	recesiveAlleles = 2.0*n + n
	allelesPopulation = 2.0*(k+m+n)

	probability = ((dominantAlleles/allelesPopulation)*
		((dominantAlleles-1 + recesiveAlleles)/(allelesPopulation-1))+
		(recesiveAlleles/allelesPopulation)*(dominantAlleles/(allelesPopulation-1)))

	return probability
