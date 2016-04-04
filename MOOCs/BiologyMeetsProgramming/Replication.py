# TODO: refactor all names to match pep8 guidelines
def PatternCount(Pattern, Text):
    # Input:  Strings Pattern and Text
    # Output: The number of times Pattern appears in Text   count = 0
    count = 0
    for i in range(len(Text)-len(Pattern)+1):
        if Text[i:i+len(Pattern)] == Pattern:
            count = count+1
    return count


def CountDict(Text, k):
    # Input:  A string Text and an integer k
    # Output: CountDict(Text, k)
    Count = {}
    for i in range(len(Text)-k+1):
        Pattern = Text[i:i+k]
        Count[i] = PatternCount(Pattern, Text)
    return Count


def FrequentWords(Text, k):
    # Input:  A string Text and an integer k
    # Output: A list containing all most frequent k-mers in Text
    FrequentPatterns = []
    Count = CountDict(Text, k)
    m = max(Count.values())
    for i in Count:
        if Count[i] == m:
            FrequentPatterns.append(Text[i:i+k])
    return remove_duplicates(FrequentPatterns)


def remove_duplicates(list):
    no_duplicates_list = []
    for item in list:
        if(item not in no_duplicates_list):
            no_duplicates_list.append(item)

    return no_duplicates_list


def ReverseComplement(dna):
    # Input: A string of DNA
    # Output: The reverse complementary string
    complementary_bases = {"A": "T", "T": "A", "C": "G", "G": "C"}
    complement = ""
    for base in dna:
        complement += complementary_bases[base]

    return complement[::-1]


def PatternMatching(Pattern, dna):
    # Input: A pattern and a string of DNA
    # Output: A list containing all the starting positions of the pattern in
    # the DNA string
    positions = []
    for i in range(len(dna)-len(Pattern)+1):
        if dna[i:i+len(Pattern)] == Pattern:
            positions.append(i)
    return positions


def SymbolArray(Genome, symbol):
    # Input: A genome string and a nucleotide letter
    # Output: A symbol array in which each position has the count of
    # half the string for the symbol starting in the array position
    array = {}
    n = len(Genome)
    ExtendedGenome = Genome + Genome[0:n//2]
    for i in range(n):
        array[i] = PatternCount(symbol, ExtendedGenome[i:i+n//2])
    return array


def FasterSymbolArray(genome, symbol):
        # Input:  Strings Genome and symbol
        # Output: FasterSymbolArray(Genome, symbol)
        array = {}
        n = len(genome)
        extendedGenome = genome + genome[0:n//2]
        array[0] = PatternCount(symbol, extendedGenome[0:n//2])
        for i in range(1, n):
            array[i] = array[i - 1]
            if extendedGenome[i - 1] == symbol:
                array[i] = array[i] - 1
            if extendedGenome[i:i + n//2 - 1] == symbol:
                array[i] = array[i] + 1
        return array


def Skew(genome):
    skew_array = {0: 0}
    for idx, nitrogenous_base in enumerate(genome, 1):
        if(nitrogenous_base == "G"):
            skew_array[idx] = skew_array[idx-1] + 1
        elif(nitrogenous_base == "C"):
            skew_array[idx] = skew_array[idx-1] - 1
        else:
            skew_array[idx] = skew_array[idx-1]
    return skew_array


def MinimumSkew(genome):
    # Input:  A DNA string Genome
    # Output: A list containing all integers i minimizing Skew(Prefix_i(Text))
    # over all values of i (from 0 to |Genome|)
    skew_array = Skew(genome)
    minGC = min(skew_array.values())
    positions_minGC = []

    for position in range(1, len(genome)):
        if(skew_array[position] == minGC):
            positions_minGC.append(position)

    return positions_minGC


def HammingDistance(p, q):
    assert len(p) == len(q)
    hamming_number = 0
    for i in range(len(p)):
        if(p[i] != q[i]):
            hamming_number += 1
    return hamming_number


def ApproximatePatternMatching(pattern, genome, d):
    # Input:  Strings Pattern and Text along with an integer d
    # Output: A list containing all starting positions where Pattern appears
    # as a substring of Text with at most d mismatches
    positions = []
    for i in range(len(genome) - len(pattern) + 1):
        genome_window = genome[i: i + len(pattern)]
        if(HammingDistance(pattern, genome_window) <= d):
            positions.append(i)

    return positions


def ApproximatePatternCount(pattern, genome, d):
    # Input:  Strings Pattern and Text, and an integer d
    # Output: The number of times Pattern appears in Text with at most d
    # mismatches
    count = 0
    for i in range(len(genome)-len(pattern)+1):
        genome_window = genome[i: i + len(pattern)]
        if(HammingDistance(pattern, genome_window) <= d):
            count = count+1
    return count
