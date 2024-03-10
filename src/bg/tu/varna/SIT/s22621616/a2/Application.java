package bg.tu.varna.SIT.s22621616.a2;

import bg.tu.varna.SIT.s22621616.a2.Entities.Builders.Library;
import bg.tu.varna.SIT.s22621616.a2.Entities.Builders.Book;
import bg.tu.varna.SIT.s22621616.a2.Entities.Singletons.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.Enums.Genre;
import bg.tu.varna.SIT.s22621616.a2.Enums.Keywords;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {

        LibraryInstance libraryInstance = LibraryInstance.getInstance();

        Book book = new Book.Builder("Petko Petkov","Heya", Genre.ADVENTURE, "soso", 2013, "adfaf32").build();

        libraryInstance.getLibrary().addBook(book);

        libraryInstance.getLibrary().printBooks();
    }
}