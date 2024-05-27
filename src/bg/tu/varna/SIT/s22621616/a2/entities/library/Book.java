package bg.tu.varna.SIT.s22621616.a2.entities.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Book {
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private List<Keywords> keywords;
    private int yearOfRelease;
    private double rating;
    private int usersRated;
    private String id;

    public Book(String author, String title, Genre genre, String description,
                int yearOfRelease) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.yearOfRelease = yearOfRelease;
        this.id = genId();
        this.keywords = new ArrayList<>();
        this.rating = 0;
        this.usersRated = 0;
    }

    public Book(String author, String title, Genre genre, String description,
                int yearOfRelease, String id, List<Keywords> keywords, double rating, int usersRated) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.yearOfRelease = yearOfRelease;
        this.id = id;
    }

    private String genId() {
        String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * range.length());
            salt.append(range.charAt(index));
        }
        return salt.toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Keywords> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keywords> keywords) {
        this.keywords = keywords;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getUsersRated() {
        return usersRated;
    }

    public void setUsersRated(int usersRated) {
        this.usersRated = usersRated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
