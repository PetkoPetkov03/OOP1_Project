package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.CommandImportance;

import java.util.List;

public class MenuBookInfo implements MenuState {
    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        List<String> inputs = tokenizer.getInputs();

        if(inputs.size() != 1) {
            throw new RuntimeException("empty token list or wrong number of tokens");
        }

        libraryInstance.bookInfo(inputs.getFirst(), user);
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
