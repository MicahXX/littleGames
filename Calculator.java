import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    double n1;
    double n2;
    String operator; 

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

    private void dividingLine() {
        System.out.println(DARK_BLUE + "══════════════════════════════" + RESET);
    }

    // starter menu
    public void showMenu() {
        System.out.println(RED + "0: Exit");
        System.out.println(BRIGHT_GREEN + "1: Addition" + RESET);
        System.out.println(BRIGHT_GREEN + "2: Subtraction" + RESET);
        System.out.println(BRIGHT_GREEN + "3: Multiplication" + RESET);
        System.out.println(BRIGHT_GREEN + "4: Division");
        System.out.println(MAGENTA + "?: Show Menu" + RESET);
    }

    public void inputOperator() {
        dividingLine();
        System.out.print(BRIGHT_GREEN + "Choose an Operator (0-4, " + MAGENTA + "?" + BRIGHT_GREEN + "): " + RESET);
        operator = scanner.nextLine();
    }

    // checks if operator is 0, valid or not valid
    public boolean validateOperator() {
        while (true) {
            switch (operator) {
                case "0":
                    dividingLine();
                    System.out.println(GOLD + "Thank you for using my calculator!" + RESET);
                    return false;
                case "?":
                    showMenu();
                    dividingLine();
                    System.out.print(BRIGHT_GREEN + "Choose an Operator (0-4, " + MAGENTA + "?" + BRIGHT_GREEN + "): " + RESET);
                    operator = scanner.nextLine();
                    break;
                default:
                    if (operator.matches("[1-4]")) {
                        dividingLine();
                        return true;
                    } else {
                        dividingLine();
                        System.err.print(RED + "Invalid choice! Choose an Operator(0-4, ?): " + RESET);
                        operator = scanner.nextLine();
                    }
            }
        }
    }

    // asks user for number
    public void inputNumber() {
        System.out.print(PURPLE + "Choose number 1: " + RESET);
        validateNumber();
        n1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print(PURPLE + "Choose number 2: " + RESET);
        validateNumber();
        n2 = scanner.nextDouble();
        scanner.nextLine();

        dividingLine();
    }

    // checks if user input is a number
    public void validateNumber() {
        while (true) {
            if (scanner.hasNextDouble()) {
                break;
            } else {
                System.out.print(RED + "Invalid choice! Choose a valid number: " + RESET);
                scanner.nextLine();
            }
        }
    }

    // calculates the result (maybe add more features)
    public void result() {
        switch (operator) {
            case "1":
                System.out.println(GOLD + n1 + " + " + n2  + " = " + (n1 + n2) + RESET);
                break;
            case "2":
                System.out.println(GOLD + n1 + " - " + n2 + " = " + (n1 - n2) + RESET);
                break;
            case "3":
                System.out.println(GOLD + n1 + " * " + n2 + " = " + (n1 * n2) + RESET);
                break;
            case "4":
                if (n2 == 0) {
                    System.out.print(RED + "Invalid choice! Choose a valid number 2: " + RESET);
                    validateNumber();
                    n2 = scanner.nextDouble();
                    scanner.nextLine();

                    dividingLine();
                    System.out.println(GOLD + n1 + " / " + n2 + " = " + (n1 / n2) + RESET);
                } else {
                    System.out.println(GOLD + n1 + " / " + n2 + " = " + (n1 / n2) + RESET);
                }
                break;
        }
    }

    // starts the calc in one method
    public void startProgram() {
        // shows once at the start
        author();
        showMenu();

        // shows till user does 0
        while (true) {
            inputOperator();
            if (!validateOperator()) { break; }
            inputNumber();
            result();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.startProgram();
    }
}

