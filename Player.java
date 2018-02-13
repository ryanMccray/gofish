package gofish_assn;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> book = new ArrayList<Card>();
	private int[] opponentChoice = new int[13];
	private String name;
	
	public Player(String name) {
		this.name = name;
		for(int i = 0; i<opponentChoice.length;i++) {
			opponentChoice[i]=0;
		}
	}
	
	public void addCardToHand(Card c) {
		this.hand.add(c);
	}
	
	public Card removeCardFromHand(Card c) {
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
		return name;
	}
	
	public String handToString() {
		String s = new String();
		for(int i = 0; i < this.hand.size(); i++) {
			s += this.hand.get(i).toString();
			s += '\n';
		}
		return s;
	}
	
	public String bookToString() {
		String s = new String();
		for(int i = 0; i < this.book.size(); i+=2) {
			s += (this.book.get(i).toString()+ " " + this.book.get(i+1).toString());
			s += '\n';
		}
		return s;
	}
	
	public int getHandSize() {
		return this.hand.size();
	}
	
	
	public int getBookSize() {
		return this.book.size();
	}
	
	
	//Here are som ideas for additional functionality that you may want/need
	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true

    public boolean checkHandForBook() {
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
    	for(int i=0; i <this.hand.size();i++) {
    		if(this.hand.get(i).getRank() == c.getRank()) {
    			return true;
    		}
    	}
    	return false; //stubbed
    }
    public void addOppChoic(int rank) {
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
