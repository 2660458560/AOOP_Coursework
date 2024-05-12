import java.util.Scanner;

/**
 * Represents a command-line interface (CLI) application for playing the Numberle game.
 * The user interacts with the game through the command line. This class provides
 * the main entry point for running the game, ensuring a correct gameplay loop
 * and user interaction.
 */
public class CLIApp {
    private final INumberleModel model; // The game model used for managing the game state and processing user input.
    private final Scanner scanner; // The Scanner object used for reading user input from the command line.

    /**
     * Constructs a CLIApp object with a new instance of NumberleModel and a Scanner for user input.
     * @ensures model != null "The model is properly initialized."
     * @ensures scanner != null "The scanner for reading user input is initialized."
     */
    public CLIApp() {
        model = new NumberleModel(); // Create a new instance of NumberleModel as the game model.
        scanner = new Scanner(System.in); // Create a new Scanner object to read user input from the command line.
    }

    /**
     * Starts the Numberle game.
     * This method displays welcome messages, handles user input, and controls the game flow.
     * @requires model != null "The game model must be initialized before starting the game."
     * @requires scanner != null "Input scanner must be initialized before starting the game."
     * @ensures "The game continues until it is either won or all attempts are used."
     */
    public void startGame() {
        System.out.println("Welcome to Numberle Game!");
        System.out.println("----------------------------------------");
        System.out.println("What you need to do is to find");
        System.out.println("a hidden mathematical equation");
        System.out.println("through at most 6 guesses.");
        System.out.println("After each guess, some feedback will be provided to");
        System.out.println("help you gradually narrow down the scope.");
        System.out.println("Let's start!");
        System.out.println("----------------------------------------");

        model.startNewGame(); // Initialize a new game using the game model.

        while (!model.isGameOver()) {
            System.out.println("You have " + model.getRemainingAttempts() + "/6 attempts remained.");
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            boolean valid = model.processInput(guess); // Process the user's guess using the game model.

            if (valid) {
                System.out.println("----------------------------------------");
                System.out.println("For your guess this time, there is a hint: ");
                System.out.println(model.getCurrentGuess().toString());
                System.out.println("√ means correct digit or operator at the right place;");
                System.out.println("? means digit or operator exists but not here;");
                System.out.println("× means it does not appear in this equation.");
            } else {
                System.out.println("Invalid equation.");
            }

            System.out.println("----------------------------------------");
        }

        if (model.isGameWon()) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("Game over! You ran out of attempts. The target equation was: " + model.getTargetNumber());
        }

        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = scanner.nextLine();

        if (playAgain.equalsIgnoreCase("yes")) {
            startGame(); // Restart the game if the user wants to play again
        } else {
            System.out.println("Thank you for playing Numberle Game!");
        }
    }

    /**
     * The main entry point of the application.
     * Creates an instance of CLIApp and starts the game.
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        CLIApp game = new CLIApp(); // Create a new instance of CLIApp.
        game.startGame(); // Start the game by calling the startGame() method.
    }
}
