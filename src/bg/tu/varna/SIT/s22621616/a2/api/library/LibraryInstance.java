package bg.tu.varna.SIT.s22621616.a2.api.library;

import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.api.database.FileManager;
import bg.tu.varna.SIT.s22621616.a2.api.database.XMLLibParser;

import java.io.File;
import java.util.ArrayList;

/**
 * The LibraryInstance class is a singleton that provides access to a Library object,
 * allowing management of books and their information.
 */
public class LibraryInstance {
    private static LibraryInstance instance;
    private final Library library;

    /**
     * Private constructor for LibraryInstance.
     * Initializes the library with an empty list of books.
     */
    LibraryInstance() {
        library = new Library(new ArrayList<>());
    }

    /**
     * Gets the singleton instance of LibraryInstance.
     *
     * @return The single instance of LibraryInstance.
     */
    public static LibraryInstance getInstance() {
        if (instance == null) {
            instance = new LibraryInstance();
        }
        return instance;
    }

    /**
     * Gets the Library object associated with this instance.
     *
     * @return The Library object.
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Adds a book to the library based on user input.
     *
     * @param user The user adding the book.
     */
    public void addBook(User user) {
        getLibrary().addBook(user);
    }

    /**
     * Retrieves information about a book based on its ID.
     *
     * @param id   The ID of the book.
     * @param user The user requesting the book information.
     */
    public void bookInfo(String id, User user) {
        getLibrary().bookInfo(id, user);
    }

    /**
     * Displays all books in the library.
     */
    public void displayBooks() {
        getLibrary().printBooks();
    }

    /**
     * Sorts the books in the library based on user-defined parameters.
     *
     * @param tokenizer The tokenizer containing the sorting parameters.
     */
    public void sort(Tokenizer tokenizer) {
        getLibrary().sort(tokenizer);
    }

    /**
     * Finds and displays books based on the specified parameters.
     *
     * @param tokenizer The tokenizer containing the search parameters.
     */
    public void findBooksByParameter(Tokenizer tokenizer) {
        getLibrary().findBooksByParameter(tokenizer);
    }

    /**
     * Loads books from an XML file into the library.
     */
    public void loadBooks() {
        FileManager fileManager = InterfaceInstance.getInstance().getFileManager();
        File libFile = fileManager.getDatabases().optArg();
        getLibrary().setBooks(XMLLibParser.parseBooksXML(libFile));
    }
}
