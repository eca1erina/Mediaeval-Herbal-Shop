package herbshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlagueHerbs extends JsonManager implements Grindable, Comparable {
    List <Herb> herbs = new ArrayList<Herb>();

    public boolean compareByPrice(Herb h1, Herb h2) {
        if (h1.coinPrice < h2.coinPrice) return true;
        else return false;
    }

    public boolean comopareByEfficiency(Herb h1, Herb h2) {
        if (h1.efficiencyRate > h2.efficiencyRate) return true;
        else return false;
    }

    public void sortByPrice() {
        for (int i=0; i<herbs.size()-1; i++) {
            for (int j=i+1; j<herbs.size(); j++) {
                if (!compareByPrice(herbs.get(i), herbs.get(j))) {
                    Collections.swap(herbs, i, j);
                }
            }
        }
    }

    public void sortByEfficiency() {
        for (int i=0; i<herbs.size()-1; i++) {
            for (int j=i+1; j<herbs.size(); j++) {
                if (!comopareByEfficiency(herbs.get(i), herbs.get(j))) {
                    Collections.swap(herbs, i, j);
                }
            }
        }
    }

    public void groupByBestValue() {
        for (int i=0; i<herbs.size(); i++) {
            if (herbs.get(i).coinPrice <= 3 && herbs.get(i).efficiencyRate>=60) {
                herbs.get(i).getName();
            }
        }
    }

    public PlagueHerbs() {
        herbs = readHerbsFromJson("fluHerbs.json");
    }

    public void addHerb(Herb h) {
        herbs.add(h);
    }

    public int grindPieces(int indices[]) throws HerbNotFoundException, InsufficientQuantityException {
        int grams = 0;
        System.out.println("Grind, grind\n Crush, crush\n");
        System.out.println("Waters cleere, by moon and sun,\n" + //
                        "Cleanse this flesh ‘til harm be done.\n" + //
                        "Flowe ye swift, take plague awaye,\n" + //
                        "And leaveth health where illness lay.\n");
                        for (int index : indices) {
                            if (index < 0 || index >= herbs.size()) {
                                throw new HerbNotFoundException("Herb with index " + index + " not found.");
                            }
                            Herb herb = herbs.get(index);
                            if (herb.quantity <= 0) {
                                throw new InsufficientQuantityException("Not enough quantity of " + herb.name + " to grind.");
                            }
                            herb.quantity--;
                            grams += 5;
                        }
                        return grams;
    }

    public Pills makePills(int indices[]) throws HerbNotFoundException, InsufficientQuantityException {
        Pills pills = new Pills(grindPieces(indices));
        int coinPrice = 0, chickenPrice = 0, winePrice = 0;
        for (int i=0; i<indices.length; i++) {
            if (i < 0 || i >= herbs.size()) {
                throw new HerbNotFoundException("Herb with index " + i + " not found.");
            }
            pills.addIngredient(this.herbs.get(indices[i]));
            coinPrice += this.herbs.get(i).coinPrice;
            chickenPrice += this.herbs.get(i).chickenPrice;
            winePrice += this.herbs.get(i).winePrice;
        }

        pills.chickenPrice = chickenPrice;
        pills.coinPrice = coinPrice;
        pills.winePrice = winePrice;
        return pills;
    }

    public void printHerbs() {
        System.out.println("\n Oh, no! These herbs should help you:\n");
        for (int i=0; i<herbs.size(); i++) {
            System.out.println(i);
            herbs.get(i).printName();
            herbs.get(i).printCountry();
            herbs.get(i).printProperties();
            herbs.get(i).printPrice();
            herbs.get(i).printEfficieny();
            System.out.println("\n");
        }
    }
}
