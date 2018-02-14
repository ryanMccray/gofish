package gofish_assn;
import java.io.*;

public class GoFishGame {
	/**
	 * @param mainDeck Deck holding the deck of the game, cards not yet used by either Player.
	 * @param p1 First Player to be interacting with mainDeck.
	 * @param p2 Second Player to be interacting with mainDeck.
	 */
	Deck mainDeck = new Deck();
	Player p1 = new Player("p1");
	Player p2 = new Player("p2");
	
	public GoFishGame() {
		/**
		 * *****************************************************************************
		 */
		mainDeck.shuffle();
		for(int i = 0; i<7;i++) {
			p1.addCardToHand(mainDeck.dealCard());
			p2.addCardToHand(mainDeck.dealCard());
		}
		while(p1.checkHandForBook()) {
			
		}
		while(p2.checkHandForBook()) {
			
		}
		//playGame(); use if they only call our constructor
	}
	public void playGame() {
		/**
		 * @param output File object to store game results in GoFish_Results.txt
		 * @param toFile PrintWriter object to fill output with game results
		 * @param pairs Int holding number of pairs between the two Players
		 * @return None, this is a void method that fills a text file.
		 */
		try {
			File output = new File("GoFish_Results.txt");
			PrintWriter toFile = new PrintWriter(output);
			//PUT CODE IN HERE
			int i = 0;
			int pairs = (p1.getBookSize()/2)+(p2.getBookSize()/2);
			while(pairs<26) {
				if(i==0) {
					toFile.println(this.p1Turn());
					if(p1.checkHandForBook()) {
						i = 0;
						pairs++;
					}
					else {
						i = (i+1)%2;
					}
				}
				if(i==1) {
					toFile.println(this.p2Turn());
					if(p2.checkHandForBook()) {
						i = 1;
						pairs++;
						}
					else {
						i = (i+1)%2;
						}
				}
			}
			toFile.println(this.printResults());
			toFile.close();
		}
		catch (FileNotFoundException oops) {
			System.out.println("Sorry: " + oops);
		}
	}
	public String p1Turn() {
		/**
		 * @param s String to hold what conversation from this Player's turn.
		 * @param checker Card chosen from hand to ask if opponent has ******************english hard
		 * @return String with conversation of this Player's turn.
		 */
		String s = "";
		if(p1.getHandSize()==0) {
			s+= p1.getName()+" has no cards."+ '\n'+ this.draw(p1);
		}
		else {
			Card checker = p1.chooseCardFromHand();
			s+= p1.getName()+" asks: Do you have a "+checker.getRankToString()+'\n'+p2.getName()+" says: ";
			if(p2.rankInHand(checker)) {
				s+="Yes, I do have a "+ checker.getRankToString()+'\n';
				p1.addCardToHand(p2.removeCardFromHand(checker));
				s+=p1.getName()+" books the "+ checker.getRankToString()+'\n';
			}
			else {
				s+="Go Fish!";
				s+= this.draw(p1);
			}
		}
		return s;
	}
	public String p2Turn() {
		/**
		 * @param s String to hold what conversation from this Player's turn.
		 * @param checker Card chosen from hand to ask if opponent has ******************english hard
		 * @return String with conversation of this Player's turn.
		 */
		String s = "";
		if(p2.getHandSize()==0) {
			s+= p2.getName()+" has no cards."+ '\n'+ this.draw(p2);
		}
		else {
			Card checker = p2.chooseCardFromHand();
			s+= p2.getName()+" asks: Do you have a "+checker.getRankToString()+'\n'+p1.getName()+" says: ";
			if(p1.rankInHand(checker)) {
				s+="Yes, I do have a "+ checker.getRankToString()+'\n';
				p2.addCardToHand(p1.removeCardFromHand(checker));
				s+=p2.getName()+" books the "+ checker.getRankToString()+'\n';
			}
			else {
				s+="Go Fish!";
				s+= this.draw(p2);
			}
		}
		return s;
	}
	
	public String draw(Player p) {
		/**
		 * @param s String to hold information of which card Player drew.
		 * @param nxt Card picked from top of mainDeck
		 * @return String holding information of which card Player drew.
		 */
		String s = "";
		Card nxt = mainDeck.dealCard();
		p.addCardToHand(nxt);
		s+= p1.getName()+" draws "+nxt.toString()+'\n';
		return s;
	}
	
	public String printResults() {
		/**
		 * @param s String to hold final information of the game
		 * @param p1Book Int of how many cards are in p1's book.
		 * @param p2Book Int of how many cards are in p2's book.
		 * @return String holding winner status, and info of each Player's books. 
		 */
		String s = "";
		int p1Book = p1.getBookSize();
		int p2Book = p2.getBookSize();
		String winner = "";
		if(p1Book>p2Book) {
			winner = p1.getName();
			s+= p1.getName()+" won with "+(p1.getBookSize()/2)+" pairs."+ '\n';
			s+= p1.bookToString();
			s+= p2.getName()+" had "+(p2.getBookSize()/2)+" pairs."+ '\n';
			s+= p2.bookToString();
		}
		if(p2Book>p1Book) {
			s+= p2.getName()+" won with "+(p2.getBookSize()/2)+" pairs."+ '\n';
			s+= p2.bookToString();
			s+= p1.getName()+" had "+(p1.getBookSize()/2)+" pairs."+ '\n';
			s+= p1.bookToString();
		}
		else {
			s+= "No one one!\n";
			s+= p1.getName()+" had "+(p1.getBookSize()/2)+" pairs."+ '\n';
			s+= p1.bookToString();
			s+= p2.getName()+" had "+(p2.getBookSize()/2)+" pairs."+ '\n';
			s+= p2.bookToString();
		}
		return s;
	}

}
