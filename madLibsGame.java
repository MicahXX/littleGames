import java.util.Scanner;

public class madLibsGame {
    public static void main(String[] args) {
        // MAD LIBS GAME
        Scanner scanner = new Scanner(System.in);

        String adjective1;
        String noun1;
        String adjective2;
        String verb1;
        String adjective3; 

        System.out.println("Welcome to my game where you have to add words like nouns " +
                "and complete the sentences.");

        System.out.print("-------------"); 

        System.out.println("\nToday I went to a " + "<adjective1>" + " zoo.");
        System.out.println("In an exhibit, I saw a " + "<noun1>" + ".");
        System.out.println("<noun1>" + " was " + "<adjective2>" + " and " + "<verb1>" + ".");
        System.out.println("I was " + "<adjective3>" + "!");

        System.out.println("-------------");

        System.out.print("Enter adjective1: ");
        adjective1 = scanner.nextLine();
        System.out.print("Enter noun: ");
        noun1 = scanner.nextLine();
        System.out.print("Enter adjective2: ");
        adjective2 = scanner.nextLine();
        System.out.print("Enter verb with -ing: ");
        verb1 = scanner.nextLine();
        System.out.print("Enter adjective3: ");
        adjective3 = scanner.nextLine();

        System.out.print("--------------");

        System.out.println("\nToday I went to a " + adjective1 + " zoo.");
        System.out.println("In an exhibit, I saw a " + noun1 + ".");
        System.out.println(noun1 + " was " + adjective2 + " and " + verb1 + ".");
        System.out.println("I was " + adjective3 + "!");

        scanner.close();
    }
}


