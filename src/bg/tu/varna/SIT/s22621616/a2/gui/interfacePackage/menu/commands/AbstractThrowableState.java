package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands;

import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;

public abstract class AbstractThrowableState implements MenuState {
    private final String output;

    public AbstractThrowableState(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
