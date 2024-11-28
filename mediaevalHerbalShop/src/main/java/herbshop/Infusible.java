package herbshop;

/**
 * Infusible
 */
public interface Infusible {
    public int infuseHerb(int indices[]) throws HerbNotFoundException, InsufficientQuantityException;
    public Potion makePotion(int indices[]) throws HerbNotFoundException, InsufficientQuantityException;
}
