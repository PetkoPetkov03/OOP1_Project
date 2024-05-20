package bg.tu.varna.SIT.s22621616.a2.entities.singletons;

import bg.tu.varna.SIT.s22621616.a2.entities.builders.BookBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryInstance {
    private static LibraryInstance instance;
    private final Library library;

    LibraryInstance(){
        library = new Library(new HashMap<String, BookBuilder>());
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

    public boolean addBooks() {
        Scanner scanner = new Scanner(System.in);

        List<BookBuilder> books = new ArrayList<BookBuilder>();

        System.out.println("How many books do you wish to add?");

        if(!scanner.hasNextLine()) {
            return false;
        }

        int numOfBooks = Integer.parseInt(scanner.nextLine());

        boolean integrity = true;

        for(int i = 0; i < numOfBooks; i++) {

            String input;
            System.out.println("For (optional) values you can type '!!' to generate the default value!");
            System.out.println("Title of the book: ");

            if(!scanner.hasNextLine()) {
                return false;
            }

            input = scanner.nextLine();
        }

        return true;
    }
}
