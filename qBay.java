import java.util.Scanner;

public class qBay{
    public static void main(String[] args) 
    {
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
            System.out.println("Menu: \n 1.Buy \n 2.Sell \n 3.Cart \n 4.Logout");
        }

    }
}
