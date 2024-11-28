package herbshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pills {
    List <Herb> ingredients = new ArrayList<Herb>();
    int quantity, coinPrice, chickenPrice, winePrice;
    List <String> names = new ArrayList<String>();

    public Pills(int quantity) {
        this.quantity = quantity;
    }

    public void addName() {
        names.add("No-More-Death Drops");
        names.add("Fever Fizz Tablets");
        names.add("Cough-Banish Crumble");
        names.add("Not Today, Pestilence! Pills");
        names.add("Knight's Health Capsules");
        names.add("Holy Health Pebbles");
        names.add("Necromancer's Curing Stones");
        names.add("Malice Slayer Pills");
        names.add("Pestilence-Be-Gone Tablets");
        names.add("Sorcerer's Spirit Drops");
    }

    public void addIngredient(Herb h) {
        this.ingredients.add(h);
    }

    public void printPills() {
        addName();
        Random random = new Random();
        String randomName = names.get(random.nextInt(names.size()));
        System.out.println(randomName);
        System.out.println("Ingredients: ");
        for (Herb h : ingredients) {
            h.printName();
        }
        System.out.println("Quantity: " + quantity + " g. ");
        System.out.println("Price: " + coinPrice + " coins | " + chickenPrice + " chickens | " + winePrice + "l fine wine");
    }
}
