package bg.tu.varna.SIT.s22621616.a2.api.library;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.SubCommands;

import java.util.stream.Collectors;

import java.util.Comparator;
import java.util.List;

/**
 * The Library class represents a collection of books and provides methods to manage them.
 */
public class Library implements Book {
    private List<BookStructure> books;

    public List<BookStructure> getBooks() {
        return books;
    }

    public void setBooks(List<BookStructure> books) {
        this.books = books;
    }

    /**
     * Constructs a Library with a list of books.
     *
     * @param books List of BookStructure objects representing the books in the library.
     */
    public Library(List<BookStructure> books) {
        setBooks(books);
    }

    /**
     * Adds a new book to the library based on user input.
     *
     * @param user The user adding the book.
     */
    public void addBook(User user) {
        BookStructure book = build(user);
        getBooks().add(book);
    }

    /**
     * Prints the details of all books in the library.
     */
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
        for (BookStructure ibook : books) {
            if (ibook.getId().equals(id)) {
                return ibook;
            }
        }
        return null;
    }

    /**
     * Creates a book with user input.
     *
     * @param user The user for whom the book is being created.
     * @return A new BookStructure object based on user input.
     */
    @Override
    public BookStructure build(User user) {
        BookStructure book = new BookStructure();
        return book.build(user);
    }

    /**
     * Finds and prints books based on the specified parameter.
     *
     * @param tokenizer The tokenizer containing the search parameters.
     */
    public void findBooksByParameter(Tokenizer tokenizer) {
        SubCommands subCommand = tokenizer.getSubCommand();
        StringBuilder optionString = new StringBuilder();
        List<String> options = tokenizer.getInputs();

        for (int i = 0; i < options.size(); i++) {
            if (i > 0) {
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
            case null, default -> {
                System.out.println("Unknown subcommand");
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

        if (book == null) {
            throw new RuntimeException(String.format("Book with id: %s doesn't exist!", id));
        }

        book.bookInfo(id, user);
    }

    public void sort(Tokenizer tokenizer) {
        SubCommands subCommand = tokenizer.getSubCommand();
        SubCommands instruct = tokenizer.getInstrCommand();

        switch (subCommand) {
            case TITLE -> sortByTitle(instruct);
            case AUTHOR -> sortByAuthor(instruct);
            case null, default -> System.out.println(Application.ANSI_RED + "Unknown subcommand" + Application.RESET);
        }
    }

    private void sortByTitle(SubCommands instruct) {
        books.sort(Comparator.comparing(BookStructure::getTitle));
        books = reverse(books, instruct);
    }

    private List<BookStructure> reverse(List<BookStructure> list, SubCommands instruct) {
        if (instruct == SubCommands.DESC) {
            return list.reversed();
        }
        return list;
    }

    private void sortByAuthor(SubCommands instruct) {
        books.sort(Comparator.comparing(BookStructure::getAuthor));
        books = reverse(books, instruct);
    }
}
