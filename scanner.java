import java.util.Scanner;

public class GreetingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hi, " + name + "! Welcome to the world of Java.");
        
        scanner.close();
    }
}
