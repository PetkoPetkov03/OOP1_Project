package bg.tu.varna.SIT.s22621616.a2.api.library;

import bg.tu.varna.SIT.s22621616.a2.Application;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;

import java.util.*;

/**
 * The BookStructure class implements the {@link Book} interface and represents a book object with various attributes
 * such as author, title, genre, description, keywords, year of release, rating, and user ratings.
 */
public class BookStructure implements Book {

    // Fields representing the book's properties.
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private List<Keywords> keywords = new ArrayList<>();
    private int yearOfRelease;
    private double rating = 0;
    private HashMap<String, User> usersRated = new HashMap<>();
    private String id;

    /**
     * Generates a random 18-character string to be used as the unique book ID.
     *
     * @return A randomly generated book ID.
     */
    public String genId() {
        String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * range.length());
            salt.append(range.charAt(index));
        }
        return salt.toString();
    }

    // Getter and setter methods for author.
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and setter methods for title.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter methods for genre.
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Getter and setter methods for description.
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter methods for keywords.
    public List<Keywords> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keywords> keywords) {
        this.keywords = keywords;
    }

    // Getter and setter methods for yearOfRelease.
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    // Getter and setter methods for rating.
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Getter and setter methods for usersRated.
    public HashMap<String, User> getUsersRated() {
        return usersRated;
    }

    public void setUsersRated(HashMap<String, User> usersRated) {
        this.usersRated = usersRated;
    }

    // Getter and setter methods for id.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Adds a keyword to the list of keywords associated with the book.
     *
     * @param keyword The {@link Keywords} object to add to the keywords list.
     */
    public void addKeyword(Keywords keyword) {
        getKeywords().add(keyword);
    }

    /**
     * Builds a new book based on user input by prompting the user for the book's details.
     *
     * @param user The {@link User} object providing input for the book creation.
     * @return A new {@link BookStructure} based on the user input.
     */
    @Override
    public BookStructure build(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a book");

        BookStructure book = new BookStructure();

        System.out.print("Author: ");
        book.setAuthor(scanner.nextLine());

        System.out.print("Book Title: ");
        book.setTitle(scanner.nextLine());

        System.out.println("Valid genres:");
        for (Genre genre : Genre.values()) {
            System.out.println(genre.name());
        }

        System.out.print("Genre: ");
        Genre genre = Translator.translateUserStringToEnum(Genre.class, scanner.nextLine());
        if (genre == null) {
            System.out.println(Application.ANSI_RED + "Unknown genre" + Application.RESET);
            this.build(user); // Recursion if genre is invalid.
        }
        book.setGenre(genre);

        System.out.print("Year of release: ");
        book.setYearOfRelease(Integer.parseInt(scanner.nextLine()));

        System.out.print("Description: ");
        book.setDescription(scanner.nextLine());

        System.out.println("Add keywords");
        for (Keywords keyword : Keywords.values()) {
            System.out.println(keyword.name());
        }
        System.out.print("How many keywords do you wish to add?");
        for (int i = 0; i < Integer.parseInt(scanner.nextLine()); i++) {
            System.out.print("Add keyword: ");
            book.addKeyword(Translator.translateUserStringToEnum(Keywords.class, scanner.nextLine()));
        }

        book.setId(book.genId());

        return book;
    }

    /**
     * Displays detailed information about a book using its ID.
     *
     * @param id   The unique identifier of the book.
     * @param user The {@link User} requesting the book information.
     */
    @Override
    public void bookInfo(String id, User user) {
        System.out.println(this.toString());
    }

    /**
     * Returns a string representation of the book object.
     *
     * @return A string containing the book's details such as author, title, genre, description, keywords, etc.
     */
    @Override
    public String toString() {
        return "BookStructure{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", keywords=" + keywords +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                ", usersRated=" + usersRated +
                ", id='" + id + '\'' +
                '}';
    }
}
