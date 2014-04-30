import java.util.ArrayList;
/**
 * Blake Colyer
 * CS 110
 * CardPile 
 */
public class CardPile implements CardPileInterface{
	//fields
	private final int CARDS_IN_DECK = 52;
	private Card topCard;
	private int bottomCard;
	
	private ArrayList<Card> cPile;
	
	/**
	 * CardPile constructor 
	 */
	public CardPile() {
		
		cPile = new ArrayList<Card>();
	
	}
	

	/**
	 * addCardBottom adds a card to the bottom of a pile
	 * @param c1 
	 */
	public void addCardBottom(Card c1){
		cPile.add(c1);

	}
	/**
	 * getTopCard removes the top card
	 * @return topCard
	 */
	public Card getTopCard(){
		topCard = cPile.remove(0);
		return topCard;
		
	}
	
	/**
	 * toString method returns description of pile
	 */
	public String toString(){
		String str = cPile.toString();
		return str;
			
	}
	
	/**
	 * returns the size of the pile
	 */
	public int getSize(){
		return cPile.size();
	}
	
	/**
	 * flipCard removes the top card
	 * @return the top card
	 */
	public Card flipCard(){
		return cPile.remove(0);
	}
	


}
