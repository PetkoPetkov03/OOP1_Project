package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.State;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

public class MenuOpenFilesState implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();

        interfaceInstance.getFileManager().openLibraryDatabase("Library.xml");
        interfaceInstance.getFileManager().openUserDatabaseFile("Users.xml");

        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        libraryInstance.loadBooks();
    }

    /**
     * @return MenuState instance
     */
    @Override
    public State getState() {
        return null;
    }

    @Override
    public Enum<?> getImportance() {
        return null;
    }
}
