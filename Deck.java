package src.gofish_assn;

import java.util.ArrayList;

import src.gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	//creates a new sorted deck
	public Deck() {
		
		for(int suits = 1; suits < 5; suits++) {
			
			char suit = 'c';
			if(suits == 2) {
				suits = 'd';
			}else if(suits == 3) {
				suits = 'h';
			}else {
				suits = 's';
			}
			
			for(int ranks = 1; ranks < 14; ranks++) {
				Card hold = new Card(ranks, suit);
				deck.add(hold);
			}
		}
		
	}
	
	public Deck(int r) { //for when you want an empty deck @shuffle
		
	}
	
	public void shuffle() {
		ArrayList<Card> deck2 = new ArrayList<Card>(0); /*if normal deck, remove 0. 
		but then you will have to remove all the cards that the deck is automatically filled with*/
		for(int transfer = 0; transfer < 52; transfer++) {
			int rand = (int)(Math.random()*(51-transfer));
			deck2.add(deck.get(rand));
			deck.remove(rand);
		}
		for(int transfer = 0; transfer < 52; transfer++) {
			deck.add(deck2.get(transfer));
		}
	}
	
	
	public void printDeck() {
		for(int count = 0; count < 52; count++) {
			deck.get(count).toString();
		}
	}
	
	
	public Card dealCard() { 
		
		 Card c = deck.get(0);
		 deck.remove(0);
		 return c;
		  
		 
		
	}
	

}
