import java.util.ArrayList;
/*
 * Blake Colyer
 * CS 110
 * PlayGame class creates 2 random piles of 26 cards
 * Determines the winner of each round/flip as well as entire game
 * DRIVER AT BOTTOM OF PAGE to test 1 round of the game
 */
public class PlayGame implements PlayGameInterface{
	private Deck warDeck = new Deck();
	private CardPile p1 = new CardPile();
	private CardPile p2 = new CardPile();
	private Card pp1;
	private Card pp2;
	private boolean status;
   private int i;
   
	
	
	/**
	 * PlayGame constructor creates a deck and shuffles it
	 * @param d2
	 */
	public PlayGame(Deck d2) {
		warDeck = d2;
		warDeck.shuffle();
		
	}
	
	/**
	 * createHands creates the 2 seperate/random player hands
	 */
	public void createHands(){
		//Creates the two players seperate decks of 28 cards each
		for(int i=0; i< warDeck.cardsRemaining(); i+=2){
			p1.addCardBottom(warDeck.dealCard());
		}
		for(int i=0; i< warDeck.cardsRemaining(); i+=2){
			p2.addCardBottom(warDeck.dealCard());
		}
	}
	/**
	 * flip method determines the winner of each round
	 * 
	 */
	
	public void flip(){
		//pp1 = new Card(p1.flipCard());
		pp1 = p1.flipCard();
     // pp2 = new Card(p2.flipCard());
     pp2 = p2.flipCard();
      System.out.println("Player 1 value");
		System.out.println(pp1.getRank());
      System.out.println("Player 2 value");
      
		System.out.println(pp2.getRank());
		
      }
     public int getRoundWinner(){
     int i = 0;
		//p1 higher card thank p2
		if(pp1.getRank() > pp2.getRank()){
			 i = 1;
			 p1.addCardBottom(pp1);
			 p1.addCardBottom(pp2);
			 
			 System.out.println("p1");
					
		}
		//p2 higher card than p1
		else if(pp1.getRank() < pp2.getRank()){
			 i = 2;
			 p2.addCardBottom(pp2);
			 p2.addCardBottom(pp1); 
			 System.out.println("p2");
				
		}
		
		//war, p1 and p2 have cards with the same rank
		else if(pp1.getRank() == pp2.getRank()){
			i = 0;
			
			Card ppp1 = new Card(p1.flipCard());
			Card ppp2 = new Card(p2.flipCard());
		
		
			if(pp1.getRank() > pp2.getRank()){
				i = 1;
				p1.addCardBottom(pp1);
				p1.addCardBottom(pp2);
				p1.addCardBottom(ppp1);
				p1.addCardBottom(ppp2);
			}
			else if(pp1.getRank() < pp2.getRank()){
				i = 2;
				p2.addCardBottom(ppp2);
				p2.addCardBottom(ppp1);
				p2.addCardBottom(pp1);
				p2.addCardBottom(pp2);
			}
			else if (pp1.getRank() == pp2.getRank()){
				 i = 0;
			}
         
        
				
      }
      return i;
	}
   
   //returns card type for each user
   public Card getCardP1(){
      return pp1;
   }
   
   public Card getCardP2(){
      return pp2;
    }
	/**
	 * cardsRemainingPlayer1
	 * @return size of player1 hands
	 */
	  public int cardsRemainingPlayer1(){  
	      return p1.getSize();
	   }
	  /**
		 * cardsRemainingPlayer2
		 * @return size of player2 hands
		 */
	  public int cardsRemainingPlayer2(){
		  return p2.getSize();
	  }
	  public boolean gameOver(){
		  if(p1.getSize() == 0 || p2.getSize() == 0)
			  status = true;
		  else 
			  status = false;
		  
		  return status;
	  }
	
		/**
		 * determineWinner determines who has the larger deck
		 * @return win The winner of the war game
		 */
		public int determineWinner(){
			int win;
			if(p1.getSize() > p2.getSize())
				win = 1;
			else if(p1.getSize() < p2.getSize())
				win = 2;
			else
				win = 0;
			
			return win;
		
	}
	
		public static void main (String [] args){
			Deck d1 = new Deck();
			d1.shuffle();
			
			PlayGame p1 = new PlayGame(d1);
			
			p1.createHands();
				p1.flip();
	
		}
	


}
