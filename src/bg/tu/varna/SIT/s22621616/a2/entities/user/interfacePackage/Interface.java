package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuContext;

public class Interface implements UserInterface {
    private boolean running = true;
    private User user = null;
    private final MenuContext menu = new MenuContext();

    /**
     * Check if the interface should be running
     *
     * @return Interface running
     */
    @Override
    public boolean isRunning() {
        return this.running;
    }

    /**
     * Set the state of the interface
     *
     * @param running gets the current value of the state of the interface
     */
    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Fetch Menu
     *
     * @return Interface userMenu
     */
    @Override
    public MenuContext getMenu() {
        return this.menu;
    }

    /**
     * Fetch user
     *
     * @return Interface user
     */
    @Override
    public User getUser() {
        return this.user;
    }

    /**
     * Set the current user
     */
    @Override
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the library instance through Interface
     *
     * @return Interface libraryInstance
     */
    @Override
    public LibraryInstance getLibraryInstance() {
        return null;
    }
}
