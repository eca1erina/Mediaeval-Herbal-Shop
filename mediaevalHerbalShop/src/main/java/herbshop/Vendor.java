package herbshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Vendor extends JsonManager {
    static String name, country;
    static List<Herb> herbs = new ArrayList<>();

    public Vendor() {}

    public void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("\nWhat is your name?");
            System.out.print("My name is: ");
            name = reader.readLine().trim();

            System.out.print("I am from the country of: ");
            country = reader.readLine().trim();
            System.out.println("\nHi " + name + " of " + country + "! What herbs have you got for me?");

            String choice;
            while (true) {
                displayMenu();
                choice = reader.readLine().trim();
                
                if ("0".equals(choice)) {
                    System.out.println("Goodbye, " + name + "! Safe travels.");
                    break;
                }

                String pathname = getPathnameForChoice(choice);
                if (pathname.isEmpty()) {
                    System.out.println("Invalid choice. Please select a number between 0 and 4.");
                    continue;
                }

                herbs = readHerbsFromJson(pathname); 
                int sum = 0;

                System.out.print("Number of herbs to add: ");
                int herbCount = parsePositiveInt(reader.readLine());
                if (herbCount < 0) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    continue;
                }

                for (int i = 0; i < herbCount; i++) {
                    Herb herb = getHerbFromUserInput(reader);
                    if (herb != null) {
                        Herb existingHerb = findHerbByName(herb.getName());
                        if (existingHerb != null) {
                            existingHerb.setQuantity(existingHerb.getQuantity() + herb.getQuantity());
                            System.out.println("Updated quantity of " + herb.getName() + ".");
                        } else {
                            herbs.add(herb);
                            System.out.println("Added new herb: " + herb.getName() + ".");
                        }
                        sum += herb.coinPrice * herb.quantity;
                    } else {
                        System.out.println("Failed to add herb. Please try again.");
                        i--; 
                    }
                }

                System.out.println("Alrighty, here are your " + sum + " coins. Do you have anything else for me?");
                writeHerbsToJson(herbs, pathname);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }

    private void displayMenu() {
        System.out.println("1. Flu herbs");
        System.out.println("2. Plague herbs");
        System.out.println("3. Youth herbs");
        System.out.println("4. Immortality herbs");
        System.out.println("0. Exit");
        System.out.print("Type in your choice: ");
    }

    private String getPathnameForChoice(String choice) {
        switch (choice) {
            case "1": return "fluHerbs.json";
            case "2": return "plagueHerbs.json";
            case "3": return "youthHerbs.json";
            case "4": return "immortalityHerbs.json";
            default: return "";
        }
    }

    private Herb getHerbFromUserInput(BufferedReader reader) {
        try {
            System.out.print("Name of herb: ");
            String name = reader.readLine().trim();

            System.out.print("Country of origin: ");
            String country = reader.readLine().trim();

            System.out.print("Property: ");
            String property = reader.readLine().trim();

            System.out.print("Efficiency rate (integer 0-100): ");
            int efficiency = parsePositiveIntWithinRange(reader.readLine(), 0, 100);
            if (efficiency < 0) return null;

            System.out.print("Price in coins: ");
            int coinPrice = parsePositiveInt(reader.readLine());
            if (coinPrice < 0) return null;

            System.out.print("Quantity: ");
            int quantity = parsePositiveInt(reader.readLine());
            if (quantity < 0) return null;

            return new Herb(name, property, country, coinPrice, coinPrice * 3, coinPrice * 2, quantity, efficiency);
        } catch (IOException e) {
            System.err.println("Error reading herb details: " + e.getMessage());
            return null;
        } 
    }

    private Herb findHerbByName(String herbName) {
        for (Herb herb : herbs) {
            if (herb.getName().equalsIgnoreCase(herbName)) {
                return herb;
            }
        }
        return null;
    }

    private int parsePositiveInt(String input) {
        try {
            int value = Integer.parseInt(input.trim());
            if (value >= 0) return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
        }
        return -1; 
    }

    private int parsePositiveIntWithinRange(String input, int min, int max) {
        int value = parsePositiveInt(input);
        if (value >= min && value <= max) return value;
        System.out.println("Value out of range. Please enter a value between " + min + " and " + max + ".");
        return -1;
    }
}
