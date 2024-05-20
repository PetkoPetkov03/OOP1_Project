package bg.tu.varna.SIT.s22621616.a2.entities.singletons;

import bg.tu.varna.SIT.s22621616.a2.entities.builders.BookBuilder;

import java.util.HashMap;

public class Library {
    HashMap<String, BookBuilder> books;

    public HashMap<String, BookBuilder> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, BookBuilder> books) {
        this.books = books;
    }

    public Library(HashMap<String, BookBuilder> books) {
        setBooks(books);
    }

    public void addBook(BookBuilder book) {
        getBooks().put(book.getId(), book);
    }

    public void printBooks() {
        getBooks().forEach((s, book) -> {
            System.out.println(s + " " + book.getTitle() + " " + book.getRating());
        });
    }

    public BookBuilder findBook(String id) {
        return getBooks().getOrDefault(id, null);
    }
}
