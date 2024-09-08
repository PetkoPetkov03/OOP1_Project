package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.userActions;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.Authorization;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.database.FileManager;
import bg.tu.varna.SIT.s22621616.a2.database.XMLLibParser;

import java.util.List;
import java.util.Objects;

public class RegisterState implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        List<String> inputs = tokenizer.getInputs();
        if(inputs.size() < 2) {
            System.out.println(Application.ANSI_RED + "Not enough inputs" + Application.RESET);
            return;
        }
        String username = tokenizer.getInputs().getFirst();
        String password = tokenizer.getInputs().getLast();
        Authorization authorization = Authorization.BASIC;

        if(user.getAuthorization().equals(Authorization.ADMIN)) {
            String authInput = tokenizer.getInputs().get(1);
            if(Objects.equals(Translator.translateUserStringToEnum(Authorization.class, authInput), Authorization.ADMIN)) {
                authorization = Authorization.ADMIN;
            }
        }


        FileManager fileManager = InterfaceInstance.getInstance().getFileManager();


        List<User> registeredUsers = XMLLibParser.parseUsersXML(fileManager.getDatabases().mainArg());
        System.out.println(registeredUsers.toString());
        User registeredUser = new User(username, password, authorization);

        registeredUsers.add(registeredUser);

        XMLLibParser.addUserToXML(fileManager.getDatabases().mainArg(), registeredUser);
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
