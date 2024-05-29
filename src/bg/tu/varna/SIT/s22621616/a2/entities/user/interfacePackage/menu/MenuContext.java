package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

public class MenuContext implements MenuState {
    private MenuState menuState;

    private  MenuState convertOption(String option) {
        if (option == null) {
            System.out.println("Option provided is null");
            return null;
        }

        MenuState finalMenuOption = null;
        System.out.println("Available MenuOptions: ");
        for (MenuOptions menuOption : MenuOptions.values()) {
            if (option.equalsIgnoreCase(menuOption.name())) {
                finalMenuOption = menuOption.getState();
                break;
            }
        }

        return finalMenuOption;
    }

    public void setMenuState(String option) {

        MenuState mOption = convertOption(option);

        if (mOption == null) {
            throw new NullPointerException("No such command found!");
        }

        this.menuState = mOption;
    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute() {
        this.menuState.execute();
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this.menuState;
    }
}
