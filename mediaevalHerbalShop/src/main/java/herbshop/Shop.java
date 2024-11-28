package herbshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Shop {
    static Villager villager = new Villager();
    static FluHerbs fluHerbs = new FluHerbs();
    static PlagueHerbs plagueHerbs = new PlagueHerbs();
    static ImmortalityHerbs immortalityHerbs = new ImmortalityHerbs();
    static YouthHerbs youthHerbs = new YouthHerbs();

    public Shop() {
    }

    public static void printWelcome() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is your name?");
        System.out.println("My name is: ");
        String choice = reader.readLine();
        villager.name = choice;
        System.out.println("My occupation is: ");
        choice = reader.readLine();
        villager.occupation = choice;
        System.out.println("\n Hi " + villager.name + " the " + villager.occupation + "! What ails you?");
        
    }
    
    public static void printMenu() {
        System.out.println("\n1. I have a cold. *cough* *cough*");
        System.out.println("2. I have the black plague. *sounds of dying*");
        System.out.println("3. I want to be forever young. ");
        System.out.println("4. I want to become immortal.");
        System.out.println("0. Exit.\n");
        System.out.println("Choose one of the options: ");
    }

    public void main() throws IOException, HerbNotFoundException, InsufficientQuantityException {

        printWelcome();
        String choice="";

        while (!new String("0").equals(choice)) {

            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            choice = reader.readLine();

            if (new String("1").equals(choice)) {

                fluHerbs.sortByPrice();
                fluHerbs.printHerbs();

                //read the ids
                Scanner scanner = new Scanner(System.in);
                System.out.print("Type in the number of herbs you'd like: ");
                int size = scanner.nextInt();
                if (size < 0) return ;

                int[] numbers = new int[size];
                System.out.println("Type in the IDs of the herbs you want:");
                for (int i = 0; i < size; i++) {
                    numbers[i] = scanner.nextInt();
                    if (numbers[i] < 0) {
                        System.out.println("Invalid herb ID. Please enter a positive integer.");
                        i--;
                    }
                }

                Pills pills = fluHerbs.makePills(numbers);
                pills.printPills();

            }
            else if (new String("2").equals(choice)) {
                plagueHerbs.sortByPrice();
                plagueHerbs.printHerbs();
                //read the ids
                Scanner scanner = new Scanner(System.in);
                System.out.print("Type in the number of herbs you'd like: ");
                int size = scanner.nextInt();
                int[] numbers = new int[size];
                System.out.println("Type in the IDs of the herbs you want:");
                for (int i = 0; i < size; i++) {
                    numbers[i] = scanner.nextInt();
                    if (numbers[i] < 0) {
                        System.out.println("Invalid herb ID. Please enter a positive integer.");
                        i--;
                    }
                }
                
                Pills pills = plagueHerbs.makePills(numbers);
                pills.printPills();

            }
            else if (new String("4").equals(choice)) {
                immortalityHerbs.sortByPrice();
                immortalityHerbs.printHerbs();
                //read the ids
                Scanner scanner = new Scanner(System.in);
                System.out.print("Type in the number of herbs you'd like: ");
                int size = scanner.nextInt();
                int[] numbers = new int[size];
                System.out.println("Type in the IDs of the herbs you want:");
                for (int i = 0; i < size; i++) {
                    numbers[i] = scanner.nextInt();
                    if (numbers[i] < 0) {
                        System.out.println("Invalid herb ID. Please enter a positive integer.");
                        i--;
                    }
                }
                
                Potion potion = immortalityHerbs.makePotion(numbers);
                potion.printPotion();
            }
            else if (new String("3").equals(choice)) {
                youthHerbs.sortByPrice();
                youthHerbs.printHerbs();
                //read the ids
                Scanner scanner = new Scanner(System.in);
                System.out.print("Type in the number of herbs you'd like: ");
                int size = scanner.nextInt();
                int[] numbers = new int[size];
                System.out.println("Type in the IDs of the herbs you want:");
                for (int i = 0; i < size; i++) {
                    numbers[i] = scanner.nextInt();
                    if (numbers[i] < 0) {
                        System.out.println("Invalid herb ID. Please enter a positive integer.");
                        i--;
                    }
                }
                
                Potion potion = youthHerbs.makePotion(numbers);
                potion.printPotion();
            }
            else if (new String("0").equals(choice)) System.exit(0);

            System.out.println("Perfect! Do you need anything else?");
            System.out.println("0. No");
            System.out.println("1. Yes");

            choice = reader.readLine();

        }

    }
}
