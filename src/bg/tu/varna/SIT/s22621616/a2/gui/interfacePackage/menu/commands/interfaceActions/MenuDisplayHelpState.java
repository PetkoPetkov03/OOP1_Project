package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.interfaceActions;

import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.CommandImportance;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.MenuOptions;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;

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
    public void execute(Tokenizer tokenizer, User user) {
        display();
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
