package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;

import java.util.HashMap;
import java.util.Scanner;

public class Library implements Book {
    HashMap<String, BookStructure> books;

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

    public Book findBook(String id) {
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
    public void bookInfo(User user) {
        System.out.println("Id: ");
        String id;
        Scanner scanner = new Scanner(System.in);

        id = scanner.nextLine();

        BookStructure book = (BookStructure) findBook(id);

        book.bookInfo(user);
    }
}
