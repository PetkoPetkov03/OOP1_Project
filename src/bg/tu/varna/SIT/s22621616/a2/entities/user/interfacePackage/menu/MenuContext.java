package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.MenuOptions;

public class MenuContext {
    private MenuState menuState;

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
