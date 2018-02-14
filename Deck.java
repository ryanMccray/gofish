package gofish_assn;

import java.util.ArrayList;
import gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	/**
	 * @param deck ArrayList of Cards.
	 * @param NUM_CARDS Final int holding starting number of Cards in deck.
	 *  
	 */
	private ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	//creates a new sorted deck
	public Deck() {
		/**
		 * @param suit Loop counter for suit of each card.
		 * @param ranks Loop counter for rank of each card.
		 * @return None, this is a default constructor.
		 */
		for(Card.Suits suit: Card.Suits.values()) {
			for(int ranks = 1; ranks < 14; ranks++) {
				Card hold = new Card(ranks,suit);
				deck.add(hold);
			}
		}
		
	}
	
	public Deck(int r) { //for when you want an empty deck @shuffle
		/**
		 * @return None, this is an assignment constructor for empty decks ONLY*************
		 */
		
	}
	
	public void shuffle() {
		/**
		 * @param deck2 Empty deck to place the random cards from deck into.
		 * @param transfer Loop counter to keep track of number of cards already copied.
		 * @param rand Int that is randomly set each loop to select card from deck.
		 * @return None, this is a void method that rearranges a deck.
		 */
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
		/**
		 * @return None, but outputs deck by printing each card's rank and suit.
		 */
		for(int count = 0; count < deck.size(); count++) {
			System.out.println(deck.get(count).toString());
		}
	}
	
	
	public Card dealCard() { 
		/**
		 * @param c Card that gets the first card in deck.
		 * @return Card that is "on top" of the deck, which is first in the ArrayList.
		 * 
		 */
		
		 Card c = deck.get(0);
		 deck.remove(0);
		 return c;
		  
		 
		
	}
	

}
