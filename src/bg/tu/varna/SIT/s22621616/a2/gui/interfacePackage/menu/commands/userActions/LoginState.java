package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.userActions;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.api.database.XMLLibParser;

import java.util.List;

public class LoginState implements MenuState {

    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
        if(interfaceInstance.getUser() != null) {
            System.out.println("Already logged in!");
            return;
        }
        List<String> inputs = tokenizer.getInputs();
        if(inputs.size() < 2) {
            System.out.println(Application.ANSI_RED + "Not enough inputs" + Application.RESET);
            return;
        }
        String username = inputs.getFirst();
        String password = inputs.getLast();

        List<User> users = XMLLibParser.parseUsersXML(interfaceInstance.getFileManager().getDatabases().mainArg());

        for(User xmlUser : users) {
            if(xmlUser.getUsername().equals(username) && xmlUser.getPassword().equals(password)) {
                User loggedUser = new User(xmlUser.getUsername(), xmlUser.getPassword(), xmlUser.getAuthorization());
                interfaceInstance.setUser(loggedUser);
                return;
            }
        }

        System.out.println(Application.ANSI_RED + "User dosen't exist!" + Application.RESET);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public State getState() {
        return this;
    }

    @Override
    public Enum<?> getImportance() {
        throw new UnsupportedOperationException("Importance is not assigned to a state action");
    }
}
