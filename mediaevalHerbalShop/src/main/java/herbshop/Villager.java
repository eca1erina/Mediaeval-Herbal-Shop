package herbshop;

import java.util.HashSet;
import java.util.Set;

public class Villager {
    String name, occupation;
    Set<Potion> potions = new HashSet<>();
    Set<Pills> pills = new HashSet<>();

    public Villager() {
    }

    public void updatePotions(Potion potion) {
        if (potions.add(potion)) {
            System.out.println("Potion added to your purchases.");
        } else {
            System.out.println("You have already purchased this potion.");
        }
    }

    public void updatePills(Pills pill) {
        if (pills.add(pill)) {
            System.out.println("Pills added to your purchases.");
        } else {
            System.out.println("You have already purchased these pills.");
        }
    }

    public void review() {
        System.out.println("Was the remedy efficient in helping you?");
    }
    
}
