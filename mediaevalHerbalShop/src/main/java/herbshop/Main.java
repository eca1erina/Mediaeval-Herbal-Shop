package herbshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InvalidUserException extends RuntimeException {
    public InvalidUserException(String message) {
        super(message);
    }
}

public class Main {
    static Shop shop = new Shop();
    static Vendor vendor = new Vendor();

    public static void main(String[] args) throws InsufficientQuantityException, HerbNotFoundException {
        try {
            if (args.length == 1) {
                if ("villager".equalsIgnoreCase(args[0])) {
                    shop.main();
                } else if ("vendor".equalsIgnoreCase(args[0])) {
                    vendor.main();
                } else {
                    throw new InvalidUserException("Invalid command. Please type 'villager' or 'vendor'.");
                }
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Welcome to the Mediaeval Herbal Shop! \nWho are you?\n");
                System.out.println("1. Villager");
                System.out.println("2. Vendor");
                System.out.println("0. Exit\n");
                System.out.print("Type in your choice: ");

                String choice = reader.readLine().trim();

                try {
                    int option = Integer.parseInt(choice);

                    if (option < 0 || option > 2) {
                        throw new IndexOutOfBoundsException("Invalid choice index. Please enter 0, 1, or 2.");
                    }

                    switch (option) {
                        case 1:
                            shop.main();
                            break;
                        case 2:
                            vendor.main();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            throw new InvalidUserException("Invalid choice. Please enter 0, 1, or 2.");
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidUserException("Input must be a number. Please enter 0, 1, or 2.");
                }
            }
        } catch (InvalidUserException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

