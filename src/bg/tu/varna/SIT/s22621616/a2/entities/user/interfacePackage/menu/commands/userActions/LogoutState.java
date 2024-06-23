package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.userActions;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.State;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

public class LogoutState implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();

        interfaceInstance.setUser(null);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public State getState() {
        return this;
    }

    @Override
    public Enum<?> getImportance() {
        throw new UnsupportedOperationException("Importance is not assigned to a state action");
    }
}
