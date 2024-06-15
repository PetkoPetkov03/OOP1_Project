package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.Command;

public interface State extends Command {
    /**
     * @return MenuState instance
     */
    MenuState getState();
}
