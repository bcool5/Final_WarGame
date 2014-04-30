/**
 * DeckInterface
 * @author blakecolyer
 */
public interface DeckInterface {
	Card dealCard();
	int cardsRemaining();
	void shuffle();
	boolean isEmpty();
}
