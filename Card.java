package src.gofish_assn;

public class Card {
	
	public enum Suits {club, diamond, heart, spade};
	
	static int TOP_RANK = 13; //King
	static int LOW_RANK = 1; //Ace
	
	int rank;  //1 is an Ace
	Suits suit;
	
	public Card() {
		rank = 1;
		suit = Suits.spade;
	}
	
	public Card(int r, char s) {
		/**
		 * @author Ryan McCray
		 * @param r This integer is the rank
		 * @param s This char is the first character of the Suit
		 * @return None, this only sets suit to a Suit
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
		rank = r;
		suit = s;
	}
	
	private Suits toSuit(char c) {
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
		if(r == 13) {
			return "K";
		}else if(r == 12) {
			return "Q";
		}else if(r == 11) {
			return "J";
		}else if(r == 1) {
			return "A";
		}else if(r == 10) {  // is there an easier way to convert ints to strings? there HAS to be
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
		return rank;
	}
	
	public Suits getSuit() {
		return suit;
	}
	
	public String toString() {
		String s = "";
		
		s = s + rankToString(getRank()) + suitToString(getSuit());
		
		return s;
	}
}
