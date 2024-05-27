package bg.tu.varna.SIT.s22621616.a2.entities.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Book {
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private List<Keywords> keywords;
    private int yearOfRelease;
    private double rating = 0;
    private int usersRated = 0;
    private String id;

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

    public void addKeyword(Keywords keyword) {
        getKeywords().add(keyword);
    }

    public Book userFill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a book");

        Book book = new Book();

        System.out.print("Author: ");
        book.setAuthor(scanner.nextLine());

        System.out.print("Book Title: ");
        book.setTitle(scanner.nextLine());

        System.out.println("valid genres!");
        for(Genre genre: Genre.values()) {
            System.out.println(genre.name());
        }

        System.out.print("Genre: ");
        book.setGenre(Genre.valueOf(scanner.nextLine().toUpperCase()));

        System.out.print("Year of release: ");
        book.setYearOfRelease(Integer.parseInt(scanner.nextLine()));

        System.out.print("Description: ");
        book.setDescription(scanner.nextLine());

        System.out.println("Add keywords");
        for(Keywords keyword: Keywords.values()) {
            System.out.println(keyword.name());
        }
        System.out.print("How many keywords do you wish to add?");
        for(int i = 0; i < Integer.parseInt(scanner.nextLine()); i++) {
            System.out.print("Add keyword: ");
            book.addKeyword(Keywords.valueOf(scanner.nextLine().toUpperCase()));
        }

        book.setId(book.genId());

        return book;
    }
}
