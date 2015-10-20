def harmonic(x, y):
    """Return the harmonic mean of x and y.

    >>> harmonic(2, 6)
    3.0
    >>> harmonic(1, 1)
    1.0
    >>> harmonic(2.5, 7.5)
    3.75


    """
    return 2/(1/x + 1/y)

from math import pi

def pi_fraction(gap):
    """Print the fraction within gap of pi that has the smallest denominator.

    >>> pi_fraction(0.01)
    22 / 7 = 3.142857142857143
    >>> pi_fraction(1)
    3 / 1 = 3.0
    >>> pi_fraction(1/8)
    13 / 4 = 3.25
    >>> pi_fraction(1e-6)
    355 / 113 = 3.1415929203539825


    """
    def in_gap(fraction):
        return fraction < pi + gap and fraction > pi - gap
    
    numerator, denominator = 3, 1
    fraction = numerator / denominator

    while not in_gap(fraction):
        numerator += 1
        fraction = numerator / denominator
        if fraction > pi + gap:
            denominator += 1
            numerator = denominator * 3
    print(numerator, '/', denominator, '=', fraction)

def nearest_two(x):
    """Return the power of two that is nearest to x.

    >>> nearest_two(8)    # 2 * 2 * 2 is 8
    8.0
    >>> nearest_two(11.5) # 11.5 is closer to 8 than 16
    8.0
    >>> nearest_two(14)   # 14 is closer to 16 than 8
    16.0
    >>> nearest_two(2015)
    2048.0
    >>> nearest_two(.1)
    0.125
    >>> nearest_two(0.75) # Tie between 1/2 and 1
    1.0
    >>> nearest_two(1.5)  # Tie between 1 and 2
    2.0


    """
    def positive_pow_two(x):
        power_of_two, lower_power_of_two = 1.0, 1.0
        while power_of_two < x:
            power_of_two *= 2
            if power_of_two < x:
                lower_power_of_two = power_of_two
        if power_of_two - x <= x -lower_power_of_two:
            return power_of_two
        else:
            return lower_power_of_two

    def negative_pow_two(x):
        power_of_two, lower_power_of_two = 1.0, 1.0
        while power_of_two > x:
            power_of_two *= 1/2
            if power_of_two > x:
                lower_power_of_two = power_of_two
        if x - power_of_two <= x - lower_power_of_two:
            return power_of_two
        else:
            return lower_power_of_two
    
    if x >= 1:
        return positive_pow_two(x)
    else:
        return negative_pow_two(x   )
        
