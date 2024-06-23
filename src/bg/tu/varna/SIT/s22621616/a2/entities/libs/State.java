package bg.tu.varna.SIT.s22621616.a2.entities.libs;

import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.Command;

public interface State extends Command {
    /**
     * @return MenuState instance
     */
    State getState();
}
