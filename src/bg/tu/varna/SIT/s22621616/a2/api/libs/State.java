package bg.tu.varna.SIT.s22621616.a2.api.libs;

import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.Command;

/**
 * Represents a state in a command pattern, extending the Command interface.
 * This interface defines a method to retrieve the current menu state.
 */
public interface State extends Command {
    /**
     * Retrieves the current MenuState instance associated with this state.
     *
     * @return The current MenuState instance.
     */
    State getState();
}
