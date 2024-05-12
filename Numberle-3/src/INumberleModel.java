// INumberleModel.java

//Import necessary classes
import java.util.Set;

/**
 * Defines the basic behavior of the Numberle game model, specifying the operations
 * necessary for managing game states and player interactions.
 */
public interface INumberleModel {
    int MAX_ATTEMPTS = 6; // Maximum number of attempts in the game
    int EQUATION_LENGTH = 7; // Length of the number puzzle
    String GUESS_EQUATIONS_FILE = "equations.txt"; // File name to store guessed equations
    boolean FLAG_SHOW_ERROR_EQUATION = true; // Whether to show incorrect equations


    /**
     * Initializes the game model to a default state ready for a new game.
     * @ensures game state is reset ready for new game interaction
     */
    void initialize();

    /**
     * Processes user input and updates game state accordingly.
     *
     * @param input the user input string
     * @requires input != null
     * @ensures \result == true if input is valid according to game rules
     * @return true if the input is valid, false otherwise
     */
    boolean processInput(String input);

    /**
     * Checks if the game is over, either by reaching the maximum number of attempts
     * or by solving the puzzle.
     *
     * @ensures \result == true if game is won or no attempts remain
     * @return true if the game is over, false otherwise
     */
    boolean isGameOver();

    /**
     * Determines if the game has been won by the player.
     *
     * @ensures \result == true if the current guess equals the target number
     * @return true if the game is won, false otherwise
     */
    boolean isGameWon();

    /**
     * Retrieves the current target number or equation that players are trying to guess.
     *
     * @ensures \result != null
     * @return the string representation of the target number or equation
     */
    String getTargetNumber();

    /**
     * Retrieves the current guess in its string form.
     *
     * @ensures \result != null
     * @return the StringBuilder object representing the current guess equation
     */
    StringBuilder getCurrentGuess();

    /**
     * Retrieves the number of remaining attempts the player has to solve the puzzle.
     *
     * @ensures \result >= 0
     * @return the number of remaining attempts
     */
    int getRemainingAttempts();

    /**
     * Resets the game to its initial state for a new round.
     * @ensures the game is reset to start conditions
     */
    void startNewGame();

    /**
     * Gets the set of grey letters indicating incorrect guesses.
     *
     * @ensures \result != null
     * @return the set of grey letters
     */
    Set<String> getGreyLetters();

    /**
     * Gets the set of yellow letters indicating correct letters in the wrong positions.
     *
     * @ensures \result != null
     * @return the set of yellow letters
     */
    Set<String> getYellowLetters();

    /**
     * Gets the set of green letters indicating correct letters in the correct positions.
     *
     * @ensures \result != null
     * @return the set of green letters
     */
    Set<String> getGreenLetters();
}