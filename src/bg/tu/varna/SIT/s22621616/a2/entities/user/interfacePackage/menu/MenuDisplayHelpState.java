package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Translator;

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
    public void execute() {
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
