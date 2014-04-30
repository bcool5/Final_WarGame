import java.util.Random;
import java.util.ArrayList;
/**
 * Blake Colyer
 * CS 110
 * Deck class creates a deck of 52 cards
 *
 */
public class Deck implements DeckInterface{
	final int CARDS_IN_DECK = 52;
	private ArrayList<Card> deck;
	int count;
	
	/**
	 * Deck construcotr creates a new deck
	 */
	public Deck() {
	
		newDeck();
	}
	
	/**
	 * newDeck method puts the 52 cards into an array
	 */
	public void newDeck(){
		deck = new ArrayList<Card>();
		for(int r = Card.ACE; r <= Card.KING; r++){
			for(int s = Card.CLUBS; s<=Card.SPADES; s++){
				deck.add(new Card(r,s));
			}
		}
	}
	 public Card dealCard(){
		Card c = deck.remove(0);
		return c;
	   }
	
	   public int cardsRemaining(){  
	      return deck.size();
	   }
	/**
	 * shuffle the cards
	 */
	public void shuffle(){
		int rNum;
		Card temp;
		Random r = new Random();
		for(int i = 0; i< deck.size(); i++){
			rNum = r.nextInt(deck.size());
			temp = deck.get(i);
			deck.set(i, deck.get(rNum));
			deck.set(rNum, temp);
			
		}
	}
	 public boolean isEmpty(){
		 return (deck.size() == 0);
	   }
      
  
	public static void main(String [] args){
		Deck deck = new Deck();
		deck.shuffle();
		int i = 0;
//      while (deck.cardsRemaining() > 0)
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());
     
//      


	}
	

}
