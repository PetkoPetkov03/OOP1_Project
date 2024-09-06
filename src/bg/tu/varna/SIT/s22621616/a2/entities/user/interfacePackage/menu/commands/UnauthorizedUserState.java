package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.State;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

import static bg.tu.varna.SIT.s22621616.a2.Application.ANSI_RED;
import static bg.tu.varna.SIT.s22621616.a2.Application.RESET;

public class UnauthorizedUserState implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        System.out.println(ANSI_RED + "Unauthorized user command" + RESET);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public State getState() {
        return this;
    }

    /**
     * Retrieves the importance level of the command.
     *
     * @return The importance level of the command as an Enum.
     */
    @Override
    public Enum<?> getImportance() {
        throw new UnsupportedOperationException();
    }
}
