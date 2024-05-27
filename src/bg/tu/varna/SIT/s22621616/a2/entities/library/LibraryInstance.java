package bg.tu.varna.SIT.s22621616.a2.entities.library;

import java.util.HashMap;

public class LibraryInstance {
    private static LibraryInstance instance;
    private final Library library;

    LibraryInstance(){
        library = new Library(new HashMap<String, Book>());
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

    public boolean addBooks(Book interfaceResponse) {

        boolean response = getLibrary().addBook(interfaceResponse);

        return response;
    }

    public void displayBooks() {
        getLibrary().printBooks();
    }
}
