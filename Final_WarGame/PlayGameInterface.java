/**
 * CardInterface
 * @author blakecolyer
 */
public interface PlayGameInterface {
	void createHands();
	void flip();
	int cardsRemainingPlayer1();
	int cardsRemainingPlayer2();
	boolean gameOver();
   Card getCardP1();
   Card getCardP2();
	int determineWinner();

}
