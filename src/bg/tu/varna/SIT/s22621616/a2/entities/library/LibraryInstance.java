package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.files.FileManager;
import bg.tu.varna.SIT.s22621616.a2.files.XMLLibParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryInstance {
    private static LibraryInstance instance;
    private final Library library;

    LibraryInstance(){
        library = new Library(new ArrayList<>());
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

    public void sort(Tokenizer tokenizer) {
        getLibrary().sort(tokenizer);
    }

    public void findBooksByParameter(Tokenizer tokenizer) {
        getLibrary().findBooksByParameter(tokenizer);
    }

    public void loadBooks() {
        FileManager fileManager = InterfaceInstance.getInstance().getFileManager();

        File libFile = fileManager.getDatabases().optArg();

        getLibrary().setBooks(XMLLibParser.parseBooksXML(libFile));
    }
}
