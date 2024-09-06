package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.userActions;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.State;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.Authorization;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.files.FileManager;
import bg.tu.varna.SIT.s22621616.a2.files.XMLLibParser;

import java.awt.desktop.UserSessionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
