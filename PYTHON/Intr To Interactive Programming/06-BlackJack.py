# Mini-project #6 - Blackjack

import simplegui
import random

# load card sprite - 936x384 - source: jfitz.com
CARD_SIZE = (72, 96)
CARD_CENTER = (36, 48)
card_images = simplegui.load_image("http://storage.googleapis.com/codeskulptor-assets/cards_jfitz.png")

CARD_BACK_SIZE = (72, 96)
CARD_BACK_CENTER = (36, 48)
card_back = simplegui.load_image("http://storage.googleapis.com/codeskulptor-assets/card_jfitz_back.png")    

# initialize some useful global variables
in_play = False
outcome = ""
score = 0

# define globals for cards
SUITS = ('C', 'S', 'H', 'D')
RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}


# define card class
class Card:
    def __init__(self, suit, rank):
        if (suit in SUITS) and (rank in RANKS):
            self.suit = suit
            self.rank = rank
        else:
            self.suit = None
            self.rank = None
            print "Invalid card: ", suit, rank

    def __str__(self):
        return self.suit + self.rank

    def get_suit(self):
        return self.suit

    def get_rank(self):
        return self.rank

    def draw(self, canvas, pos):
        card_loc = (CARD_CENTER[0] + CARD_SIZE[0] * RANKS.index(self.rank), 
                    CARD_CENTER[1] + CARD_SIZE[1] * SUITS.index(self.suit))
        canvas.draw_image(card_images, card_loc, CARD_SIZE, [pos[0] + CARD_CENTER[0], pos[1] + CARD_CENTER[1]], CARD_SIZE)
        
# define hand class
class Hand:
    def __init__(self):
        self.hand_list=[]

    def __str__(self):
        handString =""
        for card in self.hand_list:
            handString += card.suit+card.rank + " "
        return handString
       
    def add_card(self, card):
        self.hand_list.append(card)

    def get_value(self):
        # count aces as 1, if the hand has an ace, then add 10 to hand value if it doesn't bust
        totalValue = 0
        asInHand = False
        for card in self.hand_list:
            if (VALUES[card.rank] == 1) and (totalValue + 11 < 21):
                card_value = 11
                asInHand = True
            else:
                card_value = VALUES[card.rank]
            if totalValue + card_value > 19 and asInHand == True:
                totalValue += card_value - 10
                asInHand = False
            else:
                totalValue += card_value          
        return totalValue # compute the value of the hand, see Blackjack video
   
    def draw(self, canvas, pos):
        pass	# draw a hand on the canvas, use the draw method for cards
     
# define deck class 
class Deck:
    def __init__(self):
        self.deck_list=[]
        for suit in SUITS:
            for rank in RANKS:
                card = Card(suit,rank)
                self.deck_list.append(card)

    def shuffle(self):
        # shuffle the deck 
        random.shuffle(self.deck_list)
        pass    # use random.shuffle()

    def deal_card(self):
        card = self.deck_list[0]
        return self.deck_list.pop(0)
    
    def __str__(self):
        deckString =""
        for card in self.deck_list:
            deckString += card.suit+card.rank + " "
        return deckString


#define event handlers for buttons
def deal():
    global outcome, in_play, deck, player_hand, dealer_hand, score, deal_resolved

    #check if deal have been clicked in the middle of a game
    if in_play:
        score -= 1
    
    #actions for a new deal
    outcome = "Hit or stand?"
    deal_resolved = False  	#Flag variable to know if the deal has been resolved
                            #avoids the score keep countig by pressing the stand button
                            #once the game is over
    deck= Deck()
    deck.shuffle()
    
    player_hand = Hand()
    player_hand.add_card(deck.deal_card())
    player_hand.add_card(deck.deal_card())
    
    dealer_hand = Hand()
    dealer_hand.add_card(deck.deal_card())
    dealer_hand.add_card(deck.deal_card())

    #show in the terminal cards and value of player's and dealer's hand
    print "Player hand:", player_hand, player_hand.get_value()
    print "Dealer hand:", dealer_hand, dealer_hand.get_value()
    
    #Flag to know that neither player nor dealer have busted
    in_play = True

def hit():
    global in_play, outcome
    
    # if the hand is in play, hit the player    
    if in_play:
        player_hand.add_card(deck.deal_card())
        
    #show in the terminal the current player's hand
    print player_hand
    
    # if busted, assign a message to outcome, update in_play and pass to stand()
    if player_hand.get_value() > 21 and in_play:
        print "You busted"
        in_play = False
        stand()
        
def stand():
    global in_play, outcome, score, deal_resolved
    
    #Game logic. If player or dealer busted
    if deal_resolved == False:
        if in_play == False:
            print "You've busted"
            outcome = "You've busted"
            score -= 1
            deal_resolved = True
        if in_play:    
            while dealer_hand.get_value() < 17:
                dealer_hand.add_card(deck.deal_card())
            if dealer_hand.get_value() > 21:
                print "The dealer busted"
                outcome = "The dealer busted"
                score += 1
                deal_resolved = True
                in_play = False
            
        print player_hand.get_value(), dealer_hand.get_value()
           
        #who wons?
        if in_play:
            if player_hand.get_value() > dealer_hand.get_value():
                print "Player wins"
                outcome= "Player wins"
                score += 1
            else:
                print "Dealer wins"
                outcome= "Dealer wins"
                score -= 1
            deal_resolved = True
            in_play = False
        
# draw handler    
def draw(canvas):
    #Game texts
    canvas.draw_text("BlackJack", [220,70],40,"Black")
    canvas.draw_text("Player's hand", [80,390],20,"black","monospace")
    canvas.draw_text("Dealer's hand", [400,140],20,"black","monospace")

    #Game info texts
    canvas.draw_text(outcome, [230,330], 35,"red")
    canvas.draw_text("Score: "+str(score),[50,150],30,"red")
    if not in_play:
        canvas.draw_text("New Deal?", [80,250], 35, "Yellow")
    
    #draw player hand
    draw_pos_player = [80,400] #initial position in the canvas where draw the player cards
    for card in player_hand.hand_list: #draws each card
        card.draw(canvas, draw_pos_player)
        draw_pos_player[0] += 70
    
    #draw dealer hand
    draw_dealer_pos = [500,200]#same as draw_pos_player but for dealer's hand
    if in_play:
        #one of the two dealer's card is not showed until the game ends
        canvas.draw_image(card_back,CARD_BACK_CENTER, CARD_BACK_SIZE,
                          draw_dealer_pos, CARD_BACK_SIZE)
        draw_dealer_pos[0] -= 70
        dealer_hand.hand_list[1].draw(canvas, draw_dealer_pos)
    else:
        for card in dealer_hand.hand_list:
            card.draw(canvas, draw_dealer_pos)
            draw_dealer_pos[0] -= 70
    

# initialization frame
frame = simplegui.create_frame("Blackjack", 600, 600)
frame.set_canvas_background("Green")

#create buttons and canvas callback
frame.add_button("Deal", deal, 200)
frame.add_button("Hit",  hit, 200)
frame.add_button("Stand", stand, 200)
frame.set_draw_handler(draw)


# get things rolling
deal()
frame.start()

