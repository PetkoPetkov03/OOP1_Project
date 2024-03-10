package bg.tu.varna.SIT.s22621616.a2.Entities.Builders;

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

    public void addBook(Book book) {
        getBooks().put(book.getId(), book);
    }

    public void printBooks() {
        getBooks().forEach((s, book) -> {
            System.out.println(s + " " + book.getTitle() + " " + book.getRating());
        });
    }
}
