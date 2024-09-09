package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.libraryActions;

import bg.tu.varna.SIT.s22621616.a2.api.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.CommandImportance;

public class MenuFindBookByPerimeter implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        LibraryInstance.getInstance().findBooksByParameter(tokenizer);
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
