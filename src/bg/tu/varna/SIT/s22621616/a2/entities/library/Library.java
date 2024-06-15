package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;

import java.util.HashMap;
import java.util.Scanner;

public class Library implements Book {
    private HashMap<String, BookStructure> books;

    public HashMap<String, BookStructure> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, BookStructure> books) {
        this.books = books;
    }

    public Library(HashMap<String, BookStructure> books) {
        setBooks(books);
    }

    public void addBook(User user) {
        BookStructure book = build(user);
        getBooks().put(book.getId(), book);
    }

    public void printBooks() {
        getBooks().forEach((s, book) -> {
            System.out.println(s + " " + book.getTitle() + " " + book.getRating());
        });
    }

    private Book findBook(String id) {
        return getBooks().getOrDefault(id, null);
    }

    /**
     * Create a book with user input
     *
     * @param user User
     * @return new Book(...)
     */
    @Override
    public BookStructure build(User user) {
        BookStructure book = new BookStructure();

        book = book.build(user);
        return book;
    }

    /**
     * Create a book without user input
     *
     * @return new Book()
     */
    @Override
    public BookStructure build() {
        return null;
    }

    @Override
    public void bookInfo(String id, User user) {
        BookStructure book = (BookStructure) findBook(id);

        if(book == null) {
            throw new RuntimeException(String.format("Book with id: %s doesn't exist!", id));
        }

        book.bookInfo(id, user);
    }

    public void sort() {

    }
}
