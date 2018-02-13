package gofish_assn;

import java.util.ArrayList;
import gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	//creates a new sorted deck
	public Deck() {
		for(Card.Suits suit: Card.Suits.values()) {
			for(int ranks = 1; ranks < 14; ranks++) {
				Card hold = new Card(ranks,suit);
				deck.add(hold);
			}
		}
		
	}
	
	public Deck(int r) { //for when you want an empty deck @shuffle
		
	}
	
	public void shuffle() {
		ArrayList<Card> deck2 = new ArrayList<Card>(0); /*if normal deck, remove 0. 
		but then you will have to remove all the cards that the deck is automatically filled with*/
		for(int transfer = 0; transfer < NUM_CARDS; transfer++) {
			int rand = (int)(Math.random()*(NUM_CARDS-transfer));
			deck2.add(deck.get(rand));
			deck.remove(rand);
		}
		for(int transfer = 0; transfer < NUM_CARDS; transfer++) {
			deck.add(deck2.get(transfer));
		}
	}
	
	
	public void printDeck() {
		for(int count = 0; count < deck.size(); count++) {
			System.out.println(deck.get(count).toString());
		}
	}
	
	
	public Card dealCard() { 
		
		 Card c = deck.get(0);
		 deck.remove(0);
		 return c;
		  
		 
		
	}
	

}
