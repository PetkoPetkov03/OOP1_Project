package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;

public class MenuDisplayBooksState implements MenuState {

    public void display() {
        LibraryInstance.getInstance().displayBooks();
    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute() {
        display();
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }
}
