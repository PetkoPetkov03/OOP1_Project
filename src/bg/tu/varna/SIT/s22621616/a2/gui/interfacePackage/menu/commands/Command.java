package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands;

/**
 * Command interface represents a command that can be executed in a menu system.
 */
public interface Command {
    /**
     * Retrieves the importance level of the command.
     *
     * @return The importance level of the command as an Enum.
     */
    Enum<?> getImportance();
}
