package gofish_assn;

import java.util.ArrayList;

public class Player {
	/**
	 * @param hand Deck that will store Cards that Player is holding.
	 * @param book Deck that will store matched cards of the Player.
	 * @param opponentChoice IntArray that holds ranks that the opponent has asked for.
	 * @param name String that holds Player's name.
	 * 
	 */
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> book = new ArrayList<Card>();
	private int[] opponentChoice = new int[13];
	private String name;
	
	public Player(String name) {
		/**
		 * @param name Holds given String containing name of Player.
		 * @return None, this is an assignment constructor.
		 */
		this.name = name;
		for(int i = 0; i<opponentChoice.length;i++) {
			opponentChoice[i]=0;
		}
	}
	
	public void addCardToHand(Card c) {
		/**
		 * @param c Card given to player, to be added to hand
		 * @return None, only adds Card c to hand.
		 */
		this.hand.add(c);
	}
	
	public Card removeCardFromHand(Card c) {
		/**
		 * @param c Card to be removed from hand. ************** if player has?
		 * @param retcard Card holder, used for scanning Deck hand for Card c, and returning it.
		 * @return Card that was removed from hand.
		 */
		int i = 0;
		Card retCard = this.hand.get(i);
		while(retCard.getRank()!=c.getRank() && i<this.hand.size()) {
			i++;
			retCard = this.hand.get(i);
		}
		this.hand.remove(i);
		return retCard;
	}
	
	public String getName() {
		/**
		 * @return String holding name of Player.
		 */
		return name;
	}
	
	public String handToString() {
		/**
		 * @param s String to hold ranks and suits of each Card in hand.
		 * @return String holding the ranks and suits of each Card in hand.
		 */
		String s = new String();
		for(int i = 0; i < this.hand.size(); i++) {
			s += this.hand.get(i).toString();
			s += '\n';
		}
		return s;
	}
	
	public String bookToString() {
		/**
		 * 
		 * @param s String to hold ranks and suits of each Card in book.
		 * @return String holding the ranks and suits of each Card in book.
		 */
		String s = new String();
		for(int i = 0; i < this.book.size(); i+=2) {
			s += (this.book.get(i).toString()+ " " + this.book.get(i+1).toString());
			s += '\n';
		}
		return s;
	}
	
	public int getHandSize() {
		/**
		 * @return Int of cards in hand.
		 * 
		 */
		return this.hand.size();
	}
	
	
	public int getBookSize() {
		/**
		 * @parma Int of cards in book.
		 */
		return this.book.size();
	}
	
	
	//Here are som ideas for additional functionality that you may want/need
	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true

    public boolean checkHandForBook() {
    	/**
    	 * @param cur Card holder to check for equivalent ranks.
    	 * @return Boolean, true if there are two cards that share the same rank. *****************
    	 */
    	if (this.hand.size()==1) {
    		return false;
    	}
    	for(int j = 0; j< this.hand.size()-1; j++) {
	    	Card cur = this.hand.get(j);
	    	for(int i = j+1; i< this.hand.size(); i++) {
	    		if(cur.getRank()==this.hand.get(i).getRank()) {
	    			this.book.add(cur);
	    			this.book.add(this.hand.get(i));
	    			this.hand.remove(j);
	    			this.hand.remove(i-1);
	    			return true;//stubbed
	    		}
	    	}
    	}
    	return false;
    }

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    public boolean rankInHand(Card c) {
    	/**
    	 * @param c Given Card whose rank we are looking for in Player's hand.
    	 * @return Boolean, true if Player has a Card with same rank as c.
    	 */
    	for(int i = 0; i < this.hand.size(); i++) {
    		if (this.hand.get(i).getRank()==c.getRank()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    //uses some strategy to choose one card from the player's
    //hand so they can say "Do you have a 4?"
    public Card chooseCardFromHand() {
    	/**
    	 * @param c Card holder of first card in hand.
    	 * @return Card, either one that the other Player has asked for the rank of, or just first one in hand.
    	 */
    	Card c = this.hand.get(0);
    	for(int i=0; i <this.hand.size();i++) {
    		for(int j =0; j<this.opponentChoice.length; j++) {
    			if(this.hand.get(i).getRank()==this.opponentChoice[j]) {
    				return this.hand.get(i);
    			}
    		}
    	}
    	return c;
    }
    
    //Does the player have the card c in her hand?
    public boolean cardInHand(Card c) {
    	/**
    	 * @param c Given Card whose rank we are seeing if we have. *************************
    	 * @return Boolean, true if Player has a Card with the same rank as c.
    	 */
    	for(int i=0; i <this.hand.size();i++) {
    		if(this.hand.get(i).getRank() == c.getRank()) {
    			return true;
    		}
    	}
    	return false; //stubbed
    }
    
    public void addOppChoic(int rank) {
    	/**
    	 * @param rank Given int of rank that other Player has asked for.
    	 * @return None, just adds rank to opponentChoice.
    	 */
    	int i = 0;
    	while (this.opponentChoice[i]!= 0 || this.opponentChoice[i]!= rank) {
    		i++;
    	}
    	this.opponentChoice[i] = rank;
    }

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    //e.g. will return true if the player has a 7d and the parameter is 7c
    
//    public boolean sameRankInHand(Card c) {
//    	return false; //stubbed
//    }

}
