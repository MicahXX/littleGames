import java.util.Scanner;

public class tinyQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // add another variable or change this if you want to make more questions 
        // and use it in the same format as shown below
        String beginOfTheQuiz;
        String nameOfOwner;
        String nameOfManager;
        String nameOfTheDeveloper;
        int ww2Beginning; 
        int minecraftRelease;

        int points = 0;
        int maxPoints = 5; // change this amount based on the amount of questions you have

        // beginning message of the quiz
        System.out.println("Welcome to my Quiz with 5 little questions about Marcusk and his Discord Server" +
                ", also there are some general questions too.");
        System.out.println();

        // asks if user wants to begin the quiz
        System.out.print("Do you want to begin? (y/n) ");
        beginOfTheQuiz = scanner.nextLine();

        if (normalize(beginOfTheQuiz).equals("n")) {
            System.exit(0);
        }
        System.out.println("----------------------");

        // start of the quiz (put your questions here)
        System.out.print("What is the name of the owner of the youtuber who owns the disc? ");
        nameOfOwner = scanner.nextLine();

        if (normalize(nameOfOwner).equals("marcusk")) {
            System.out.println("Correct!");
            points++;
        } else {
            System.out.println("Wrong. The correct answer was Marcusk.");
        }

        System.out.println("----------------------");

        System.out.print("What is the name of the manager of the disc? ");
        nameOfManager = scanner.nextLine();

        if (normalize(nameOfManager).equals("hannah")) {
            System.out.println("Correct!");
            points++;
        } else {
            System.out.println("Wrong. The correct answer was Hannah.");
        }

        System.out.println("----------------------");

        System.out.print("What is the name of the Developer of the disc? ");
        nameOfTheDeveloper = scanner.nextLine();

        if (normalize(nameOfTheDeveloper).equals("baylem")) {
            System.out.println("Correct!");
            points++;
        } else {
            System.out.println("Wrong. The correct answer was Baylem.");
        }

        System.out.println("----------------------");

        System.out.print("When did WW2 begin? ");
        if (scanner.hasNextInt()) {
            ww2Beginning = scanner.nextInt();
            scanner.nextLine();
            if (ww2Beginning == 1939) {
                System.out.println("Correct!");
                points++;
            }
        } else {
            System.out.println("Wrong. The correct answer was 1939.");
            scanner.nextLine();
        }

        System.out.println("----------------------");

        System.out.print("When did Minecraft the full version first release? ");
        if (scanner.hasNextInt()) {
            minecraftRelease = scanner.nextInt();
            scanner.nextLine();
            if (minecraftRelease == 2011) {
                System.out.println("Correct!");
                points++;
            }
        } else {
            System.out.println("Wrong. The correct answer was 2011.");
            scanner.nextLine();
        }

        System.out.println("----------------------");

        // End message of correct answer and how good you were
        float perCorrect = ((float) points / maxPoints) * 100;

        if (perCorrect == 100) {
            System.out.printf("You got %.1f%% correct and you are the Marcusk Master!\n", perCorrect);
        } else if (perCorrect < 99 && perCorrect >= 80) {
            System.out.printf("You got %.1f%% correct and you are the Marcusk Elite!\n", perCorrect);
        } else if (perCorrect < 80 && perCorrect >= 60) {
            System.out.printf("You got %.1f%% correct and you are the Marcusk Novice!\n", perCorrect);
        } else if (perCorrect < 60 && perCorrect >= 40) {
            System.out.printf("You got %.1f%% correct and you are the Marcusk Beginner!\n", perCorrect);
        } else if (perCorrect < 40 && perCorrect >= 20) {
            System.out.printf("You got %.1f%% correct and you are the Marcusk NotKnower!\n", perCorrect);
        } else if (perCorrect < 20) {
            System.out.printf("You got %.1f%% correct and you ask yourself who is Marcusk?!\n", perCorrect);
        }

        scanner.close(); // scanner cant be used again
    }

    private static String normalize(String input) { // makes it so the user can also type the answer in lowercase or with spaces
        return input.trim().replaceAll("\\s+", "").toLowerCase();
    }
}


