package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;

public interface MenuState extends State {
    /**
     * execute command depending on the menu state.
     */
    void execute(Tokenizer tokenizer, User user);
}
