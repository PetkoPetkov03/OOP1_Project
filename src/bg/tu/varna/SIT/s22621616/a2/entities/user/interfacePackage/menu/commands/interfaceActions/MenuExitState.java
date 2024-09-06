package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.CommandImportance;

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
    public void execute(Tokenizer tokenizer, User user) {
        System.out.println(Application.ANSI_GREEN + "Exiting program..." + Application.RESET);
        exit();
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
