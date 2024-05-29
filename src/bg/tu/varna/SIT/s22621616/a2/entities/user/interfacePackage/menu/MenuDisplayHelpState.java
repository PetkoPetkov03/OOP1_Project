package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

public class MenuDisplayHelpState implements MenuState {

    private String translate(MenuOptions menuOption) {
        String translation;

        translation = menuOption.name().replace("_", " ");

        return translation;
    }

    public void display() {
        for(MenuOptions menuOption: MenuOptions.values()) {
            System.out.print(translate(menuOption) + "\t\t\t");
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
