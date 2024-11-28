package herbshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Potion {
    List <String> names = new ArrayList<String>();
    List <Herb> ingredients = new ArrayList<Herb>();
    int quantity, coinPrice, chickenPrice, winePrice;

    public Potion(int quantity) {
        this.quantity = quantity;
    }

    public void addName() {
        names.add("Elixir of Everlasting Essence");
        names.add("Potion of Perpetual Peasanthood");
        names.add("Youthful Brew of Boundless Days");
        names.add("Vitality Vial of the Ancients");
        names.add("Brew of the Eternal Blossom");
        names.add("Mirthful Mead of the Ages");
        names.add("The Ageless Alchemist’s Ambrosia");
        names.add("Bard's Breath of Life Brew");
        names.add("Merry Maiden’s Miracle Mead");
        names.add("Lifeblood of the Golden Hour");
    }

    public void addIngredient(Herb h) {
        this.ingredients.add(h);
    }

    public void printPotion() {
        addName();
        Random random = new Random();
        String randomName = names.get(random.nextInt(names.size()));
        System.out.println(randomName);
        System.out.println("Ingredients: ");
        for (Herb h : ingredients) {
            h.printName();
        }
        System.out.println("Quantity: " + quantity + " ml ");
        System.out.println("Price: " + coinPrice + " coins | " + chickenPrice + " chickens | " + winePrice + "l fine wine");
    }
}
