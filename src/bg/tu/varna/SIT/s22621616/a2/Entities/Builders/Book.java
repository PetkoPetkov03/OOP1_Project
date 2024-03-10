package bg.tu.varna.SIT.s22621616.a2.Entities.Builders;

import bg.tu.varna.SIT.s22621616.a2.Enums.Genre;
import bg.tu.varna.SIT.s22621616.a2.Enums.Keywords;

import java.util.List;

public class Book {
    private String author;
    private String title;
   private Genre genre;
   private String description;
    private List<Keywords> keywords;
    private int yearOfRelease;
    private double rating;
    private String id;

    public static class Builder {
        private String author;
        private String title;
        private Genre genre;
        private String description;
        private List<Keywords> keywords;
        private int yearOfRelease;
        private double rating;
        private String id;

        public Builder withKeywords(Keywords[] keywords) {
            setKeywords(List.of(keywords));

            return this;
        }

        public Builder withRating(double rating) {
            setRating(rating);

            return this;
        }

        public Builder(String author, String title, Genre genre, String description,  int yearOfRelease, String id) {
            setAuthor(author);
            setTitle(title);
            setGenre(genre);
            setDescription(description);
            setYearOfRelease(yearOfRelease);
            setId(id);
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public Genre getGenre() {
            return genre;
        }

        public String getDescription() {
            return description;
        }

        public List<Keywords> getKeywords() {
            return keywords;
        }

        public int getYearOfRelease() {
            return yearOfRelease;
        }

        public double getRating() {
            return rating;
        }

        public String getId() {
            return id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setKeywords(List<Keywords> keywords) {
            this.keywords = keywords;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setYearOfRelease(int yearOfRelease) {
            this.yearOfRelease = yearOfRelease;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public Book(Builder builder) {
        this.author = builder.getAuthor();
        this.title = builder.getTitle();
        this.genre = builder.getGenre();
        this.description = builder.getDescription();
        this.keywords = builder.getKeywords();
        this.yearOfRelease = builder.getYearOfRelease();
        this.rating = builder.getRating();
        this.id = builder.getId();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public List<Keywords> getKeywords() {
        return keywords;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public String getId() {
        return id;
    }
}
