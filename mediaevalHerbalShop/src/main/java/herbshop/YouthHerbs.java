package herbshop;

import java.io.*;
import java.util.*;

public class YouthHerbs extends JsonManager implements Infusible, Comparable {
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

    public YouthHerbs() {
        herbs = readHerbsFromJson("fluHerbs.json");
    }

    public void addHerb(Herb h) {
        herbs.add(h);
    }

    public int infuseHerb(int indices[]) throws HerbNotFoundException, InsufficientQuantityException {
        int ml = 0;
        System.out.println("Boil, boil\n Stir, stir\n");
        System.out.println("By lighte of mone and sunne’s rise,\n" + 
                        "Keepeth yonge in gentil guise.\n" + 
                        "Fro wrinkled age, the visage shield,\n" + 
                        "As faire and fresh as blossomed field.\n");
                        for (int index : indices) {
                            if (index < 0 || index >= herbs.size()) {
                                throw new HerbNotFoundException("Herb with index " + index + " not found.");
                            }
                            Herb herb = herbs.get(index);
                            if (herb.quantity <= 0) {
                                throw new InsufficientQuantityException("Not enough quantity of " + herb.name + " to grind.");
                            }
                            herb.quantity--;
                            ml += 10;
                        }
        return ml;
    }

    public Potion makePotion(int indices[]) throws HerbNotFoundException, InsufficientQuantityException {
        Potion potion = new Potion(infuseHerb(indices));
        int coinPrice = 0, chickenPrice = 0, winePrice = 0;
        for (int i=0; i<indices.length; i++) {
            if (i < 0 || i >= herbs.size()) {
                throw new HerbNotFoundException("Herb with index " + i + " not found.");
            }
            potion.addIngredient(this.herbs.get(indices[i]));
            coinPrice += this.herbs.get(i).coinPrice;
            chickenPrice += this.herbs.get(i).chickenPrice;
            winePrice += this.herbs.get(i).winePrice;
        }
        potion.chickenPrice = chickenPrice;
        potion.coinPrice = coinPrice;
        potion.winePrice = winePrice;
        return potion;
    }

    public void printHerbs() {
        System.out.println("\nI see, you are looking to preserve your beauty. Here's what you need: \n");
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
