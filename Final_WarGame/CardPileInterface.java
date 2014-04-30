/**
 * CardPileInterface
 * @author blakecolyer
 */
public interface CardPileInterface {
	void addCardBottom(Card c1);
	Card getTopCard();
	String toString();
	int getSize();
	Card flipCard();
}

