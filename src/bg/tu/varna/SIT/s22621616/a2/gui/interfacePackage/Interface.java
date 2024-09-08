package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage;

import bg.tu.varna.SIT.s22621616.a2.api.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuContext;

/**
 * The Interface class implements the {@link UserInterface} and manages the main control flow of the application.
 * It holds the current user session, menu context, and controls whether the interface is running.
 */
public class Interface implements UserInterface {

    /**
     * Indicates whether the interface is currently running.
     */
    private boolean running = true;

    /**
     * The current user interacting with the interface.
     */
    private User user;

    /**
     * The context for managing menus and their states.
     */
    private final MenuContext menu = new MenuContext();

    /**
     * Checks if the interface is currently running.
     *
     * @return {@code true} if the interface is running, {@code false} otherwise.
     */
    @Override
    public boolean isRunning() {
        return this.running;
    }

    /**
     * Sets the running state of the interface.
     *
     * @param running A boolean indicating the new running state of the interface.
     */
    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Retrieves the current menu context for the interface.
     *
     * @return The {@link MenuContext} used by the interface.
     */
    @Override
    public MenuContext getMenu() {
        return this.menu;
    }

    /**
     * Retrieves the current user interacting with the interface.
     *
     * @return The {@link User} object representing the current user.
     */
    @Override
    public User getUser() {
        return this.user;
    }

    /**
     * Sets the current user for the interface session.
     *
     * @param user The {@link User} to set as the current user.
     */
    @Override
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the library instance through the interface.
     * This operation is currently unsupported and will throw an exception if invoked.
     *
     * @return This method does not return a value, as it always throws an exception.
     * @throws UnsupportedOperationException when this method is called, indicating that the operation is not supported.
     */
    @Override
    public LibraryInstance getLibraryInstance() {
        throw new UnsupportedOperationException("Unusable operation!");
    }

}
