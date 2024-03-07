package bg.tu.varna.SIT.s22621616.a2;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        HashMap<String, Books> booksHashMap = new HashMap<>();

        Books book = new Books("t", "tete", Genre.ADVENTURE, "sdgs", new Keywords[]{Keywords.TEMPLATE},
                2003, 5.0F, "sdghsdg");

        booksHashMap.put(book.id, book);
        Library lib = new Library(booksHashMap);

        lib.printBooks();
    }
}