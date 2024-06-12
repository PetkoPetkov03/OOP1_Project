package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;

public class MenuContext implements MenuState {
    private MenuState menuState;

    public void setMenuState(MenuOptions option) {
        if (option == null) {
            throw new NullPointerException("No such command found!");
        }

        this.menuState = option.getState();
    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        this.menuState.execute(tokenizer, user);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this.menuState;
    }
}
