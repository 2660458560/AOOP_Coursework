/**
 * The controller class for the Numberle game. This class mediates interactions between the view and the model.
 */
public class NumberleController {
    private final INumberleModel model;

    /**
     * Constructs a controller for managing the Numberle game.
     * @param model The game model this controller will manage.
     * @ensures this.model == model "Ensure the model passed to the constructor is the model associated with this controller."
     */
    public NumberleController(INumberleModel model) {
        this.model = model;
    }

    /**
     * Sets the view for the controller. Currently does not link a specific view component.
     * @todo Implement linking to a specific view component.
     */
    public void setView() {
        // Implementation should assign a view if it becomes necessary
    }

    /**
     * Processes the player's input guess.
     * @param input The player's input guess.
     * @requires input != null "The input string cannot be null."
     * @return True if the input is processed successfully, otherwise false.
     * @ensures \result == !model.processInput(input) "Returns the opposite of the model's processInput method."
     */
    public boolean processInput(String input) {
        return !model.processInput(input);
    }

    /**
     * Checks if the game is over.
     * @return True if the game is over, otherwise false.
     * @ensures \result == model.isGameOver() "The result reflects the state of the game being over from the model."
     */
    public boolean isGameOver() {
        return model.isGameOver();
    }

    /**
     * Checks if the game is won.
     * @return True if the game is won, otherwise false.
     * @ensures \result == model.isGameWon() "The result reflects whether the game has been won based on the model's state."
     */
    public boolean isGameWon() {
        return model.isGameWon();
    }

    /**
     * Gets the target number that the player needs to guess.
     * @return The target number.
     * @ensures \result == model.getTargetNumber() "Returns the current target number from the model."
     */
    public String getTargetEquation() {
        return model.getTargetNumber();
    }

    /**
     * Gets the current guess made by the player.
     * @return The current guess.
     * @ensures \result == model.getCurrentGuess() "Returns the current guess stored in the model."
     */
    public StringBuilder getCurrentGuess() {
        return model.getCurrentGuess();
    }

    /**
     * Gets the number of remaining attempts for the player.
     * @return The number of remaining attempts.
     * @ensures \result == model.getRemainingAttempts() "Returns the number of remaining attempts from the model."
     */
    public int getRemainingAttempts() {
        return model.getRemainingAttempts();
    }

    /**
     * Starts a new game by instructing the model to reset.
     * @ensures model conditions are reset "Ensures the model starts a new game, resetting all necessary attributes."
     */
    public void startNewGame() {
        model.startNewGame();
    }
}
