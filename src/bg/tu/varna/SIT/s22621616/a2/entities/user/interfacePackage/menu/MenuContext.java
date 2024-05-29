package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;

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
    public void execute(User user) {
        this.menuState.execute(user);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this.menuState;
    }
}
