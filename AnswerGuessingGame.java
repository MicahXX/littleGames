import java.util.Scanner;

public class AnswerGuessingGame {
    Scanner sc = new Scanner(System.in);

    private int points = 0;
    int skipsLeft = 2; // change this amount if you want to allow more skips

    // colours
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[97m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String GOLD = "\u001B[38;2;255;215;0m";
    public static final String DARK_BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[95m";

    private void author() {
        System.out.println(DARK_BLUE + "╔══════════════════════════════╗" + RESET);
        System.out.println(GOLD + "         by MicahCode         " + RESET);
        System.out.println(DARK_BLUE + "╚══════════════════════════════╝" + RESET);
    }

    private void divline() {
        System.out.println(DARK_BLUE + "══════════════════════════════" + RESET);
    }

    public void startGame() {
        System.out.println(DARK_BLUE + "Welcome to my Answer Guessing Game!" + RESET);
        divline();
    }

    public void questionSystem() {
        String[][] questions = {
                {"What is the most commonly used programming language for Websites?", "JavaScript", "It's name is close to another popular language.", "It's famous for being pretty annoying to debug.", "It's name is close to Java."},
                {"What is 2 + 2?", "4", "It's an even number.", "It's greater than 3.", "It's less than 5."},
                {"What is the best programming language for data science?", "Python", "It's name is the same as an animal.", "many new beginners start with this language.", "It starts with an P."}
        }; // (Question) (Answer) (tip1) (tip2) (tip3) --> if you add questions

        for (String[] q : questions) {
            String question = q[0];
            int tipsUsed = 0;
            int wrongAnswers = 0;
            System.out.println(WHITE + question + RESET);
            System.out.println(GOLD + "Skips Left: " + skipsLeft + RESET);
            divline();

            while (true) {
                System.out.print(MAGENTA + "Your answer (type 'tip' for a hint or 'skip'): " + RESET);
                String userInput = sc.nextLine();
                if (userInput.equalsIgnoreCase("tip") && tipsUsed < 3) {
                    System.out.println(WHITE + "tip: " + q[2 + tipsUsed] + RESET);
                    divline();
                    tipsUsed++;
                } else if (userInput.equalsIgnoreCase("tip") && tipsUsed == 3) {
                    System.out.println(WHITE + "OUT OF TIPS" + RESET);
                    divline();
                } else if (userInput.equalsIgnoreCase("skip")) {
                    if (skipsLeft > 0) {
                        System.out.println(RED + "You skipped this question!" + RESET);
                        divline();
                        skipsLeft--;
                        break;
                    } else {
                        System.out.println(WHITE + "No skips left!" + RESET);
                        divline();
                    }
                }
                else if (userInput.equalsIgnoreCase(q[1])) {
                    System.out.println(PURPLE + "Congratulations! You guessed it!" + RESET);
                    divline();
                    points += 4 - (tipsUsed - wrongAnswers) / 2;
                    break;
                } else {
                    wrongAnswers++;
                    System.out.println(RED + "Wrong..." + RESET);
                    divline();
                }
            }
        }
        endGame();
    }

    public void displayResults() {
        System.out.println(DARK_BLUE + "╔══════════════════════════════╗" + RESET);
        if (points >= 10) {
            System.out.println(GOLD + "         Rank: Master" + RESET);
        } else if (points >= 6) {
            System.out.println(GOLD + "       Rank: Intermediate" + RESET);
        } else {
            System.out.println(GOLD + "         Rank: Beginner" + RESET);
        }
        System.out.println(DARK_BLUE + "╚══════════════════════════════╝" + RESET);
    }

    public void endGame() {
        displayResults();
        divline();
        System.out.println(BRIGHT_GREEN + "Thank you for playing!" + RESET);
    }

    public static void main(String[] args) {
        AnswerGuessingGame game = new AnswerGuessingGame();

        game.author();
        game.startGame();
        game.questionSystem();
    }
}