/**
 * CardInterface
 * @author blakecolyer
 */
public interface CardInterface {
	int getSuit();
	int getRank();
	boolean equals (Card obj2);
	int comparePlay(Card obj2);
}
