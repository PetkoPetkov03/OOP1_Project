package bg.tu.varna.SIT.s22621616.a2.entities.library;

import java.util.HashMap;

public class Library {
    HashMap<String, Book> books;

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, Book> books) {
        this.books = books;
    }

    public Library(HashMap<String, Book> books) {
        setBooks(books);
    }

    public boolean addBook(Book book) {
        getBooks().put(book.getId(), book);

        return true;
    }

    public void printBooks() {
        getBooks().forEach((s, book) -> {
            System.out.println(s + " " + book.getTitle() + " " + book.getRating());
        });
    }

    public Book findBook(String id) {
        return getBooks().getOrDefault(id, null);
    }
}
