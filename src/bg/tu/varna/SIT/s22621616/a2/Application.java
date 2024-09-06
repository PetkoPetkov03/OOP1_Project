package bg.tu.varna.SIT.s22621616.a2;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;

/**
 * The Application class serves as the entry point for running the program.
 * It initializes an instance of {@link InterfaceInstance} and starts its execution.
 */
public class Application {

    /**
     * ANSI escape code for green text formatting.
     */
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * ANSI escape code for red text formatting.
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * ANSI escape code to reset text formatting.
     */
    public static final String RESET = "\033[0m";

    /**
     * The main method that serves as the entry point for the application.
     * It retrieves a singleton instance of {@link InterfaceInstance} and calls its {@code run} method to start the program.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
        interfaceInstance.run();
    }
}
