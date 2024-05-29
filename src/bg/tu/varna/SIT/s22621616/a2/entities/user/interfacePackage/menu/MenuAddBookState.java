package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.library.Book;
import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;

public class MenuAddBookState implements MenuState {

    /**
     * add a book to the library by asking the user for input
     */
    private void addBook() {
        Book book = new Book().userFill();

        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        libraryInstance.addBooks(book);

    }

    /**
     * execute command depending on the menu state.
     */
    @Override
    public void execute() {
        addBook();
    }

    /**
     * @return MenuState instance
     */
    @Override
    public MenuState getState() {
        return this;
    }
}
