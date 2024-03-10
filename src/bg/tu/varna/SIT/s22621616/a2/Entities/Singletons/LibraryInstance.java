package bg.tu.varna.SIT.s22621616.a2.Entities.Singletons;

import bg.tu.varna.SIT.s22621616.a2.Entities.Builders.Book;
import bg.tu.varna.SIT.s22621616.a2.Entities.Builders.Library;

import java.util.HashMap;

public class LibraryInstance {
    private static LibraryInstance instance;
    private final Library library;

    private LibraryInstance(){
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
}
