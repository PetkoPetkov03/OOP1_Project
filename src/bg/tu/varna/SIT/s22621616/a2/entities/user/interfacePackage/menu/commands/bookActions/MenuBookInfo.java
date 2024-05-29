package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;

public class MenuBookInfo implements MenuState {
    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute(User user) {
        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        libraryInstance.bookInfo(user);
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }
}
