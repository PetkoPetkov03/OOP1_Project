package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.MenuOptions;

/**
 * The MenuContext class manages the current state of the menu system.
 * It holds the active menu state and provides methods to set the state,
 * execute commands based on the current state, and retrieve the current
 * menu state. This class facilitates the interaction between the user
 * input and the corresponding menu actions.
 */
public class MenuContext {
    private MenuState menuState;
    public static String GlobalError;

    public void setMenuState(MenuOptions option) {
        if (option == null) {
            throw new NullPointerException("No such command found!");
        }

        this.menuState = (MenuState) option.getState();
    }

    /**
     * execute command depending on the menu state.
     */
    public void execute(Tokenizer tokenizer, User user) {
        this.menuState.execute(tokenizer, user);
    }

    /**
     * @return MenuState instance
     */
    public MenuState getState() {
        return this.menuState;
    }
}
