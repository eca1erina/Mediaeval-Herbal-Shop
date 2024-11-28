package herbshop;
/**
 * Comparable
 */
public interface Comparable {
    public boolean compareByPrice(Herb h1, Herb h2);
    public boolean comopareByEfficiency(Herb h1, Herb h2);
    public void sortByPrice();
    public void sortByEfficiency();
    public void groupByBestValue();
}
