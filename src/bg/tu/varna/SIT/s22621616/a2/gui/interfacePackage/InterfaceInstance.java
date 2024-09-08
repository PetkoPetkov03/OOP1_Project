package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage;

import bg.tu.varna.SIT.s22621616.a2.api.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuContext;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.MenuOptions;
import bg.tu.varna.SIT.s22621616.a2.api.database.FileManager;

import java.util.Scanner;

/**
 * The InterfaceInstance class is a singleton implementation of the {@link UserInterface}.
 * It serves as a mediator between the user, the interface, and the system, providing methods to handle user commands and interface behavior.
 */
public class InterfaceInstance implements UserInterface {

    /**
     * The single instance of InterfaceInstance to enforce the singleton pattern.
     */
    private static InterfaceInstance interfaceInstance;

    /**
     * The user interface instance that handles the interaction between the user and the system.
     */
    private final Interface userInterface;

    /**
     * The tokenizer responsible for parsing user input into commands.
     */
    private final Tokenizer tokenizer = new Tokenizer();

    /**
     * The scanner used for reading user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * The file manager responsible for managing file-based databases.
     */
    private final FileManager fileManager = new FileManager();

    /**
     * Private constructor to enforce singleton pattern.
     * Initializes the user interface and loads necessary databases.
     */
    private InterfaceInstance() {
        this.userInterface = new Interface();
        this.fileManager.openLibraryDatabase("Library.xml");
        this.fileManager.openUserDatabaseFile("Users.xml");
    }

    /**
     * Returns the singleton instance of InterfaceInstance.
     * If no instance exists, a new one is created.
     *
     * @return The singleton instance of {@link InterfaceInstance}.
     */
    public static InterfaceInstance getInstance() {
        if (interfaceInstance == null) {
            interfaceInstance = new InterfaceInstance();
        }
        return interfaceInstance;
    }

    /**
     * Retrieves the user interface instance.
     *
     * @return The current {@link Interface} instance.
     */
    public Interface getUserInterface() {
        return userInterface;
    }

    /**
     * Runs the interface instance in a loop, processing user input and executing commands.
     * Continues until the system indicates it should stop running.
     *
     * @throws NullPointerException If no command is found in the user input.
     */
    public void run() {
        while (isRunning()) {
            System.out.print("Use Primary command: ");
            if (!scanner.hasNext()) {
                throw new NullPointerException("Couldn't find a command!");
            }

            tokenizer.parse(scanner.nextLine());
            if (tokenizer.isEmCleared()) {
                System.out.println("test1");
                continue;
            }

            MenuOptions men = tokenizer.getCommand();
            if (men == null) {
                men = MenuOptions.THROWABLE_STATE;
                MenuContext.GlobalError = "Primary command not found!";
                tokenizer.clear(false);
            }
            getMenu().setMenuState(men);
            if (tokenizer.isEmCleared()) {
                System.out.println("test3");
                continue;
            }

            getMenu().execute(tokenizer, getUser());
            if (tokenizer.isEmCleared()) {
                continue;
            }

            tokenizer.clear(false);
            scanner.reset();
        }
    }

    /**
     * Checks if the interface is still running.
     *
     * @return {@code true} if the interface is running, {@code false} otherwise.
     */
    @Override
    public boolean isRunning() {
        return getUserInterface().isRunning();
    }

    /**
     * Sets the running state of the interface.
     *
     * @param running A boolean indicating the new running state of the interface.
     */
    @Override
    public void setRunning(boolean running) {
        getUserInterface().setRunning(running);
    }

    /**
     * Retrieves the current menu context from the user interface.
     *
     * @return The {@link MenuContext} instance associated with the interface.
     */
    @Override
    public MenuContext getMenu() {
        return getUserInterface().getMenu();
    }

    /**
     * Retrieves the current user from the user interface.
     *
     * @return The {@link User} instance representing the current user.
     */
    @Override
    public User getUser() {
        return getUserInterface().getUser();
    }

    /**
     * Sets the current user in the user interface.
     *
     * @param user The {@link User} to set as the current user.
     */
    @Override
    public void setUser(User user) {
        getUserInterface().setUser(user);
    }

    /**
     * Retrieves the library instance from the user interface.
     *
     * @return The {@link LibraryInstance} managed by the interface.
     */
    @Override
    public LibraryInstance getLibraryInstance() {
        return getUserInterface().getLibraryInstance();
    }

    /**
     * Retrieves the file manager responsible for file-based operations.
     *
     * @return The {@link FileManager} instance.
     */
    public FileManager getFileManager() {
        return fileManager;
    }
}
