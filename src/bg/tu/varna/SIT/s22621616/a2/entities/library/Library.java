package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.SubCommands;

import java.util.*;
import java.util.stream.Collectors;

public class Library implements Book {
    private List<BookStructure> books;

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

    private void printBooks(List<BookStructure> filteredBooks) {
        filteredBooks.forEach((book) -> {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getRating());
        });
    }

    private BookStructure findBook(String id) {
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



    public void findBooksByParameter(Tokenizer tokenizer) {
        SubCommands subCommand = tokenizer.getSubCommand();
        StringBuilder optionString = new StringBuilder();
        List<String> options = tokenizer.getInputs();

        System.out.println(options.toString());

        for(int i = 0; i < options.size(); i++) {
            if(i > 0) {
                optionString.append(" ");
            }
            optionString.append(options.get(i));
        }

        switch (subCommand) {

            case AUTHOR -> {
                printBooks(findBooksByAuthor(optionString.toString()));
            }
            case TITLE -> {
                printBooks(findBooksByTitle(optionString.toString()));
            }
            case TAG -> {
                printBooks(findBooksByTag(optionString.toString()));
            }
        }
    }

    private List<BookStructure> findBooksByAuthor(String input) {
        return books.stream().filter(book -> book.getAuthor().equals(input)).collect(Collectors.toList());
    }

    private List<BookStructure> findBooksByTitle(String input) {
        return books.stream().filter(book -> book.getTitle().equals(input)).collect(Collectors.toList());
    }

    private List<BookStructure> findBooksByTag(String input) {
        return books.stream().filter(book -> book.getKeywords().contains(Translator.translateUserStringToEnum(Keywords.class, input)))
                .collect(Collectors.toList());
    }

    @Override
    public void bookInfo(String id, User user) {
        BookStructure book = findBook(id);

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
