package bg.tu.varna.SIT.s22621616.a2;

import java.util.HashMap;

public class Library {
    HashMap<String, Books> books;

    public HashMap<String, Books> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, Books> books) {
        this.books = books;
    }

    public Library(HashMap<String, Books> books) {
        setBooks(books);
    }

    public void addBook(Books book) {
        getBooks().put(book.id, book);
    }

    public void printBooks() {
        getBooks().forEach((s, book) -> {
            System.out.println(s + " " + book.title);
        });
    }
}
