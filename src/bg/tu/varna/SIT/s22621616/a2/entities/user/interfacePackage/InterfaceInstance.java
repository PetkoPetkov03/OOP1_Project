package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuContext;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuOptions;

import java.util.Scanner;

public class InterfaceInstance {
    private boolean running = true;
    private User user;
    private static InterfaceInstance interfaceInstance;
    private MenuContext menu = new MenuContext();
    private static LibraryInstance libraryInstance;

    public InterfaceInstance() {
        this.user = null;
    }

    public static InterfaceInstance getInstance() {
        if (interfaceInstance == null) {
            interfaceInstance = new InterfaceInstance();
        }

        libraryInstance = LibraryInstance.getInstance();
        return interfaceInstance;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static InterfaceInstance getInterfaceInstance() {
        return interfaceInstance;
    }

    public MenuContext getMenu() {
        return menu;
    }

    public void setMenu(MenuContext menu) {
        this.menu = menu;
    }

    public static LibraryInstance getLibraryInstance() {
        return libraryInstance;
    }

    public void run() {
        while (isRunning()) {
            Scanner scanner = new Scanner(System.in);

            if(!scanner.hasNext()) {
                throw new NullPointerException("Couldn't find a command!");
            }

            getMenu().setMenuState(Translator.translateUserStringToEnum(MenuOptions.class, scanner.nextLine()));

            getMenu().execute();
        }
    }
}
