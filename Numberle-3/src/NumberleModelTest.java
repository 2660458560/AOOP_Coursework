// Importing the necessary classes for JUnit testing

import org.junit.Test;

import java.util.Set;   // Importing the Set interface

import static org.junit.Assert.*;


public class NumberleModelTest {
    /**
     * Test to verify that valid input is processed correctly.
     * Ensures that valid inputs lead to correct game state updates.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures model.processInput returns true
     */
    @Test
    public void processInput_ValidInput_Test1() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing valid input
        boolean processInput = model.processInput("1+2=3-0");
        assertTrue("Valid input should return true", processInput);   // Asserting that processing valid input returns true// Asserting that the game is won after correct input
    }

    /**
     * Test to verify that valid input is processed correctly.
     * Ensures that valid inputs lead to correct game state updates.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures model.processInput returns true
     */
    @Test
    public void processInput_ValidInput_Test2() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing valid input
        boolean processInput = model.processInput("1+21=22");
        assertTrue("Valid input should return true", processInput);   // Asserting that processing valid input returns true// Asserting that the game is won after correct input
    }

    /**
     * Test to verify that invalid input is correctly identified.
     * Ensures that invalid inputs are properly rejected without altering game-winning state.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures model.processInput returns false
     */
    @Test
    public void processInput_InvalidInput_Test1() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing invalid input
        boolean processInput = model.processInput("1+2=3-1");
        assertFalse("Invalid input should return false", processInput);   // Asserting that processing invalid input returns false
    }

    /**
     * Test to verify that invalid input is correctly identified.
     * Ensures that invalid inputs are properly rejected without altering game-winning state.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures model.processInput returns false
     */
    @Test
    public void processInput_InvalidInput_Test2() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing invalid input
        boolean processInput = model.processInput("1/0+5==");
        assertFalse("Invalid input should return false", processInput);   // Asserting that processing invalid input returns false
    }

    @Test
    public void gameWon_Test() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Get target number
        String targetNumber = model.getTargetNumber();
        // Testing game won
        model.processInput(targetNumber);// Processing valid input
        assertTrue("Game should be won after correct input", model.isGameWon());   // Asserting that the game is won after correct input
    }

    /**
     * Test to confirm that the game does not prematurely indicate an over state.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures game is not over immediately after initialization
     */
    @Test
    public void isGameOver_GameNotOver_Test() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing game not over
        assertFalse("Game should not be over at the start", model.isGameOver());   // Asserting that the game is not over at the start
    }

    /**
     * Test that the game correctly handles game over after the maximum number of attempts.
     */
    @Test
    public void testGameOverAfterMaxAttempts() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model
        model.FLAG_RANDOM_SELECT = false;   // Setting the random selection flag to false
        for (int i = 0; i < 6; i++) {
            model.processInput("1+2=3+0");  // Incorrect guesses, each decrementing the attempt counter
        }
        assertEquals("No attempts left", 0, model.getRemainingAttempts());
        assertTrue("Game should be over after the maximum number of attempts", model.isGameOver());

    }

    /**
     * Test to ensure the set of grey letters is empty upon initialization.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures the initial set of grey letters is empty
     */
    @Test
    public void getGreyLetters_Test() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing grey letters
        Set<String> greyLetters = model.getGreyLetters();   // Getting the set of grey letters from the model
        System.out.println("greyLetters: " + greyLetters);
        assertTrue("Grey letters should be empty at initialization", greyLetters.isEmpty());   // Asserting that the set of grey letters is empty at initialization
    }

    /**
     * Test to ensure the set of yellow letters is empty upon initialization.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures the initial set of yellow letters is empty
     */
    @Test
    public void getYellowLetters_Test() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing yellow letters
        Set<String> yellowLetters = model.getYellowLetters();   // Getting the set of yellow letters from the model
        System.out.println("yellowLetters: " + yellowLetters);
        assertTrue("Yellow letters should be empty at initialization", yellowLetters.isEmpty());   // Asserting that the set of yellow letters is empty at initialization
    }

    /**
     * Test to ensure the set of green letters is empty upon initialization.
     *
     * @requires an initialized instance of NumberleModel
     * @ensures the initial set of green letters is empty
     */
    @Test
    public void getGreenLetters_Test() {
        NumberleModel model = new NumberleModel();   // Creating an instance of the NumberleModel class
        model.initialize();   // Initializing the model

        // Testing green letters
        Set<String> greenLetters = model.getGreenLetters();   // Getting the set of green letters from the model
        System.out.println("greenLetters: " + greenLetters);
        assertTrue("Green letters should be empty at initialization", greenLetters.isEmpty());   // Asserting that the set of green letters is empty at initialization
    }
}