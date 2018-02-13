package gofish_assn;



public class Main {
	
	public static void main(String args[]) {
		System.out.println("Hello World!");
		
		Card c = new Card(4, 'c');
		Card c2 = new Card(4,'d');
		Card c3 = new Card(5,'s');
		
		/*System.out.println();
		System.out.println(c.toString()+'\n');
			
		Deck d = new Deck();
		
		d.printDeck();
		System.out.println();
		
		d.shuffle();
		
		System.out.println();
		d.printDeck();

		
		c = d.dealCard();
		System.out.println(c.toString());*/
		GoFishGame game = new GoFishGame();
		System.out.println(game.p1.getName());
		System.out.println(game.p1.handToString());
		System.out.println(game.p1.bookToString());
		System.out.println(game.p2.getName());
		System.out.println(game.p2.handToString());
		System.out.println(game.p2.bookToString());
		game.playGame();
		game.mainDeck.printDeck();
		
	}

}
