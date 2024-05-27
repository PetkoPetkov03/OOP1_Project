package bg.tu.varna.SIT.s22621616.a2.entities.user.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.library.Book;
import bg.tu.varna.SIT.s22621616.a2.entities.library.LibraryInstance;

public class Menu {
    private MenuOptions option;

    private  MenuOptions convertOption(String option) {
        if (option == null) {
            System.out.println("Option provided is null");
            return null;
        }

        MenuOptions finalMenuOption = null;
        System.out.println("Available MenuOptions: ");
        for (MenuOptions menuOption : MenuOptions.values()) {
            System.out.println(menuOption.name());
            if (option.equalsIgnoreCase(menuOption.name())) {
                finalMenuOption = menuOption;
                break;
            }
        }

        return finalMenuOption;
    }

    public void setOption(String option) {
        MenuOptions mOption = convertOption(option);

        if (mOption == null) {
            throw new NullPointerException("No such command found!");
        }

        this.option = mOption;
    }

    public MenuOptions getOption() {
        return option;
    }

    private void exit(InterfaceInstance interfaceInstance) {
        interfaceInstance.setRunning(!interfaceInstance.isRunning());
    }

    private String translate(MenuOptions menuOption) {
        String translation;

        translation = menuOption.name().replace("_", " ");

        return translation;
    }

    public void display() {
        for(MenuOptions menuOption: MenuOptions.values()) {

            System.out.print(translate(menuOption) + "\t\t\t");
            System.out.println(menuOption.name());
        }
    }

    private void addBook() {
        Book book = new Book().userFill();

        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        libraryInstance.addBooks(book);

    }

    public void execute()  {
        switch (getOption()) {
            case ADD_A_BOOK -> addBook();
            case SHOW -> LibraryInstance.getInstance().displayBooks();
            case EXIT -> exit(InterfaceInstance.getInterfaceInstance());
        }
    }
}
