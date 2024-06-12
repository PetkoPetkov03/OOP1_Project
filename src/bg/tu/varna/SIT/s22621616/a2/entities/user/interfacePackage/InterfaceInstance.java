package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuContext;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuOptions;

import java.util.Scanner;

public class InterfaceInstance implements UserInterface {
    private static InterfaceInstance interfaceInstance;
    private final Interface userInterface;


    public Interface getUserInterface() {
        return userInterface;
    }

    private InterfaceInstance() {
        this.userInterface = new Interface();
    }

    public static InterfaceInstance getInstance() {
        if (interfaceInstance == null) {
            interfaceInstance = new InterfaceInstance();
        }

        return interfaceInstance;
    }

    public void run() {
        while (isRunning()) {
            Tokenizer tokenizer = new Tokenizer();
            Scanner scanner = new Scanner(System.in);

            if(!scanner.hasNext()) {
                throw new NullPointerException("Couldn't find a command!");
            }

            tokenizer.parse(scanner.nextLine());
            getMenu().setMenuState(tokenizer.getOption());

            getMenu().execute(tokenizer, getUser());
        }
    }

    /**
     * Check if the interface should be running
     *
     * @return Interface running
     */
    @Override
    public boolean isRunning() {
        return getUserInterface().isRunning();
    }

    /**
     * Set the state of the interface
     *
     * @param running gets the current value of the state of the interface
     */
    @Override
    public void setRunning(boolean running) {
        getUserInterface().setRunning(!isRunning());
    }

    /**
     * Fetch Menu
     *
     * @return Interface userMenu
     */
    @Override
    public MenuContext getMenu() {
        return getUserInterface().getMenu();
    }

    /**
     * Fetch user
     *
     * @return Interface user
     */
    @Override
    public User getUser() {
        return getUserInterface().getUser();
    }

    /**
     * Set the current user
     *
     * @param user
     */
    @Override
    public void setUser(User user) {
        getUserInterface().setUser(user);
    }

    /**
     * Get the library instance through Interface
     *
     * @return Interface libraryInstance
     */
    @Override
    public LibraryInstance getLibraryInstance() {
        return getUserInterface().getLibraryInstance();
    }
}
