package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuOptions;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

public class MenuDisplayHelpState implements MenuState {

    private void display() {
        for(MenuOptions menuOption: MenuOptions.values()) {
            System.out.print(Translator.translateEnumToUserString(menuOption) + "\t\t\t");
            System.out.println(menuOption.name());
        }
    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute(User user) {
        display();
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }
}
