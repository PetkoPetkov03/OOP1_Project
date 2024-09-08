package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands;

import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;

import static bg.tu.varna.SIT.s22621616.a2.Application.ANSI_RED;
import static bg.tu.varna.SIT.s22621616.a2.Application.RESET;

public class ThrowableState extends AbstractThrowableState {
    public ThrowableState(String output) {
        super(output);
    }

    @Override
    public State getState() {
        return this;
    }

    @Override
    public Enum<?> getImportance() {
        return null;
    }

    @Override
    public void execute(Tokenizer tokenizer, User user) {
        System.out.println(ANSI_RED + getOutput() + RESET);
    }
}
