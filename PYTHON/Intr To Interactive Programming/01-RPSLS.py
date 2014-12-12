#MINIPROJECT 1
#GAME VERSION OF ROCK-PAPER-SCISSORS-LIZARD-SPOCK


#import library for generete random numbers
import random

# Rock-paper-scissors-lizard-Spock template


# The key idea of this program is to equate the strings
# "rock", "paper", "scissors", "lizard", "Spock" to numbers
# as follows:
#
# 0 - rock
# 1 - Spock
# 2 - paper
# 3 - lizard
# 4 - scissors

# helper functions

def name_to_number(name):
    if name == "rock":
        return 0
    elif name == "Spock":
        return 1
    elif name == "paper":
        return 2
    elif name == "lizard":
        return 3
    elif name == "scissors":
        return 4
    else:
        print "Incorrect Choice"


def number_to_name(number):
    if number == 0:
        return "rock"
    elif number == 1:
        return "Spock"
    elif number == 2:
        return "paper"
    elif number == 3:
        return "lizard"
    elif number == 4:
        return "scissors"
    else:
        print "Incorrect choice"
   
#Main function that computes the choices

def rpsls(player_choice): 
    #Blank line to separate consecutive games
    print "" 
   
    print "The player chooses ", player_choice
    
    #Convert the player's choice into a number
    player_choice_num = name_to_number(player_choice)
  
    #generates the choice of the computer
    comp_number = random.randrange(5)

    # convert comp_number to comp_choice using the function number_to_name() and prints it
    #in the terminal
    comp_choice = number_to_name(comp_number)
    print "Computer chooses ", comp_choice
    
    
    # compute difference of comp_number and player_number modulo five

    difference= (player_choice_num - comp_number)%5
    
    # use if/elif/else to determine winner, print winner message
    if difference == 0:
        print "Player and computer tie!"
    elif difference <= 2:
        print "Player wins!"
    elif difference >=3:
        print "Computer wins!"
    else:
        print "Something went wrong"
    
# test your code - THESE CALLS MUST BE PRESENT IN YOUR SUBMITTED CODE
rpsls("rock")
rpsls("Spock")
rpsls("paper")
rpsls("lizard")
rpsls("scissors")

# always remember to check your completed program against the grading rubric



