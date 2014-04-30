import javax.swing.ImageIcon;
/**
 * Blake Colyer
 * CS 110
 * Creation of a Card
 * a card is made up of its suit and rank values
 */

 

public class Card implements CardInterface{
	//constants
	//SUITS
	public final static int CLUBS = 0;
	public final static int DIAMONDS = 1;
	public final static int HEARTS = 2;
	public final static int SPADES = 3;
	//RANKS
	public final static int ACE = 1;
	public final static int KING = 13;
	public final static int QUEEN = 12;
	public final static int JACK = 11;
	//fields
	private int suit; //clubs, diamons, hearts or spades
	private int rank; //1-13
   private ImageIcon pic;
   
		//Strings to hold the picture
		String rankString = null;
		String suitString = null;
     
	
	/**
	 * Card constructor creates a card
	 * and gets the images of the card
	 * @param s The suit of the card
	 * @param r The rank of the card
	 */

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
		
      
		//get rank as string
		if(rank > 1 && rank < 11)
			rankString = rank + "";
		else if(rank == 1)
			rankString = "ace";
		else if (rank == 11)
			rankString = "jack";
		else if(rank == 12)
			rankString = "queen";
		else if(rank == 13)
			rankString = "king";
		//get suit as string
		if(suit == 0)
			suitString = "c";
		else if(suit == 1)
			suitString = "d";
		else if(suit == 2)
			suitString = "h";
		else if(suit == 3)
			suitString = "s";
         
		String picName = (rankString + suitString + ".jpg");
		pic = new ImageIcon(picName);
     // pic = new ImageIcon("acec.jpg");
	}
	
	/**
	 * copy constructor
	 */
	public Card(Card obj2) {
		rank = obj2.rank;
		suit = obj2.suit;
			
	}
	
	/**
	 * getSuit returns the suit of the card
	 * @return suit
	 */
	public int getSuit(){
		return suit;
	}
	
	/**
	 * getRank returns the rank of the card
	 * @return rank
	 */
	public int getRank(){
		return rank;
	}
   
   /**
   * getPic returns the picture of the card
   */
   public ImageIcon getPic(){
      return new ImageIcon(rankString + suitString + ".jpg");
   }
   /**
   * Returns a description of the suit of this card.
   * @return the suit value of the card as a string.
   */
    public String getSuitAsString() {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
        switch ( suit ) {
           case SPADES:  
               return "Spades";
           case HEARTS:   
               return "Hearts";
           case DIAMONDS: 
               return "Diamonds";
           case CLUBS:   
                return "Clubs";
           default:       
               return "Invalid";
        }
    }
/**
   * Returns a description of the rank of this card.
   * @return the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
        switch (rank) {
           case 1:   
               return "Ace";
           case 2:  
                return "2";
           case 3:  
                return "3";
           case 4:  
                return "4";
           case 5:
               return "5";
           case 6:  
                return "6";
           case 7:   
                return "7";
           case 8:  
                return "8";
           case 9:   
               return "9";
           case 10: 
                return "10";
           case 11:
                 return "Jack";
           case 12: 
                return "Queen";
           case 13:  
               return "King";
           default: 
                return "INVALID";
        }
    }
	 /**
   * Returns a description of this card.
   * @return the name of the card.
   */

    public String toString() 
    {
        return getRankAsString() + " of " + getSuitAsString();
    }
	  /**
	   * Compares two cards to determine if they have the same value.
	   * @param card Card obj2
	   * @return true if the two cards have the same rank and suitvalues,
	   * falseotherwise.
	   */
	   public boolean equals(Card obj2 ) 
	   {
	      if ( ( rank != obj2.rank ) || ( suit != obj2.suit ) )
	         return false;
	      else
	         return true;
	   }
	   
	   public int comparePlay(Card obj2){
		   //if rank of obj1 is smallest return -1  
		   if((rank == 0) && (obj2.rank != 0))
		   		return -1;
		   //if rank is largest retrun 1
		   else if((obj2.rank == 0) && rank != 0)
		   		return 1;
		   else if (rank > obj2.rank)
			   return 1;
		   else if(obj2.rank > rank)
			   return -1;
		   else 
			   return 0;
	   }
      
      public static void main(String [] args){
         Card c = new Card(5,3);
         System.out.println(c.getPic());
      }
	
	

}
