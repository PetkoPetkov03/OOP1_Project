package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.userActions;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.database.FileManager;
import bg.tu.varna.SIT.s22621616.a2.database.XMLLibParser;

import java.io.File;
import java.util.List;

public class RemoveUserState implements MenuState {
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        List<String> inputs = tokenizer.getInputs();
        if (inputs.isEmpty()) {
            System.out.println(Application.ANSI_RED + "No username provided. Please specify a username to remove." + Application.RESET);
            return;
        }

        String usernameToRemove = inputs.getFirst();


        FileManager fileManager = InterfaceInstance.getInstance().getFileManager();
        File userFile = fileManager.getDatabases().mainArg();

        boolean userRemoved = XMLLibParser.removeUserFromXML(userFile, usernameToRemove);

        if (userRemoved) {
            System.out.println("User '" + usernameToRemove + "' has been successfully removed.");
        } else {
            System.out.println(Application.ANSI_RED + "User '" + usernameToRemove + "' not found." + Application.RESET);
        }
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
        throw new UnsupportedOperationException("Importance is not assigned to a state action");
    }
}
