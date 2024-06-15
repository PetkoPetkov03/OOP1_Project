package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

public class MenuSortBooksState implements MenuState {

    private void sort(Tokenizer tokenizer, User user) {
        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        libraryInstance.sort();
    }

    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        sort(tokenizer, user);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }

    @Override
    public int getImportance() {
        throw new UnsupportedOperationException("Importance is not assigned to a state action");
    }
}
