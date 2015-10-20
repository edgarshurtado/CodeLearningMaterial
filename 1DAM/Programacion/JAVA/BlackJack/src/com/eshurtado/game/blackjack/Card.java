package com.eshurtado.game.blackjack;



public class Card {
	/** Controls the text that appears in the card**/
	private String rank;
	private int suit;
	private int value;
	
	public Card(String rank, int suit, int value){
		this.rank = rank;
		this.suit = suit;
		this.value = value;
	}
	
}
