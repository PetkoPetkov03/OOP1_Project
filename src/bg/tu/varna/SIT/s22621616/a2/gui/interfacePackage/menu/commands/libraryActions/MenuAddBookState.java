package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.libraryActions;

import bg.tu.varna.SIT.s22621616.a2.api.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.CommandImportance;

public class MenuAddBookState implements MenuState {

    /**
     * add a book to the library by asking the user for input
     */
    private void addBook(User user) {
        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        libraryInstance.addBook(user);
    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        addBook(user);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }

    @Override
    public CommandImportance getImportance() {
        throw new UnsupportedOperationException("Importance is not assigned to a state action");
    }
}
