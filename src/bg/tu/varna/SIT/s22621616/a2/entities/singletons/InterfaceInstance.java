package bg.tu.varna.SIT.s22621616.a2.entities.singletons;

import bg.tu.varna.SIT.s22621616.a2.entities.normal.User;
import bg.tu.varna.SIT.s22621616.a2.enums.MenuOptions;

import java.util.Objects;
import java.util.Scanner;

public class InterfaceInstance {
    private User user;
    private static InterfaceInstance interfaceInstance;
    private static LibraryInstance libraryInstance;

    public InterfaceInstance() {
        this.user = null;
    }

    public static InterfaceInstance getInstance() {
        if(interfaceInstance == null) {
            interfaceInstance = new InterfaceInstance();
        }

        libraryInstance = LibraryInstance.getInstance();

        return interfaceInstance;
    }

    private boolean logIn(String username, String password) {
        return false;
    }

    public void run(boolean running) {
        while (running) {
            Scanner scanner = new Scanner(System.in);
            String command = "";

            if(scanner.hasNext()){
                command = scanner.nextLine();
            }

            if(command.equalsIgnoreCase(MenuOptions.ADD.name())) {
                libraryInstance.addBooks();
            }

            if(Objects.equals(command.toLowerCase(), MenuOptions.EXIT.name().toLowerCase())) {
                running = false;
            }
        }
    }
}
