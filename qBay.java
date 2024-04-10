import java.util.ArrayList;
import java.util.Scanner;

public class qBay {

    ArrayList<String[]> sellItems = new ArrayList<>();
    private static String[][] itemsToBuy = { { "T-shirt", "clothes", "John", "Stan", "John.Stan@quinnipiac.edu", "12.00" },
            { "Tent", "camping", "Adrian", "Smith", "Adrian.Smith@quinnipiac.edu", "100.00" },
            { "Dress", "clothes", "Ann", "Rossi", "Ann.Rossi@quinnipiac.edu", "50.00" },
            { "Basketball", "sports", "Mark", "Ross", "Mark.Ross@quinnipiac.edu", "10.00" },
            { "Toy", "pets", "Rivera", "Owens", "Rivera.Owens@quinnipiac.edu", "12.00" } };
    
    //feel free to change this if needed
    ArrayList<String[]> cart = new ArrayList<>();

    public static void main(String[] args) {
        qBay qbay = new qBay();

        // Users for login
        String userOne = "taylor.lea@quinnipiac.edu";
        String passwordOne = "password1";

        String userTwo = "hannah.pfersch@quinnipiac.edu";
        String passwordTwo = "password2";

        String userThree = "hayden.ward@quinnipiac.edu";
        String passwordThree = "password3";

        // welcome message
        System.out.println("Welcome to qBay!");
        System.out.println(
                "       __________               \n  _____\\______   \\_____  ___.__.\n / ____/|    |  _/\\__  \\<   |  |\n< <_|  ||    |   \\ / __ \\\\___  |\n \\__   ||______  /(____  / ____|\n    |__|       \\/      \\/\\/  ");
        System.out.println("Please login using your quinnipiac email and password: ");

        // prompt user to login
        int loginTryCount = 0;
        boolean loggedIn = false;

        while (loginTryCount < 3 && loggedIn == false) {
            Scanner scan = new Scanner(System.in);
            loginTryCount++;
            System.out.println("Email: ");
            String username = scan.next();
            System.out.println("Password: ");
            String password = scan.next();

            if (username.equals(userOne)) {
                if (password.equals(passwordOne)) {
                    System.out.println("Login successful!");
                    loggedIn = true;
                }
            } else if (username.equals(userTwo)) {
                if (password.equals(passwordTwo)) {
                    System.out.println("Login successful!");
                    loggedIn = true;
                }
            } else if (username.equals(userThree)) {
                if (password.equals(passwordThree)) {
                    System.out.println("Login successful!");
                    loggedIn = true;
                }
            } else {
                if (loginTryCount < 3) {
                    System.out.println("incorrect, please try again.");
                } else {
                    System.out.println("you have been locked out of your account due to suspicous activity.");
                }
            }
        }

        if (loggedIn = true) {
            qbay.menu();
        }
    }

    public void menu() {
        System.out.println("Menu: \n 1. Buy \n 2. Sell \n 3. Cart \n 4. Logout");

        Scanner scan = new Scanner(System.in);

        int choice = scan.nextInt();

        if (choice == 1) {
            // buy
            buy();
        } else if (choice == 2) {
            sell();
        } else if (choice == 3) {
            // cart
        } else if (choice == 4) {
            // logout
        } else {
            System.out.println("Invalid choice selection 1, please try again");
        }

    }

    public void buy() {
        Scanner scan = new Scanner(System.in);
        if(sellItems.size() > 0) {
            String[][] tempArray = new String[sellItems.size() + itemsToBuy.length][6];
            for(int i=0; i < sellItems.size(); i++) {
                tempArray[i] = sellItems.get(i);
            }
            for(int j=0; j < itemsToBuy.length; j++) {
                tempArray[j + sellItems.size()] = itemsToBuy[j];
            }
            itemsToBuy = tempArray;
        }
        System.out.println("Welcome to the buy page!\nPlease enter the name of the item to view more information about it.");
        System.out.println("Type menu to go back to the menu.");

        String userInput;
        for (int i = 0; i < itemsToBuy.length; i++) {
            System.out.println((i + 1) + " " + itemsToBuy[i][0]);
        }
        userInput = scan.nextLine();
        if(userInput.toLowerCase().equals("menu")) {
            menu();
        }
        String itemToBuy = userInput;
        for (int i = 0; i < itemsToBuy.length; i++) {
            if (userInput.equals(itemsToBuy[i][0])) {
                System.out.println("Item name: " + itemsToBuy[i][0]);
                System.out.println("Category: " + itemsToBuy[i][1]);
                System.out.println("Seller first name: " + itemsToBuy[i][2]);
                System.out.println("Seller last name: " + itemsToBuy[i][3]);
                System.out.println("Seller email: " + itemsToBuy[i][4]);
                System.out.println("Item price: $" + itemsToBuy[i][5]);
                System.out.println("\nWould you like to add this item to your cart?");
                userInput = scan.nextLine();
                if(userInput.toLowerCase().equals("yes")) {
                    System.out.println(itemToBuy + " has been added to your cart.");
                    //would add to the list created for the checkout function here
                    //feel free to change this part if needed
                    String[] item = { itemsToBuy[i][0], itemsToBuy[i][1], itemsToBuy[i][2], itemsToBuy[i][3], itemsToBuy[i][4], itemsToBuy[i][5] };
                    cart.add(item);
                    

                    String[][] tempArray = new String[itemsToBuy.length-1][6];
                    int itemsToBuyIndex = 0;
                    for(int j=0; j < tempArray.length;) {
                        if(!itemsToBuy[itemsToBuyIndex][0].equals(itemToBuy)) {
                            tempArray[j] = itemsToBuy[itemsToBuyIndex];
                            j++;
                        }
                        itemsToBuyIndex++;
                    }
                    itemsToBuy = tempArray;
                    if(i < sellItems.size() && sellItems.size() > 0) {
                        sellItems.remove(i);
                    }
                    buy();
                } else {
                    buy();
                }
            }

        }
        buy();
        scan.close();
    }

    public void sell() {
        System.out.println("Welcome to the sell page!!");
        System.out.println("Menu: \n 1. View current items \n 2. Add new item \n 3. Return to menu");

        Scanner scan = new Scanner(System.in);

        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.println("Current listed items: " + sellItems.size());

            for (int i = 0; i < sellItems.size(); i++) {
                String[] item = sellItems.get(i);

                for (int j = 0; j < item.length; j++) {
                    System.out.print(item[j] + " ");
                }
                System.out.println();
            }

            sell();
        } else if (choice == 2) {
            System.out.println("Please enter the following information about the item you wish to sell.");
            System.out.println("Item Name: ");
            String itemName = scan.next();
            System.out.println("Category: ");
            String category = scan.next();
            System.out.println("First Name: ");
            String FirstName = scan.next();
            System.out.println("Last Name: ");
            String LastName = scan.next();
            System.out.println("Email: ");
            String email = scan.next();
            System.out.println("Price: ");
            String price = scan.next();

            String[] item = { itemName, category, FirstName, LastName, email, price };

            sellItems.add(item);

            sell();
        } else if (choice == 3) {
            menu();
        } else {
            System.out.println("Invalid choice selection 2, please try again");
        }
        scan.close();
    }
}
