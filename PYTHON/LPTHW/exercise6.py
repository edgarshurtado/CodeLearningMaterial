#Creates a string with a format operator asigning
#to it the value 10 and all that is stored in 'x'
x = "There are %d types of people." % 10
#Creates the string 'binary' and stores it in the 
#variable binary
binary = "binary"
#Creates the string "don't" and stores it in the
#variabe do_not
do_not = "don't"
#Asigment statement. Creates a string with 2 format 
#operators. The values of both are gived together and
#for doing so the values have to be inside "()"
y = "Those who know %s and those who %s." % (binary, do_not)

#2 print statements
print x
print y

#print statement which uses %r for representing a string
#for this reason the string will be automatically be inside "''"
print "I said: %r." % x
#this lines tells that the argument will be a string, so initially
#the string isn't between "''". For this reason, to having the 
#introduced sentence between "''" the author adds them.
print "I also said: '%s'." % y

#Asigment statement
hilarious = False
#Asigment statement. A string with the generic format operator but
#without a value. 
joke_evaluation = "Isn't that joke so funny?! %r"

#print statement where a boolean is passed as value for the format
#operator of the string. Otherwise the print joke_evaluation would 
#print the format operator (aka %r)
print joke_evaluation % hilarious

#2 assigment statements of 2 strings
w = "This is the left side of..."
e = "a string with a right side."

#Print statement which concatenates the 2 previous
#strings.
print w + e
