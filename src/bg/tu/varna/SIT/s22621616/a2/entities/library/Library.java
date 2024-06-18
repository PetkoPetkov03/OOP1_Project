package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.SubCommands;

import java.util.*;

public class Library implements Book {
    private List<BookStructure> books = new ArrayList<>();

    public List<BookStructure> getBooks() {
        return books;
    }

    public void setBooks(List<BookStructure> books) {
        this.books = books;
    }

    public Library(List<BookStructure> books) {
        setBooks(books);
    }

    public void addBook(User user) {
        BookStructure book = build(user);
        getBooks().add(book);
    }

    public void printBooks() {
        getBooks().forEach((book) -> {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getRating());
        });
    }

    private Book findBook(String id) {
        BookStructure book = null;
        for(BookStructure ibook : books) {
            if(ibook.getId().equals(id)) {
                book = ibook;
            }
        }

        return book;
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

    public void sort(Tokenizer tokenizer) {
        SubCommands subCommand = tokenizer.getSubCommand();
        SubCommands instruct = tokenizer.getInstrCommand();

        switch (subCommand) {
            case SubCommands.TITLE: {
                sortByTitle(instruct);
                break;
            }
            case SubCommands.AUTHOR: {
                sortByAuthor(instruct);
                break;
            }
        }
    }

    private void sortByTitle(SubCommands instruct) {
        books.sort(Comparator.comparing(BookStructure::getTitle));

        books = reverse(books, instruct);
    }

    private List<BookStructure> reverse(List<BookStructure> list, SubCommands instruct) {
        if(instruct == SubCommands.DESC) {
            list = list.reversed();
        }

        return list;
    }

    private void sortByAuthor(SubCommands instruct) {
        books.sort(Comparator.comparing(BookStructure::getAuthor));

        books = reverse(books, instruct);
    }
}
