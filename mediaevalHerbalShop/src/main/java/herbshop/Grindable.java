package herbshop;

/**
 * Grindable
 */
public interface Grindable {
    public int grindPieces(int i[]) throws InsufficientQuantityException, HerbNotFoundException;
    public Pills makePills(int i[]) throws InsufficientQuantityException, HerbNotFoundException;
}
