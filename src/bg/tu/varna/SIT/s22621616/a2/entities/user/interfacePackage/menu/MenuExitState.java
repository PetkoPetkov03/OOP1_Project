package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;

public class MenuExitState implements MenuState {

    /**
     * tell the interface to exit from the program
     */
    private void exit() {
        InterfaceInstance instance = InterfaceInstance.getInstance();
        instance.setRunning(!instance.isRunning());
    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute() {
        exit();
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }
}
