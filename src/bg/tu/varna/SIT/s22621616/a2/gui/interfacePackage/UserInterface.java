package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage;

import bg.tu.varna.SIT.s22621616.a2.api.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuContext;

public interface UserInterface {
    /**
     * Check if the interface should be running
     * @return Interface running
     */
    boolean isRunning();

    /**
     * Set the state of the interface
     * @param running gets the current value of the state of the interface
     */
    void setRunning(boolean running);

    /**
     * Fetch Menu
     * @return Interface userMenu
     */
    MenuContext getMenu();

    /**
     * Fetch user
     * @return Interface user
     */
    User getUser();

    /**
     * Set the current user
     */
    void setUser(User user);

    /**
     * Get the library instance through Interface
     * @return Interface libraryInstance
     */
    LibraryInstance getLibraryInstance();
}
