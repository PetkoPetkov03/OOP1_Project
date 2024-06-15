package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;

import java.util.HashMap;

public class LibraryInstance {
    private static LibraryInstance instance;
    private final Library library;

    LibraryInstance(){
        library = new Library(new HashMap<String, BookStructure>());
    }

    public static LibraryInstance getInstance() {
        if (instance == null) {
            instance = new LibraryInstance();
        }
        return instance;
    }

    public Library getLibrary() {
        return library;
    }

    public void addBook(User user) {
        getLibrary().addBook(user);
    }

    public void bookInfo(String id, User user) {
        getLibrary().bookInfo(id, user);
    }

    public void displayBooks() {
        getLibrary().printBooks();
    }

    public void sort() {
        getLibrary().sort();
    }
}
