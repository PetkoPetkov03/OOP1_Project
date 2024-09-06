package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands;

import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

public abstract class AbstractThrowableState implements MenuState {
    private final String output;

    public AbstractThrowableState(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
