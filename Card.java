package gofish_assn;

public class Card {
	/**
	 * @author rmm3989 
	 * @param TOP_RANK Int stores value of King, 13.
	 * @param LOW_RANK Int stores value of Ace, 1.
	 * @param rank Private int stores value of card.
	 * @param suit Private object Suit that stores suit of card.
	 *
	 */
	
	public enum Suits {club, diamond, heart, spade};
	
	final static int TOP_RANK = 13; //King
	final static int LOW_RANK = 1; //Ace
	
	private int rank;  //1 is an Ace
	private Suits suit;
	
	public Card() {
		/**
		 * @return None, this is the default constructor. Sets rank to 1 and suit to spade.
		 */
		rank = 1;
		suit = Suits.spade;
	}
	

	public Card(int r, char s) {
		/**
		 * @param r Int holding the given rank.
		 * @param s Char holding the given first letter of a suit.
		 * @return None, this is an assignment constructor *****************
		 * @see If s does not hold first letter of a suit, defaults to heart.
		 */
		rank = r;
		if(s == 's') {
			suit = Suits.spade;
		}else if(s == 'd') {
			suit = Suits.diamond;
		}else if(s == 'c') {
			suit = Suits.club;
		}else {
			suit = Suits.heart;
		}

	}
	
	public Card(int r, Suits s) {
		/**
		 * @param r Int holding the given rank.
		 * @param s Suits object holding the given suit.
		 * @return None, this is an assignment constructor *****************
		 */
		rank = r;
		suit = s;
	}
	
	private Suits toSuit(char c) {
		/**
		 * @param c Char holding given first letter of a suit.
		 * @return The Suits object corresponding to given char, if no match then defaults to heart.
		 */
		if(c == 's') {
			return Suits.spade;
		}else if(c == 'd') {
			return Suits.diamond;
		}else if(c == 'c') {
			return Suits.club;
		}else {
			return Suits.heart;
		}
	}
	
	private String suitToString(Suits s)
	{
		/**
		 * @param s Suits object holding a suit.
		 * @return String of the first letter of the given suit.
		 */
		
		if(s == Suits.diamond) {
			return "d";
		}else if(s == Suits.club) {
			return "c";
		}else if(s == Suits.spade) {
			return "s";
		}else {
			return "h";
		}
	}
	
	private String rankToString(int r)
	{
		/**
		 *@param r Int holding given rank.
		 *@return String of the corresponding card rank.
		 */
		if(r == 13) {
			return "K";
		}else if(r == 12) {
			return "Q";
		}else if(r == 11) {
			return "J";
		}else if(r == 1) {
			return "A";
		}else if(r == 10) {
			return "10";
		}else if(r == 9) {  
			return "9";
		}else if(r == 8) {  
			return "8";
		}else if(r == 7) {  
			return "7";
		}else if(r == 6) {  
			return "6";
		}else if(r == 5) { 
			return "5";
		}else if(r == 4) { 
			return "4";
		}else if(r == 3) {  
			return "3";
		}else{ 
			return "2";
		}
	}
		
	
	public int getRank() {
		/**
		 * @return Int rank of card.
		 */
		return rank;
	}
	public String getRankToString() {
		/**
		 * @return String containing card rank.
		 */
		return rankToString(getRank());
	}
	
	public Suits getSuit() {
		/**
		 * @return Suits object suit of card.
		 */
		return suit;
	}
	
	public String toString() {
		/**
		 * @param s String created to hold strings of rank and suit.
		 * @return String containing rank and suit of card.
		 */
		String s = "";
		
		s = s + rankToString(getRank()) + suitToString(getSuit());
		
		return s;
	}
}
