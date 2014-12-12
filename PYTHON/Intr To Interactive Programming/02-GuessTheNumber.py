#MINIPROJECT2
#GAME GUESS THE NUMBER

import simplegui
import random


    

# helper function to start and restart the game
def new_game(range):
    # initialize global variables used in your code here
    global secret_number
    global number_guesses  #How many times user tried
    print "New game in range 0 -", range
    print ""
    number_guesses = 0
    secret_number=random.randrange(0, range)


# define event handlers for control panel
def range100():
    # button that changes the range to [0,100) and starts a new game 
    global max_guesses
    global game_range
    game_range = 100
    new_game(game_range)
    max_guesses = 7

def range1000():
    # button that changes the range to [0,1000) and starts a new game     
    global max_guesses
    global game_range
    
    game_range = 1000
    new_game(game_range)
    max_guesses = 10
   
    
def input_guess(guess):
    guess = int(guess)
    print ""
    print "The guess was: ", guess
    # main game logic goes here
    global number_guesses
    
    number_guesses +=1  
    
    if number_guesses == max_guesses:
        print "You Lose!"
        print ""
        new_game(game_range)
    else:
        if guess < secret_number:
            print "Higher!"
            
            print "Remaining ", max_guesses-number_guesses
        elif guess > secret_number:
            print "Lower!"
            
            print "Remaining ", max_guesses-number_guesses
        else:
            print "Correct!"
            new_game(game_range)

    
# create frame
frame = simplegui.create_frame("Frame", 200, 200)

button100 = frame.add_button("0-100", range100, 70)

button100 = frame.add_button("0-1000", range1000, 70)

inp= frame.add_input("My guess", input_guess, 50)



# register event handlers for control elements and start frame


# call new_game 
new_game(100)


# always remember to check your completed program against the grading rubric

