"""Required questions for lab 2"""

## Boolean Operators ##

# Q6
def both_positive(x, y):
    """
    Returns True if both x and y are positive.
    >>> both_positive(-1, 1)
    False
    >>> both_positive(1, 1)
    True
    """
    "*** YOUR CODE HERE ***"
    return x > 0 and y > 0

## while Loops ##

# Q9
def factors(n):
    """Prints out all of the numbers that divide `n` evenly.

    >>> factors(20)
    20
    10
    5
    4
    2
    1
    """
    for i in range(20, 0, -1):
        if n % i == 0:
            print(i)

# Q10
def fib(n):
    """Returns the nth Fibonacci number.

    >>> fib(0)
    0
    >>> fib(1)
    1
    >>> fib(2)
    1
    >>> fib(3)
    2
    >>> fib(4)
    3
    >>> fib(5)
    5
    >>> fib(6)
    8
    """
    result = 0
    i = 0
    while i <= n:
        if i == 0:
            result = 0
        elif i == 1 or i == 2:
            prev1, prev2, result = 1, 1, 1
        else:
            result = prev1 + prev2
            prev2 = prev1
            prev1 = result
        i += 1
    print(result)

