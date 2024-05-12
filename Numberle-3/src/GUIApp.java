import javax.swing.*;

/**
 * A GUI application that creates and displays the Numberle game GUI.
 * This class is responsible for setting up the GUI environment,
 * initializing the game model, controller, and view components.
 */
public class GUIApp {

    /**
     * The entry point of the GUIApp application.
     * This method schedules the application GUI to be created and shown in the Event Dispatch Thread (EDT),
     * ensuring thread safety for the GUI components.
     *
     * @param args The command-line arguments, not used in this application.
     * @ensures the GUI is initialized and displayed safely within the EDT
     *          "Ensures that all GUI components are created on the proper thread for thread safety."
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIApp::createAndShowGUI);
    }

    /**
     * Creates and shows the Numberle game GUI.
     * This method sets up the main components necessary for the game's GUI,
     * including the model, controller, and view. It ensures proper initialization,
     * linking of the components, and displays the GUI.
     *
     * @ensures model is not null "Ensures that the model is initialized and ready for the game."
     * @ensures controller != null "Ensures that the controller is initialized and linked to the model."
     * @ensures view != null "Ensures that the view is initialized, linked to both the model and controller, and ready to display the game."
     * @ensures the GUI is visible "Ensures that the GUI is visible on screen and components are correctly laid out."
     */
    public static void createAndShowGUI() {
        // Initialize the model component of the game
        INumberleModel model = new NumberleModel();

        // Initialize the controller component, linking it with the model
        NumberleController controller = new NumberleController(model);

        // Initialize the view component, linking it with both the model and the controller
        // and ensuring that the view can respond to user inputs and model updates.
        NumberleView view = new NumberleView(model, controller);

    }
}
