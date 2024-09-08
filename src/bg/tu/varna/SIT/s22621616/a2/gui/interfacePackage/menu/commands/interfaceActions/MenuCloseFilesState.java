package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.interfaceActions;

import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;

public class MenuCloseFilesState implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
        interfaceInstance.getFileManager().close();
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
