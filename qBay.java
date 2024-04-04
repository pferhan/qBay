import java.util.ArrayList;
import java.util.Scanner;

public class qBay {
    ArrayList<String[]> sellItems = new ArrayList<>();
    public static void main(String[] args) 
    {
        qBay qbay = new qBay();

        //Users for login
        String userOne = "taylor.lea@quinnipiac.edu";
        String passwordOne = "password1";

        String userTwo = "hannah.pfersch@quinnipiac.edu";
        String passwordTwo = "password2";

        String userThree = "hayden.ward@quinnipiac.edu";
        String passwordThree = "password3";

        //welcome message
        System.out.println("Welcome to qBay!");
        System.out.println("       __________               \n  _____\\______   \\_____  ___.__.\n / ____/|    |  _/\\__  \\<   |  |\n< <_|  ||    |   \\ / __ \\\\___  |\n \\__   ||______  /(____  / ____|\n    |__|       \\/      \\/\\/  ");
        System.out.println("Please login using your quinnipiac email and password: ");

        //prompt user to login
        int loginTryCount = 0;
        boolean loggedIn = false;

        while(loginTryCount < 3 && loggedIn == false){
            Scanner scan = new Scanner(System.in);
            loginTryCount++;
            System.out.println("Email: ");
            String username = scan.next();
            System.out.println("Password: ");
            String password = scan.next();

            if(username.equals(userOne)){
                if(password.equals(passwordOne)){
                    System.out.println("Login successful!");
                    loggedIn = true;
                }
            }else if(username.equals(userTwo)){
                if(password.equals(passwordTwo)){
                    System.out.println("Login successful!");
                    loggedIn = true;
                }
            }else if(username.equals(userThree)){
                if(password.equals(passwordThree)){
                    System.out.println("Login successful!");
                    loggedIn = true;
                }
            }else{
                if(loginTryCount < 3){
                System.out.println("incorrect, please try again.");
                }else{
                System.out.println("you have been locked out of your account due to suspicous activity.");
                }
            }
        }

        if(loggedIn = true){
            qbay.menu();
        }
    }

    public void menu() {
        System.out.println("Menu: \n 1. Buy \n 2. Sell \n 3. Cart \n 4. Logout");

        Scanner scan = new Scanner(System.in);

        int choice = scan.nextInt();

        if (choice == 1) {
            //buy
        } else if (choice == 2) {
            sell();
        } else if (choice == 3) {
            //cart
        } else if (choice == 4) {
            //logout
        } else {
            System.out.println("Invalid choice selection 1, please try again");
        }

        scan.close();
    }

    public void sell() {
        System.out.println("Welcome to the sell page!!");
        System.out.println("Menu: \n 1. View current items \n 2. Add new item \n 3. Return to menu");

        Scanner scan = new Scanner(System.in);

        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.println("Current listed items: " + sellItems.size());

            for (int i = 0; i < sellItems.size(); i++)
            {
                String[] item = sellItems.get(i);
                
                for (int j = 0; j < item.length; j++) 
                {
                    System.out.print(item[j] + " ");
                }
                 System.out.println();
            }

            sell();
        } else if (choice == 2) {
            System.out.println("Please enter the following information about the item you wish to sell.");
            System.out.println("Name: ");
            String name = scan.next();
            System.out.println("Category: ");
            String category = scan.next();
            System.out.println("Price: ");
            String price = scan.next();
            
            String[] item = {name, category, price};
            
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
