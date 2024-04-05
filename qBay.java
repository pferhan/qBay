import java.util.Scanner;

public class qBay{
    static String[][] items = {{"T-shirt", "clothes", "John", "Stan", "John.Stan@quinnipiac.edu", "$12.00"}, 
    {"name of item", "category", "first name", "last name", "email", "price"}, 
    {"name of item", "category", "first name", "last name", "email", "price"}, 
    {"name of item", "category", "first name", "last name", "email", "price"}, 
    {"name of item", "category", "first name", "last name", "email", "price"}};
    public static void main(String[] args) 
    {
        buy();
    }

    public static void buy() {
        Scanner scan = new Scanner(System.in);
        String userInput;
        for(int i=0; i<items.length; i++) {
            System.out.println(items[i][0]);
        }
        userInput = scan.nextLine();
        for(int i=0; i<items.length; i++) {
            if(userInput.equals(items[i][0])) {
                for(int j=0; j<items[i].length-1; j++) {
                    System.out.println(items[i][j]);
                }
            }
        }
    }
}
